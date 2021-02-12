package io.openslice.tmf.pcm620.reposervices;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.pcm620.model.BundledProductSpecification;
import io.openslice.tmf.pcm620.model.ProductSpecification;
import io.openslice.tmf.pcm620.model.ProductSpecificationCharacteristic;
import io.openslice.tmf.pcm620.model.ProductSpecificationCreate;
import io.openslice.tmf.pcm620.model.ProductSpecificationRelationship;
import io.openslice.tmf.pcm620.model.ProductSpecificationUpdate;
import io.openslice.tmf.pcm620.repo.ProductSpecificationRepository;
import io.openslice.tmf.prm669.model.RelatedParty;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;

@Service
public class ProductSpecificationRepoService {


	@Autowired
	ProductSpecificationRepository prodsOfferingRepo;
	
	

	private SessionFactory sessionFactory;


	/**
	 * from
	 * https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
	 * 
	 * @param factory
	 */
	@Autowired
	public ProductSpecificationRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public ProductSpecification addProductSpecification(@Valid ProductSpecificationCreate serviceProductSpecification) {

		ProductSpecification serviceSpec = new ProductSpecification();
		serviceSpec = this.updateProductSpecificationDataFromAPIcall(serviceSpec, serviceProductSpecification);
		serviceSpec = this.prodsOfferingRepo.save(serviceSpec);

	
		return this.prodsOfferingRepo.save(serviceSpec);
	}

	public List<ProductSpecification> findAll() {
		return (List<ProductSpecification>) this.prodsOfferingRepo.findByOrderByName();
	}

	/**
	 * 
	 * This findAll is optimized on fields. 
	 * @param fields
	 * @param allParams
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@Transactional
	public List findAll(@Valid String fields, Map<String, String> allParams)
			throws UnsupportedEncodingException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ProductSpecification> alist = null;
		try {
//			String sql = "SELECT s FROM ProductSpecification s";
			String sql = "SELECT "
					+ "s.uuid as uuid,"
					+ "s.id as id,"
					+ "s.name as name,"
					+ "s.description as description,"
					+ "s.isBundle as isBundle,"
					+ "s.version as version,"
					+ "s.type as type";
			
			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", s." + f + " as " + f ;
				}
				
			}			
			sql += " FROM ProductSpecification s";
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			sql += " ORDER BY s.name";
			
	
			
			List<Object> mapaEntity = session
				    .createQuery(sql )
				    .setResultTransformer( new ResultTransformer() {
						
						@Override
						public Object transformTuple(Object[] tuple, String[] aliases) {
							Map<String, Object> result = new LinkedHashMap<String, Object>(tuple.length);
							        for (int i = 0; i < tuple.length; i++) {
							            String alias = aliases[i];
							            if (alias.equals("type")) {
							            	alias = "@type";
							            }
							            if (alias != null) {
							                result.put(alias, tuple[i]);
							            }
							        }

							        return result;
						}
						
						@Override
						public List transformList(List collection) {
							return collection;
						}
					} )
				    .list();
			
//			//this will fetch the whole object fields
//			if ( (( allParams!= null) && ( allParams.size()>0)) ) {
//				List<ProductSpecification> resultlist = new ArrayList<>();
//				for (ProductSpecification s : alist) {
//					resultlist.add(  findByUuid( s.getUuid() ));
//				}
//				return resultlist;
//			}
			
			
			
			return mapaEntity;
		
			
			
			
		} finally {
			tx.commit();
			session.close();
		}

	}

//	 @Transactional(propagation=Propagation.REQUIRED , readOnly=true,
//	 noRollbackFor=Exception.class)
	public ProductSpecification findByUuid(String id) {
		Optional<ProductSpecification> optionalCat = this.prodsOfferingRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public ProductSpecification findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		ProductSpecification dd = null;
		try {
			dd = session.get(ProductSpecification.class, id);
			if (dd == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(dd.getAttachment());
			Hibernate.initialize(dd.getRelatedParty()  );
			Hibernate.initialize(dd.getBundledProductSpecification() );
			Hibernate.initialize(dd.getResourceSpecification() );
			Hibernate.initialize(dd.getServiceSpecification() );
			for (ProductSpecificationCharacteristic schar : dd.getProductSpecCharacteristic() ) {
				Hibernate.initialize(schar.getProductSpecCharacteristicValue() );

			}
			

			tx.commit();
		} finally {
			session.close();
		}
		return dd;
	}

	public Void deleteByUuid(String id) {
		Optional<ProductSpecification> optionalCat = this.prodsOfferingRepo.findByUuid(id);
		ProductSpecification s = optionalCat.get();
		if (s == null) {
			return null;
		}


		/**
		 * prior deleting we need to delete other dependency objects
		 */

		this.prodsOfferingRepo.delete(s);
		return null;
	}
	

	@Transactional
	public ProductSpecification updateProductSpecification(String id,
			@Valid ProductSpecificationUpdate aProductSpecification) {

		ProductSpecification s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ProductSpecification prodOff = s;
		prodOff = this.updateProductSpecificationDataFromAPIcall(prodOff, aProductSpecification);

		prodOff = this.prodsOfferingRepo.save(prodOff);
		
		
		
		return this.prodsOfferingRepo.save(prodOff);

	}

	
	@Transactional
	private ProductSpecification updateProductSpecificationDataFromAPIcall(ProductSpecification prodSpec,
			ProductSpecificationUpdate prodSpecUpd) {


		
		if (prodSpecUpd.getName() != null) {
			prodSpec.setName(prodSpecUpd.getName());
		}

		if (prodSpecUpd.getDescription() != null) {
			prodSpec.setDescription(prodSpecUpd.getDescription());

		}

		if (prodSpecUpd.isIsBundle() != null) {
			prodSpec.isBundle(prodSpecUpd.isIsBundle());
		}
		
		if (prodSpecUpd.getBrand() != null) {
			prodSpec.setBrand( prodSpecUpd.getBrand() );

		}
		
		if (prodSpecUpd.getProductNumber() != null) {
			prodSpec.setProductNumber(prodSpecUpd.getProductNumber());

		}

		prodSpec.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		

		if (prodSpecUpd.getLifecycleStatus() != null) {
			prodSpec.setLifecycleStatusEnum(ELifecycle.getEnum(prodSpecUpd.getLifecycleStatus()));
		}
		
		if (prodSpecUpd.getVersion() != null) {
			prodSpec.setVersion(prodSpecUpd.getVersion());
		}
	


		/**
		 * Update Attachment list
		 */
		if (prodSpecUpd.getAttachment() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AttachmentRefOrValue ar : prodSpecUpd.getAttachment()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRefOrValue orinalAtt : prodSpec.getAttachment()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getAttachment().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<AttachmentRefOrValue> toRemove = new ArrayList<>();
			for (AttachmentRefOrValue ss : prodSpec.getAttachment()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (AttachmentRefOrValue ar : toRemove) {
				prodSpec.getAttachment().remove(ar);
			}

		}
		
		
		

		/**
		 * Update BundledProductSpecification list
		 */
		if (prodSpecUpd.getBundledProductSpecification() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (BundledProductSpecification ar : prodSpecUpd.getBundledProductSpecification()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (BundledProductSpecification orinalAtt : prodSpec.getBundledProductSpecification()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getBundledProductSpecification().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<BundledProductSpecification> toRemove = new ArrayList<>();
			for (BundledProductSpecification ss : prodSpec.getBundledProductSpecification()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (BundledProductSpecification ar : toRemove) {
				prodSpec.getBundledProductSpecification().remove(ar);
			}

		}


		/**
		 * Update ProductSpecificationCharacteristic list
		 */
		if (prodSpecUpd.getProductSpecCharacteristic() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ProductSpecificationCharacteristic ar : prodSpecUpd.getProductSpecCharacteristic()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (ProductSpecificationCharacteristic orinalAtt : prodSpec.getProductSpecCharacteristic()) {
					if (orinalAtt.getName().equals(ar.getName())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getName(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getProductSpecCharacteristic().add(ar);
					idAddedUpdated.put(ar.getName(), true);
				}
			}

			List<ProductSpecificationCharacteristic> toRemove = new ArrayList<>();
			for (ProductSpecificationCharacteristic ss : prodSpec.getProductSpecCharacteristic()) {
				if (idAddedUpdated.get(ss.getName()) == null) {
					toRemove.add(ss);
				}
			}

			for (ProductSpecificationCharacteristic ar : toRemove) {
				prodSpec.getProductSpecCharacteristic().remove(ar);
			}

		}
		
		


		/**
		 * Update ProductSpecificationRelationship list
		 */
		if (prodSpecUpd.getProductSpecificationRelationship() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ProductSpecificationRelationship ar : prodSpecUpd.getProductSpecificationRelationship() ) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (ProductSpecificationRelationship orinalAtt : prodSpec.getProductSpecificationRelationship()) {
					if (orinalAtt.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getProductSpecificationRelationship().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<ProductSpecificationRelationship> toRemove = new ArrayList<>();
			for (ProductSpecificationRelationship ss : prodSpec.getProductSpecificationRelationship()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (ProductSpecificationRelationship ar : toRemove) {
				prodSpec.getProductSpecificationRelationship().remove(ar);
			}

		}
		
		/**
		 * Update RelatedParty list
		 */
		if (prodSpecUpd.getRelatedParty() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (RelatedParty ar : prodSpecUpd.getRelatedParty() ) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (RelatedParty orinalAtt : prodSpec.getRelatedParty()) {
					if (orinalAtt.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getRelatedParty().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<RelatedParty> toRemove = new ArrayList<>();
			for (RelatedParty ss : prodSpec.getRelatedParty()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (RelatedParty ar : toRemove) {
				prodSpec.getRelatedParty().remove(ar);
			}

		}


		/**
		 * Update ResourceSpecificationRef list
		 */
		if (prodSpecUpd.getResourceSpecification()  != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ResourceSpecificationRef ar : prodSpecUpd.getResourceSpecification() ) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (ResourceSpecificationRef orinalAtt : prodSpec.getResourceSpecification()) {
					if (orinalAtt.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getResourceSpecification().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<ResourceSpecificationRef> toRemove = new ArrayList<>();
			for (ResourceSpecificationRef ss : prodSpec.getResourceSpecification()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (ResourceSpecificationRef ar : toRemove) {
				prodSpec.getResourceSpecification().remove(ar);
			}
		}
		
		/**
		 * Update ResourceSpecificationRef list
		 */
		if (prodSpecUpd.getServiceSpecification()  != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceSpecificationRef ar : prodSpecUpd.getServiceSpecification() ) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (ServiceSpecificationRef orinalAtt : prodSpec.getServiceSpecification()) {
					if (orinalAtt.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					prodSpec.getServiceSpecification().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<ServiceSpecificationRef> toRemove = new ArrayList<>();
			for (ServiceSpecificationRef ss : prodSpec.getServiceSpecification()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceSpecificationRef ar : toRemove) {
				prodSpec.getServiceSpecification().remove(ar);
			}
		}
		
		
		TimePeriod tp = new TimePeriod();
		if (prodSpecUpd.getValidFor() != null) {
			tp.setStartDateTime(prodSpecUpd.getValidFor().getStartDateTime());
			tp.setEndDateTime(prodSpecUpd.getValidFor().getEndDateTime());
			prodSpec.setValidFor(tp);
		}

		

		return prodSpec;
	}
	
}
