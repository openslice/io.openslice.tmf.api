/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
package io.openslice.tmf.stm653.reposervices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.openslice.tmf.common.model.Attachment;
import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.pcm620.reposervices.AttachmentRepoService;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.stm653.model.CharacteristicSpecification;
import io.openslice.tmf.stm653.model.ServiceTestSpecRelationship;
import io.openslice.tmf.stm653.model.ServiceTestSpecification;
import io.openslice.tmf.stm653.model.ServiceTestSpecificationCreate;
import io.openslice.tmf.stm653.model.ServiceTestSpecificationUpdate;
import io.openslice.tmf.stm653.repo.ServiceTestSpecificationRepository;
import io.openslice.tmf.util.AttachmentUtil;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;

/**
 * @author ctranoris
 *
 */
@Service
public class ServiceTestSpecificationRepoService {

	private static final transient Log logger = LogFactory.getLog(ServiceTestSpecificationRepoService.class.getName());

	@Autowired
	ServiceTestSpecificationRepository aServiceTestSpecificationRepo;

	private SessionFactory sessionFactory;
	


	@Autowired
	AttachmentRepoService attachmentRepoService;
	

	private static final String METADATADIR = System.getProperty("user.home") + File.separator + ".attachments"
			+ File.separator + "metadata" + File.separator;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	public ServiceTestSpecificationRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	public ServiceTestSpecification addServiceTestSpecification(
			@Valid ServiceTestSpecificationCreate serviceServiceTestSpecification) {

		ServiceTestSpecification serviceSpec = new ServiceTestSpecification();
		serviceSpec = this.updateServiceTestSpecDataFromAPIcall(serviceSpec, serviceServiceTestSpecification);
		serviceSpec = this.aServiceTestSpecificationRepo.save(serviceSpec);

		return this.aServiceTestSpecificationRepo.save(serviceSpec);
	}

	private ServiceTestSpecification updateServiceTestSpecDataFromAPIcall(ServiceTestSpecification serviceSpec,
			@Valid ServiceTestSpecificationUpdate serviceSpecUpd) {

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

			for (AttachmentRefOrValue ar : serviceSpecUpd.getAttachment()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRefOrValue orinalAtt : serviceSpec.getAttachment()) {
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

			List<AttachmentRefOrValue> toRemove = new ArrayList<>();
			for (AttachmentRefOrValue ss : serviceSpec.getAttachment()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (AttachmentRefOrValue ar : toRemove) {
				serviceSpec.getAttachment().remove(ar);
			}

		}

		/**
		 * Update ServiceSpecCharacteristic list We need to compare by name, since IDs
		 * will not exist
		 */
		if (serviceSpecUpd.getSpecCharacteristic() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (CharacteristicSpecification charUpd : serviceSpecUpd.getSpecCharacteristic()) {

				boolean nameExists = false;
				for (CharacteristicSpecification originalSpecChar : serviceSpec.getSpecCharacteristic()) {
					if (originalSpecChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put(originalSpecChar.getName(), true);
						originalSpecChar.updateWith(charUpd);
						break;
					}
				}

				if (!nameExists) {
					serviceSpec.getSpecCharacteristic().add(new CharacteristicSpecification(charUpd));
					idAddedUpdated.put(charUpd.getName(), true);
				}

			}

			List<CharacteristicSpecification> toRemove = new ArrayList<>();
			for (CharacteristicSpecification ss : serviceSpec.getSpecCharacteristic()) {
				if (idAddedUpdated.get(ss.getName()) == null) {
					toRemove.add(ss);
				}
			}

			for (CharacteristicSpecification serviceSpecCharacteristic : toRemove) {
				serviceSpec.getSpecCharacteristic().remove(serviceSpecCharacteristic);
			}

		}

		/**
		 * Update RelatedParty list
		 */
		if (serviceSpecUpd.getRelatedParty() != null) {
			// reattach fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (RelatedParty rp : serviceSpecUpd.getRelatedParty()) {

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

		if (serviceSpecUpd.getServiceTestSpecRelationship() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceTestSpecRelationship ar : serviceSpecUpd.getServiceTestSpecRelationship()) {
				// find ServiceSpecRelationship by id and reload it here.
				// we need the ServiceSpecRelationship model from spec models
				boolean idexists = false;
				for (ServiceTestSpecRelationship orinalAtt : serviceSpec.getServiceTestSpecRelationship()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					serviceSpec.getServiceTestSpecRelationship().add(ar);
					idAddedUpdated.put(ar.getId(), true);

				}
			}

			List<ServiceTestSpecRelationship> toRemove = new ArrayList<>();
			for (ServiceTestSpecRelationship ss : serviceSpec.getServiceTestSpecRelationship()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceTestSpecRelationship ar : toRemove) {
				serviceSpec.getServiceTestSpecRelationship().remove(ar);
			}

		}

		TimePeriod tp = new TimePeriod();
		if (serviceSpecUpd instanceof ServiceTestSpecificationCreate)
			if (((ServiceTestSpecificationCreate) serviceSpecUpd).getValidFor() != null) {
				tp.setStartDateTime(((ServiceTestSpecificationCreate) serviceSpecUpd).getValidFor().getStartDateTime());
				tp.setEndDateTime(((ServiceTestSpecificationCreate) serviceSpecUpd).getValidFor().getEndDateTime());
				serviceSpec.setValidFor(tp);
			}

		if (serviceSpecUpd.getRelatedServiceSpecification() != null) {
			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceSpecificationRef ar : serviceSpecUpd.getRelatedServiceSpecification()) {
				// find ServiceSpecRelationship by id and reload it here.
				// we need the ServiceSpecRelationship model from spec models
				boolean idexists = false;
				for (ServiceSpecificationRef orinalAtt : serviceSpec.getRelatedServiceSpecification()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					serviceSpec.getRelatedServiceSpecification().add(ar);
					idAddedUpdated.put(ar.getId(), true);

				}
			}

			List<ServiceSpecificationRef> toRemove = new ArrayList<>();
			for (ServiceSpecificationRef ss : serviceSpec.getRelatedServiceSpecification()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceSpecificationRef ar : toRemove) {
				serviceSpec.getRelatedServiceSpecification().remove(ar);
			}

		}

		return serviceSpec;

	}
	
	public ServiceTestSpecification findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		ServiceTestSpecification dd = null;
		try {
			dd = session.get(ServiceTestSpecification.class, id);
			if (dd == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(dd.getAttachment());
			Hibernate.initialize(dd.getRelatedParty());
			Hibernate.initialize(dd.getServiceTestSpecRelationship() );
			Hibernate.initialize(dd.getSpecCharacteristic());
			Hibernate.initialize(dd.getConstraint());
			Hibernate.initialize(dd.getEntitySpecRelationship() );
			Hibernate.initialize(dd.getTestMeasureDefinition()  );
			
			for (CharacteristicSpecification schar : dd.getSpecCharacteristic()) {
				Hibernate.initialize(schar.getCharacteristicValueSpecification() );
				Hibernate.initialize(schar.getCharSpecRelationship());

			}
			Hibernate.initialize(dd.getRelatedServiceSpecification() );

			tx.commit();
		} finally {
			session.close();
		}
		return dd;
	}

	public List<ServiceTestSpecification> findAll() {
		return (List<ServiceTestSpecification>) this.aServiceTestSpecificationRepo.findByOrderByName();
	}

	public Void deleteByUuid(String id) {
		Optional<ServiceTestSpecification> optionalCat = this.aServiceTestSpecificationRepo.findByUuid(id);
		ServiceTestSpecification s = optionalCat.get();
		if (s == null) {
			return null;
		}

		this.aServiceTestSpecificationRepo.delete(s);
		return null;
	}

	/**
	 * @param myfields
	 * @param allParams
	 * @return
	 */
	public List<ServiceTestSpecification> findAll(String myfields, @Valid Map<String, String> allParams) {
		// this can be refactored properly in future (see for example implementation in ServiceSpecificationRepo)
		return findAll();
	}

	public ServiceTestSpecification updateServiceTestSpecification(String id,
			@Valid ServiceTestSpecificationUpdate serviceServiceSpecification) {

		ServiceTestSpecification s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ServiceTestSpecification serviceSpec = s;
		serviceSpec = this.updateServiceTestSpecDataFromAPIcall(serviceSpec, serviceServiceSpecification);

		serviceSpec = this.aServiceTestSpecificationRepo.save(serviceSpec);	

		
		return this.aServiceTestSpecificationRepo.save(serviceSpec);
	}

	public ServiceTestSpecification findByUuid(String id) {
		Optional<ServiceTestSpecification> optionalCat = this.aServiceTestSpecificationRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public Attachment addAttachmentToServiceTest(String id, 
			//@Valid Attachment attachment,
			@Valid MultipartFile afile,
			String urlpath) {
		Optional<ServiceTestSpecification> s = this.aServiceTestSpecificationRepo.findByUuid(id);
		if (s.get() == null) {
			return null;
		}

		ServiceTestSpecification spec = s.get();
		Attachment att = new Attachment();
		att = this.attachmentRepoService.addAttachment(att);
		att.setMimeType(afile.getContentType());

		
		String tempDir = METADATADIR + spec.getId() + "/attachments/" + att.getId() + File.separator;

		try {
			Files.createDirectories(Paths.get(tempDir));
			String aFileNamePosted = afile.getOriginalFilename();// AttachmentUtil.getFileName(image.getHeaders());
			logger.info("aFileNamePosted = " + aFileNamePosted);
			// If there is an icon name
			if (!aFileNamePosted.equals("")) {
				// Save the icon File
				String targetfile = AttachmentUtil.saveFile(afile, tempDir);
				logger.info("afile saved to = " + targetfile);
				att.setContent(targetfile);
				att.setName(aFileNamePosted);
				// Save the file destination
				urlpath = urlpath.replace("tmf-api/", "");
				att.setUrl( urlpath + "/" + att.getId() + "/"
						+ aFileNamePosted);
				att = this.attachmentRepoService.updateAttachment( att );
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		AttachmentRefOrValue attref = new AttachmentRefOrValue();
		attref.setId(att.getId());
		attref.setDescription(att.getDescription());
		attref.setUrl(att.getUrl());
		attref.setName(att.getName());

		spec.addAttachmentItem(attref);
		this.aServiceTestSpecificationRepo.save(spec);
		
		
		return att;
	}

	public Attachment getAttachment(String attid) {
		return this.attachmentRepoService.findByUuid( attid );
	}
	
	

	
	
}
