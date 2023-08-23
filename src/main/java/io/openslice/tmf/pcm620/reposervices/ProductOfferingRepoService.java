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

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.openslice.tmf.am651.model.AgreementRef;
import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.pcm620.model.BundledProductOffering;
import io.openslice.tmf.pcm620.model.ProductOffering;
import io.openslice.tmf.pcm620.model.ProductOfferingCreate;
import io.openslice.tmf.pcm620.model.ProductOfferingPriceRef;
import io.openslice.tmf.pcm620.model.ProductOfferingUpdate;
import io.openslice.tmf.pcm620.model.ProductSpecificationCharacteristicValueUse;
import io.openslice.tmf.pcm620.repo.ProductOfferingRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;

@Service
public class ProductOfferingRepoService {


	@Autowired
	ProductOfferingRepository prodsOfferingRepo;
	
	

	private SessionFactory sessionFactory;


	/**
	 * from
	 * https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
	 * 
	 * @param factory
	 */
	@Autowired
	public ProductOfferingRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public ProductOffering addProductOffering(@Valid ProductOfferingCreate serviceProductOffering) {

		ProductOffering serviceSpec = new ProductOffering();
		serviceSpec = this.updateProductOfferingDataFromAPIcall(serviceSpec, serviceProductOffering);
		serviceSpec = this.prodsOfferingRepo.save(serviceSpec);

	
		return this.prodsOfferingRepo.save(serviceSpec);
	}

	public List<ProductOffering> findAll() {
		return (List<ProductOffering>) this.prodsOfferingRepo.findByOrderByName();
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
		List<ProductOffering> alist = null;
		try {
//			String sql = "SELECT s FROM ProductOffering s";
			String sql = "SELECT "
					+ "s.uuid as uuid,"
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
			sql += " FROM ProductOffering s";
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
							            if (alias.equals("uuid")) {
							            	result.put("id", tuple[i]);
							            }
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
//				List<ProductOffering> resultlist = new ArrayList<>();
//				for (ProductOffering s : alist) {
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
	public ProductOffering findByUuid(String id) {
		Optional<ProductOffering> optionalCat = this.prodsOfferingRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public ProductOffering findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		ProductOffering dd = null;
		try {
			dd = session.get(ProductOffering.class, id);
			if (dd == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(dd.getAttachment());
			Hibernate.initialize(dd.getAgreement() );
			Hibernate.initialize(dd.getBundledProductOffering() );
			Hibernate.initialize(dd.getCategory());
			Hibernate.initialize(dd.getMarketSegment());
			for (ProductSpecificationCharacteristicValueUse schar : dd.getProdSpecCharValueUse()) {
				Hibernate.initialize(schar.getProductSpecCharacteristicValue() );

			}
			Hibernate.initialize(dd.getPlace() );
			Hibernate.initialize(dd.getProductOfferingPrice() );
			Hibernate.initialize(dd.getProductOfferingTerm() );
			Hibernate.initialize(dd.getServiceCandidate() );
			Hibernate.initialize(dd.getResourceCandidate() );

			tx.commit();
		} finally {
			session.close();
		}
		return dd;
	}

	public Void deleteByUuid(String id) {
		Optional<ProductOffering> optionalCat = this.prodsOfferingRepo.findByUuid(id);
		ProductOffering s = optionalCat.get();
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
	public ProductOffering updateProductOffering(String id,
			@Valid ProductOfferingUpdate aProductOffering) {

		ProductOffering s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ProductOffering prodOff = s;
		prodOff = this.updateProductOfferingDataFromAPIcall(prodOff, aProductOffering);

		prodOff = this.prodsOfferingRepo.save(prodOff);
		
		
		
		return this.prodsOfferingRepo.save(prodOff);

	}

	
	@Transactional
	private ProductOffering updateProductOfferingDataFromAPIcall(ProductOffering prodOffering,
			ProductOfferingUpdate prodOfferingUpd) {


		
		if (prodOfferingUpd.getName() != null) {
			prodOffering.setName(prodOfferingUpd.getName());
		}

		if (prodOfferingUpd.getDescription() != null) {
			prodOffering.setDescription(prodOfferingUpd.getDescription());

		}

		if (prodOfferingUpd.isIsBundle() != null) {
			prodOffering.isBundle(prodOfferingUpd.isIsBundle());
		}
		
		if (prodOfferingUpd.isIsSellable() != null) {
			prodOffering.isSellable(prodOfferingUpd.isIsSellable());

		}
		
		if (prodOfferingUpd.getStatusReason() != null) {
			prodOffering.setStatusReason(prodOfferingUpd.getStatusReason());

		}

		prodOffering.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		

		if (prodOfferingUpd.getLifecycleStatus() != null) {
			prodOffering.setLifecycleStatusEnum(ELifecycle.getEnum(prodOfferingUpd.getLifecycleStatus()));
		}
		
		if (prodOfferingUpd.getVersion() != null) {
			prodOffering.setVersion(prodOfferingUpd.getVersion());
		}
		
		if ( prodOfferingUpd.getServiceLevelAgreement() != null ) {
			prodOffering.setServiceLevelAgreement( prodOfferingUpd.getServiceLevelAgreement()  );
		}
		
		if ( prodOfferingUpd.getServiceCandidate() != null ) {
			prodOffering.setServiceCandidate( prodOfferingUpd.getServiceCandidate()  );
		}

		if ( prodOfferingUpd.getResourceCandidate() != null ) {
			prodOffering.setResourceCandidate( prodOfferingUpd.getResourceCandidate()  );
		}

		if ( prodOfferingUpd.getProductSpecification() != null ) {
			prodOffering.setProductSpecification( prodOfferingUpd.getProductSpecification()  );
		}


		/**
		 * Update Attachment list
		 */
		if (prodOfferingUpd.getAttachment() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AttachmentRefOrValue ar : prodOfferingUpd.getAttachment()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (AttachmentRefOrValue orinalAtt : prodOffering.getAttachment()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					prodOffering.getAttachment().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<AttachmentRefOrValue> toRemove = new ArrayList<>();
			for (AttachmentRefOrValue ss : prodOffering.getAttachment()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (AttachmentRefOrValue ar : toRemove) {
				prodOffering.getAttachment().remove(ar);
			}

		}
		
		
		
		
		
		/**
		 * Update ServiceSpecCharacteristic list We need to compare by name, since IDs
		 * will not exist
		 */
		if (prodOfferingUpd.getProdSpecCharValueUse() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ProductSpecificationCharacteristicValueUse charUpd : prodOfferingUpd.getProdSpecCharValueUse()) {

				boolean nameExists = false;
				for (ProductSpecificationCharacteristicValueUse originalProdChar : prodOffering.getProdSpecCharValueUse()) {
					if (originalProdChar.getName().equals(charUpd.getName())) {
						nameExists = true;
						idAddedUpdated.put(originalProdChar.getName(), true);
						originalProdChar.updateWith(charUpd);
						break;
					}
				}

				if (!nameExists) {
					prodOffering.getProdSpecCharValueUse().add(new ProductSpecificationCharacteristicValueUse(charUpd));
					idAddedUpdated.put(charUpd.getName(), true);
				}

			}

			List<ProductSpecificationCharacteristicValueUse> toRemove = new ArrayList<>();
			for (ProductSpecificationCharacteristicValueUse ss : prodOffering.getProdSpecCharValueUse()) {
				if (idAddedUpdated.get(ss.getName()) == null) {
					toRemove.add(ss);
				}
			}

			for (ProductSpecificationCharacteristicValueUse serviceSpecCharacteristic : toRemove) {
				prodOffering.getProdSpecCharValueUse().remove(serviceSpecCharacteristic);
			}

		}

		

		/**
		 * Update ProductOfferingPriceRef list
		 */
		if (prodOfferingUpd.getProductOfferingPrice() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ProductOfferingPriceRef ar : prodOfferingUpd.getProductOfferingPrice()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (ProductOfferingPriceRef orinalAtt : prodOffering.getProductOfferingPrice()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					prodOffering.getProductOfferingPrice().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<ProductOfferingPriceRef> toRemove = new ArrayList<>();
			for (ProductOfferingPriceRef ss : prodOffering.getProductOfferingPrice()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ProductOfferingPriceRef ar : toRemove) {
				prodOffering.getProductOfferingPrice().remove(ar);
			}

		}



		/**
		 * Update BundledProductOffering list
		 */
		if (prodOfferingUpd.getBundledProductOffering() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (BundledProductOffering ar : prodOfferingUpd.getBundledProductOffering()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (BundledProductOffering orinalAtt : prodOffering.getBundledProductOffering()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					prodOffering.getBundledProductOffering().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<BundledProductOffering> toRemove = new ArrayList<>();
			for (BundledProductOffering ss : prodOffering.getBundledProductOffering()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (BundledProductOffering ar : toRemove) {
				prodOffering.getBundledProductOffering().remove(ar);
			}

		}

		

		/**
		 * Update BundledProductOffering list
		 */
		if (prodOfferingUpd.getAgreement() != null) {

			// reattach attachments fromDB
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AgreementRef ar : prodOfferingUpd.getAgreement()) {
				// find attachmet by id and reload it here.
				// we need the attachment model from resource spec models
				boolean idexists = false;
				for (AgreementRef orinalAtt : prodOffering.getAgreement()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					prodOffering.getAgreement().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<AgreementRef> toRemove = new ArrayList<>();
			for (AgreementRef ss : prodOffering.getAgreement()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (AgreementRef ar : toRemove) {
				prodOffering.getAgreement().remove(ar);
			}

		}


		TimePeriod tp = new TimePeriod();
		if (prodOfferingUpd.getValidFor() != null) {
			tp.setStartDateTime(prodOfferingUpd.getValidFor().getStartDateTime());
			tp.setEndDateTime(prodOfferingUpd.getValidFor().getEndDateTime());
			prodOffering.setValidFor(tp);
		}

		

		return prodOffering;
	}
	
}
