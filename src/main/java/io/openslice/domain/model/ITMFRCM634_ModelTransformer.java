package io.openslice.domain.model;

import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;

/**
 * @author ctranoris
 * 
 * Transforms the PoJo class to/from the equivalent TMF model 
 */
public interface ITMFRCM634_ModelTransformer {
	
	
	ResourceSpecificationCreate toRSpecCreate_InitRepo();
	
	
	default ResourceSpecificationCreate toRSpecCreate() {
		return null;
	}
	
	default ResourceSpecificationUpdate toRSpecUpdate() {
		return null;
	}
	
	/**
	 * loads the class fields from this model
	 * @param rSpec
	 */
	DomainModelDefinition fromRSpec( ResourceSpecification rSpec ) ;
	
}
