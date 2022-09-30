package io.openslice.tmf.ri639.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.openslice.tmf.common.model.AttachmentRefOrValue;
import io.openslice.tmf.common.model.service.Note;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Resource is an abstract entity that describes the common set of attributes shared by all concrete resources. The polymorphic attributes @type, @schemaLocation &amp; @referredType are related to the Resource entity and not the related ResourceRefOrValue class itself
 */
@ApiModel(description = "Resource is an abstract entity that describes the common set of attributes shared by all concrete resources. The polymorphic attributes @type, @schemaLocation & @referredType are related to the Resource entity and not the related ResourceRefOrValue class itself")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-08T09:52:18.013684600+03:00[Europe/Athens]")
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
