/*-
 * ========================LICENSE_START=================================
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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * For implementing the callback and events, it might be useful to check the DDD pattern: https://www.baeldung.com/spring-data-ddd
 * 
 * 
 * @author ctranoris
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-29T19:18:54.771Z")

@Configuration
public class SwaggerDocumentationConfig {

    ApiInfo apiInfo633() {
        return new ApiInfoBuilder()
        		
            .title("Service Catalog Management")
            .description("## TMF API Reference: TMF633 - Service Catalog Management  "
            		+ "### Release : 18.5 - December 2018  Service Catalog API is one of Catalog Management API Family. Service Catalog API goal is to provide a catalog of services.   "
            		+ "### Resource  - serviceCatalog  "
            		+ "### Operations Service Catalog API performs the following operations on the resource : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity (for administration purposes) - Manage notification of events")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo620() {
        return new ApiInfoBuilder()
            .title("Product Catalog Management")
            .description("## TMF API Reference: TMF620 - Product Catalog Management  ### Release : 19.0 - June 2019  Product Catalog API is one of Catalog Management API Family. Product Catalog API goal is to provide a catalog of products.   ### Operations Product Catalog API performs the following operations on the resources : - Retrieve an entity or a collection of entities depending on filter criteria - Partial update of an entity (including updating rules) - Create an entity (including default values and creation rules) - Delete an entity - Manage notification of events")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo634() {
        return new ApiInfoBuilder()
            .title("Resource Catalog Management")
            .description("This is Swagger UI environment generated for the TMF Resource Catalog Management specification")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("2.0")
            .contact(new Contact("","", ""))
            .build();
    }

    ApiInfo apiInfo638() {
        return new ApiInfoBuilder()
            .title("Service Inventory Management")
            .description("## TMF API Reference : TMF 638 - Service Inventory Management v4 Release 18.5 - Dec 2018  The intent of this API is to provide a consistent/standardized mechanism to query and manipulate the Service inventory.  The Service Inventory API can be used to query the service instances for a customer via Self Service Portal or the Call Centre operator can query the service instances on behalf of the customer while a customer may have a complaint or a query. Note: Only the CustomerFacingServices instances will be presented to the customer.  The Service Inventory API can be called by the Service Order Management to create a new service instance/ update an existing service instance in the Service Inventory.  ### Service resource Service is an abstract base class for defining the Service hierarchy. All Services are characterized as either being possibly visible and usable by a Customer or not. This gives rise to the two subclasses of  Service: CustomerFacingService and ResourceFacingService.  ### Service Inventory API performs the following operations on service  : - Retrieve  a service or a collection of services depending on filter criteria - Partial update of a service (including updating rules) - Create a service (including default values and creation rules and for administration users only) - Delete a service (for administration users only) - Notification of events on service  Copyright (c)TM Forum 2018. All Rights Reserved.")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0.0")
            .contact(new Contact("","", ""))
            .build();
    }



    ApiInfo apiInfo641() {
        return new ApiInfoBuilder()
            .title("API ServiceOrdering")
            .description("## TMF API Reference : TMF 641 - Service Ordering Management  ## Release : 18.5 - Dec 2018  The Service Order API provides a standardized mechanism for managing Service Order, a type of order which can be used to place an order between a customer and a service provider or between a service provider and a partner and vice versa.  ### Service Order resource A service order will describe a list of service order items.  A service order item references an action on an existing  or  future  service.  By  service  we  designed  Customer Facing  Service  (CFS)  as  well  as  Resource Facing Service (RFS). From a component perspective, a service order should be available - from a Service Orchestration Component (and it could mix CFS and RFS) - from an Infrastructure Control & Management component (and it would have only RFS)  ### Service Order API performs the following operations on service order : - Retrieval of a service order or a collection of service orders depending on filter criteria - Partial update of a service order (including updating rules) - Creation of a service order (including default values and creation rules) - Deletion of service order (for administration purposes) - Notification of events on Service order  Copyright © TM Forum 2018. All Rights Reserved")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0.0")
            .contact(new Contact("","", ""))
            .build();
    }

    ApiInfo apiInfo657() {
        return new ApiInfoBuilder()
            .title("Service Quality Management")
            .description("This is Swagger UI environment generated for the TMF Service Quality Management specification")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("2.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo669() {
        return new ApiInfoBuilder()
                .title("Party Role Management")
                .description("This is Swagger UI environment generated for the TMF Party Role Management specification")
                .license("")
                .licenseUrl("http://unlicense.org")
                .termsOfServiceUrl("")
                .version("4.0")
                .contact(new Contact("","", ""))
                .build();
    }
    

    ApiInfo apiInfo632() {
        return new ApiInfoBuilder()
            .title("API Party")
            .description("## TMF API Reference : TMF 632 - Party   ### Release : 19.0   The party API provides standardized mechanism for party management such as creation, update, retrieval, deletion and notification of events. Party can be an individual or an organization that has any kind of relation with the enterprise. Party is created to record individual or organization information before the assignment of any role. For example, within the context of a split billing mechanism, Party API allows creation of the individual or organization that will play the role of 3 rd payer for a given offer and, then, allows consultation or update of his information.  ### Resources - Organization - Individual - Hub  Party API performs the following operations : - Retrieve an organization or an individual - Retrieve a collection of organizations or individuals according to given criteria - Create a new organization or a new individual - Update an existing organization or an existing individual - Delete an existing organization or an existing individual - Notify events on organizatin or individual")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo651() {
        return new ApiInfoBuilder()
            .title("Agreement Management")
            .description("This is Swagger UI environment generated for the TMF Agreement Management specification")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("2.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo666() {
        return new ApiInfoBuilder()
            .title("Account Management")
            .description("This is Swagger UI environment generated for the TMF Account Management specification")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo629() {
        return new ApiInfoBuilder()
            .title("Customer Management")
            .description("This is Swagger UI environment generated for the TMF Customer Management specification")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("")
            .version("4.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    ApiInfo apiInfo691() {
        return new ApiInfoBuilder()
            .title("Federated ID")
            .description("This is Swagger UI environment generated for the TMF FederatedID specification")
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .termsOfServiceUrl("")
            .version("1.0")
            .contact(new Contact("","", ""))
            .build();
    }
    
    
    @Bean
    public Docket customscm633(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-633-Service Catalog Management-v4.0.0")
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.scm633.api"))
//                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.scm620.api"))
//                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.scm634.api"))
//                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.scm638.api"))
//                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.scm641.api"))
//                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.scm657.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo633());
    }
    
    @Bean
    public Docket swaggerpcm620() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-620-Product Catalog Management-v4.0.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.pcm620.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo620());

    }
    
    @Bean
    public Docket swaggerrcm634() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-634-Resource Catalog Management-v2.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.rcm634.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo634());

    }
    @Bean
    public Docket swaggersim638() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-638-Service Inventory Management-v4.0.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.sim638.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo638());

    }
    @Bean
    public Docket swaggerso641() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-641-API ServiceOrdering-v4.0.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.so641.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo641());

    }
    @Bean
    public Docket swaggersqm657() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-657-Service Quality Management-v2.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.sqm657.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo657());

    }


    @Bean
    public Docket swaggerprm669() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-669-Party Role Management-v4.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.prm669.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo657());

    }
    @Bean
    public Docket swaggerpm632() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-632-Party Management-v4.0.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.pm632.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo657());

    }

    @Bean
    public Docket swaggeram651() {

        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-651-Agreement Management-v2.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.am651.api"))
                    .build()
                    .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo657());

    }
    

    @Bean
    public Docket swaggeram666(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("tmf-api-666-Account Management-v4.0.0")
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.am666.api"))
                    .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo666());
    }
    
    @Bean
    public Docket swaggercm629(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.cm629.api"))
                    .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo629());
    }
    
    @Bean
    public Docket swaggercm691(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("io.openslice.tmf.fi691.api"))
                    .build()
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo691());
    }
}
