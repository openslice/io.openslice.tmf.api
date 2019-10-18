package io.openslice.tmf.scm633.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.scm633.model.Any;
import io.openslice.tmf.scm633.model.TimePeriod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A ServiceSpecCharacteristicValue object is used to define a set of
 * attributes, each of which can be assigned to a corresponding set of
 * attributes in a ServiceSpecCharacteristic object. The values of the
 * attributes in the ServiceSpecCharacteristicValue object describe the values
 * of the attributes that a corresponding ServiceSpecCharacteristic object can
 * take on.
 */
@ApiModel(description = "A ServiceSpecCharacteristicValue object is used to define a set of attributes, each of which can be assigned to a corresponding set of attributes in a ServiceSpecCharacteristic object. The values of the attributes in the ServiceSpecCharacteristicValue object describe the values of the attributes that a corresponding ServiceSpecCharacteristic object can take on.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Entity(name = "ServiceSpecCharacteristicValue")
public class ServiceSpecCharacteristicValue extends BaseRootEntity {
	@JsonProperty("isDefault")
	private Boolean isDefault = null;

	@JsonProperty("rangeInterval")
	private String rangeInterval = null;

	@JsonProperty("regex")
	private String regex = null;

	@JsonProperty("unitOfMeasure")
	private String unitOfMeasure = null;

	@JsonProperty("valueFrom")
	private Integer valueFrom = null;

	@JsonProperty("valueTo")
	private Integer valueTo = null;

	@JsonProperty("valueType")
	private String valueType = null;

	@JsonProperty("validFor")
	private TimePeriod validFor = null;

	@JsonProperty("value")
	private Any value = null;

	public ServiceSpecCharacteristicValue() {
	}
	
	public ServiceSpecCharacteristicValue(ServiceSpecCharacteristicValue r) {
		this();
		isDefault = r.isDefault;
		rangeInterval = r.rangeInterval;
		regex = r.regex;
		unitOfMeasure = r.unitOfMeasure;
		valueFrom = r.valueFrom;
		valueTo = r.valueTo;
		valueType = r.valueType;
		validFor = new TimePeriod( r.validFor );
		value = new Any( r.value.getValue(), r.value.getAlias()) ;
//		type = r.type;
		baseType = r.baseType;
		
		
	}

	public ServiceSpecCharacteristicValue isDefault(Boolean isDefault) {
		this.isDefault = isDefault;
		return this;
	}

	/**
	 * Indicates if the value is the default value for a characteristic
	 * 
	 * @return isDefault
	 **/
	@ApiModelProperty(value = "Indicates if the value is the default value for a characteristic")

	public Boolean isIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}

	public ServiceSpecCharacteristicValue rangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
		return this;
	}

	/**
	 * An indicator that specifies the inclusion or exclusion of the valueFrom and
	 * valueTo attributes. If applicable, possible values are \"open\", \"closed\",
	 * \"closedBottom\" and \"closedTop\".
	 * 
	 * @return rangeInterval
	 **/
	@ApiModelProperty(value = "An indicator that specifies the inclusion or exclusion of the valueFrom and valueTo attributes. If applicable, possible values are \"open\", \"closed\", \"closedBottom\" and \"closedTop\".")

	public String getRangeInterval() {
		return rangeInterval;
	}

	public void setRangeInterval(String rangeInterval) {
		this.rangeInterval = rangeInterval;
	}

	public ServiceSpecCharacteristicValue regex(String regex) {
		this.regex = regex;
		return this;
	}

	/**
	 * A regular expression constraint for given value
	 * 
	 * @return regex
	 **/
	@ApiModelProperty(value = "A regular expression constraint for given value")

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public ServiceSpecCharacteristicValue unitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
		return this;
	}

	/**
	 * A length, surface, volume, dry measure, liquid measure, money, weight, time,
	 * and the like. In general, a determinate quantity or magnitude of the kind
	 * designated, taken as a standard of comparison for others of the same kind, in
	 * assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.
	 * 
	 * @return unitOfMeasure
	 **/
	@ApiModelProperty(value = "A length, surface, volume, dry measure, liquid measure, money, weight, time, and the like. In general, a determinate quantity or magnitude of the kind designated, taken as a standard of comparison for others of the same kind, in assigning to them numerical values, as 1 foot, 1 yard, 1 mile, 1 square foot.")

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public ServiceSpecCharacteristicValue valueFrom(Integer valueFrom) {
		this.valueFrom = valueFrom;
		return this;
	}

	/**
	 * The low range value that a characteristic can take on
	 * 
	 * @return valueFrom
	 **/
	@ApiModelProperty(value = "The low range value that a characteristic can take on")

	public Integer getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(Integer valueFrom) {
		this.valueFrom = valueFrom;
	}

	public ServiceSpecCharacteristicValue valueTo(Integer valueTo) {
		this.valueTo = valueTo;
		return this;
	}

	/**
	 * The upper range value that a characteristic can take on
	 * 
	 * @return valueTo
	 **/
	@ApiModelProperty(value = "The upper range value that a characteristic can take on")

	public Integer getValueTo() {
		return valueTo;
	}

	public void setValueTo(Integer valueTo) {
		this.valueTo = valueTo;
	}

	public ServiceSpecCharacteristicValue valueType(String valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * A kind of value that the characteristic can take on, such as numeric, text,
	 * and so forth
	 * 
	 * @return valueType
	 **/
	@ApiModelProperty(value = "A kind of value that the characteristic can take on, such as numeric, text, and so forth")

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public ServiceSpecCharacteristicValue validFor(TimePeriod validFor) {
		this.validFor = validFor;
		return this;
	}

	/**
	 * The period of time for which a value is applicable
	 * 
	 * @return validFor
	 **/
	@ApiModelProperty(value = "The period of time for which a value is applicable")

	@Valid

	public TimePeriod getValidFor() {
		return validFor;
	}

	public void setValidFor(TimePeriod validFor) {
		this.validFor = validFor;
	}

	public ServiceSpecCharacteristicValue value(Any value) {
		this.value = value;
		return this;
	}

	/**
	 * A discrete value that the characteristic can take on, or the actual value of
	 * the characteristic
	 * 
	 * @return value
	 **/
	@ApiModelProperty(value = "A discrete value that the characteristic can take on, or the actual value of the characteristic")

	@Valid

	public Any getValue() {
		return value;
	}

	public void setValue(Any value) {
		this.value = value;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ServiceSpecCharacteristicValue serviceSpecCharacteristicValue = (ServiceSpecCharacteristicValue) o;
		return Objects.equals(this.isDefault, serviceSpecCharacteristicValue.isDefault)
				&& Objects.equals(this.rangeInterval, serviceSpecCharacteristicValue.rangeInterval)
				&& Objects.equals(this.regex, serviceSpecCharacteristicValue.regex)
				&& Objects.equals(this.unitOfMeasure, serviceSpecCharacteristicValue.unitOfMeasure)
				&& Objects.equals(this.valueFrom, serviceSpecCharacteristicValue.valueFrom)
				&& Objects.equals(this.valueTo, serviceSpecCharacteristicValue.valueTo)
				&& Objects.equals(this.valueType, serviceSpecCharacteristicValue.valueType)
				&& Objects.equals(this.validFor, serviceSpecCharacteristicValue.validFor)
				&& Objects.equals(this.value, serviceSpecCharacteristicValue.value)
				&& Objects.equals(this.baseType, serviceSpecCharacteristicValue.baseType)
				&& Objects.equals(this.schemaLocation, serviceSpecCharacteristicValue.schemaLocation)
				&& Objects.equals(this.type, serviceSpecCharacteristicValue.type);
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(uuid, isDefault, rangeInterval, regex, unitOfMeasure, valueFrom, valueTo, valueType, validFor,
//				value, baseType, schemaLocation, type);
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ServiceSpecCharacteristicValue {\n");

		sb.append("    isDefault: ").append(toIndentedString(isDefault)).append("\n");
		sb.append("    rangeInterval: ").append(toIndentedString(rangeInterval)).append("\n");
		sb.append("    regex: ").append(toIndentedString(regex)).append("\n");
		sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
		sb.append("    valueFrom: ").append(toIndentedString(valueFrom)).append("\n");
		sb.append("    valueTo: ").append(toIndentedString(valueTo)).append("\n");
		sb.append("    valueType: ").append(toIndentedString(valueType)).append("\n");
		sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
		sb.append("    value: ").append(toIndentedString(value)).append("\n");
		sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
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
