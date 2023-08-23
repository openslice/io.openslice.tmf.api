package io.openslice.tmf.lcm.reposervices;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
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

import io.openslice.tmf.common.model.service.ServiceSpecificationRef;
import io.openslice.tmf.lcm.model.LCMRuleSpecification;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationCreate;
import io.openslice.tmf.lcm.model.LCMRuleSpecificationUpdate;
import io.openslice.tmf.lcm.repo.LCMRuleSpecificationRepository;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;



@Service(value = "lcmRuleSpecificationRepoService")
public class LCMRuleSpecificationRepoService {


	@Autowired
	LCMRuleSpecificationRepository lcmRuleSpecificationRepository;
	

	private SessionFactory sessionFactory;

	@Autowired
	public LCMRuleSpecificationRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	

	@Transactional
	public LCMRuleSpecification addLCMRuleSpecification(@Valid LCMRuleSpecificationCreate ruleSpecificationCreate) {
		
		LCMRuleSpecification as = new LCMRuleSpecification();
		as = updateLCMRuleSpecificationFromAPICall( as, ruleSpecificationCreate);
		as = this.lcmRuleSpecificationRepository.save(as);
		return as;
	}



	public List<LCMRuleSpecification> findAll() {
		return (List<LCMRuleSpecification>) this.lcmRuleSpecificationRepository.findAll();
	}


	public Void deleteById(String id) {
		Optional<LCMRuleSpecification> optionalCat = this.lcmRuleSpecificationRepository.findByUuid(id);
		this.lcmRuleSpecificationRepository.delete(optionalCat.get());
		return null;
	}


	@Transactional
	public LCMRuleSpecification updateLCMRuleSpecification(String id, @Valid LCMRuleSpecificationUpdate body) {

		LCMRuleSpecification s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		LCMRuleSpecification alm = s;
		alm = this.updateLCMRuleSpecificationFromAPICall(alm, body);

		alm = this.lcmRuleSpecificationRepository.save(alm);
		return alm;
	}


	@Transactional
	public LCMRuleSpecification findByUuid(String id) {
		Optional<LCMRuleSpecification> optionalCat = this.lcmRuleSpecificationRepository.findByUuid(id);
		return optionalCat.orElse(null);
	}
	
	public List findAll(String myfields, @Valid Map<String, String> allParams) 
			throws UnsupportedEncodingException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ServiceSpecification> alist = null;
		try {
//			String sql = "SELECT s FROM ServiceSpecification s";
			String sql = "SELECT "
					+ "s.uuid as uuid,"
					+ "s.uuid as id,"
					+ "s.name as name,"
					+ "s.description as description,"
					+ "s.priority as priority,"
					+ "s.lcmrulephase as lcmrulephase";
			
			if (myfields != null) {
				String[] field = myfields.split(",");
				for (String f : field) {
					sql += ", s." + f + " as " + f ;
				}
				
			}			
			sql += " FROM LCMRuleSpec s";
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			sql += " ORDER BY s.priority, s.name";
			
	
			
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
//				List<ServiceSpecification> resultlist = new ArrayList<>();
//				for (ServiceSpecification s : alist) {
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
	
	
	@Transactional 
	public LCMRuleSpecification findById(String id) {
		Optional<LCMRuleSpecification> optionalCat = this.lcmRuleSpecificationRepository.findByUuid(id);
		return optionalCat.orElse(null);
	}

	
	@Transactional 
	public LCMRuleSpecification findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		LCMRuleSpecification ls = null;
		try {
			ls = session.get(LCMRuleSpecification.class, id);
			if ( ls == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(ls.getServiceSpecs() );
			tx.commit();
		} finally {
			session.close();
		}

		return ls;
	}
	
	@Transactional
	public List findByServiceSpecificationRefId(String serviceSpecId) {
		//return this.lcmRuleSpecificationRepository.findByServiceSpecificationRef( serviceSpecId );		
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ServiceSpecification> alist = null;
		try {
//			String sql = "SELECT s FROM ServiceSpecification s";
			String sql = "SELECT "
					+ "s.uuid as uuid,"
					+ "s.uuid as id,"	//this is correct
					+ "s.name as name,"
					+ "s.description as description,"
					+ "s.priority as priority,"
					+ "s.lcmrulephase as lcmrulephase";
			

			sql += " FROM LCMRuleSpec s JOIN s.serviceSpecs spec WHERE spec.id LIKE '" + serviceSpecId+"'";
			//sql += " FROM LCMRuleSpec s JOIN s.serviceSpecs spec";
			
			sql += " ORDER BY s.priority, s.name";
			
	
			
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
			
			
			return mapaEntity;
		
			
			
			
		} finally {
			tx.commit();
			session.close();
		}
	}
	
	@Transactional
	public List<LCMRuleSpecification> findByServiceSpecificationRefIdAndPhase(String serviceSpecId, String phaseName) {
		
		
		return this.lcmRuleSpecificationRepository.findByServiceSpecificationRefAndPhase( serviceSpecId, phaseName );		
	}
	

	private LCMRuleSpecification updateLCMRuleSpecificationFromAPICall(LCMRuleSpecification as,
			@Valid LCMRuleSpecificationUpdate ruleSpecificationUpdate) {

		if ( ruleSpecificationUpdate.getName()  != null) {
			as.setName( ruleSpecificationUpdate.getName() );
		}
		
		if ( ruleSpecificationUpdate.getDescription() != null) {
			as.setDescription( ruleSpecificationUpdate.getDescription() );
		}

		if ( ruleSpecificationUpdate.getLcmrulephase()   != null) {
			as.setLcmrulephase( ruleSpecificationUpdate.getLcmrulephase()  );

		}

		if ( ruleSpecificationUpdate.getPriority() != 0) {
			as.setPriority( ruleSpecificationUpdate.getPriority()  );
		}
		
		
		
		if ( ruleSpecificationUpdate.getLifecycleStatus()   != null) {
			as.setLifecycleStatus( ruleSpecificationUpdate.getLifecycleStatus() );
		}		

		if ( ruleSpecificationUpdate.getContent()  != null) {
			as.setContent( ruleSpecificationUpdate.getContent() );
		}
		if ( ruleSpecificationUpdate.getCode()  != null) {
			as.setCode( ruleSpecificationUpdate.getCode() );
		}

		if ( ruleSpecificationUpdate.getServiceSpecs()  != null) {
			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (ServiceSpecificationRef ar : ruleSpecificationUpdate.getServiceSpecs()) {
				// find by id and reload it here.

				boolean idexists = false;
				for (ServiceSpecificationRef orinalCom : as.getServiceSpecs()) {
					if (ar.getId()!=null && orinalCom.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalCom.getId(), true);
						break;
					}
				}

				if (!idexists) {
					as.getServiceSpecs().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<ServiceSpecificationRef> toRemove = new ArrayList<>();
			for (ServiceSpecificationRef ss : as.getServiceSpecs()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (ServiceSpecificationRef ar : toRemove) {
				as.getServiceSpecs().remove(ar);
			}

		}

		return as;
	}




}
