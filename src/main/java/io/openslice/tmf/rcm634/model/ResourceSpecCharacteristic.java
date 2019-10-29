package io.openslice.tmf.rcm634.model;

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
 * This class defines the characteristic features of a resource specification.
 * Every ResourceSpecification has a variety of important attributes, methods,
 * constraints, and relationships, which distinguish a resource specification
 * from other resource specifications.
 */
@ApiModel(description = "This class defines the characteristic features of a resource specification. Every ResourceSpecification has a variety of important attributes, methods, constraints, and relationships, which distinguish a resource specification from other resource specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

@Entity(name = "ResourceSpecCharacteristic")
public class ResourceSpecCharacteristic extends BaseRootNamedEntity {


	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	@JsonProperty("description")
	private String description = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("configurable")
	private Boolean configurable = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;


	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	@JsonProperty("@valueSchemaLocation")
	private String valueSchemaLocation = null;

	@JsonProperty("minCardinality")
	private Integer minCardinality = null;

	@JsonProperty("maxCardinality")
	private Integer maxCardinality = null;

	@JsonProperty("isUnique")
	private Boolean isUnique = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("extensible")
	private Boolean extensible = null;

	@JsonProperty("resourceSpecCharRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceSpecCharRelationship> resourceSpecCharRelationship =  new HashSet<>();;

	@JsonProperty("resourceSpecCharacteristicValue")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ResourceSpecCharacteristicValue> resourceSpecCharacteristicValue =  new HashSet<>();;

	public ResourceSpecCharacteristic() {
		super();
		this.baseType = "BaseRootEntity";
		this.type = this.getClass().getName();
	}
	
	
	public ResourceSpecCharacteristic(ResourceSpecCharacteristic src) {
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
		
		for (ResourceSpecCharRelationship r : src.resourceSpecCharRelationship) {
			this.addResourceSpecCharRelationshipItem( new ResourceSpecCharRelationship( r ));
		}
		
		for (ResourceSpecCharacteristicValue r : src.resourceSpecCharacteristicValue) {
			this.addResourceSpecCharacteristicValueItem( new ResourceSpecCharacteristicValue(r) );
		}

	}

	public ResourceSpecCharacteristic name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * A word, term, or phrase by which this characteristic specification is known
	 * and distinguished from other characteristic specifications.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(value = "A word, term, or phrase by which this characteristic specification is known and distinguished from other characteristic specifications.")

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceSpecCharacteristic description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * A narrative that explains the CharacteristicSpecification.
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "A narrative that explains the CharacteristicSpecification.")

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ResourceSpecCharacteristic valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric, text
	 * and so forth
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

	public ResourceSpecCharacteristic configurable(Boolean configurable) {
		this.configurable = configurable;
		return this;
	}

	/**
	 * If true, the Boolean indicates that the ResourceSpecCharacteristic is
	 * configurable
	 * 
	 * @return configurable
	 **/
	@ApiModelProperty(value = "If true, the Boolean indicates that the ResourceSpecCharacteristic is configurable")

	public Boolean isConfigurable() {
		return configurable;
	}

	public void setConfigurable(Boolean configurable) {
		this.configurable = configurable;
	}

	public ResourceSpecCharacteristic validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period of time for which a characteristic is applicable.
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period of time for which a characteristic is applicable.")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ResourceSpecCharacteristic type(String type) {
		this.type = type;
		return this;
	}

	/**
	 * (Class) type of the ResourceSpecCharacteristic
	 * 
	 * @return type
	 **/
	@ApiModelProperty(value = "(Class) type of the ResourceSpecCharacteristic")

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ResourceSpecCharacteristic schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A link to the schema describing this characteristic specification
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "A link to the schema describing this characteristic specification")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public ResourceSpecCharacteristic valueSchemaLocation(String valueSchemaLocation) {
		this.valueSchemaLocation = valueSchemaLocation;
		return this;
	}

	/**
	 * This (optional) field provides a link to the schema describing the value type
	 * 
	 * @return valueSchemaLocation
	 **/
	@ApiModelProperty(value = "This (optional) field provides a link to the schema describing the value type")

	public String getValueSchemaLocation() {
		return valueSchemaLocation;
	}

	public void setValueSchemaLocation(String valueSchemaLocation) {
		this.valueSchemaLocation = valueSchemaLocation;
	}

	public ResourceSpecCharacteristic minCardinality(Integer minCardinality) {
		this.minCardinality = minCardinality;
		return this;
	}

	/**
	 * The minimum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where zero is
	 * the value for the minCardinality.
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

	public ResourceSpecCharacteristic maxCardinality(Integer maxCardinality) {
		this.maxCardinality = maxCardinality;
		return this;
	}

	/**
	 * The maximum number of instances a CharacteristicValue can take on. For
	 * example, zero to five phone numbers in a group calling plan, where five is
	 * the value for the maxCardinality.
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

	public ResourceSpecCharacteristic isUnique(Boolean isUnique) {
		this.isUnique = isUnique;
		return this;
	}

	/**
	 * An indicator that specifies if a value is unique for the specification.
	 * Possible values are; \"unique while value is in effect\" and \"unique whether
	 * value is in effect or not\"
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

	public ResourceSpecCharacteristic regex(String regex) {
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

	public ResourceSpecCharacteristic extensible(Boolean extensible) {
		this.extensible = extensible;
		return this;
	}

	/**
	 * An indicator that specifies that the values for the characteristic can be
	 * extended by adding new values when instantiating a characteristic for a
	 * resource.
	 * 
	 * @return extensible
	 **/
	@ApiModelProperty(value = "An indicator that specifies that the values for the characteristic can be extended by adding new values when instantiating a characteristic for a resource.")

	public Boolean isExtensible() {
		return extensible;
	}

	public void setExtensible(Boolean extensible) {
		this.extensible = extensible;
	}

	public ResourceSpecCharacteristic resourceSpecCharRelationship(
			Set<ResourceSpecCharRelationship> resourceSpecCharRelationship) {
		this.resourceSpecCharRelationship = resourceSpecCharRelationship;
		return this;
	}

	public ResourceSpecCharacteristic addResourceSpecCharRelationshipItem(
			ResourceSpecCharRelationship resourceSpecCharRelationshipItem) {
		if (this.resourceSpecCharRelationship == null) {
			this.resourceSpecCharRelationship = new HashSet<>();
		}
		this.resourceSpecCharRelationship.add(resourceSpecCharRelationshipItem);
		return this;
	}

	/**
	 * Get resourceSpecCharRelationship
	 * 
	 * @return resourceSpecCharRelationship
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<ResourceSpecCharRelationship> getResourceSpecCharRelationship() {
		return resourceSpecCharRelationship;
	}

	public void setResourceSpecCharRelationship( Set<ResourceSpecCharRelationship> resourceSpecCharRelationship) {
		this.resourceSpecCharRelationship = resourceSpecCharRelationship;
	}

	public ResourceSpecCharacteristic resourceSpecCharacteristicValue(
			Set<ResourceSpecCharacteristicValue> resourceSpecCharacteristicValue) {
		this.resourceSpecCharacteristicValue = resourceSpecCharacteristicValue;
		return this;
	}

	public ResourceSpecCharacteristic addResourceSpecCharacteristicValueItem(
			ResourceSpecCharacteristicValue resourceSpecCharacteristicValueItem) {
		if (this.resourceSpecCharacteristicValue == null) {
			this.resourceSpecCharacteristicValue = new HashSet<>();
		}
		this.resourceSpecCharacteristicValue.add(resourceSpecCharacteristicValueItem);
		return this;
	}

	/**
	 * Get resourceSpecCharacteristicValue
	 * 
	 * @return resourceSpecCharacteristicValue
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Set<ResourceSpecCharacteristicValue> getResourceSpecCharacteristicValue() {
		return resourceSpecCharacteristicValue;
	}

	public void setResourceSpecCharacteristicValue(
			Set<ResourceSpecCharacteristicValue> resourceSpecCharacteristicValue) {
		this.resourceSpecCharacteristicValue = resourceSpecCharacteristicValue;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResourceSpecCharacteristic resourceSpecCharacteristic = (ResourceSpecCharacteristic) o;
		return Objects.equals(this.name, resourceSpecCharacteristic.name)
				&& Objects.equals(this.description, resourceSpecCharacteristic.description)
				&& Objects.equals(this.valueType, resourceSpecCharacteristic.valueType)
				&& Objects.equals(this.configurable, resourceSpecCharacteristic.configurable)
				&& Objects.equals(this.validFor, resourceSpecCharacteristic.validFor)
				&& Objects.equals(this.type, resourceSpecCharacteristic.type)
				&& Objects.equals(this.schemaLocation, resourceSpecCharacteristic.schemaLocation)
				&& Objects.equals(this.valueSchemaLocation, resourceSpecCharacteristic.valueSchemaLocation)
				&& Objects.equals(this.minCardinality, resourceSpecCharacteristic.minCardinality)
				&& Objects.equals(this.maxCardinality, resourceSpecCharacteristic.maxCardinality)
				&& Objects.equals(this.isUnique, resourceSpecCharacteristic.isUnique)
				&& Objects.equals(this.regex, resourceSpecCharacteristic.regex)
				&& Objects.equals(this.extensible, resourceSpecCharacteristic.extensible)
				&& Objects.equals(this.resourceSpecCharRelationship,
						resourceSpecCharacteristic.resourceSpecCharRelationship)
				&& Objects.equals(this.resourceSpecCharacteristicValue,
						resourceSpecCharacteristic.resourceSpecCharacteristicValue);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, name, description, valueType, configurable, validFor, type, schemaLocation,
//				valueSchemaLocation, minCardinality, maxCardinality, isUnique, regex, extensible,
//				resourceSpecCharRelationship, resourceSpecCharacteristicValue);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ResourceSpecCharacteristic {\n");

		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    configurable: ").append(toIndentedString(configurable)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    valueSchemaLocation: ").append(toIndentedString(valueSchemaLocation)).append("\n");
		sb.append("    minCardinality: ").append(toIndentedString(minCardinality)).append("\n");
		sb.append("    maxCardinality: ").append(toIndentedString(maxCardinality)).append("\n");
		sb.append("    isUnique: ").append(toIndentedString(isUnique)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    extensible: ").append(toIndentedString(extensible)).append("\n");
		sb.append("    resourceSpecCharRelationship: ").append(toIndentedString(resourceSpecCharRelationship))
				.append("\n");
		sb.append("    resourceSpecCharacteristicValue: ").append(toIndentedString(resourceSpecCharacteristicValue))
				.append("\n");
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


	public void updateWith(ResourceSpecCharacteristic src) {
		this.name = src.getName();
		this.description = src.getDescription();
		this.maxCardinality = src.getMaxCardinality();
		this.minCardinality = src.getMinCardinality();
		this.regex = src.getRegex();
		this.isUnique =src.isUnique;
		this.configurable =src.isConfigurable();
		this.extensible =src.isExtensible();

		this.updateResourceSpecCharacteristicValues(src.getResourceSpecCharacteristicValue());
		this.updateResourceSpecCharRelationships(src.getResourceSpecCharRelationship());

		
	}
	
	
	private void updateResourceSpecCharacteristicValues(
			@Valid Set<ResourceSpecCharacteristicValue> srcSet) {

		Map<Integer, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ResourceSpecCharacteristicValue r : srcSet) {

			boolean valueExists = false;
			for (ResourceSpecCharacteristicValue thisCharVal : this.resourceSpecCharacteristicValue) {
				if ( thisCharVal.hashCode() == r.hashCode() ) {
					valueExists = true;
					idAddedUpdated.put(thisCharVal.hashCode(), true);
					break;
				}
			}
			
			if (!valueExists) {
				ResourceSpecCharacteristicValue nr = new ResourceSpecCharacteristicValue( r );
				this.addResourceSpecCharacteristicValueItem( nr );
				idAddedUpdated.put( nr.hashCode(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<ResourceSpecCharacteristicValue> toRemove = new ArrayList<>();
		for (ResourceSpecCharacteristicValue ss : this.resourceSpecCharacteristicValue) {
			if ( idAddedUpdated.get( ss.hashCode() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (ResourceSpecCharacteristicValue r : toRemove) {
			this.resourceSpecCharacteristicValue.remove(r);
		}
		
		
	}
	
	private void updateResourceSpecCharRelationships(
			@Valid Set<ResourceSpecCharRelationship> srcSet) {
		
		
		Map< String, Boolean> idAddedUpdated = new HashMap<>();
		/**
		 * update, add the incomings
		 */
		for (ResourceSpecCharRelationship r : srcSet) {

			boolean valueExists = false;
			for (ResourceSpecCharRelationship thisCharVal : this.resourceSpecCharRelationship) {
				if ( (thisCharVal.getId()!=null) && (thisCharVal.getId().equals(r.getId() ) )) {
					valueExists = true;
					idAddedUpdated.put( thisCharVal.getId() , true);
					break;
				}
			}
			
			if (!valueExists) {
				this.resourceSpecCharRelationship.add( new ResourceSpecCharRelationship( r ));
				idAddedUpdated.put( r.getId(), true);
			}
			
		}
		
		/**
		 * remove those that don't exist anymore
		 */
		
		List<ResourceSpecCharRelationship> toRemove = new ArrayList<>();
		for (ResourceSpecCharRelationship ss : this.resourceSpecCharRelationship) {
			if ( idAddedUpdated.get( ss.getId() ) == null ) {
				toRemove.add(ss);
			}
		}
		
		for (ResourceSpecCharRelationship r : toRemove) {
			this.resourceSpecCharRelationship.remove(r);
		}
		
		
	}
}
