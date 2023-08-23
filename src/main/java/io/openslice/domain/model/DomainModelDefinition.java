package io.openslice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ctranoris
 */

@Getter
@Setter
@AllArgsConstructor
public class DomainModelDefinition {
	
	//instance variables
	protected String uuid;
	protected String name;
	protected String version;
	protected String description;
	protected String category;
	
	
	
}
