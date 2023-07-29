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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openslice.tmf.am642.model.AlarmStateType;
import io.openslice.tmf.am642.model.ClearAlarms;
import io.openslice.tmf.am642.model.ClearAlarmsCreate;
import io.openslice.tmf.am642.repo.ClearAlarmsRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;

@Service
public class ClearAlarmsRepoService {

	@Autowired
	ClearAlarmsRepository alRepo;

	private SessionFactory sessionFactory;

	@Autowired
	public ClearAlarmsRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	public ClearAlarms addClearAlarm(@Valid ClearAlarmsCreate ac) {
		ClearAlarms al = new ClearAlarms();
		
		al = updateFromAPICall( al , ac);
		return this.alRepo.save( al );
	}

	

	public List findAll(String fields, Map<String, String> allParams) throws UnsupportedEncodingException {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ClearAlarms> alist = null;
		try {
			String sql = "SELECT "
					+ "s.uuid as uuid,"
					+ "s.id as id,"
					+ "s.alarmClearedTime as alarmClearedTime,"
					+ "s.clearUserId as clearUserId,"
					+ "s.state as state";
			
			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", s." + f + " as " + f ;
				}
				
			}			
			sql += " FROM AMClearAlarms s";
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			sql += " ORDER BY s.alarmClearedTime DESC";
			
	
			
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

	public ClearAlarms findById(String id) {
		Optional<ClearAlarms> optionalCat = this.alRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}
	
	private ClearAlarms updateFromAPICall(ClearAlarms al, @Valid ClearAlarmsCreate aSrc) {

		al.setClearSystemId( aSrc.getClearSystemId());
		al.setAlarmClearedTime( OffsetDateTime.now(ZoneOffset.UTC) );
		al.setClearUserId( aSrc.getClearUserId() );
		
		if ( aSrc.getState() != null ) {
			al.setState( aSrc.getState());			
		}
		al.setState( AlarmStateType.cleared.name() );
		if ( aSrc.getState() != null ) {
			al.setState( aSrc.getState());			
		}
		
//		maybe here we need to update the real Alarm?
//				raised | updated | cleared).

		al.getClearedAlarm().addAll( aSrc.getClearedAlarm() )  ;
		
		
		al.getAlarmPattern().addAll(aSrc.getAlarmPattern() );
		
		

		return al;
	}
	
}
