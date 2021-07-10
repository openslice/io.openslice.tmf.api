package io.openslice.tmf.ri639.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Configuration feature.
 */
@ApiModel(description = "Configuration feature.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIFeature")
public class Feature {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	protected String uuid = null;

	@JsonProperty("id")
	private String id = null;

	@JsonProperty("isBundle")
	private Boolean isBundle = null;

	@JsonProperty("isEnabled")
	private Boolean isEnabled = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("constraint")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<ConstraintRef> constraint = new HashSet<>();

	@JsonProperty("featureCharacteristic")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Characteristic> featureCharacteristic = new HashSet<>();

	@JsonProperty("featureRelationship")
	@Valid
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<FeatureRelationship> featureRelationship = new HashSet<>();


	/**
	 * Unique identifier of the feature.
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the feature.")
	public String getId() {
		id = uuid;
		return uuid;
	}


	public Feature isBundle(Boolean isBundle) {
		this.isBundle = isBundle;
		return this;
	}

	/**
	 * True if this is a feature group. Default is false.
	 * 
	 * @return isBundle
	 **/
	@ApiModelProperty(value = "True if this is a feature group. Default is false.")

	public Boolean isIsBundle() {
		return isBundle;
	}

	public void setIsBundle(Boolean isBundle) {
		this.isBundle = isBundle;
	}

	public Feature isEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
		return this;
	}

	/**
	 * True if this feature is enabled. Default is true.
	 * 
	 * @return isEnabled
	 **/
	@ApiModelProperty(value = "True if this feature is enabled. Default is true.")

	public Boolean isIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Feature name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * This is the name for the feature.
	 * 
	 * @return name
	 **/
	@ApiModelProperty(required = true, value = "This is the name for the feature.")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Feature constraint( Set<ConstraintRef> constraint) {
		this.constraint = constraint;
		return this;
	}

	public Feature addConstraintItem(ConstraintRef constraintItem) {
		if (this.constraint == null) {
			this.constraint = new HashSet<>();
		}
		this.constraint.add(constraintItem);
		return this;
	}

	/**
	 * This is a list of feature constraints.
	 * 
	 * @return constraint
	 **/
	@ApiModelProperty(value = "This is a list of feature constraints.")
	@Valid
	public Set<ConstraintRef> getConstraint() {
		return constraint;
	}

	public void setConstraint(Set<ConstraintRef> constraint) {
		this.constraint = constraint;
	}

	public Feature featureCharacteristic(Set<Characteristic> featureCharacteristic) {
		this.featureCharacteristic = featureCharacteristic;
		return this;
	}

	public Feature addFeatureCharacteristicItem(Characteristic featureCharacteristicItem) {
		this.featureCharacteristic.add(featureCharacteristicItem);
		return this;
	}

	/**
	 * This is a list of Characteristics for a particular feature.
	 * 
	 * @return featureCharacteristic
	 **/
	@ApiModelProperty(required = true, value = "This is a list of Characteristics for a particular feature.")
	@NotNull
	@Valid
	@Size(min = 1)
	public Set<Characteristic> getFeatureCharacteristic() {
		return featureCharacteristic;
	}

	public void setFeatureCharacteristic(Set<Characteristic> featureCharacteristic) {
		this.featureCharacteristic = featureCharacteristic;
	}

	public Feature featureRelationship(Set<FeatureRelationship> featureRelationship) {
		this.featureRelationship = featureRelationship;
		return this;
	}

	public Feature addFeatureRelationshipItem(FeatureRelationship featureRelationshipItem) {
		if (this.featureRelationship == null) {
			this.featureRelationship = new HashSet<>();
		}
		this.featureRelationship.add(featureRelationshipItem);
		return this;
	}

	/**
	 * Get featureRelationship
	 * 
	 * @return featureRelationship
	 **/
	@ApiModelProperty(value = "")
	@Valid
	public Set<FeatureRelationship> getFeatureRelationship() {
		return featureRelationship;
	}

	public void setFeatureRelationship(Set<FeatureRelationship> featureRelationship) {
		this.featureRelationship = featureRelationship;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Feature feature = (Feature) o;
		return Objects.equals(this.id, feature.id) && Objects.equals(this.isBundle, feature.isBundle)
				&& Objects.equals(this.isEnabled, feature.isEnabled) && Objects.equals(this.name, feature.name)
				&& Objects.equals(this.constraint, feature.constraint)
				&& Objects.equals(this.featureCharacteristic, feature.featureCharacteristic)
				&& Objects.equals(this.featureRelationship, feature.featureRelationship);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isBundle, isEnabled, name, constraint, featureCharacteristic, featureRelationship);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Feature {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
		sb.append("    isEnabled: ").append(toIndentedString(isEnabled)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    constraint: ").append(toIndentedString(constraint)).append("\n");
		sb.append("    featureCharacteristic: ").append(toIndentedString(featureCharacteristic)).append("\n");
		sb.append("    featureRelationship: ").append(toIndentedString(featureRelationship)).append("\n");
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
}
