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
package io.openslice.sd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import io.openslice.tmf.scm633.model.ServiceSpecification;
import io.swagger.annotations.ApiModel;

/**
 * This model will hold information that will help later on service orchestration.
 * It should be attached to entities that we need to orchestrate in general, like {@link ServiceSpecification} 
 * 
 * @author ctranoris
 *
 */
@ApiModel(description = "This model will hold information that will help later on service orchestration.")
@Validated
@Entity(name = "ServiceDescriptor")
public class ServiceDescriptor {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;


	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	Set<ServiceDescriptorAttr> metadata = new HashSet<>();
	
	
	/**
	 * references the root entity ID of this SD 
	 */
	private String rootEntityID;

	/**
	 * references the root entity ID of this SD 
	 */
	private String rootEntityType;
	
	
	public ServiceDescriptor() {

	}


	/**
	 * @return the metadata
	 */
	public Set<ServiceDescriptorAttr> getMetadata() {
		return metadata;
	}


	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Set<ServiceDescriptorAttr> metadata) {
		this.metadata = metadata;
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
	 * @return the rootEntityID
	 */
	public String getRootEntityID() {
		return rootEntityID;
	}


	/**
	 * @param rootEntityID the rootEntityID to set
	 */
	public void setRootEntityID(String rootEntityID) {
		this.rootEntityID = rootEntityID;
	}


	/**
	 * @return the rootEntityType
	 */
	public String getRootEntityType() {
		return rootEntityType;
	}


	/**
	 * @param rootEntityType the rootEntityType to set
	 */
	public void setRootEntityType(String rootEntityType) {
		this.rootEntityType = rootEntityType;
	}
	
	
	
}
