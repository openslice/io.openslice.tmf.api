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
package io.openslice.tmf.common.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;

/**
 * Any
 */
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T19:18:54.771Z")

@Embeddable
public class Any {


	@Lob
	@Column( columnDefinition = "LONGTEXT")
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
	
	public Any(long value, String alias) {
		super();
		this.value = value+"";
		this.alias = alias;
	}

	public Any(int value, String alias) {
		super();
		this.value = value+"";
		this.alias = alias;
	}
	
	public Any(int value) {
		super();
		this.value = value+"";
		this.alias = "";
	}
	
	public Any(Any anyval) {

		if (anyval != null) {
			this.value = anyval.value;
			this.alias = anyval.alias;
			
		}
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

		Any a = (Any) o;
		
		return Objects.equals(this.value, a.value)
				&& Objects.equals(this.alias, a.alias );
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
