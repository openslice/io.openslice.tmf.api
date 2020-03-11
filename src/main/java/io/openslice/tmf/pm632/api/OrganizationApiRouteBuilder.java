package io.openslice.tmf.pm632.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.LoggingLevel;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.centrallog.client.CLevel;
import io.openslice.centrallog.client.CentralLogger;
import io.openslice.tmf.pm632.model.OrganizationAttributeValueChangeEvent;
import io.openslice.tmf.pm632.model.OrganizationCreateEvent;
import io.openslice.tmf.pm632.reposervices.OrganizationRepoService;

@Configuration
@Component
public class OrganizationApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(OrganizationApiRouteBuilder.class.getName());

	@Value("${EVENT_ORGANIZATION_CREATE}")
	private String EVENT_ORGANIZATION_CREATE = "";

	@Value("${EVENT_ORGANIZATION_CHANGED}")
	private String EVENT_ORGANIZATION_CHANGED = "";

	@Value("${CATALOG_GET_EXTERNAL_SERVICE_PARTNERS}")
	private String CATALOG_GET_EXTERNAL_SERVICE_PARTNERS = "";
	

	@Value("${CATALOG_GET_PARTNER_ORGANIZATON_BY_ID}")
	private String CATALOG_GET_PARTNER_ORGANIZATON_BY_ID = "";
	
	
	
	@Autowired
	private ProducerTemplate template;

    @Autowired
	OrganizationRepoService organizationRepoService;

	@Value("${spring.application.name}")
	private String compname;
	
	@Override
	public void configure() throws Exception {

		from( CATALOG_GET_EXTERNAL_SERVICE_PARTNERS )
		.log(LoggingLevel.INFO, log, CATALOG_GET_EXTERNAL_SERVICE_PARTNERS + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( organizationRepoService, "getPartnerOrganizationsWithAPI")
		//.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
		from( CATALOG_GET_PARTNER_ORGANIZATON_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_PARTNER_ORGANIZATON_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( organizationRepoService, "findByUuidJson");
	}

	/**
	 * @param ce
	 * @param id
	 */
	public void publishEvent(Object ce, String objId) {
		try {
			String msgtopic = "";

			Map<String, Object> map = new HashMap<>();
			map.put("objId", objId);

			if (ce instanceof OrganizationCreateEvent) {
				msgtopic = EVENT_ORGANIZATION_CREATE;
				((OrganizationCreateEvent) ce).setEventType(ce.getClass().getName());
				map.put("eventid", ((OrganizationCreateEvent) ce).getEventId());
				logger.info("will send Event for type " + ((OrganizationCreateEvent) ce).getEventType());
			} else if (ce instanceof OrganizationAttributeValueChangeEvent) {
				msgtopic = EVENT_ORGANIZATION_CHANGED;

				((OrganizationAttributeValueChangeEvent) ce).setEventType(ce.getClass().getName());
				map.put("eventid", ((OrganizationAttributeValueChangeEvent) ce).getEventId());
				logger.info("will send Event for type " + ((OrganizationAttributeValueChangeEvent) ce).getEventType());
			}

			String apayload = toJsonString( ce );
			template.sendBodyAndHeaders(msgtopic, apayload, map);

			CentralLogger.log(CLevel.INFO, apayload, compname);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Cannot send Event . " + e.getMessage());
		}

	}
	
	static String toJsonString(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}

}
