package io.openslice.tmf.ri639.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Resource is an abstract entity that describes the common set of attributes shared by all concrete resources. The polymorphic attributes @type, @schemaLocation &amp; @referredType are related to the Resource entity and not the related ResourceRefOrValue class itself
 */
@Schema(description = "Resource is an abstract entity that describes the common set of attributes shared by all concrete resources. The polymorphic attributes @type, @schemaLocation & @referredType are related to the Resource entity and not the related ResourceRefOrValue class itself")
@Validated
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
@Entity(name = "RIResourceRefOrVal")
@JsonIgnoreProperties( {"uuid"} )
public class ResourceRefOrValue extends Resource  {

	public void setId(@NotNull String id) {
		this.id = id;
				
	}

	public String getId() {
		if ( id == null) {
			return super.getId();
		}
		return this.id;
	}
  
}
