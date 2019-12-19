package io.openslice.tmf.fi691.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import io.openslice.tmf.common.model.BaseRootNamedEntity;
import io.openslice.tmf.fi691.model.GeographicPointType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeographicLocationRefOrValueType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-20T00:39:05.842+02:00")

@Entity(name = "GeographicLocationRefOrValueType")
public class GeographicLocationRefOrValueType extends BaseRootNamedEntity {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("geographicPoint")
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "uuid")
	private GeographicPointType geographicPoint = null;

	@JsonProperty("@schemaLocation")
	private String schemaLocation = null;

	public GeographicLocationRefOrValueType id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique identifier of the location entity within the server
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "Unique identifier of the location entity within the server")

	public String getId() {
		return uuid;
	}

	public GeographicLocationRefOrValueType geographicPoint(GeographicPointType geographicPoint) {
		this.geographicPoint = geographicPoint;
		return this;
	}

	/**
	 * A list of geo points. A GeoPoint defines a geographic point through
	 * coordinates
	 * 
	 * @return geographicPoint
	 **/
	@ApiModelProperty(value = "A list of geo points. A GeoPoint defines a geographic point through coordinates")

	@Valid

	public GeographicPointType getGeographicPoint() {
		return geographicPoint;
	}

	public void setGeographicPoint(GeographicPointType geographicPoint) {
		this.geographicPoint = geographicPoint;
	}

	public GeographicLocationRefOrValueType schemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
		return this;
	}

	/**
	 * A Link to the schema describing this REST Resource
	 * 
	 * @return schemaLocation
	 **/
	@ApiModelProperty(value = "A Link to the schema describing this REST Resource")

	public String getSchemaLocation() {
		return schemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GeographicLocationRefOrValueType geographicLocationRefOrValueType = (GeographicLocationRefOrValueType) o;
		return Objects.equals(this.id, geographicLocationRefOrValueType.id)
				&& Objects.equals(this.href, geographicLocationRefOrValueType.href)
				&& Objects.equals(this.name, geographicLocationRefOrValueType.name)
				&& Objects.equals(this.type, geographicLocationRefOrValueType.type)
				&& Objects.equals(this.geographicPoint, geographicLocationRefOrValueType.geographicPoint)
				&& Objects.equals(this.type, geographicLocationRefOrValueType.type)
				&& Objects.equals(this.schemaLocation, geographicLocationRefOrValueType.schemaLocation);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class GeographicLocationRefOrValueType {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    href: ").append(toIndentedString(href)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    geographicPoint: ").append(toIndentedString(geographicPoint)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
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
