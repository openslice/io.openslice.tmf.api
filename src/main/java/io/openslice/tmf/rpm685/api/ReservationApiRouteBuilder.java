package io.openslice.tmf.rpm685.api;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.tmf.rpm685.model.AvailabilityCheckCreate;
import io.openslice.tmf.rpm685.model.ReservationCreate;
import io.openslice.tmf.rpm685.reposervices.ResourcePoolRepoService;
import io.openslice.tmf.rpm685.reposervices.ResourceReservationRepoService;


@Configuration
//@RefreshScope
@Component
public class ReservationApiRouteBuilder  extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog( ReservationApiRouteBuilder.class.getName());

	@Autowired
	ResourcePoolRepoService resourcePoolRepoService;
	
	@Autowired
	ResourceReservationRepoService resourceReservationRepoService;
	
	@Value("${RESERVATION_CREATE}")
	private String RESERVATION_CREATE = "";
	
	@Value("${RESERVATION_AVAILABILITY_CHECK}")
	private String RESERVATION_AVAILABILITY_CHECK = "";
	
	
	@Override
	public void configure() throws Exception {
		
		from( RESERVATION_CREATE )
		.log(LoggingLevel.INFO, log, RESERVATION_CREATE + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ReservationCreate.class, true)
		.bean( resourceReservationRepoService, "addReservation(${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
		
		from( RESERVATION_AVAILABILITY_CHECK )
		.log(LoggingLevel.INFO, log, RESERVATION_AVAILABILITY_CHECK + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, AvailabilityCheckCreate.class, true)
		.bean( resourcePoolRepoService, "availabilityCheck(${body} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
		
	}
}
