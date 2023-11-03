package io.openslice.domain.model;

import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.model.ResourceUpdate;

/**
 * @author ctranoris
 * 
 * Transforms the PoJo class to/from the equivalent TMF model 
 */
public interface ITMFRI639_ModelTransformer {
	
	

	
	default ResourceCreate toResourceCreate() throws Exception {
		return null;
	};

	default ResourceUpdate toResourceUpdate() throws Exception {
		return null;
	};
	
	/**
	 * loads the class fields from this model
	 * @param rSpec
	 */
	default void fromResource( Resource rSpec ) {
		
	}

	
}
