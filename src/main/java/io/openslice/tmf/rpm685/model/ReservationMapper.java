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
public interface ReservationMapper {



	@Mapping(target = "baseType", ignore = true)
	@Mapping(target = "schemaLocation", ignore = true)
	@Mapping(target = "href", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "uuid", ignore = true)
	@Mapping(target = "lastUpdate", ignore = true)
	@Mapping(target = "lifecycleStatus", ignore = true)
	@Mapping(target = "lifecycleStatusEnum", ignore = true)
	@Mapping(target = "version", ignore = true)
	Reservation fromReservationDTO( ReservationUpdate resdto);	
	
	
	@Mapping(target = "baseType", ignore = true)
	@Mapping(target = "schemaLocation", ignore = true)
	@Mapping(target = "href", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "uuid", ignore = true)
	@Mapping(target = "lastUpdate", ignore = true)
	@Mapping(target = "lifecycleStatus", ignore = true)
	@Mapping(target = "lifecycleStatusEnum", ignore = true)
	@Mapping(target = "version", ignore = true)
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Reservation updateReservation( @MappingTarget  Reservation entity, ReservationUpdate  updateEntity);
}
