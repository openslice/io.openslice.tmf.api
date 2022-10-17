package io.openslice.tmf.ro652.reposervices;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;

import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceRefOrValue;

@Mapper( 
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS   )
public interface ResourceOrderMapper {

	ResourceRefOrValue fromResource(Resource res);
	
}
