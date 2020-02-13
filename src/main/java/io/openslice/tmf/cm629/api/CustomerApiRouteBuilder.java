package io.openslice.tmf.cm629.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
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
import io.openslice.tmf.cm629.model.CustomerAttributeValueChangeEvent;
import io.openslice.tmf.cm629.model.CustomerCreateEvent;
import io.openslice.tmf.so641.model.ServiceOrderAttributeValueChangeNotification;
import io.openslice.tmf.so641.model.ServiceOrderCreateNotification;
import io.openslice.tmf.so641.model.ServiceOrderDeleteNotification;
import io.openslice.tmf.so641.model.ServiceOrderStateChangeNotification;

@Configuration
@Component
public class CustomerApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(CustomerApiRouteBuilder.class.getName());

	@Value("${EVENT_CUSTOMER_CREATE}")
	private String EVENT_CUSTOMER_CREATE = "";

	@Value("${EVENT_CUSTOMER_CHANGED}")
	private String EVENT_CUSTOMER_CHANGED = "";

	@Autowired
	private ProducerTemplate template;


	@Value("${spring.application.name}")
	private String compname;
	
	@Override
	public void configure() throws Exception {

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

			if (ce instanceof CustomerCreateEvent) {
				msgtopic = EVENT_CUSTOMER_CREATE;
				((CustomerCreateEvent) ce).setEventType(ce.getClass().getName());
				map.put("eventid", ((CustomerCreateEvent) ce).getEventId());
				logger.info("will send Event for type " + ((CustomerCreateEvent) ce).getEventType());
			} else if (ce instanceof CustomerAttributeValueChangeEvent) {
				msgtopic = EVENT_CUSTOMER_CHANGED;

				((CustomerAttributeValueChangeEvent) ce).setEventType(ce.getClass().getName());
				map.put("eventid", ((CustomerAttributeValueChangeEvent) ce).getEventId());
				logger.info("will send Event for type " + ((CustomerAttributeValueChangeEvent) ce).getEventType());
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
