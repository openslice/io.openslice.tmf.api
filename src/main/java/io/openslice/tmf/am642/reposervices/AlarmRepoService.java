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

import io.openslice.tmf.am642.api.AlarmApiRouteBuilderEvents;
import io.openslice.tmf.am642.model.AffectedService;
import io.openslice.tmf.am642.model.Alarm;
import io.openslice.tmf.am642.model.AlarmCreate;
import io.openslice.tmf.am642.model.AlarmCreateEvent;
import io.openslice.tmf.am642.model.AlarmCreateEventPayload;
import io.openslice.tmf.am642.model.AlarmRef;
import io.openslice.tmf.am642.model.AlarmStateType;
import io.openslice.tmf.am642.model.AlarmUpdate;
import io.openslice.tmf.am642.model.Comment;
import io.openslice.tmf.am642.model.RelatedPlaceRefOrValue;
import io.openslice.tmf.am642.repo.AlarmRepository;
import io.openslice.tmf.common.model.service.ServiceStateType;
import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.openslice.tmf.sim638.service.ServiceRepoService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.validation.Valid;

@Service
public class AlarmRepoService {

	@Autowired
	AlarmRepository alarmRepo;

	@Autowired
	ServiceRepoService serviceRepoService;

	@Autowired
	AlarmApiRouteBuilderEvents alarmApiRouteBuilder;

	private SessionFactory sessionFactory;

	@Autowired
	public AlarmRepoService(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		this.sessionFactory = factory.unwrap(SessionFactory.class);
	}

	@Transactional
	public Alarm addAlarm(@Valid AlarmCreate alarmUpdate) {
		Alarm al = new Alarm();
		al.setAlarmReportingTime(OffsetDateTime.now(ZoneOffset.UTC));
		al.setAlarmChangedTime(OffsetDateTime.now(ZoneOffset.UTC));
		al.setSourceSystemId(alarmUpdate.getSourceSystemId());
		al.setAlarmRaisedTime( alarmUpdate.getAlarmRaisedTime() );

		al = updateAlarmFromAPICall(al, alarmUpdate);

		al = updateAffectedServiceIF_NFVO(al);

		al = this.alarmRepo.save(al);
		raiseAlarmCreateEvent(al);
		return al;
	}

	public List<Alarm> findAll() {
		return (List<Alarm>) this.alarmRepo.findAll();
	}

	public Alarm findById(String id) {
		Optional<Alarm> optionalCat = this.alarmRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	/**
	 * 
	 * This one is needed if we have a specific alarm from NFVO (OSM in our case)
	 * In future we might have more complex things
	 * This function could be in OAS to find and identify the related Service from the inventory
	 * that is related with this NS instance
	 * 
	 * @param al
	 * @return
	 */
	private Alarm updateAffectedServiceIF_NFVO(Alarm al) {
		// specificProblem(DeploymentRequestID=OSM NS_ID)

		if ( (al.getSourceSystemId().equals("mano-client-service") ) && (al.getAlarmDetails() != null) ) {
			if (al.getAlarmDetails().contains("DeploymentRequestID")) {
				String[] vals = al.getAlarmDetails().split(";");
				for (String details : vals) {
					String[] d = details.split("=");
					if ( d[0].equals( "DeploymentRequestID" ) ) {
						var aservices = serviceRepoService.findDeploymentRequestID( d[1] );
						
						for (io.openslice.tmf.sim638.model.Service service : aservices) {
							if ( service.getState().equals( ServiceStateType.ACTIVE )  ) {
								AffectedService as = new AffectedService();
								as.setId( service.getUuid());
								as.setBaseType("Service");
								al.getAffectedService().add(as );								
							}
						}	
						
					}				
				}
				
			}
		}

		return al;
	}

	@Transactional
	private Alarm updateAlarmFromAPICall(Alarm al, @Valid AlarmUpdate alarmUpdate) {

		if (alarmUpdate.getAckState() != null) {
			al.setAckState(alarmUpdate.getAckState());
		}
		if (alarmUpdate.getAckSystemId() != null) {
			al.setAckSystemId(alarmUpdate.getAckSystemId());
		}
		if (alarmUpdate.getAckUserId() != null) {
			al.setAckUserId(alarmUpdate.getAckUserId());
		}
		if (alarmUpdate.getAlarmChangedTime() != null) {
			al.setAlarmChangedTime(alarmUpdate.getAlarmChangedTime());
		}
		if (alarmUpdate.getAlarmClearedTime() != null) {
			al.setAlarmClearedTime(alarmUpdate.getAlarmClearedTime());
		}
		if (alarmUpdate.getAlarmDetails() != null) {
			al.setAlarmDetails(alarmUpdate.getAlarmDetails());
		}
		if (alarmUpdate.isAlarmEscalation() != null) {
			al.setAlarmEscalation(alarmUpdate.isAlarmEscalation());
		}
//		if (alarmUpdate.getAlarmReportingTime()!=null){
//			al.setAlarmReportingTime(alarmUpdate.getAlarmReportingTime());			
//		}
		if (alarmUpdate.getAlarmType() != null) {
			al.setAlarmType(alarmUpdate.getAlarmType());
		}
		if (alarmUpdate.getAlarmedObjectType() != null) {
			al.setAlarmedObjectType(alarmUpdate.getAlarmedObjectType());
		}
		if (alarmUpdate.getClearSystemId() != null) {
			al.setClearSystemId(alarmUpdate.getClearSystemId());
		}
		if (alarmUpdate.getClearUserId() != null) {
			al.setClearUserId(alarmUpdate.getClearUserId());
		}
		if (alarmUpdate.getExternalAlarmId() != null) {
			al.setExternalAlarmId(alarmUpdate.getExternalAlarmId());
		}
		if (alarmUpdate.isIsRootCause() != null) {
			al.setIsRootCause(alarmUpdate.isIsRootCause());
		}
		if (alarmUpdate.getPerceivedSeverity() != null) {
			al.setPerceivedSeverity(alarmUpdate.getPerceivedSeverity());
		}
		if (alarmUpdate.getPlannedOutageIndicator() != null) {
			al.setPlannedOutageIndicator(alarmUpdate.getPlannedOutageIndicator());
		}
		if (alarmUpdate.getProbableCause() != null) {
			al.setProbableCause(alarmUpdate.getProbableCause());
		}
		if (alarmUpdate.getProposedRepairedActions() != null) {
			al.setProposedRepairedActions(alarmUpdate.getProposedRepairedActions());
		}
		if (alarmUpdate.getReportingSystemId() != null) {
			al.setReportingSystemId(alarmUpdate.getReportingSystemId());
		}

		if (alarmUpdate.isServiceAffecting() != null) {
			al.setServiceAffecting(alarmUpdate.isServiceAffecting());
		}
		if (alarmUpdate.getSpecificProblem() != null) {
			al.setSpecificProblem(alarmUpdate.getSpecificProblem());
		}

		al.setState(AlarmStateType.raised.name());
		if (alarmUpdate.getState() != null) {
			al.setState(alarmUpdate.getState());
		}

		if (alarmUpdate.getAffectedService() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AffectedService ar : alarmUpdate.getAffectedService()) {
				// find by id and reload it here.
				// we need the model from resource models
				boolean idexists = false;
				for (AffectedService orinalAtt : al.getAffectedService()) {
					if (orinalAtt.getId().equals(ar.getId())) {
						idexists = true;
						idAddedUpdated.put(orinalAtt.getId(), true);
						break;
					}
				}

				if (!idexists) {
					al.getAffectedService().add(ar);
					idAddedUpdated.put(ar.getId(), true);
				}
			}

			List<AffectedService> toRemove = new ArrayList<>();
			for (AffectedService ss : al.getAffectedService()) {
				if (idAddedUpdated.get(ss.getId()) == null) {
					toRemove.add(ss);
				}
			}

			for (AffectedService ar : toRemove) {
				al.getAffectedService().remove(ar);
			}

		}

		if (alarmUpdate.getAlarmedObject() != null) {
			al.setAlarmedObject(alarmUpdate.getAlarmedObject());
		}

		if (alarmUpdate.getCorrelatedAlarm() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AlarmRef ar : alarmUpdate.getCorrelatedAlarm()) {
				// find by id and reload it here.
				// we need the model from resource models
				boolean idexists = false;
				for (AlarmRef orinalCom : al.getCorrelatedAlarm()) {
					if (orinalCom.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalCom.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					al.getCorrelatedAlarm().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<AlarmRef> toRemove = new ArrayList<>();
			for (AlarmRef ss : al.getCorrelatedAlarm()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (AlarmRef ar : toRemove) {
				al.getCorrelatedAlarm().remove(ar);
			}

		}

		if (alarmUpdate.getCrossedThresholdInformation() != null) {
			al.setCrossedThresholdInformation(alarmUpdate.getCrossedThresholdInformation());
		}

		if (alarmUpdate.getParentAlarm() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (AlarmRef ar : alarmUpdate.getParentAlarm()) {
				// find by id and reload it here.
				// we need the model from resource models
				boolean idexists = false;
				for (AlarmRef orinalCom : al.getParentAlarm()) {
					if (orinalCom.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalCom.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					al.getParentAlarm().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<AlarmRef> toRemove = new ArrayList<>();
			for (AlarmRef ss : al.getParentAlarm()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (AlarmRef ar : toRemove) {
				al.getParentAlarm().remove(ar);
			}

		}

		if (alarmUpdate.getPlace() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (RelatedPlaceRefOrValue ar : alarmUpdate.getPlace()) {
				// find by id and reload it here.
				// we need the model from resource models
				boolean idexists = false;
				for (RelatedPlaceRefOrValue orinalCom : al.getPlace()) {
					if (orinalCom.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalCom.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					al.getPlace().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

			List<RelatedPlaceRefOrValue> toRemove = new ArrayList<>();
			for (RelatedPlaceRefOrValue ss : al.getPlace()) {
				if (idAddedUpdated.get(ss.getUuid()) == null) {
					toRemove.add(ss);
				}
			}

			for (RelatedPlaceRefOrValue ar : toRemove) {
				al.getPlace().remove(ar);
			}

		}

		if (alarmUpdate.getComment() != null) {
			// reattach attachments fromDB

			Map<String, Boolean> idAddedUpdated = new HashMap<>();

			for (Comment ar : alarmUpdate.getComment()) {
				// find by id and reload it here.
				// we need the model from resource models
				boolean idexists = false;
				for (Comment orinalCom : al.getComment()) {
					if (orinalCom.getUuid().equals(ar.getUuid())) {
						idexists = true;
						idAddedUpdated.put(orinalCom.getUuid(), true);
						break;
					}
				}

				if (!idexists) {
					al.getComment().add(ar);
					idAddedUpdated.put(ar.getUuid(), true);
				}
			}

		}

		return al;
	}

	public Void deleteById(String id) {
		Optional<Alarm> optionalCat = this.alarmRepo.findByUuid(id);
		this.alarmRepo.delete(optionalCat.get());
		return null;
	}

	public List findAll(@Valid String fields, Map<String, String> allParams) throws UnsupportedEncodingException {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<ServiceSpecification> alist = null;
		try {
			String sql = "SELECT " + "s.uuid as uuid," + "s.uuid as id," + "s.alarmType as alarmType,"
					+ "s.ackState as ackState," + "s.alarmRaisedTime as alarmRaisedTime,"
					+ "s.alarmReportingTime as alarmReportingTime," + "s.probableCause as probableCause,"
					+ "s.sourceSystemId as sourceSystemId," + "s.state as state,"
					+ "s.perceivedSeverity as perceivedSeverity";

			if (fields != null) {
				String[] field = fields.split(",");
				for (String f : field) {
					sql += ", s." + f + " as " + f;
				}

			}
			sql += " FROM AMAlarm s";
			if (allParams.size() > 0) {
				sql += " WHERE ";
				for (String pname : allParams.keySet()) {
					sql += " " + pname + " LIKE ";
					String pval = URLDecoder.decode(allParams.get(pname), StandardCharsets.UTF_8.toString());
					sql += "'" + pval + "'";
				}

			}
			sql += " ORDER BY s.alarmRaisedTime DESC";

			List<Object> mapaEntity = session.createQuery(sql).setResultTransformer(new ResultTransformer() {

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
			}).list();

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
	public Alarm updateAlarm(String id, @Valid AlarmUpdate alarmUpdate) {
		Alarm s = this.findByUuid(id);
		if (s == null) {
			return null;
		}
		Alarm alm = s;
		alm = this.updateAlarmFromAPICall(alm, alarmUpdate);

		alm = this.alarmRepo.save(alm);
		return alm;
	}

	public Alarm findByUuid(String id) {
		Optional<Alarm> optionalCat = this.alarmRepo.findByUuid(id);
		return optionalCat.orElse(null);
	}

	public Alarm findByUuidEager(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction(); // instead of begin transaction, is it possible to continue?
		Alarm dd = null;
		try {
			dd = session.get(Alarm.class, id);
			if (dd == null) {
				return this.findByUuid(id);// last resort
			}
			Hibernate.initialize(dd.getAffectedService());
			Hibernate.initialize(dd.getComment());
			Hibernate.initialize(dd.getCorrelatedAlarm());
			Hibernate.initialize(dd.getParentAlarm());
			Hibernate.initialize(dd.getPlace());

			tx.commit();
		} finally {
			session.close();
		}
		return dd;
	}

	@Transactional
	private void raiseAlarmCreateEvent(Alarm alarm) {
		AlarmCreateEvent e = new AlarmCreateEvent();
		AlarmCreateEventPayload p = new AlarmCreateEventPayload();
		p.setAlarm(alarm);
		e.setEvent(p);
		e.setTitle("AlarmCreate " + alarm.getId());
		e.setTimeOcurred( alarm.getAlarmReportingTime() );
		alarmApiRouteBuilder.publishEvent(e, alarm.getId());
	}

}
