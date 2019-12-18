package io.openslice.tmf.scm633.api;

import java.io.IOException;

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

import io.openslice.model.NetworkServiceDescriptor;
import io.openslice.tmf.scm633.reposervices.ServiceSpecificationRepoService;
import io.openslice.tmf.so641.api.ServiceOrderApiRouteBuilder;
import io.openslice.tmf.so641.model.ServiceOrder;

@Configuration
//@RefreshScope
@Component
public class ServiceSpecificationApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceOrderApiRouteBuilder.class.getName());

	@Value("${CATALOG_GET_SERVICESPEC_BY_ID}")
	private String CATALOG_GET_SERVICESPEC_BY_ID = "";
	
	@Value("${VNFNSD_CATALOG_GET_NSD_BY_ID}")
	private String VNFNSD_CATALOG_GET_NSD_BY_ID = "";
	
	
	@Autowired
	ServiceSpecificationRepoService serviceSpecificationRepoService;
	
    @Autowired
    private ProducerTemplate template;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_GET_SERVICESPEC_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICESPEC_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceSpecificationRepoService, "findByUuidEager")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		
	}

	
	/**
	 * get  service order by id from model via bus
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public NetworkServiceDescriptor retrieveNSD( String nsdID) {
		logger.info("will retrieve NetworkServiceDescriptor from NSD/VNF catalog nsdID=" + nsdID   );
		try {
			Object response = template.
					requestBody( VNFNSD_CATALOG_GET_NSD_BY_ID, nsdID);

			if ( !(response instanceof String)) {
				logger.error("NetworkServiceDescriptor object is wrong.");
				return null;
			}
			NetworkServiceDescriptor sor = toJsonObj( (String)response, NetworkServiceDescriptor.class); 
			//logger.debug("retrieveServiceOrder response is: " + response);
			return sor;
			
		}catch (Exception e) {
			logger.error("Cannot retrieve NetworkServiceDescriptor details from catalog. " + e.toString());
		}
		return null;
	}
	

	
	static <T> T toJsonObj(String content, Class<T> valueType)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue( content, valueType);
    }
	
}
