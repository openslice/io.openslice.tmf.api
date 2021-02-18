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

import io.openslice.tmf.common.model.ELifecycle;
import io.openslice.tmf.common.model.TimePeriod;
import io.openslice.tmf.pcm620.model.ProductOfferingPrice;
import io.openslice.tmf.pcm620.model.ProductOfferingPriceCreate;
import io.openslice.tmf.pcm620.model.ProductOfferingPriceUpdate;
import io.openslice.tmf.pcm620.model.ProductSpecificationCharacteristicValueUse;
import io.openslice.tmf.pcm620.repo.ProductOfferingPriceRepository;

@Service
public class ProductOfferingPriceRepoService {


	@Autowired
	ProductOfferingPriceRepository prodsOfferingRepo;
	
	

	private SessionFactory sessionFactory;


	/**
	 * from
	 * https://stackoverflow.com/questions/25063995/spring-boot-handle-to-hibernate-sessionfactory
	 * 
	 * @param factory
	 */
	@Autowired
	public ProductOfferingPriceRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}
	
	public ProductOfferingPrice addProductOfferingPrice(@Valid ProductOfferingPriceCreate serviceProductOfferingPrice) {

		ProductOfferingPrice serviceSpec = new ProductOfferingPrice();
		serviceSpec = this.updateProductOfferingPriceDataFromAPIcall(serviceSpec, serviceProductOfferingPrice);
		serviceSpec = this.prodsOfferingRepo.save(serviceSpec);

	
		return this.prodsOfferingRepo.save(serviceSpec);
	}

	public List<ProductOfferingPrice> findAll() {
		return (List<ProductOfferingPrice>) this.prodsOfferingRepo.findByOrderByName();
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
		List<ProductOfferingPrice> alist = null;
		try {
//			String sql = "SELECT s FROM ProductOfferingPrice s";
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
			sql += " FROM ProductOfferingPrice s";
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
//				List<ProductOfferingPrice> resultlist = new ArrayList<>();
//				for (ProductOfferingPrice s : alist) {
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
	public ProductOfferingPrice findByUuid(String id) {
		Optional<ProductOfferingPrice> optionalCat = this.prodsOfferingRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public ProductOfferingPrice findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		ProductOfferingPrice dd = null;
		try {
			dd = session.get(ProductOfferingPrice.class, id);
			if (dd == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(dd.getConstraint() );
			Hibernate.initialize(dd.getPlace() );
			Hibernate.initialize(dd.getBundledPopRelationship());
			Hibernate.initialize(dd.getProductOfferingTerm());
			Hibernate.initialize(dd.getTax() );
			for (ProductSpecificationCharacteristicValueUse schar : dd.getProdSpecCharValueUse()) {
				Hibernate.initialize(schar.getProductSpecCharacteristicValue() );

			}
			Hibernate.initialize(dd.getPricingLogicAlgorithm() ) ;

			tx.commit();
		} finally {
			session.close();
		}
		return dd;
	}

	public Void deleteByUuid(String id) {
		Optional<ProductOfferingPrice> optionalCat = this.prodsOfferingRepo.findByUuid(id);
		ProductOfferingPrice s = optionalCat.get();
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
	public ProductOfferingPrice updateProductOfferingPrice(String id,
			@Valid ProductOfferingPriceUpdate aProductOfferingPrice) {

		ProductOfferingPrice s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		ProductOfferingPrice prodOff = s;
		prodOff = this.updateProductOfferingPriceDataFromAPIcall(prodOff, aProductOfferingPrice);

		prodOff = this.prodsOfferingRepo.save(prodOff);
		
		
		
		return this.prodsOfferingRepo.save(prodOff);

	}

	
	@Transactional
	private ProductOfferingPrice updateProductOfferingPriceDataFromAPIcall(ProductOfferingPrice prodOffering,
			ProductOfferingPriceUpdate prodOfferingUpd) {


		
		if (prodOfferingUpd.getName() != null) {
			prodOffering.setName(prodOfferingUpd.getName());
		}

		if (prodOfferingUpd.getDescription() != null) {
			prodOffering.setDescription(prodOfferingUpd.getDescription());

		}

		if (prodOfferingUpd.isIsBundle() != null) {
			prodOffering.isBundle(prodOfferingUpd.isIsBundle());
		}
		
	

		prodOffering.setLastUpdate(OffsetDateTime.now(ZoneOffset.UTC));
		

		if (prodOfferingUpd.getLifecycleStatus() != null) {
			prodOffering.setLifecycleStatusEnum(ELifecycle.getEnum(prodOfferingUpd.getLifecycleStatus()));
		}
		
		if (prodOfferingUpd.getVersion() != null) {
			prodOffering.setVersion(prodOfferingUpd.getVersion());
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

		

	


		TimePeriod tp = new TimePeriod();
		if (prodOfferingUpd.getValidFor() != null) {
			tp.setStartDateTime(prodOfferingUpd.getValidFor().getStartDateTime());
			tp.setEndDateTime(prodOfferingUpd.getValidFor().getEndDateTime());
			prodOffering.setValidFor(tp);
		}

		

		return prodOffering;
	}
	
}
