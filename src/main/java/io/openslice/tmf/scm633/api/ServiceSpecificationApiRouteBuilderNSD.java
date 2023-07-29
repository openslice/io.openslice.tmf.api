/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2020 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */
package io.openslice.tmf.scm633.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.openslice.model.NetworkServiceDescriptor;

@Configuration
//@RefreshScope
@Component
public class ServiceSpecificationApiRouteBuilderNSD extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceSpecificationApiRouteBuilderNSD.class.getName());

	@Value("${NFV_CATALOG_GET_NSD_BY_ID}")
	private String NFV_CATALOG_GET_NSD_BY_ID = "";
	
	
    @Autowired
    private ProducerTemplate template;
	
	@Override
	public void configure() throws Exception {
		
		
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
					requestBody( NFV_CATALOG_GET_NSD_BY_ID, nsdID);

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
