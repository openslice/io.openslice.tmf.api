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
package io.openslice.tmf.stm653.api;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

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

import io.openslice.tmf.stm653.model.ServiceTestCreate;
import io.openslice.tmf.stm653.model.ServiceTestUpdate;
import io.openslice.tmf.stm653.reposervices.ServiceTestRepoService;
import io.openslice.tmf.stm653.reposervices.ServiceTestSpecificationRepoService;

@Configuration
//@RefreshScope
@Component
public class ServiceTestSpecificationApiRouteBuilder extends RouteBuilder {

	private static final transient Log logger = LogFactory.getLog(ServiceTestSpecificationApiRouteBuilder.class.getName());

	@Value("${CATALOG_GET_SERVICETESTSPEC_BY_ID}")
	private String CATALOG_GET_SERVICETESTSPEC_BY_ID = "";
	
	

	@Value("${CATALOG_ADD_SERVICETEST}")
	private String CATALOG_ADD_SERVICETEST = "";


	@Value("${CATALOG_UPD_SERVICETEST}")
	private String CATALOG_UPD_SERVICETEST = "";
	

	@Value("${CATALOG_GET_SERVICETEST_BY_ID}")
	private String CATALOG_GET_SERVICETEST_BY_ID = "";
	
	
	
	@Autowired
	ServiceTestSpecificationRepoService serviceTestSpecificationRepoService;
	

	@Autowired
	ServiceTestRepoService serviceTestRepoService;
	
    @Autowired
    private ProducerTemplate template;
	
	@Override
	public void configure() throws Exception {
		
		from( CATALOG_GET_SERVICETESTSPEC_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICETESTSPEC_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceTestSpecificationRepoService, "findByUuidEager")
		.marshal().json( JsonLibrary.Jackson, String.class)
		.convertBodyTo( String.class );
		

		from( CATALOG_ADD_SERVICETEST )
		.log(LoggingLevel.INFO, log, CATALOG_ADD_SERVICETEST + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceTestCreate.class, true)
		.bean( serviceTestRepoService, "addServiceTest(${body})")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );

		from( CATALOG_GET_SERVICETEST_BY_ID )
		.log(LoggingLevel.INFO, log, CATALOG_GET_SERVICETEST_BY_ID + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.bean( serviceTestRepoService, "getServiceTestEagerAsString")
		.convertBodyTo( String.class );

		from(CATALOG_UPD_SERVICETEST)
		.log(LoggingLevel.INFO, log, CATALOG_UPD_SERVICETEST + " message received!")
		.to("log:DEBUG?showBody=true&showHeaders=true")
		.unmarshal().json( JsonLibrary.Jackson, ServiceTestUpdate.class, true)
		.bean( serviceTestRepoService, "updateServiceTest(${header.serviceid}, ${body} )")
		.marshal().json( JsonLibrary.Jackson)
		.convertBodyTo( String.class );
	}


	
	static <T> T toJsonObj(String content, Class<T> valueType)  throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.readValue( content, valueType);
    }
	
}
