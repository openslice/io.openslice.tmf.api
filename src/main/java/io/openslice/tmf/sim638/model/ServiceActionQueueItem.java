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


package io.openslice.tmf.sim638.model;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;

/**
 * @author ctranoris
 * 
 * These are items inserted in the ServiceActionQueue
 *
 */
@Entity(name = "ServiceActionQueueItem")
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Schema(description = "These are items inserted in the ServiceActionQueue ")
@Validated
public class ServiceActionQueueItem {


	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;
	

	@JsonProperty("serviceRefId")
	private String serviceRefId = null;
	

	private OffsetDateTime insertedDate = null;

	@JsonProperty("action")
	ServiceActionQueueAction action = ServiceActionQueueAction.NONE; 
	
	/**
	 * keeps the original service object in JSON. Useful to revert changes or identify different characteristics
	 */

	@Lob
	@Column(name = "LORIGINAL_SERVICE", columnDefinition = "LONGTEXT")
	private String originalServiceInJSONL;
	
	public ServiceActionQueueItem() {
		insertedDate = OffsetDateTime.now(ZoneOffset.UTC);
	}

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the serviceRefId
	 */
	public String getServiceRefId() {
		return serviceRefId;
	}

	/**
	 * @param serviceRefId the serviceRefId to set
	 */
	public void setServiceRefId(String serviceRefId) {
		this.serviceRefId = serviceRefId;
	}

	/**
	 * @return the insertedDate
	 */
	public OffsetDateTime getInsertedDate() {
		return insertedDate;
	}

	/**
	 * @param insertedDate the insertedDate to set
	 */
	public void setInsertedDate(OffsetDateTime insertedDate) {
		this.insertedDate = insertedDate;
	}
	
	public void setInsertedDate(String insDate) {
		if ( insDate!=null ) {
			this.insertedDate = OffsetDateTime.parse( insDate );			
		}
	}
	
	
	@JsonProperty("insertedDate")
	public String getInsertedDateStr() {
		if ( this.insertedDate != null ) {
			return this.insertedDate.toString();			
		} else {
			return null;
		}
	}

	/**
	 * @return the action
	 */
	public ServiceActionQueueAction getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(ServiceActionQueueAction action) {
		this.action = action;
	}
	
	
	/**
	 * keeps the original service object in JSON. Useful to revert changes or identify different characteristics
	 */

	public String getOriginalServiceInJSON() {
		return originalServiceInJSONL;
	}
	/**
	 * keeps the original service object in JSON. Useful to revert changes or identify different characteristics
	 */

	public void setOriginalServiceInJSON(String originalServiceInJSON) {
		this.originalServiceInJSONL = originalServiceInJSON;
	}
	
	
}
