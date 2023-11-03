/*-
7 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 openslice.io
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
package io.openslice.tmf.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;

/**
 * For implementing the callback and events, it might be useful to check the DDD pattern: https://www.baeldung.com/spring-data-ddd
 * 
 * 
 * @author ctranoris
 *
 */
@jakarta.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-29T19:18:54.771Z")

@Configuration
@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2, bearerFormat = "JWT", 
scheme = "bearer",
flows = @OAuthFlows(authorizationCode = @OAuthFlow(
		authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}"
		, tokenUrl = "${springdoc.oAuthFlow.tokenUrl}", scopes = {
		@OAuthScope(name = "read", description = "read scope"),
		@OAuthScope(name = "write", description = "write scope") })))
public class SwaggerDocumentationConfig {
	
	/**
	 * TMF 633 Service Catalog Management
	 * @return
	 */
	@Bean
	public OpenApiCustomizer scm633OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 633 Service Catalog Management")
						.description("## TMF API Reference: TMF633 - Service Catalog Management"
								+ "### Release : 18.5-December 2018  Service Catalog API is one of Catalog Management API Family. Service Catalog API goal is to provide a catalog of services.   "
								+ "### Resource  - serviceCatalog  "
								+ "### Operations Service Catalog API performs the following operations on the resource : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity (for administration purposes) - Manage notification of events")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	             
	  }
	
    @Bean
    public GroupedOpenApi scm633(){

	  	SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	  	SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
        return GroupedOpenApi.builder()
        		.group("tmf-api-633-ServiceCatalogManagement-v4.0.0")
        		.addOpenApiCustomizer( this.scm633OpenAPI() )
        		.packagesToScan("io.openslice.tmf.scm633.api")
        		.build();

    }
      
    
    
    
	/**
	 * TMF 620 Product Catalog Management 
	 * @return
	 */
	@Bean
	public OpenApiCustomizer pcm620penAPI() {
		
		
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
	              .info(new Info().title("TMF 620 Product Catalog Management")
	            		  .description("## TMF API Reference: TMF620 - Product Catalog Management  ### Release : 19.0 - June 2019  Product Catalog API is one of Catalog Management API Family. Product Catalog API goal is to provide a catalog of products.   ### Operations Product Catalog API performs the following operations on the resources : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity - Manage notification of events")
	                      
		              .version("4.0.0")
		              .license(new License().name("Apache 2.0").url("http://openslice.io")))
					.externalDocs(new ExternalDocumentation()
							.description("TMF API Tables")
							.url("https://www.tmforum.org/oda/open-apis/table"));	     
			             
	  }
    
    
  @Bean
  public GroupedOpenApi pcm620() {

	  	SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	  	SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
      return GroupedOpenApi.builder()
      		.group("tmf-api-620-ProductCatalogManagement-v4.0.0")
    		.addOpenApiCustomizer( this.pcm620penAPI() )
            .packagesToScan("io.openslice.tmf.pcm620.api")
            .build();

  }
  
  
  
  /**
	 * TMF 622 Product Ordering
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer scm622OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 622 Product Ordering")
						.description( "TMF API Reference : TMF 622 - Product Ordering Management**\\\\n\\\\n**"
								+ "Release : 19.0 - June 2019**\\\\n\\\\nThe Product Ordering API provides a standardized mechanism for placing a product order with all of the necessary order parameters.")
						.version("1.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi scm622(){

	  	SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	  	SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
      return GroupedOpenApi.builder()
      		.group("tmf-api-622-ProductOrderingManagement-v4.0.0")
      		.addOpenApiCustomizer( this.scm622OpenAPI() )
      		.packagesToScan("io.openslice.tmf.po622.api")
      		.build();

  }
	
	  
  /**
	 * TMF 634 Resource Catalog Management
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer rcm634OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 634 Resource Catalog Management")
						.description("## TMF API Reference: TMF 634 Resource Catalog Management")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi rcm634(){
  	
      return GroupedOpenApi.builder()
    		  .group("tmf-api-634-ResourceCatalogManagement-v4.0.0")
      		.addOpenApiCustomizer( this.rcm634OpenAPI() )
      		.packagesToScan("io.openslice.tmf.rcm634.api")
      		.build();

  }
	
	  
  
  /**
	 * TMF 638 Service Inventory Management
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer sim638OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 638 Service Inventory Management")
						.description("## TMF API Reference : TMF 638 - Service Inventory Management v4 Release 18.5 - Dec 2018  The intent of this API is to provide a consistent/standardized mechanism to query and manipulate the Service inventory.  The Service Inventory API can be used to query the service instances for a customer via Self Service Portal or the Call Centre operator can query the service instances on behalf of the customer while a customer may have a complaint or a query. Note: Only the CustomerFacingServices instances will be presented to the customer.  The Service Inventory API can be called by the Service Order Management to create a new service instance/ update an existing service instance in the Service Inventory.  ### Service resource Service is an abstract base class for defining the Service hierarchy. All Services are characterized as either being possibly visible and usable by a Customer or not. This gives rise to the two subclasses of  Service: CustomerFacingService and ResourceFacingService.  ### Service Inventory API performs the following operations on service  : - Retrieve  a service or a collection of services depending on filter criteria - Partial update of a service (including updating rules) - Create a service (including default values and creation rules and for administration users only) - Delete a service (for administration users only) - Notification of events on service  Copyright (c)TM Forum 2018. All Rights Reserved.")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi sim638(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-638-ServiceInventoryManagement-v4.0.0")
      		.addOpenApiCustomizer( this.sim638OpenAPI() )
      		.packagesToScan("io.openslice.tmf.sim638.api")
      		.build();

  }
  
  
  
  
  /**
	 * TMF 641 - Service Ordering Management 
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer so641OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 641 - Service Ordering Management ")
						.description("## TMF API Reference : TMF 641 - Service Ordering Management  ## Release : 18.5 - Dec 2018  The Service Order API provides a standardized mechanism for managing Service Order, a type of order which can be used to place an order between a customer and a service provider or between a service provider and a partner and vice versa.  ### Service Order resource A service order will describe a list of service order items.  A service order item references an action on an existing  or  future  service.  By  service  we  designed  Customer Facing  Service  (CFS)  as  well  as  Resource Facing Service (RFS). From a component perspective, a service order should be available - from a Service Orchestration Component (and it could mix CFS and RFS) - from an Infrastructure Control & Management component (and it would have only RFS)  ### Service Order API performs the following operations on service order : - Retrieval of a service order or a collection of service orders depending on filter criteria - Partial update of a service order (including updating rules) - Creation of a service order (including default values and creation rules) - Deletion of service order (for administration purposes) - Notification of events on Service order  Copyright © TM Forum 2018. All Rights Reserved")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi so641(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-641-ServiceOrdering-v4.0.0")
      		.addOpenApiCustomizer( this.so641OpenAPI() )
      		.packagesToScan("io.openslice.tmf.so641.api")
      		.build();

  }
	
  
  /**
	 * TMF 657 - Service Quality Management
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer sqm657OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 657 - Service Quality Management")
						.description("This is Swagger UI environment generated for the TMF Service Quality Management specification")
						.version("2.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi sqm657(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-657-ServiceQualityManagement-v2.0")
      		.addOpenApiCustomizer( this.sqm657OpenAPI() )
      		.packagesToScan("io.openslice.tmf.sqm657.api")
      		.build();

  }
  
  

  /**
	 * TMF 669 - Party Role Management
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer prm669OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth"))
				.info(new Info().title("TMF 669 - Party Role Management")
						.description("This is Swagger UI environment generated for the TMF Party Role Management specification")
						.version("2.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi prm669(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-669-Party Role Management-v4.0")
      		.addOpenApiCustomizer( this.prm669OpenAPI() )
      		.packagesToScan("io.openslice.tmf.prm669.api")
      		.build();

  }
  
	

  /**
	 * TMF 632 - Party 
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer pm632OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth"))
				
				.info(new Info().title("TMF 632 - API Party")
						.description("## TMF API Reference : TMF 632 - Party   ### Release : 19.0   The party API provides standardized mechanism for party management such as creation, update, retrieval, deletion and notification of events. Party can be an individual or an organization that has any kind of relation with the enterprise. Party is created to record individual or organization information before the assignment of any role. For example, within the context of a split billing mechanism, Party API allows creation of the individual or organization that will play the role of 3 rd payer for a given offer and, then, allows consultation or update of his information.  ### Resources - Organization - Individual - Hub  Party API performs the following operations : - Retrieve an organization or an individual - Retrieve a collection of organizations or individuals according to given criteria - Create a new organization or a new individual - Update an existing organization or an existing individual - Delete an existing organization or an existing individual - Notify events on organizatin or individual")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	

@Bean
  public GroupedOpenApi pm632(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-632-PartyManagement-v4.0.0")
      		.addOpenApiCustomizer( this.pm632OpenAPI() )
      		.packagesToScan("io.openslice.tmf.pm632.api")
      		.build();

  }

  
  /**
	 * TMF 651 - Agreement Management 
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer am651OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info().title("TMF 651 - Agreement Management ")
						 .description("This is Swagger UI environment generated for the TMF Agreement Management specification")
						.version("2.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi am651(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-651-Agreement Management-v2.0")
      		.addOpenApiCustomizer( this.am651OpenAPI() )
      		.packagesToScan("io.openslice.tmf.am651.api")
      		.build();

  }
  
  

  
  /**
	 * TMF 652 Resource Order Management-v4.0.0
	 * @return
	 */
  
  
	@Bean
	public OpenApiCustomizer rom652OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						.title("TMF 652 Resource Order Management-v4.0.0")
						.description("This is Swagger UI environment generated for the TMF 652-Resource Order Management-v4.0.0 specification")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
  @Bean
  public GroupedOpenApi rom652(){
	 
	  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
	 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
	 
      return GroupedOpenApi.builder()
    		  .group("tmf-api-652-ResourceOrderManagement-v4.0.0")
      		.addOpenApiCustomizer( this.rom652OpenAPI() )
      		.packagesToScan("io.openslice.tmf.ro652.api")
      		.build();

  }
  
  
  /**
	 * TMF 652 Resource Order Management-v4.0.0
	 * @return
	 */


	@Bean
	public OpenApiCustomizer am666OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						.title("TMF 666 Account Management")
						.description("This is Swagger UI environment generated for the TMF Account Management specification")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi am666(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	  		  .group("tmf-api-666-Account Management-v4.0.0")
	    		.addOpenApiCustomizer( this.am666OpenAPI() )
	    		.packagesToScan("io.openslice.tmf.am666.api")
	    		.build();
	
	}


	/**
	 *TMF 639 API Resource Inventory Management
	 * @return
	 */


	@Bean
	public OpenApiCustomizer ri639penAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 639 API Resource Inventory Management")
						 .description("## TMF API Reference: TMF639 - Resource Inventory   ### Release : 19.5 - December 2019  Resource Inventory  API goal is to provide the ability to manage Resources.  ### Operations Resource Inventory API performs the following operations on the resources : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity (for administration purposes) - Manage notification of events")
						.version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi ri639(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	  		  .group("tmf-api-639-Resource Inventory Management-v4.0.0")
	    		.addOpenApiCustomizer( this.ri639penAPI() )
	    		.packagesToScan("io.openslice.tmf.ri639.api")
	    		.build();
	
	}

	
	

	/**
	 *TMF 640 API Service Activation and Configuration
	 * @return
	 */


	@Bean
	public OpenApiCustomizer sac640penAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 640 API Service Activation and Configuration")
						 .description("## TMF API Reference: TMF640 - Service Activation and Configuration  ### Release : 18.5 - December 2018  Service Activation and Configuration API goal is to provide the ability to activate and configure Services.  ### Operations Service Activation and Configuration API performs the following operations on the resources : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity (for administration purposes) - Manage notification of events")
//			            .version("3.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi sac640(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("tmf-api-640-Service Activation and Configuration-v3.0.0")
	    		.addOpenApiCustomizer( this.sac640penAPI() )
	    		.packagesToScan("io.openslice.tmf.sac640.api")
	    		.build();
	
	}
	
	

	/**
	 *tmf-api-629-Customer Management-v4.0.0
	 * @return
	 */


	@Bean
	public OpenApiCustomizer cm629penAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 629 Customer Management-v4.0.0")

			            .description("This is Swagger UI environment generated for the TMF Customer Management specification")
			            .version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi cm629(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("tmf-api-629-Customer Management-v4.0.0")
	    		.addOpenApiCustomizer( this.cm629penAPI() )
	    		.packagesToScan("io.openslice.tmf.cm629.api")
	    		.build();
	
	}
	
	


	/**
	 * TMF 691 Federated ID
	 * @return
	 */


	@Bean
	public OpenApiCustomizer fi691OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 691 Federated ID")
						 .description("This is Swagger UI environment generated for the TMF FederatedID specification")
			            .version("1.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi fi691(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("tmf-api-691-Federated Identity-v1.0")
	    		.addOpenApiCustomizer( this.fi691OpenAPI() )
	    		.packagesToScan("io.openslice.tmf.fi691.api")
	    		.build();
	
	}
	
	

	/**
	 * TMF 642 Alarm Management
	 * @return
	 */


	@Bean
	public OpenApiCustomizer am642OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 642 Alarm Management")
						 .description("## TMF API Reference: TMF642 Alarm Management API")
			            .version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi am642(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("tmf-api-642-Alarm Management-v4.0.0")
	    		.addOpenApiCustomizer( this.am642OpenAPI() )
	    		.packagesToScan("io.openslice.tmf.am642.api")
	    		.build();
	
	}
	
	

	/**
	 * TMF 653 Service Test Management
	 * @return
	 */


	@Bean
	public OpenApiCustomizer stm653OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 653 Service Test Management")
						 .description("## TMF API Reference: TMF653 - Service Test Management  ### Release : 20.0 - April 2020  Service Test Management API goal is to provide the ability to manage tests of provisioned Services.   ### Resource  - ServiceTest  - ServiceTestSpecification  ### Operations Service Test Management API performs the following operations on the resources : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity (for administration purposes) - Manage notification of events")
			            .version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("TMF API Tables")
						.url("https://www.tmforum.org/oda/open-apis/table"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi stm653(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("tmf-api-653-Service Test Management-v4.0.0")
	    		.addOpenApiCustomizer( this.stm653OpenAPI() )
	    		.packagesToScan("io.openslice.tmf.stm653.api")
	    		.build();
	
	}
	


	/**
	 * LCM Rules
	 * @return
	 */


	@Bean
	public OpenApiCustomizer lcmOpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("Openslice LCMRules specification API")
			            .description("This is Swagger UI environment for LCM Rules")
			            .version("4.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("Openslice")
						.url("http://openslice.io"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi lcm(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("OpensliceLCMRulesspecificationAPI")
	    		.addOpenApiCustomizer( this.lcmOpenAPI() )
	    		.packagesToScan("io.openslice.tmf.lcm.api")
	    		.build();
	
	}
  
	
	/**
	 * LCM Rules
	 * @return
	 */


	@Bean
	public OpenApiCustomizer rpm685OpenAPI() {
		return openApi -> openApi
				.specVersion( SpecVersion.V30 ).addSecurityItem(new SecurityRequirement().addList("security_auth")) 
				.info(new Info()
						 .title("TMF 685 Resource Pool Management")
						 .description("## TMF API Reference: TMF685 Resource Pool Management   ### Release : 18.0 "
			                		+ "Resources that can\r\n"
			                		+ "be reserved are only\r\n"
			                		+ "in one pool.\r\n"
			                		+ "IF a resource is not found in a pool is infinite.\r\n"
			                		+ "When one makes a reservation for a resource, then we check availability of \r\n"
			                		+ "this resource on that specific dates\r\n"
			                		+ "if checkAvailability returns the resource\r\n"
			                		+ "then it can be reserved on that specific requested date and time.")
			            .version("1.0.0")
						.license(new License()
								.name("Apache 2.0")
								.url("http://openslice.io")))
				.externalDocs(new ExternalDocumentation()
						.description("Openslice")
						.url("http://openslice.io"));	  	                  
	  }
	
	@Bean
	public GroupedOpenApi rpm685(){
		 
		  SpringDocUtils.getConfig().replaceWithClass(java.time.LocalDate.class, java.sql.Date.class);
		 SpringDocUtils.getConfig().replaceWithClass(java.time.OffsetDateTime.class, java.util.Date.class);
		 
	    return GroupedOpenApi.builder()
	    		.group("tmf-api-685 ResourcePoolManagement")
	    		.addOpenApiCustomizer( this.rpm685OpenAPI() )
	    		.packagesToScan("io.openslice.tmf.rpm685.api")
	    		.build();
	
	}
	
	
//	@Bean
//    public SecurityConfiguration security() {
//        return SecurityConfigurationBuilder.builder()
//        		
//        				    .realm("openslice")
//        				    .clientId(CLIENT_ID)
//        				    .clientSecret(CLIENT_SECRET)
//        				    .appName("oauthtoken")
//        				    .scopeSeparator(" ")
//        		.build();
//    }
//
//    private SecurityScheme securityScheme() {
//        GrantType grantType = new AuthorizationCodeGrantBuilder()
//        		.tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/protocol/openid-connect/token", "oauthtoken"))
//        		.tokenRequestEndpoint(
//        		  new TokenRequestEndpoint(AUTH_SERVER + "/protocol/openid-connect/auth", CLIENT_ID, CLIENT_SECRET))
//        		.build();
//
//        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
//        		.grantTypes(Arrays.asList(grantType))
//        		.scopes(Arrays.asList(scopes()))
//        		.build();
//        return oauth;
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//        		.securityReferences(
//        		  Arrays.asList(new SecurityReference("spring_oauth", scopes())))
//        		.forPaths(PathSelectors.regex("/.*"))
//        		.build();
//    }
//
//    private AuthorizationScope[] scopes() {
//        AuthorizationScope[] scopes = { 
//          new AuthorizationScope("read", "for read operations"), 
//          new AuthorizationScope("write", "for write operations"), 
//          new AuthorizationScope("admin", "Access admin API"), 
//          new AuthorizationScope("openapi", "Access openapi API") };
//        return scopes;
//    }
//	

}
