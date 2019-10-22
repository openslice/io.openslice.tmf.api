package io.openslice.tmf.rcm634.model;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;

/**
 * A base / value business entity used to represent a period of time between two timepoints.
 */
@ApiModel(description = "A base / value business entity used to represent a period of time between two timepoints.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T00:06:08.595+03:00")

public class TimePeriod extends io.openslice.tmf.common.model.TimePeriod   {

	public TimePeriod(TimePeriod validFor) {
		super();
	}
 }

