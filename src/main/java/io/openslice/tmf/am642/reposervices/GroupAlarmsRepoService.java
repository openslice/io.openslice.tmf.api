package io.openslice.tmf.am642.reposervices;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.am642.model.GroupAlarms;
import io.openslice.tmf.am642.model.GroupAlarmsCreate;
import io.openslice.tmf.am642.repo.GroupAlarmsRepository;

@Service
public class GroupAlarmsRepoService {

	@Autowired
	GroupAlarmsRepository alRepo;

	private SessionFactory sessionFactory;

	@Autowired
	public GroupAlarmsRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	public GroupAlarms addGroupAlarms(@Valid GroupAlarmsCreate ac) {
		GroupAlarms al = new GroupAlarms();
		
		al = updateFromAPICall( al , ac);
		return this.alRepo.save( al );
	}

	

	public List findAll(String fields, Map<String, String> allParams) throws UnsupportedEncodingException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<GroupAlarms> alist = null;
		try {
			String sql = "SELECT "
					+ "s.uuid as uuid,"
					+ "s.id as id,"
					+ "s.alarmChangedTime as alarmChangedTime,"
					+ "s.sourceSystemId as sourceSystemId,"
					+ "s.state as state";
			
			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", s." + f + " as " + f ;
				}
				
			}			
			sql += " FROM AMGroupAlarms s";
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			sql += " ORDER BY s.alarmChangedTime DESC";
			
	
			
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

	public GroupAlarms findById(String id) {
		Optional<GroupAlarms> optionalCat = this.alRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}
	
	private GroupAlarms updateFromAPICall(GroupAlarms al, @Valid GroupAlarmsCreate aSrc) {

		al.setSourceSystemId( aSrc.getSourceSystemId());
		al.setAlarmChangedTime( OffsetDateTime.now(ZoneOffset.UTC) );
		al.setState( aSrc.getState());
		al.setParentAlarm( aSrc.getParentAlarm());
		al.getCorrelatedAlarm().addAll( aSrc.getCorrelatedAlarm());
		al.getGroupedAlarm().addAll( aSrc.getGroupedAlarm() );

		return al;
	}

}
