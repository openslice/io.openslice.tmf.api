package io.openslice.tmf.rpm685.model;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper( 
		nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS   )
public interface ResourcePoolMapper {

	@Mapping(target = "uuid", ignore = true)
	@Mapping(target = "baseType", ignore = true)
	@Mapping(target = "href", ignore = true)
	@Mapping(target = "schemaLocation", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "lastUpdate", ignore = true)
	@Mapping(target = "lifecycleStatus", ignore = true)
	@Mapping(target = "lifecycleStatusEnum", ignore = true)
	@Mapping(target = "version", ignore = true)
	@Mapping(target = "validFor", ignore = true)
	ResourcePool fromResourcePoolDTO( ResourcePoolUpdate rpdto );
	
	
	@Mapping(target = "baseType", ignore = true)
	@Mapping(target = "schemaLocation", ignore = true)
	@Mapping(target = "href", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "uuid", ignore = true)
	@Mapping(target = "lastUpdate", ignore = true)
	@Mapping(target = "lifecycleStatus", ignore = true)
	@Mapping(target = "lifecycleStatusEnum", ignore = true)
	@Mapping(target = "validFor", ignore = true)
	@Mapping(target = "version", ignore = true)
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	ResourcePool updateResourcePool(@MappingTarget ResourcePool entity, ResourcePoolUpdate updateEntity);
	
}
