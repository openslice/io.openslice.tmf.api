package io.openslice.tmf.scm633.model;

import java.util.Objects;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Any
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Embeddable
public class Any {

	private String value;
	
	/**
	 * provides a meaning to the value. useful in enumerations
	 */
	private String alias;
	
	public Any() {
		super();
	}


	public Any(String value) {
		super();
		this.value = value;
	}
	
	public Any(String value, String alias) {
		super();
		this.value = value;
		this.alias = alias;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
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
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Any {\n");
	    sb.append("    value: ").append(toIndentedString(value)).append("\n");
	    sb.append("    alias: ").append(toIndentedString(alias)).append("\n");

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


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}
}
