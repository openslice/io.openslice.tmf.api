/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.scm633.reposervices;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.model.ConstituentVxF;
import io.openslice.model.ExperimentOnBoardDescriptor;
import io.openslice.model.NetworkServiceDescriptor;
import io.openslice.tmf.common.model.Any;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.EValueType;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.pcm620.model.Attachment;
import io.openslice.tmf.pcm620.reposervices.AttachmentRepoService;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.LogicalResourceSpec;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristic;
import io.openslice.tmf.rcm634.model.ResourceSpecCharacteristicValue;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.reposervices.ResourceSpecificationRepoService;
import io.openslice.tmf.scm633.api.ServiceSpecificationApiRouteBuilder;
import io.openslice.tmf.scm633.model.AttachmentRef;
import io.openslice.tmf.scm633.model.ServiceCandidate;
import io.openslice.tmf.scm633.model.ServiceCandidateCreate;
import io.openslice.tmf.scm633.model.ServiceCandidateUpdate;
import io.openslice.tmf.scm633.model.ServiceCategory;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristic;
import io.openslice.tmf.scm633.model.ServiceSpecCharacteristicValue;
import io.openslice.tmf.scm633.model.ServiceSpecRelationship;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.scm633.model.ServiceSpecificationCreate;
import io.openslice.tmf.scm633.model.ServiceSpecificationUpdate;
import io.openslice.tmf.scm633.repo.ServiceSpecificationRepository;
import io.openslice.tmf.util.AttachmentUtil;

/**
 * @author ctranoris
 *
 */
@Service
@Transactional
public class ServiceSpecificationRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceSpecificationRepoService.class.getName());

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	ServiceSpecificationRepository serviceSpecificationRepo;

	@Autowired
	CandidateRepoService candidateRepoService;

	@Autowired
	AttachmentRepoService attachmentRepoService;
	

	@Autowired
	ResourceSpecificationRepoService resourceSpecRepoService;

	@Autowired
	ServiceSpecificationApiRouteBuilder serviceSpecificationApiRouteBuilder;

	private SessionFactory sessionFactory;

	private static final String METADATADIR = System.getProperty("user.home") + File.separator + ".attachments"
			+ File.separator + "metadata" + File.separator;

	@Autowired
	public ServiceSpecificationRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	public ServiceSpecification addServiceSpecification(@Valid ServiceSpecificationCreate serviceServiceSpecification) {

		ServiceSpecification serviceSpec = new ServiceSpecification();
		serviceSpec = this.updateServiceSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);
		serviceSpec = this.serviceSpecificationRepo.save(serviceSpec);
		serviceSpec.fixSpecCharRelationhsipIDs();

		/**
		 * we automatically create s Service Candidate for this spec ready to be
		 * attached to categories
		 */
		@Valid
		ServiceCandidateCreate serviceCandidate = new ServiceCandidateCreate();
		ServiceSpecificationRef serviceSpecificationRef = new ServiceSpecificationRef();
		serviceCandidate.setServiceSpecification(serviceSpecificationRef);
		serviceSpecificationRef.setId(serviceSpec.getId());
		ServiceCandidate serviceCandidateObj = candidateRepoService.addServiceCandidate(serviceCandidate);

		serviceSpec.setServiceCandidateObjId(serviceCandidateObj.getUuid());

		return this.serviceSpecificationRepo.save(serviceSpec);
	}

	public List<ServiceSpecification> findAll() {
		return (List<ServiceSpecification>) this.serviceSpecificationRepo.findAll();
	}

	public List<ServiceSpecification> findAll(@Valid String fields, Map<String, String> allParams)
			throws UnsupportedEncodingException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ServiceSpecification> alist = null;
		try {
			String sql = "SELECT ";

			if (fields == null) {
				sql += " s";
			} else {
				sql += " s.uuid,s.name,s.description,s.isBundle ";
			}

			sql += " FROM ServiceSpecification s";
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			sql += " ORDER BY s.uuid";
			Query q = session.createQuery(sql);
			q.setFirstResult(0);
			q.setMaxResults(1000);
			alist = q.getResultList();
			return alist;
		} finally {
			tx.commit();
			session.close();
		}

	}

//	 @Transactional(propagation=Propagation.REQUIRED , readOnly=true,
//	 noRollbackFor=Exception.class)
	public ServiceSpecification findByUuid(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public ServiceSpecification findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		ServiceSpecification dd = null;
		try {
			dd = (ServiceSpecification) session.get(ServiceSpecification.class, id);
			if (dd == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(dd.getAttachment());
			Hibernate.initialize(dd.getRelatedParty());
			Hibernate.initialize(dd.getResourceSpecification());
			Hibernate.initialize(dd.getServiceLevelSpecification());
			Hibernate.initialize(dd.getServiceSpecCharacteristic());
			for (ServiceSpecCharacteristic schar : dd.getServiceSpecCharacteristic()) {
				Hibernate.initialize(schar.getServiceSpecCharacteristicValue());
				Hibernate.initialize(schar.getServiceSpecCharRelationship());

			}
			Hibernate.initialize(dd.getServiceSpecRelationship());

			tx.commit();
		} finally {
			session.close();
		}
		return dd;
	}

	public Void deleteByUuid(String id) {
		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findByUuid(id);
		ServiceSpecification s = optionalCat.get();
		if (s == null) {
			return null;
		}

		// ServiceCandidate scopt =
		// this.candidateRepoService.findById(s.getServiceCandidateObjId());
		this.candidateRepoService.deleteById(s.getServiceCandidateObjId());

		/**
		 * prior deleting we need to delete other dependency objects
		 */

		this.serviceSpecificationRepo.delete(s);
		return null;
	}


	@Transactional
	public ServiceSpecification updateServiceSpecification(String id,
			@Valid ServiceSpecificationUpdate serviceServiceSpecification) {

		ServiceSpecification s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ServiceSpecification serviceSpec = s;
		serviceSpec = this.updateServiceSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);

		serviceSpec = this.serviceSpecificationRepo.save(serviceSpec);
		serviceSpec.fixSpecCharRelationhsipIDs();
		
		//save the equivalent candidate
		ServiceCandidate serviceCandidateObj = candidateRepoService.findById( serviceSpec.getServiceCandidateObjId() );
		if ( serviceCandidateObj!=null) {
			ServiceCandidateUpdate serviceCandidateUpd = new ServiceCandidateUpdate();
			serviceCandidateUpd.setName( serviceSpec.getName() );		
			serviceCandidateUpd.setDescription( serviceSpec.getDescription() );		
			serviceCandidateUpd.setLifecycleStatus( serviceSpec.getLifecycleStatus() );	
			serviceCandidateUpd.setVersion( serviceSpec.getVersion() );				
			candidateRepoService.updateCandidate( serviceCandidateObj.getId(), serviceCandidateUpd);
		}
		
		return this.serviceSpecificationRepo.save(serviceSpec);

	}

	@Transactional
	private ServiceSpecification updateServiceSpecDataFromAPIcall(ServiceSpecification serviceSpec,
			ServiceSpecificationUpdate serviceSpecUpd) {


		
		if (serviceSpecUpd.getName() != null) {
			serviceSpec.setName(serviceSpecUpd.getName());
		}

		if (serviceSpecUpd.getDescription() != null) {
			serviceSpec.setDescription(serviceSpecUpd.getDescription());

		}

		if (serviceSpecUpd.isIsBundle() != null) {
			serviceSpec.isBundle(serviceSpecUpd.isIsBundle());

		}

		serviceSpec.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		

		if (serviceSpecUpd.getLifecycleStatus() != null) {
			serviceSpec.setLifecycleStatusEnum(ELifecycle.getEnum(serviceSpecUpd.getLifecycleStatus()));
		}
		
		if (serviceSpecUpd.getVersion() != null) {
			serviceSpec.setVersion(serviceSpecUpd.getVersion());
		}

		/**
		 * Update Attachment list
		 */
		if (serviceSpecUpd.getAttachment() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AttachmentRef ar : serviceSpecUpd.getAttachment()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRef orinalAtt : serviceSpec.getAttachment()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					serviceSpec.getAttachment().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<AttachmentRef> toRemove = new ArrayList<>();
			for (AttachmentRef ss : serviceSpec.getAttachment()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (AttachmentRef ar : toRemove) {
				serviceSpec.getAttachment().remove(ar);
			}

		}
		
		
		
		
		
		/**
		 * Update ServiceSpecCharacteristic list We need to compare by name, since IDs
		 * will not exist
		 */
		if (serviceSpecUpd.getServiceSpecCharacteristic() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceSpecCharacteristic charUpd : serviceSpecUpd.getServiceSpecCharacteristic()) {

				boolean nameExists = false;
				for (ServiceSpecCharacteristic originalSpecChar : serviceSpec.getServiceSpecCharacteristic()) {
					if (originalSpecChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put(originalSpecChar.getName(), true);
						originalSpecChar.updateWith(charUpd);
						break;
					}
				}

				if (!nameExists) {
					serviceSpec.getServiceSpecCharacteristic().add(new ServiceSpecCharacteristic(charUpd));
					idAddedUpdated.put(charUpd.getName(), true);
				}

			}

			List<ServiceSpecCharacteristic> toRemove = new ArrayList<>();
			for (ServiceSpecCharacteristic ss : serviceSpec.getServiceSpecCharacteristic()) {
				if (idAddedUpdated.get(ss.getName()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceSpecCharacteristic serviceSpecCharacteristic : toRemove) {
				serviceSpec.getServiceSpecCharacteristic().remove(serviceSpecCharacteristic);
			}

		}

		/**
		 * Update RelatedParty list
		 */
		if (serviceSpecUpd.getRelatedParty() != null) {
			// reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (RelatedParty rp : serviceSpecUpd.getRelatedParty()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (RelatedParty originalRP : serviceSpec.getRelatedParty()) {
					if (originalRP.getId().equals(rp.getId())) {
						idexists = true;
						idAddedUpdated.put(originalRP.getId(), true);
						break;
					}
				}
				if (!idexists) {
					serviceSpec.getRelatedParty().add(rp);
					idAddedUpdated.put(rp.getId(), true);
				}
			}
			List<RelatedParty> toRemove = new ArrayList<>();
			for (RelatedParty ss : serviceSpec.getRelatedParty()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (RelatedParty ar : toRemove) {
				serviceSpec.getRelatedParty().remove(ar);
			}
		}

		/**
		 * Update ServiceSpecRelationship list
		 */

		if (serviceSpecUpd.getServiceSpecRelationship() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceSpecRelationship ar : serviceSpecUpd.getServiceSpecRelationship()) {
				// find ServiceSpecRelationship by id and reload it here.
				// we need the ServiceSpecRelationship model from  spec models
				boolean idexists = false;
				for (ServiceSpecRelationship orinalAtt : serviceSpec.getServiceSpecRelationship()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					serviceSpec.getServiceSpecRelationship().add(ar);
					idAddedUpdated.put(ar.getId(), true);
					
					/**
					 * Also,
					 * we will add by default all the characteristics of this service to the related bundle parent service 
					 */
					
					serviceSpec = copyCharacteristicsOfServiceId(  ar.getId(), serviceSpec);
					
				}
			}

			List<ServiceSpecRelationship> toRemove = new ArrayList<>();
			for (ServiceSpecRelationship ss : serviceSpec.getServiceSpecRelationship()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceSpecRelationship ar : toRemove) {
				serviceSpec.getServiceSpecRelationship().remove(ar);
			}

		}

		/**
		 * Update ResourceSpecification list
		 */
		if (serviceSpecUpd.getResourceSpecification() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ResourceSpecificationRef ar : serviceSpecUpd.getResourceSpecification()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (ResourceSpecificationRef orinalAtt : serviceSpec.getResourceSpecification()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					serviceSpec.getResourceSpecification().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<ResourceSpecificationRef> toRemove = new ArrayList<>();
			for (ResourceSpecificationRef ss : serviceSpec.getResourceSpecification()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ResourceSpecificationRef ar : toRemove) {
				serviceSpec.getServiceSpecRelationship().remove(ar);
			}

		}

		/**
		 * Update ServiceLevelSpecification list
		 */
		if (serviceSpecUpd.getServiceLevelSpecification() != null) {
			serviceSpec.getServiceLevelSpecification().clear();
			serviceSpec.getServiceLevelSpecification().addAll(serviceSpecUpd.getServiceLevelSpecification());
		}

		TimePeriod tp = new TimePeriod();
		if (serviceSpecUpd.getValidFor() != null) {
			tp.setStartDateTime(serviceSpecUpd.getValidFor().getStartDateTime());
			tp.setEndDateTime(serviceSpecUpd.getValidFor().getEndDateTime());
			serviceSpec.setValidFor(tp);
		}

		if (serviceSpec.getResourceSpecification().size() > 0) {
			serviceSpec.setType("ResourceFacingServiceSpecification");
		} else {
			serviceSpec.setType("CustomerFacingServiceSpecification");
		}

		return serviceSpec;
	}

	/**
	 * @param sourceServiceSpecid
	 * @param targetServiceSpec
	 * @return the targetServiceSpec with the copied characteristics
	 */
	private ServiceSpecification copyCharacteristicsOfServiceId(String sourceServiceSpecid, ServiceSpecification targetServiceSpec) {
		
		ServiceSpecification sourceSpec = this.findByUuid(sourceServiceSpecid);
		if ( sourceSpec != null ) {
			for (ServiceSpecCharacteristic ssc : sourceSpec.getServiceSpecCharacteristic()) {
				ssc.setName( sourceSpec.getName() +"::"+ ssc.getName() ); //:: is used as delimiter
				targetServiceSpec.getServiceSpecCharacteristic().add( new ServiceSpecCharacteristic(ssc) );
				
			}			
		}
		
		return targetServiceSpec;
	}
	
	
	

	public ServiceSpecification cloneServiceSpecification(String uuid) {
		ServiceSpecification source = this.findByUuid(uuid);
		ServiceSpecification dest = new ServiceSpecification(source);

		dest.setName("Copy of " + dest.getName());
		dest.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		dest.setLifecycleStatusEnum(ELifecycle.IN_STUDY);

		dest = this.serviceSpecificationRepo.save(dest); // save to get uuids
		dest.fixSpecCharRelationhsipIDs(); // fix charRels. this is specific to
											// our solution on cloning
		dest = this.serviceSpecificationRepo.save(dest); // and resave

		return dest;
	}

	public ServiceSpecification addAttachmentToService(String id, @Valid Attachment attachment,
			@Valid MultipartFile afile) {
		Optional<ServiceSpecification> s = this.serviceSpecificationRepo.findByUuid(id);
		if (s.get() == null) {
			return null;
		}

		ServiceSpecification spec = s.get();
		Attachment att = this.attachmentRepoService.addAttachment(attachment);

		String tempDir = METADATADIR + spec.getId() + "/attachments/" + att.getId() + File.separator;

		try {
			Files.createDirectories(Paths.get(tempDir));
			String aFileNamePosted = afile.getOriginalFilename();// AttachmentUtil.getFileName(image.getHeaders());
			logger.info("aFileNamePosted = " + aFileNamePosted);
			// If there is an icon name
			if (!aFileNamePosted.equals("")) {
				// Save the icon File
				String targetfile = AttachmentUtil.saveFile(afile, tempDir + aFileNamePosted);
				logger.info("afile saved to = " + targetfile);
				att.setContent(targetfile);
				att.setMimeType(afile.getContentType());
				att.setName(aFileNamePosted);
				// Save the file destination
				att.setUrl("/serviceSpecification/" + spec.getId() + "/attachments/" + att.getId() + "/"
						+ aFileNamePosted);
				att = this.attachmentRepoService.updateAttachment(attachment);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		AttachmentRef attref = new AttachmentRef();
		attref.setId(att.getId());
		attref.setDescription(att.getDescription());
		attref.setUrl(att.getUrl());
		attref.setName(att.getName());

		spec.addAttachmentItem(attref);
		this.serviceSpecificationRepo.save(spec);
		return spec;
	}

	public ServiceSpecification findByNameAndVersion(String aname, String aversion) {

		Optional<ServiceSpecification> optionalCat = this.serviceSpecificationRepo.findByNameAndVersion(aname,
				aversion);
		return optionalCat.orElse(null);
	}

	// @Transactional(propagation=Propagation.REQUIRED , readOnly=true,
	// noRollbackFor=Exception.class)
	public ServiceSpecification addServiceSpecification(ServiceSpecification c) {

		@Valid
		ServiceSpecificationCreate serviceServiceSpecificationCr = new ServiceSpecificationCreate();

		serviceServiceSpecificationCr.setName(c.getName());
		serviceServiceSpecificationCr.setDescription(c.getDescription());
		serviceServiceSpecificationCr.setAttachment(new ArrayList<>(c.getAttachment()));
		serviceServiceSpecificationCr.setIsBundle(c.isIsBundle());
		serviceServiceSpecificationCr.setRelatedParty(new ArrayList<>(c.getRelatedParty()));
		serviceServiceSpecificationCr.setResourceSpecification(new ArrayList<>(c.getResourceSpecification()));
		serviceServiceSpecificationCr.setServiceLevelSpecification(new ArrayList<>(c.getServiceLevelSpecification()));
		serviceServiceSpecificationCr.setServiceSpecCharacteristic(new ArrayList<>(c.getServiceSpecCharacteristic()));
		serviceServiceSpecificationCr.setServiceSpecRelationship(new ArrayList<>(c.getServiceSpecRelationship()));
		serviceServiceSpecificationCr.setVersion(c.getVersion());
		serviceServiceSpecificationCr.setValidFor(new TimePeriod());

		return this.addServiceSpecification(serviceServiceSpecificationCr);

	}

	public ServiceSpecification updateServiceSpecification(ServiceSpecification c) {

		@Valid
		ServiceSpecificationUpdate serviceServiceSpecificationCr = new ServiceSpecificationUpdate();

		serviceServiceSpecificationCr.setName(c.getName());
		serviceServiceSpecificationCr.setDescription(c.getDescription());
		serviceServiceSpecificationCr.setAttachment(new ArrayList<>(c.getAttachment()));
		serviceServiceSpecificationCr.setIsBundle(c.isIsBundle());
		serviceServiceSpecificationCr.setServiceSpecRelationship(new ArrayList<>(c.getServiceSpecRelationship()));
		serviceServiceSpecificationCr.setRelatedParty(new ArrayList<>(c.getRelatedParty()));
		serviceServiceSpecificationCr.setResourceSpecification(new ArrayList<>(c.getResourceSpecification()));
		serviceServiceSpecificationCr.setServiceLevelSpecification(new ArrayList<>(c.getServiceLevelSpecification()));
		serviceServiceSpecificationCr.setServiceSpecCharacteristic(new ArrayList<>(c.getServiceSpecCharacteristic()));
		serviceServiceSpecificationCr.setVersion(c.getVersion());

		return this.updateServiceSpecification(c.getId(), serviceServiceSpecificationCr);

//		if (spec.getResourceSpecification().size() > 0) {
//			spec.setType("ResourceFacingServiceSpecification");
//		} else {
//			spec.setType("CustomerFacingServiceSpecification");
//		}
//		return this.serviceSpecificationRepo.save( spec );
//		
	}

	public ServiceSpecification cloneGSTServiceSpecification() {
		return this.cloneGSTServiceSpecification(null);
	}

	public ServiceSpecification cloneGSTServiceSpecification(String specName) {

		ServiceSpecification serviceSpecificationObj = readFromLocalResource( "gst.json" );
		serviceSpecificationObj.setName(specName);
		serviceSpecificationObj = this.addServiceSpecification(serviceSpecificationObj);
		return serviceSpecificationObj;
	}

	public ServiceSpecification cloneVINNIServiceSpecification(Boolean addServiceTopology,
			Boolean addServiceRequirements, Boolean addServiceExposureLevel1, Boolean addServiceExposureLevel2,
			Boolean addServiceExposureLevel3, Boolean addServiceExposureLevel4, Boolean addServiceMonitoring,
			Boolean addServiceTesting, Boolean addServiceVNF, Boolean addServiceNSD) {

		return this.cloneVINNIServiceSpecification(null, addServiceTopology, addServiceRequirements,
				addServiceExposureLevel1, addServiceExposureLevel2, addServiceExposureLevel3, addServiceExposureLevel4,
				addServiceMonitoring, addServiceTesting, addServiceVNF, addServiceNSD);
	}

	public ServiceSpecification cloneVINNIServiceSpecification(String specName, Boolean addServiceTopology,
			Boolean addServiceRequirements, Boolean addServiceExposureLevel1, Boolean addServiceExposureLevel2,
			Boolean addServiceExposureLevel3, Boolean addServiceExposureLevel4, Boolean addServiceMonitoring,
			Boolean addServiceTesting, Boolean addServiceVNF, Boolean addServiceNSD) {

		/**
		 * Create the VINNI-SB as Bundle from file
		 */
		
		
		ServiceSpecification serviceSpecVinniSB = readFromLocalResource("vinnisb/vinnisb.json");
		if ( specName!= null ){
			serviceSpecVinniSB.setName(specName);			
		}
		logger.info( "specRepoService size = " + this.findAll().size() );
		serviceSpecVinniSB = this.addServiceSpecification(serviceSpecVinniSB);
		logger.info( "specRepoService size = " + this.findAll().size() );
		
		for (ServiceSpecification ss : this.findAll()) {
			logger.info( "ss id = " + ss.getId() );			
		}
		logger.info( "serviceSpecVinniSB.getUuid() = " + serviceSpecVinniSB.getUuid() );			
		
		serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);
		serviceSpecVinniSB = this.findByUuidEager( serviceSpecVinniSB.getUuid());
		
		/**
		 * Create RFS 
		 * 1: Create Resource Spec NS Topology
		 * 
		 */
		if (  addServiceTopology ){
			ResourceSpecification resourceNSTopology = new LogicalResourceSpec();
			resourceNSTopology.setName( specName + "-" + "NS Topology");
			resourceNSTopology.setVersion( serviceSpecVinniSB.getVersion() );		
			ResourceSpecCharacteristic resourceSpecCharacteristicItem = new ResourceSpecCharacteristic();
			resourceSpecCharacteristicItem.setName("Network Slice name");
			resourceSpecCharacteristicItem.setDescription("Network Slice Name on target NFVO");
			resourceSpecCharacteristicItem.setValueType( EValueType.TEXT.getValue() );
			ResourceSpecCharacteristicValue resourceSpecCharacteristicValueItem = new ResourceSpecCharacteristicValue();
			resourceSpecCharacteristicValueItem.setValue( new Any("SLICENAME", "The Network slice name"));
			resourceSpecCharacteristicItem.addResourceSpecCharacteristicValueItem(resourceSpecCharacteristicValueItem);
			resourceNSTopology.addResourceSpecCharacteristicItem(resourceSpecCharacteristicItem);
			
			resourceNSTopology = resourceSpecRepoService.addResourceSpec( resourceNSTopology );
			/**
			 * 2: Create Service Topology related to resourceSpec
			 */
			ServiceSpecification serviceTopology = new ServiceSpecification();
			serviceTopology.setName( specName + "-" +"Service Topology");
			serviceTopology.setDescription( "Service Topology related to a Resource Specification");
			ResourceSpecificationRef resourceSpecificationItemRef = new ResourceSpecificationRef();
			resourceSpecificationItemRef.setId( resourceNSTopology.getId() );
			resourceSpecificationItemRef.setName( resourceNSTopology.getName() );
			resourceSpecificationItemRef.setVersion(resourceNSTopology.getVersion() );
			serviceTopology.addResourceSpecificationItem(resourceSpecificationItemRef);
			serviceTopology = this.addServiceSpecification( serviceTopology );
			/**
			 * ad to vinni sb
			 */
			ServiceSpecRelationship serviceSpecRelationshipItem  =new ServiceSpecRelationship();
			serviceSpecRelationshipItem.setId( serviceTopology.getId());
			serviceSpecRelationshipItem.setName( serviceTopology.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( serviceSpecRelationshipItem  );
			this.copyCharacteristicsOfServiceId( serviceSpecRelationshipItem.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);
		}
		
		
		
		/**
		 * Create Service Requirements
		 */
		if ( addServiceRequirements ){
			ServiceSpecification serviceReq = readFromLocalResource("vinnisb/vinnisb-req.json");
			serviceReq.setName( specName + "-" +serviceReq.getName() );
			serviceReq = this.addServiceSpecification(serviceReq);
			ServiceSpecRelationship relServiceReq  =new ServiceSpecRelationship();
			relServiceReq.setId( serviceReq.getId());
			relServiceReq.setName( serviceReq.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceReq  );
			this.copyCharacteristicsOfServiceId( relServiceReq.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);			
		}
		
		
		/**
		 * Create Service Exposure Level 1
		 */
		if ( addServiceExposureLevel1 ){
			ServiceSpecification serviceExpLevel = readFromLocalResource("vinnisb/vinnisb-exposure-L1.json");
			serviceExpLevel.setName( specName + "-" +serviceExpLevel.getName() );
			serviceExpLevel = this.addServiceSpecification( serviceExpLevel );
			ServiceSpecRelationship relServiceExp  =new ServiceSpecRelationship();
			relServiceExp.setId( serviceExpLevel.getId());
			relServiceExp.setName( serviceExpLevel.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceExp  );
			this.copyCharacteristicsOfServiceId( relServiceExp.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);			
		}
		
		/**
		 * Create Service Exposure Level 2
		 */
		if ( addServiceExposureLevel2 ){
			ServiceSpecification serviceExpLevel = readFromLocalResource("vinnisb/vinnisb-exposure-L2.json");
			serviceExpLevel.setName( specName + "-" +serviceExpLevel.getName() );
			serviceExpLevel = this.addServiceSpecification( serviceExpLevel );
			ServiceSpecRelationship relServiceExp  =new ServiceSpecRelationship();
			relServiceExp.setId( serviceExpLevel.getId());
			relServiceExp.setName( serviceExpLevel.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceExp  );
			this.copyCharacteristicsOfServiceId( relServiceExp.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);			
		}

		/**
		 * Create Service Exposure Level 3
		 */
		if ( addServiceExposureLevel3 ){
			ServiceSpecification serviceExpLevel = readFromLocalResource("vinnisb/vinnisb-exposure-L3.json");
			serviceExpLevel.setName( specName + "-" +serviceExpLevel.getName() );
			serviceExpLevel = this.addServiceSpecification( serviceExpLevel );
			ServiceSpecRelationship relServiceExp  =new ServiceSpecRelationship();
			relServiceExp.setId( serviceExpLevel.getId());
			relServiceExp.setName( serviceExpLevel.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceExp  );
			this.copyCharacteristicsOfServiceId( relServiceExp.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);			
		}
		
		/**
		 * Create Service Exposure Level 4
		 */
		if ( addServiceExposureLevel4 ){
			ServiceSpecification serviceExpLevel = readFromLocalResource("vinnisb/vinnisb-exposure-L4.json");
			serviceExpLevel.setName( specName + "-" +serviceExpLevel.getName() );
			serviceExpLevel = this.addServiceSpecification( serviceExpLevel );
			ServiceSpecRelationship relServiceExp  =new ServiceSpecRelationship();
			relServiceExp.setId( serviceExpLevel.getId());
			relServiceExp.setName( serviceExpLevel.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceExp  );
			this.copyCharacteristicsOfServiceId( relServiceExp.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);			
		}
		
		/**
		 * Create Service Monitoring
		 */
		if ( addServiceMonitoring ){
			ServiceSpecification serviceMon = readFromLocalResource("vinnisb/vinnisb-monitoring.json");
			serviceMon.setName( specName + "-" + serviceMon.getName() );
			serviceMon = this.addServiceSpecification( serviceMon );
			ServiceSpecRelationship relServiceMon  =new ServiceSpecRelationship();
			relServiceMon.setId( serviceMon.getId());
			relServiceMon.setName( serviceMon.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceMon  );
			this.copyCharacteristicsOfServiceId( relServiceMon.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);
			
		}
		
		/**
		 * Create Service Testing
		 */

		if ( addServiceTesting ){
			ServiceSpecification serviceTesting = readFromLocalResource("vinnisb/vinnisb-testing.json");
			serviceTesting.setName( specName + "-" + serviceTesting.getName() );
			serviceTesting = this.addServiceSpecification( serviceTesting );
			ServiceSpecRelationship relServiceTest  =new ServiceSpecRelationship();
			relServiceTest.setId( serviceTesting.getId());
			relServiceTest.setName(  serviceTesting.getName() );
			serviceSpecVinniSB.addServiceSpecRelationshipItem( relServiceTest  );
			this.copyCharacteristicsOfServiceId( relServiceTest.getId() , serviceSpecVinniSB);
			serviceSpecVinniSB = this.updateServiceSpecification(serviceSpecVinniSB);
			
		}
		
		
		/**
		 * Create 3rd party VNF related to resourceSpec
		 */
		if ( addServiceVNF ){
			ServiceSpecification thirdVNF = new ServiceSpecification();
			thirdVNF.setName( specName + "-" +"3rd party VNF");
			ResourceSpecificationRef resourceSpecificationthirdVNFRef = new ResourceSpecificationRef();
			resourceSpecificationthirdVNFRef.setId( null );
			resourceSpecificationthirdVNFRef.setName( thirdVNF.getName() );
			thirdVNF.addResourceSpecificationItem(resourceSpecificationthirdVNFRef);
			this.copyCharacteristicsOfServiceId( resourceSpecificationthirdVNFRef.getId() , serviceSpecVinniSB);
			thirdVNF = this.addServiceSpecification( thirdVNF );
			
			
		}
		/**
		 * Create 3rd party NSD related to resourceSpec
		 */
		if ( addServiceNSD ){
			ServiceSpecification thirdNSD = new ServiceSpecification();
			thirdNSD.setName( specName + "-" +"3rd party NSD");
			ResourceSpecificationRef resourceSpecificationthirdNSDRef = new ResourceSpecificationRef();
			resourceSpecificationthirdNSDRef.setId( null );
			resourceSpecificationthirdNSDRef.setName(thirdNSD.getName() );
			thirdNSD.addResourceSpecificationItem(resourceSpecificationthirdNSDRef);
			this.copyCharacteristicsOfServiceId( resourceSpecificationthirdNSDRef.getId() , serviceSpecVinniSB);
			thirdNSD = this.addServiceSpecification( thirdNSD );
		}
		
		
		return serviceSpecVinniSB;
	}
	

	private ServiceSpecification readFromLocalResource(String rname) {
		ServiceSpecification sc;
		try {
			sc = objectMapper.readValue(new ClassPathResource( rname ).getInputStream(), ServiceSpecification.class);
			
			return sc;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * The NSD is retrieved from the catalog via ActiveMQ.
	 * it will create a Resource Spec based on the NSD object
	 * It will create a Service Spec (RFS) which references the above Resource Spec
	 * 
	 * @param id the NSD id
	 * @return a ServiceSpecification
	 */
	public ServiceSpecification specFromNSDID(String id) {
		
		NetworkServiceDescriptor nsd = serviceSpecificationApiRouteBuilder.retrieveNSD(id);
		if (nsd == null) {
			logger.error("nsdid return null");
			return null;
		}

		logger.error("nsdid returned: " + nsd.getName());
		
		ResourceSpecification resourceNSD = new LogicalResourceSpec();
		resourceNSD.setName( nsd.getName() );
		resourceNSD.setVersion( nsd.getVersion() );
		resourceNSD.setDescription(nsd.getShortDescription());
		resourceNSD = resourceSpecRepoService.addResourceSpec( resourceNSD );
		/**
		 * add here characteristics
		 */
		
		/**
		 * 2: Create Service  related to resourceSpec
		 */
		ServiceSpecification serviceSpec = new ServiceSpecification();
		serviceSpec.setName( nsd.getName()  );
		serviceSpec.setVersion( nsd.getVersion() );
		serviceSpec.setDescription( nsd.getShortDescription() );		
		addServiceSpecCharacteristic(serviceSpec, "PackagingFormat", "NSD PackagingFormat", new Any(nsd.getPackagingFormat().toString(), "PackagingFormat"), EValueType.TEXT);
		addServiceSpecCharacteristic(serviceSpec, "PackageLocation", "NSD PackageLocation", new Any(nsd.getPackageLocation() , "PackageLocation"), EValueType.TEXT);
		addServiceSpecCharacteristic(serviceSpec, "Vendor", "NSD Vendor", new Any(nsd.getVendor()  , "Vendor"), EValueType.TEXT);
		addServiceSpecCharacteristic(serviceSpec, "NSDID", "NSD id", new Any(nsd.getId()+""  , "id"), EValueType.TEXT);
		for (ExperimentOnBoardDescriptor eobd : nsd.getExperimentOnBoardDescriptors()) {
			addServiceSpecCharacteristic(serviceSpec, "ObMANOprovider_Name", "NSD Onboarded MANO provider Name", new Any( eobd.getObMANOprovider().getName()   , ""), EValueType.TEXT);
			addServiceSpecCharacteristic(serviceSpec, "OnBoardingStatus", "NSDtOnBoardingStatus", new Any( eobd.getOnBoardingStatus().name()   , ""), EValueType.TEXT);
		}
		if (  nsd.getConstituentVxF() != null  ) {
			for (ConstituentVxF cv : nsd.getConstituentVxF()) {
				addServiceSpecCharacteristic(serviceSpec, "MemberVNFIndex_"+cv.getMembervnfIndex(), "Member VNF Index", new Any( cv.getMembervnfIndex() +""  , cv.getVnfdidRef()), EValueType.TEXT);
			}
		} else {

			logger.error("nsdid getConstituentVxF null returned: " + nsd.toString() );
		}
		
		
		ResourceSpecificationRef resourceSpecificationItemRef = new ResourceSpecificationRef();
		resourceSpecificationItemRef.setId( resourceNSD.getId() );
		resourceSpecificationItemRef.setName( resourceNSD.getName() );
		resourceSpecificationItemRef.setVersion(resourceNSD.getVersion() );
		
		serviceSpec.addResourceSpecificationItem(resourceSpecificationItemRef);
		serviceSpec = this.addServiceSpecification( serviceSpec );
		
		return serviceSpec;
	}

	/**
	 * @param serviceSpec
	 * @param name
	 */
	private void addServiceSpecCharacteristic(ServiceSpecification serviceSpec, String aName, String description, Any any, EValueType eValueType) {
		ServiceSpecCharacteristic serviceSpecCharacteristicItem = new ServiceSpecCharacteristic();
		serviceSpecCharacteristicItem.setName( aName );
		serviceSpecCharacteristicItem.setDescription(description);
		serviceSpecCharacteristicItem.valueType( eValueType.getValue() );
		serviceSpecCharacteristicItem.configurable(false);
		serviceSpecCharacteristicItem.setMinCardinality(1);
		serviceSpecCharacteristicItem.setMaxCardinality(1);
		ServiceSpecCharacteristicValue serviceSpecCharacteristicValueItem = new ServiceSpecCharacteristicValue();
		serviceSpecCharacteristicValueItem.setValue( new Any( any.getValue() , any.getAlias()));
		serviceSpecCharacteristicValueItem.isDefault( true );
		serviceSpecCharacteristicValueItem.setUnitOfMeasure("N/A");		
		serviceSpecCharacteristicItem.addServiceSpecCharacteristicValueItem(serviceSpecCharacteristicValueItem );
		serviceSpec.addServiceSpecCharacteristicItem(serviceSpecCharacteristicItem );
		
	}

}
