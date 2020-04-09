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
package io.openslice.tmf.scm633.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.BaseRootEntity;
import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.common.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class represents the key features of this service specification. For
 * example, bandwidth is a characteristic of many different types of services;
 * if bandwidth is a relevant characteristic (e.g., from the point-of-view of a
 * Customer obtaining this Service via a Product) then bandwidth would be a
 * ServiceSpecCharacteristic for that particular Service.
 */
@ApiModel(description = "This class represents the key features of this service specification. For example, bandwidth is a characteristic of many different types of services; if bandwidth is a relevant characteristic (e.g., from the point-of-view of a Customer obtaining this Service via a Product) then bandwidth would be a ServiceSpecCharacteristic for that particular Service.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceSpecCharacteristic")
public class ServiceSpecCharacteristic extends BaseRootNamedEntity {
	@JsonProperty("configurable")
	private Boolean configurable = null;

	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("extensible")
	private Boolean extensible = null;

	@JsonProperty("isUnique")
	private Boolean isUnique = null;

	@JsonProperty("maxCardinality")
	private Integer maxCardinality = null;

	@JsonProperty("minCardinality")
	private Integer minCardinality = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("serviceSpecCharRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceSpecCharRelationship> serviceSpecCharRelationship = new HashSet<>();

	@JsonProperty("serviceSpecCharacteristicValue")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ServiceSpecCharacteristicValue> serviceSpecCharacteristicValue = new HashSet<>();

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("@valueSchemaLocation")
	private String valueSchemaLocation = null;
	

	@JsonProperty("id")
	protected String id = null;

	/**
	 * @return the id
	 */
	public String getId() {
		id = uuid;
		return uuid;
	}
	
	public ServiceSpecCharacteristic configurable(Boolean configurable) {
		this.configurable = configurable;
		return this;
	}

	public ServiceSpecCharacteristic() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}

	public ServiceSpecCharacteristic(ServiceSpecCharacteristic src) {
		this();
		configurable = src.configurable;
		description = src.description;
		extensible = src.extensible;
		isUnique = src.isUnique;
		maxCardinality = src.maxCardinality;
		minCardinality = src.minCardinality;
		name = src.name;
		regex = src.regex;
		valueType = src.valueType;
		validFor = new TimePeriod( src.validFor ) ;
		
		for (ServiceSpecCharRelationship r : src.serviceSpecCharRelationship) {
			this.addServiceSpecCharRelationshipItem( new ServiceSpecCharRelationship( r ));
		}
		
		for (ServiceSpecCharacteristicValue r : src.serviceSpecCharacteristicValue) {
			this.addServiceSpecCharacteristicValueItem( new ServiceSpecCharacteristicValue(r) );
		}

	}

	/**
	 * If true, the Boolean indicates that the serviceSpecCharacteristic is
	 * configurable
	 * 
	 * @return configurable
	 **/
	@ApiModelProperty(value = "If true, the Boolean indicates that the serviceSpecCharacteristic is configurable")

	public Boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	public ServiceSpecCharacteristic description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative that explains in detail what the serviceSpecCharacteristic is
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A narrative that explains in detail what the serviceSpecCharacteristic is")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceSpecCharacteristic extensible(Boolean extensible) {
		this.extensible = extensible;
		return this;
	}

	/**
	 * An indicator that specifies that the values for the characteristic can be
	 * extended by adding new values when instantiating a characteristic for an
	 * Entity.
	 * 
	 * @return extensible
	 **/
	@ApiModelProperty(value = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for an Entity.")

	public Boolean isExtensible() {
		return extensible;
	}

	public void setExtensible(Boolean extensible) {
		this.extensible = extensible;
	}

	public ServiceSpecCharacteristic isUnique(Boolean isUnique) {
		this.isUnique = isUnique;
		return this;
	}

	/**
	 * An indicator that specifies if a value is unique for the specification.
	 * Possible values are; \"unique while value is in effect\" and \"unique
	 * whether value is in effect or not\"
	 * 
	 * @return isUnique
	 **/
	@ApiModelProperty(value = "An indicator that specifies if a value is unique for the specification. Possible values are; \"unique while value is in effect\" and \"unique whether value is in effect or not\"")

	public Boolean isIsUnique() {
		return isUnique;
	}

	public void setIsUnique(Boolean isUnique) {
		this.isUnique = isUnique;
	}

	public ServiceSpecCharacteristic maxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
		return this;
	}

	/**
	 * The maximum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where five
	 * is the value for the maxCardinality.
	 * 
	 * @return maxCardinality
	 **/
	@ApiModelProperty(value = "The maximum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where five is the value for the maxCardinality.")

	public Integer getMaxCardinality() {
		return maxCardinality;
	}

	public void setMaxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
	}

	public ServiceSpecCharacteristic minCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
		return this;
	}

	/**
	 * The minimum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where zero
	 * is the value for the minCardinality.
	 * 
	 * @return minCardinality
	 **/
	@ApiModelProperty(value = "The minimum number of instances a CharacteristicValue can take on. For example, zero to five phone numbers in a group calling plan, where zero is the value for the minCardinality.")

	public Integer getMinCardinality() {
		return minCardinality;
	}

	public void setMinCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
	}

	public ServiceSpecCharacteristic regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * A rule or principle represented in regular expression used to derive the
	 * value of a characteristic value.
	 * 
	 * @return regex
	 **/
	@ApiModelProperty(value = "A rule or principle represented in regular expression used to derive the value of a characteristic value.")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public ServiceSpecCharacteristic valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric,
	 * text and so forth
	 * 
	 * @return valueType
	 **/
	@ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public ServiceSpecCharacteristic serviceSpecCharRelationship(
			Set<ServiceSpecCharRelationship> serviceSpecCharRelationship) {
		this.serviceSpecCharRelationship = serviceSpecCharRelationship;
		return this;
	}

	public ServiceSpecCharacteristic addServiceSpecCharRelationshipItem(
			ServiceSpecCharRelationship serviceSpecCharRelationshipItem) {
		if (this.serviceSpecCharRelationship == null) {
			this.serviceSpecCharRelationship = new HashSet<ServiceSpecCharRelationship>();
		}
		this.serviceSpecCharRelationship.add(serviceSpecCharRelationshipItem);
		return this;
	}

	/**
	 * A list of service spec char relationships (ServiceSpecCharRelationship
	 * [*]). An aggregation, migration, substitution, dependency or exclusivity
	 * relationship between/among Specification Characteristics.
	 * 
	 * @return serviceSpecCharRelationship
	 **/
	@ApiModelProperty(value = "A list of service spec char relationships (ServiceSpecCharRelationship [*]). An aggregation, migration, substitution, dependency or exclusivity relationship between/among Specification Characteristics.")

	@Valid

	public Set<ServiceSpecCharRelationship> getServiceSpecCharRelationship() {
		return serviceSpecCharRelationship;
	}

	public void setServiceSpecCharRelationship(Set<ServiceSpecCharRelationship> serviceSpecCharRelationship) {
		this.serviceSpecCharRelationship = serviceSpecCharRelationship;
	}

	public ServiceSpecCharacteristic serviceSpecCharacteristicValue(
			Set<ServiceSpecCharacteristicValue> serviceSpecCharacteristicValue) {
		this.serviceSpecCharacteristicValue = serviceSpecCharacteristicValue;
		return this;
	}

	public ServiceSpecCharacteristic addServiceSpecCharacteristicValueItem(
			ServiceSpecCharacteristicValue serviceSpecCharacteristicValueItem) {
		if (this.serviceSpecCharacteristicValue == null) {
			this.serviceSpecCharacteristicValue = new HashSet<ServiceSpecCharacteristicValue>();
		}
		this.serviceSpecCharacteristicValue.add(serviceSpecCharacteristicValueItem);
		return this;
	}

	/**
	 * A list of service spec characteristic values
	 * (ServiceSpecCharacteristicValue [*]). A ServiceSpecCharacteristicValue
	 * object is used to define a set of attributes, each of which can be
	 * assigned to a corresponding set of attributes in a
	 * ServiceSpecCharacteristic object. The values of the attributes in the
	 * ServiceSpecCharacteristicValue object describe the values of the
	 * attributes that a corresponding ServiceSpecCharacteristic object can take
	 * on.
	 * 
	 * @return serviceSpecCharacteristicValue
	 **/
	@ApiModelProperty(value = "A list of service spec characteristic values (ServiceSpecCharacteristicValue [*]). A ServiceSpecCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ServiceSpecCharacteristic object. The values of the attributes in the ServiceSpecCharacteristicValue object describe the values of the attributes that a corresponding ServiceSpecCharacteristic object can take on.")

	@Valid

	public Set<ServiceSpecCharacteristicValue> getServiceSpecCharacteristicValue() {
		return serviceSpecCharacteristicValue;
	}

	public void setServiceSpecCharacteristicValue(Set<ServiceSpecCharacteristicValue> serviceSpecCharacteristicValue) {
		this.serviceSpecCharacteristicValue = serviceSpecCharacteristicValue;
	}

	public ServiceSpecCharacteristic validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period for which the serviceSpecCharacteristic is valid
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period for which the serviceSpecCharacteristic is valid")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ServiceSpecCharacteristic valueSchemaLocation(String valueSchemaLocation) {
		this.valueSchemaLocation = valueSchemaLocation;
		return this;
	}

	/**
	 * This (optional) field provides a link to the schema describing the value
	 * type.
	 * 
	 * @return valueSchemaLocation
	 **/
	@ApiModelProperty(value = "This (optional) field provides a link to the schema describing the value type.")

	public String getValueSchemaLocation() {
		return valueSchemaLocation;
	}

	public void setValueSchemaLocation(String valueSchemaLocation) {
		this.valueSchemaLocation = valueSchemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceSpecCharacteristic serviceSpecCharacteristic = (ServiceSpecCharacteristic) o;
		return Objects.equals(this.configurable, serviceSpecCharacteristic.configurable)
				&& Objects.equals(this.description, serviceSpecCharacteristic.description)
				&& Objects.equals(this.extensible, serviceSpecCharacteristic.extensible)
				&& Objects.equals(this.isUnique, serviceSpecCharacteristic.isUnique)
				&& Objects.equals(this.maxCardinality, serviceSpecCharacteristic.maxCardinality)
				&& Objects.equals(this.minCardinality, serviceSpecCharacteristic.minCardinality)
				&& Objects.equals(this.name, serviceSpecCharacteristic.name)
				&& Objects.equals(this.regex, serviceSpecCharacteristic.regex)
				&& Objects.equals(this.valueType, serviceSpecCharacteristic.valueType)
				&& Objects.equals(this.serviceSpecCharRelationship,
						serviceSpecCharacteristic.serviceSpecCharRelationship)
				&& Objects.equals(this.serviceSpecCharacteristicValue,
						serviceSpecCharacteristic.serviceSpecCharacteristicValue)
				&& Objects.equals(this.validFor, serviceSpecCharacteristic.validFor)
				&& Objects.equals(this.baseType, serviceSpecCharacteristic.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecCharacteristic.schemaLocation)
				&& Objects.equals(this.type, serviceSpecCharacteristic.type)
				&& Objects.equals(this.valueSchemaLocation, serviceSpecCharacteristic.valueSchemaLocation);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, configurable, description, extensible, isUnique, maxCardinality, minCardinality, name,
//				regex, valueType, serviceSpecCharRelationship, serviceSpecCharacteristicValue, validFor, baseType,
//				schemaLocation, type, valueSchemaLocation);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecCharacteristic {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
		sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    serviceSpecCharRelationship: ").append(toIndentedString(serviceSpecCharRelationship))
				.append("\n");
		sb.append("    serviceSpecCharacteristicValue: ").append(toIndentedString(serviceSpecCharacteristicValue))
				.append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    valueSchemaLocation: ").append(toIndentedString(valueSchemaLocation)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	public void updateWith(ServiceSpecCharacteristic src) {
		this.name = src.getName();
		this.description = src.getDescription();
		this.maxCardinality = src.getMaxCardinality();
		this.minCardinality = src.getMinCardinality();
		this.regex = src.getRegex();
		this.isUnique =src.isUnique;
		this.configurable =src.isConfigurable();
		this.extensible =src.isExtensible();
		this.valueType =src.valueType;

		this.updateServiceSpecCharacteristicValues(src.getServiceSpecCharacteristicValue());
		this.updateServiceSpecCharRelationships(src.getServiceSpecCharRelationship());

		
	}



	private void updateServiceSpecCharacteristicValues(
			@Valid Set<ServiceSpecCharacteristicValue> srcSet) {

		Map<Integer, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ServiceSpecCharacteristicValue r : srcSet) {

			boolean valueExists = false;
			for (ServiceSpecCharacteristicValue thisCharVal : this.serviceSpecCharacteristicValue) {
				if ( thisCharVal.hashCode() == r.hashCode() ) {
					valueExists = true;
					idAddedUpdated.put(thisCharVal.hashCode(), true);
					break;
				}
			}
			
			if (!valueExists) {
				ServiceSpecCharacteristicValue nr = new ServiceSpecCharacteristicValue( r );
				this.addServiceSpecCharacteristicValueItem( nr );
				idAddedUpdated.put( nr.hashCode(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<ServiceSpecCharacteristicValue> toRemove = new ArrayList<>();
		for (ServiceSpecCharacteristicValue ss : this.serviceSpecCharacteristicValue) {
			if ( idAddedUpdated.get( ss.hashCode() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (ServiceSpecCharacteristicValue r : toRemove) {
			this.serviceSpecCharacteristicValue.remove(r);
		}
		
		
	}
	
	private void updateServiceSpecCharRelationships(
			@Valid Set<ServiceSpecCharRelationship> srcSet) {
		
		
		Map< String, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ServiceSpecCharRelationship r : srcSet) {

			boolean valueExists = false;
			for (ServiceSpecCharRelationship thisCharVal : this.serviceSpecCharRelationship) {
				if ( (thisCharVal.getId()!=null) && (thisCharVal.getId().equals(r.getId() ) )) {
					valueExists = true;
					idAddedUpdated.put( thisCharVal.getId() , true);
					break;
				}
			}
			
			if (!valueExists) {
				this.serviceSpecCharRelationship.add( new ServiceSpecCharRelationship( r ));
				idAddedUpdated.put( r.getId(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<ServiceSpecCharRelationship> toRemove = new ArrayList<>();
		for (ServiceSpecCharRelationship ss : this.serviceSpecCharRelationship) {
			if ( idAddedUpdated.get( ss.getId() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (ServiceSpecCharRelationship r : toRemove) {
			this.serviceSpecCharRelationship.remove(r);
		}
		
		
	}
}
