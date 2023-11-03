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
package io.openslice.services.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import io.openslice.tmf.OpenAPISpringBoot;
import io.openslice.tmf.common.model.service.ResourceRef;
import io.openslice.tmf.rcm634.model.LogicalResourceSpecification;
import io.openslice.tmf.rcm634.model.PhysicalResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecification;
import io.openslice.tmf.rcm634.model.ResourceSpecificationCreate;
import io.openslice.tmf.rcm634.model.ResourceSpecificationRef;
import io.openslice.tmf.rcm634.model.ResourceSpecificationUpdate;
import io.openslice.tmf.ri639.model.PhysicalResource;
import io.openslice.tmf.ri639.model.Resource;
import io.openslice.tmf.ri639.model.ResourceCreate;
import io.openslice.tmf.ri639.reposervices.ResourceRepoService;
import io.openslice.tmf.rpm685.model.ApplicableTimePeriod;
import io.openslice.tmf.rpm685.model.AvailabilityCheck;
import io.openslice.tmf.rpm685.model.Capacity;
import io.openslice.tmf.rpm685.model.ExtractCreate;
import io.openslice.tmf.rpm685.model.PushCreate;
import io.openslice.tmf.rpm685.model.Reservation;
import io.openslice.tmf.rpm685.model.ReservationCreate;
import io.openslice.tmf.rpm685.model.ResourceCapacityDemand;
import io.openslice.tmf.rpm685.model.ResourcePool;
import io.openslice.tmf.rpm685.model.ResourcePoolCreate;
import io.openslice.tmf.rpm685.model.ResourcePoolRef;
import io.openslice.tmf.rpm685.model.ResourcePoolUpdate;
import io.openslice.tmf.rpm685.reposervices.ResourcePoolRepoService;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = OpenAPISpringBoot.class)
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class ResourcePoolIntegrationTest {

	private static final transient Log logger = LogFactory.getLog(ResourcePoolIntegrationTest.class.getName());

	@Autowired
	private MockMvc mvc;

	@Autowired
	ResourceRepoService resourceRepoService;

	@Autowired
	ResourcePoolRepoService resourcePoolRepoService;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}

	@WithMockUser(username = "osadmin", roles = { "USER", "ADMIN" })
	@Test
	public void testResourcePoolCreateAndUpdate() throws UnsupportedEncodingException, IOException, Exception {

		// Create a resource spec
		File sspec = new File("src/test/resources/testResourceSpec.json");
		InputStream in = new FileInputStream(sspec);
		String sspectext = IOUtils.toString(in, "UTF-8");
		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj(sspectext, ResourceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ResourceSpecification responsesSpec1 = createResourceSpec(sspeccr1);

		// create a resource

		ResourceCreate aResource = new ResourceCreate();
		aResource.setName("aNew Resource");
		aResource.setCategory("Experimentation");
		aResource.setAtType("PhysicalResource");
		ResourceSpecificationRef aServiceSpecificationRef = new ResourceSpecificationRef();
		aServiceSpecificationRef.setId(responsesSpec1.getId());
		aServiceSpecificationRef.setName(responsesSpec1.getName());
		aResource.setResourceSpecification(aServiceSpecificationRef);
		String responseResourceStr = mvc
				.perform(MockMvcRequestBuilders.post("/resourceInventoryManagement/v4/resource")
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(JsonUtils.toJson(aResource)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		logger.info("testServiceOrderCreate = " + responseResourceStr);
		Resource responseResource = JsonUtils.toJsonObj(responseResourceStr, PhysicalResource.class);

		var resPooltext = "{\"name\" : \"gNB\",\"capacity\" : {\"capacityAmount\" : 4,\"resources\": [{\"id\": \"%s\"},{\"id\": \"F0001\"},{\"id\": \"F0002\"},{\"id\": \"F0003\"} ] }}".formatted(responseResource.getId());

		ResourcePoolCreate aResourcePool = JsonUtils.toJsonObj(resPooltext, ResourcePoolCreate.class);

		logger.info("aResourcePool JSON = " + JsonUtils.toJsonString(aResourcePool));

		// @formatter:off
		String responseResourcePool = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/resourcePool")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( aResourcePool )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("testresponseResourcePoolCreate = " + responseResourcePool);
		ResourcePool responseRPool = JsonUtils.toJsonObj(responseResourcePool, ResourcePool.class);

		assertThat(responseRPool.getId()).isNotNull();
		assertThat(responseRPool.getName()).isEqualTo("gNB");
		assertThat(responseRPool.getCapacity().getCapacityAmount()).isEqualTo(4);
		assertThat(responseRPool.getCapacity().getResources().size()).isEqualTo(4);
		// assertThat(responseRPool.getCapacity().getResources().stream().findFirst().get()
		// .getId()).contains("F0002" );

		// modify capacity
		 resPooltext = "{\"name\" : \"gNB\",\"capacity\" : {\"capacityAmount\" : 8,\"resources\": [{\"id\": \"%s\"},{\"id\": \"F0001\"},{\"id\": \"F0002\"},{\"id\": \"F0003\"} ] }}".formatted(responseResource.getId());

		ResourcePoolUpdate aResourcePoolUpd = JsonUtils.toJsonObj(resPooltext, ResourcePoolUpdate.class);
	// @formatter:off
	responseResourcePool = mvc
			.perform(MockMvcRequestBuilders
			.patch("/resourcePoolManagement/v1/resourcePool/" + responseRPool.getId())
			.with(SecurityMockMvcRequestPostProcessors.csrf())
			.contentType(MediaType.APPLICATION_JSON)
			.content(JsonUtils.toJson( aResourcePoolUpd )))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn().getResponse().getContentAsString();
	// @formatter:on
		logger.info("testresponseResourcePoolCreate = " + responseResourcePool);
		responseRPool = JsonUtils.toJsonObj(responseResourcePool, ResourcePool.class);
		assertThat(responseRPool.getName()).isEqualTo("gNB");
		assertThat(responseRPool.getCapacity().getCapacityAmount()).isEqualTo(8);
		assertThat(responseRPool.getCapacity().getResources().size()).isEqualTo(4);

		responseResourcePool = mvc
				.perform(MockMvcRequestBuilders.get("/resourcePoolManagement/v1/resourcePool")
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(JsonUtils.toJson(aResourcePoolUpd)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<ResourcePool> pools = JsonUtils.toJsonObj(responseResourcePool, ArrayList.class);
		assertThat(pools.size()).isEqualTo(1);

		responseResourcePool = mvc
				.perform(MockMvcRequestBuilders.get("/resourcePoolManagement/v1/resourcePool/" + responseRPool.getId())
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(JsonUtils.toJson(aResourcePoolUpd)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		responseRPool = JsonUtils.toJsonObj(responseResourcePool, ResourcePool.class);
		assertThat(responseRPool.getName()).isEqualTo("gNB");
		assertThat(responseRPool.getCapacity().getCapacityAmount()).isEqualTo(8);

		/**
		 * Test reservations
		 */

		// Create a reservation
		String reserv = 
			"{"+ 
			"		  \"requestedPeriodEndDateTime\": \"2022-10-18T21:17:12.890623100Z\","+
			"		  \"requestedPeriodStartDateTime\": \"2022-10-11T21:17:12.890623100Z\","+
			"		  \"description\": \"new reservation\","+
			"		  \"relatedParty\": {"+
			"		    \"name\": \"Actor\""+
			"		  },"+
			"		  \"validFor\": {"+
			"		    \"endDateTime\": \"2022-10-18T21:17:12.890623100Z\","+
			"		    \"startDateTime\": \"2022-10-11T21:17:12.890623100Z\""+
			"		  },"+
			"		  \"reservationItem\": ["+
			"		    {"+
			"		      \"quantity\": 1,"+
			"		      \"resourceCapacity\": {"+
			"		        \"capacityDemandAmount\": 1,"+
			"		        \"resourcePool\": {"+
			"		          \"id\": \""+responseRPool.getId()+"\","+
			"		          \"resources\": ["+
			"		          {"+
			"		          \"id\": \""+responseResource.getId()+"\""+
			"		          }]"+
			"		        }"+
			"		      }"+
			"		    }"+
			"		  ],"+
			"		  \"serviceOrderRef\": {"+
			"		    \"id\": \"xxx\""+
			"		  }"+
			"		}";

		var rrc = JsonUtils.toJsonObj(reserv, ReservationCreate.class);

		// @formatter:off
		String responseReservation = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/reservation")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( rrc )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("testresponseReservationCreate = " + responseReservation);
		Reservation aReservation = JsonUtils.toJsonObj(responseReservation, Reservation.class);

		assertThat(aReservation.getId()).isNotNull();
		assertThat(aReservation.getDescription()).isEqualTo("new reservation");
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getQuantity()).isEqualTo(1);
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getAppliedCapacityAmount().getResource()
				.stream().findFirst().get().getId()).isEqualTo(responseResource.getId());

		responseReservation = mvc
				.perform(MockMvcRequestBuilders.get("/resourcePoolManagement/v1/reservation/" + aReservation.getId())
						.with(SecurityMockMvcRequestPostProcessors.csrf()).contentType(MediaType.APPLICATION_JSON)
						.content(JsonUtils.toJson(rrc)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("testresponseReservationPatch = " + responseReservation);
		aReservation = JsonUtils.toJsonObj(responseReservation, Reservation.class);

		assertThat(aReservation.getId()).isNotNull();
		assertThat(aReservation.getDescription()).isEqualTo("new reservation");
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getQuantity()).isEqualTo(1);
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getResourceCapacity()
				.getCapacityDemandAmount()).isEqualTo(1);
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getResourceCapacity().getResourcePool()
				.getResources().stream().findFirst().get().getId()).isEqualTo(responseResource.getId());
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getAppliedCapacityAmount().getResource()
				.stream().findFirst().get().getId()).isEqualTo(responseResource.getId());

		// Push to pool
		var resPoolPushtext =			"{\"resourcePool\": {\"id\": \"%s\"},\"capacity\": {\"capacityAmount\": 2,\"resources\": [{\"id\": \"xxx\"},{\"id\": \"yyy\"}]}}".formatted(responseRPool.getId());

		var aResourcePoolPush = JsonUtils.toJsonObj(resPoolPushtext, PushCreate.class);
		logger.info("aResourcePoolPush JSON = " + JsonUtils.toJsonString(aResourcePoolPush));

		// @formatter:off
		String responseResourcePoolPush = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/push")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( aResourcePoolPush )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseResourcePoolPush = " + responseResourcePoolPush);
		responseRPool = JsonUtils.toJsonObj(responseResourcePoolPush, ResourcePool.class);

		assertThat(responseRPool.getId()).isNotNull();
		assertThat(responseRPool.getName()).isEqualTo("gNB");
		assertThat(responseRPool.getCapacity().getCapacityAmount()).isEqualTo(10);
		assertThat(responseRPool.getCapacity().getResources().size()).isEqualTo(6);

		// Extract from pool
		var resExtrText =			"{\"resourcePool\": {\"id\": \"%s\"},\"capacity\": {\"capacityAmount\": 2,\"resources\": [{\"id\": \"xxx\"},{\"id\": \"yyy\"}]}}".formatted(responseRPool.getId());
		

		var aResourcePoolExtract = JsonUtils.toJsonObj(resExtrText, ExtractCreate.class);
		logger.info("aResourcePoolExtract JSON = " + JsonUtils.toJsonString(aResourcePoolExtract));

		// @formatter:off
		String responseResourcePoolExt = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/extract")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( aResourcePoolExtract )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseResourcePoolExt = " + responseResourcePoolExt);
		responseRPool = JsonUtils.toJsonObj(responseResourcePoolExt, ResourcePool.class);

		assertThat(responseRPool.getId()).isNotNull();
		assertThat(responseRPool.getName()).isEqualTo("gNB");
		assertThat(responseRPool.getCapacity().getCapacityAmount()).isEqualTo(8);
		assertThat(responseRPool.getCapacity().getResources().size()).isEqualTo(4);

		// Availability Check
		// will check if there are free resources of specific amount under this pool

		AvailabilityCheck av = new AvailabilityCheck();
		ResourceCapacityDemand rcd = new ResourceCapacityDemand();
		rcd.setCapacityDemandAmount(1);
		ApplicableTimePeriod aperiod = new ApplicableTimePeriod();
		aperiod.setFromDateTime(OffsetDateTime.now(ZoneOffset.UTC));
		aperiod.setEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusDays(7));
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand(rcd);
		ResourcePoolRef rpRef = new ResourcePoolRef();
		rpRef.setId(responseRPool.getId());
		rcd.setResourcePool(rpRef);

		String strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);

		// @formatter:off
		String responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		AvailabilityCheck respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck,
				AvailabilityCheck.class);

		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo( 4 );

//		RelatedParty relatedParty = new RelatedParty();
//		relatedParty.setName("Actor");
//		ReservationCreate rrc = new ReservationCreate();
//
//		ResourceCapacityDemand resCapDem = new ResourceCapacityDemand();
//		ResourcePoolRef poolRef = new ResourcePoolRef();
//		poolRef.id(responseRPool.getId());
//		resCapDem.capacityDemandAmount("1").resourcePool(poolRef);
//
//		ReservationItem resrvItem = new ReservationItem();
//		resrvItem.quantity(1).resourceCapacity(resCapDem);
//
//		ServiceOrderRef soRef = new ServiceOrderRef();
//		soRef.id("xxx");
//		TimePeriod validFor = new TimePeriod();
//		validFor.startDateTime(OffsetDateTime.now(ZoneOffset.UTC))
//				.endDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusDays(7));
//
//		rrc.description("new reservation").relatedParty(relatedParty).addReservationItemItem(resrvItem)
//				.serviceOrderRef(soRef).validFor(validFor)
//				.requestedPeriodStartDateTime(OffsetDateTime.now(ZoneOffset.UTC))
//				.requestedPeriodEndDateTime(OffsetDateTime.now(ZoneOffset.UTC).plusDays(7));
//
//		String rrcStr = JsonUtils.toJsonString(rrc);
//		logger.info("ReservationCreate = " + rrcStr);

	}

	@WithMockUser(username = "osadmin", roles = { "USER", "ADMIN" })
	@Test
	public void testFindResourceInPools() throws UnsupportedEncodingException, IOException, Exception {

		// Create a resource spec
		File sspec = new File("src/test/resources/testResourceSpec.json");
		InputStream in = new FileInputStream(sspec);
		String sspectext = IOUtils.toString(in, "UTF-8");
		ResourceSpecificationCreate sspeccr1 = JsonUtils.toJsonObj(sspectext, ResourceSpecificationCreate.class);
		sspeccr1.setName("Spec1");
		ResourceSpecification responsesSpec1 = createResourceSpec(sspeccr1);

		ResourceCreate aResource = new ResourceCreate();
		aResource.setName("gNB A Outdoor");
		aResource.setCategory("Experimentation");
		aResource.setAtType("PhysicalResource");
		ResourceSpecificationRef aServiceSpecificationRef = new ResourceSpecificationRef();
		aServiceSpecificationRef.setId(responsesSpec1.getId());
		aServiceSpecificationRef.setName(responsesSpec1.getName());
		aResource.setResourceSpecification(aServiceSpecificationRef);
		Resource r1 = resourceRepoService.addResource(aResource);
		ResourceRef rref1 = new ResourceRef();
		rref1.setId(r1.getId());
		rref1.setName( aResource.getName() );
		

		aResource.setName("gNB B Outdoor");
		Resource r1_gb = resourceRepoService.addResource(aResource);
		ResourceRef rref1_gb = new ResourceRef();
		rref1_gb.setId(r1_gb.getId());
		rref1_gb.setName( aResource.getName() );
		
		aResource.setName("gNB C Outdoor");
		Resource r1_gc = resourceRepoService.addResource(aResource);
		ResourceRef rref1_gc = new ResourceRef();
		rref1_gc.setId(r1_gc.getId());
		rref1_gc.setName( aResource.getName() );
		
		

		aResource.setName("gNB Indoor");
		Resource r2 = resourceRepoService.addResource(aResource);
		ResourceRef rref2 = new ResourceRef();
		rref2.setId(r2.getId());

		// create Pools
		ResourcePoolCreate aResourcePool = new ResourcePoolCreate();
		aResourcePool.setName("Outdoors GNBs");
		Capacity cap = new Capacity();
		cap.addResourceRefItem(rref1);
		cap.addResourceRefItem(rref1_gb);
		cap.addResourceRefItem(rref1_gc);		
		aResourcePool.setCapacity(cap);
		var rp1 = resourcePoolRepoService.addResourcePool(aResourcePool);

		aResourcePool.setName("Indoor GNBs");
		cap = new Capacity();
		cap.addResourceRefItem(rref2);
		aResourcePool.setCapacity(cap);
		var rp2 = resourcePoolRepoService.addResourcePool(aResourcePool);

		assertThat(rp1.getCapacity().getResources().size()).isEqualTo(3);
		assertThat(rp2.getCapacity().getResources().size()).isEqualTo(1);

		Set<ResourcePool> refs = resourcePoolRepoService.findResourceRefinPools( rref1.getId() );
		assertThat(refs.size()).isEqualTo(1);
		assertThat(refs.stream().findFirst().get().getId() ).isEqualTo( rp1.getId() );
		refs = resourcePoolRepoService.findResourceRefinPools( rref2.getId() );
		assertThat(refs.size()).isEqualTo(1);
		assertThat(refs.stream().findFirst().get().getId() ).isEqualTo( rp2.getId() );
		
		
		//check availability of resource on a specific date then, e.g. R1

		Set<ResourcePool> resourcePoolToCheck = resourcePoolRepoService.findResourceRefinPools( r1.getId() );
		ResourcePool rpool = resourcePoolToCheck.stream().findFirst().get();
		
		AvailabilityCheck av = new AvailabilityCheck();
		ResourceCapacityDemand rcd = new ResourceCapacityDemand();
		rcd.setCapacityDemandAmount(1);
		ApplicableTimePeriod aperiod = new ApplicableTimePeriod();
		OffsetDateTime startReservationDate = OffsetDateTime.now(ZoneOffset.UTC);
		OffsetDateTime endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(7) ;
		
		
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd );
		ResourcePoolRef rpRef = new ResourcePoolRef();
		rpRef.setId( rpool.getId() );
		rcd.setResourcePool(rpRef);
		Set<ResourceRef> resourcesToReserve = new HashSet<>();
		resourcesToReserve.add(rref1);
		rcd.setResources( resourcesToReserve  );
		String strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);

		//no resource reservation yes, so this resource is available
		// @formatter:off
		String responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		AvailabilityCheck respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);

		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(1);
		
		
		//reserve this period.
		
		// Create a reservation
		String reserv = 
			"{"+ 
			"		  \"requestedPeriodStartDateTime\": \""+ startReservationDate +"\","+
			"		  \"requestedPeriodEndDateTime\": \""+ endReservationDate +"\","+
			"		  \"description\": \"new reservation\","+
			"		  \"relatedParty\": {"+
			"		    \"name\": \"Actor\""+
			"		  },"+
			"		  \"reservationItem\": ["+
			"		    {"+
			"		      \"quantity\": 1,"+
			"		      \"resourceCapacity\": {"+
			"		        \"capacityDemandAmount\": 1,"+
			"		        \"resourcePool\": {"+
			"		          \"id\": \""+ rpool.getId()+"\","+
			"		          \"resources\": ["+
			"		          {"+
			"		          \"id\": \""+r1.getId()+"\""+
			"		          }]"+
			"		        }"+
			"		      }"+
			"		    }"+
			"		  ],"+
			"		  \"serviceOrderRef\": {"+
			"		    \"id\": \"xxx\""+
			"		  }"+
			"		}";

		var rrc = JsonUtils.toJsonObj(reserv, ReservationCreate.class);

		// @formatter:off
		String responseReservation = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/reservation")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( rrc )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("testresponseReservationCreate = " + responseReservation);
		Reservation aReservation = JsonUtils.toJsonObj(responseReservation, Reservation.class);

		assertThat(aReservation.getId()).isNotNull();
		assertThat(aReservation.getDescription()).isEqualTo("new reservation");
		assertThat(aReservation.getReservationItem().stream().findFirst().get().getQuantity()).isEqualTo(1);

		
		//ask again for availability of this resource on this period. We should not get an availability
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(0); // We should not get an availability
		
		
		//ask again for availability of this resource in between  period. We should NOT get an availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(1);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(5) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd );		
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(0); // We should  get an availability
		
		//ask again for availability of this resource in period larger that includes other reservations. We should NOT get an availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).minusDays(5);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(10) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd );		
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(0); // We should  get an availability

		
		//ask again for availability of this resource in between  period. We should NOT get an availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(5);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(10) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd );		
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(0); // We should  get an availability
				
		//ask again for availability of this resource in between  period. We should NOT get an availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).minusDays(5);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(1) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd );		
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(0); // We should  get an availability
				
		//ask again for availability of this resource on a further period. We SHOULD GET an availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(10);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(12) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd );		
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo(1); // We should  get an availability

		
		//ask again for availability of two resources of this  pool in between  period. We should get only 1 RESOURCE  availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).minusDays(5);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(1) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd ); 
		resourcesToReserve = new HashSet<>();
		resourcesToReserve.add(rref1);
		resourcesToReserve.add(rref1_gb);
		rcd.setResources( resourcesToReserve  );
		
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo( 1 ); // We should  get an availability
		for (ResourceRef resourceRef : respAvailabilityCheck.getAvailableResources()) {
			logger.info("responseAvailabilityCheckresourceRef = " + resourceRef.getName());
			
		}
				
				
		//ask again for availability of any resource of this resource pool in between  period. We should get 2 RESOURCES  availability
		
		startReservationDate = OffsetDateTime.now(ZoneOffset.UTC).minusDays(5);
		endReservationDate = OffsetDateTime.now(ZoneOffset.UTC).plusDays(1) ;
				
		aperiod.setFromDateTime( startReservationDate  );
		aperiod.setEndDateTime( endReservationDate );
		rcd.applicableTimePeriod(aperiod);
		av.setResourceCapacityDemand( rcd ); 
		rcd.setResources( null );		//THIS SIGNALS TO CHECK ALL RESOURCES OF THIS POOL	
		strav = JsonUtils.toJsonString(av);
		logger.info("AvailabilityCheck JSON = " + strav);
		
		// @formatter:off
		responseAvailabilityCheck = mvc
				.perform(MockMvcRequestBuilders
				.post("/resourcePoolManagement/v1/availabilityCheck")
				.with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtils.toJson( av )))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		// @formatter:on
		logger.info("responseAvailabilityCheck = " + responseAvailabilityCheck);
		respAvailabilityCheck = JsonUtils.toJsonObj(responseAvailabilityCheck, AvailabilityCheck.class);
		assertThat(respAvailabilityCheck.getAvailableResources().size()).isEqualTo( 2 ); // We should  get an availability
		for (ResourceRef resourceRef : respAvailabilityCheck.getAvailableResources()) {
			logger.info("responseAvailabilityCheckresourceRef = " + resourceRef.getName());
			
		}
	}

	private ResourceSpecification createResourceSpec(ResourceSpecificationUpdate sspeccr1) throws Exception {

		URI url = new URI("/resourceCatalogManagement/v4/resourceSpecification");

		String responseSpec = mvc
				.perform(MockMvcRequestBuilders.post(url).with(SecurityMockMvcRequestPostProcessors.csrf())
						.contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(sspeccr1)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		ResourceSpecification responsesSpec1;
		if (sspeccr1.getType().toLowerCase().contains("physicalresource")) {
			responsesSpec1 = JsonUtils.toJsonObj(responseSpec, PhysicalResourceSpecification.class);
		} else {
			responsesSpec1 = JsonUtils.toJsonObj(responseSpec, LogicalResourceSpecification.class);
		}

//		logger.info("createResourceSpec = " + responseSpec);
		return responsesSpec1;
	}
}
