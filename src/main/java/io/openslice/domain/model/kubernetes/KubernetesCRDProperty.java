package io.openslice.domain.model.kubernetes;

import java.util.HashMap;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author ctranoris
 */
@Getter
@Setter
@Builder
public class KubernetesCRDProperty {

	String name;
	String valueType;
	String defaultValue;
	String description;
	Map<String, KubernetesCRDProperty> properties;
	
	public Map<String, KubernetesCRDProperty> getProperties() {
		if ( properties == null) {
			this.properties = new HashMap<>();			
		}
		return properties;
	}
	

	
	
	
}
