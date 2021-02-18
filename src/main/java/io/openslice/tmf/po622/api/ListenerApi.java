/*-
 * ========================LICENSE_START=================================
 * io.openslice.tmf.api
 * %%
 * Copyright (C) 2019 - 2021 openslice.io
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
/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.po622.api;

import io.openslice.tmf.po622.model.CancelProductOrderCreateEvent;
import io.openslice.tmf.po622.model.CancelProductOrderInformationRequiredEvent;
import io.openslice.tmf.po622.model.CancelProductOrderStateChangeEvent;
import io.openslice.tmf.po622.model.Error;
import io.openslice.tmf.po622.model.EventSubscription;
import io.openslice.tmf.po622.model.ProductOrderAttributeValueChangeEvent;
import io.openslice.tmf.po622.model.ProductOrderCreateEvent;
import io.openslice.tmf.po622.model.ProductOrderDeleteEvent;
import io.openslice.tmf.po622.model.ProductOrderInformationRequiredEvent;
import io.openslice.tmf.po622.model.ProductOrderStateChangeEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-10-30T10:29:21.184964400+02:00[Europe/Athens]")
@Api(value = "listener", description = "the listener API")
public interface ListenerApi {

    Logger log = LoggerFactory.getLogger(ListenerApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Client listener for entity CancelProductOrderCreateEvent", nickname = "listenToCancelProductOrderCreateEvent", notes = "Example of a client listener for receiving the notification CancelProductOrderCreateEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/cancelProductOrderCreateEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCancelProductOrderCreateEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody CancelProductOrderCreateEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity CancelProductOrderInformationRequiredEvent", nickname = "listenToCancelProductOrderInformationRequiredEvent", notes = "Example of a client listener for receiving the notification CancelProductOrderInformationRequiredEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/cancelProductOrderInformationRequiredEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCancelProductOrderInformationRequiredEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody CancelProductOrderInformationRequiredEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity CancelProductOrderStateChangeEvent", nickname = "listenToCancelProductOrderStateChangeEvent", notes = "Example of a client listener for receiving the notification CancelProductOrderStateChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/cancelProductOrderStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToCancelProductOrderStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody CancelProductOrderStateChangeEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity ProductOrderAttributeValueChangeEvent", nickname = "listenToProductOrderAttributeValueChangeEvent", notes = "Example of a client listener for receiving the notification ProductOrderAttributeValueChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/productOrderAttributeValueChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToProductOrderAttributeValueChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody ProductOrderAttributeValueChangeEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity ProductOrderCreateEvent", nickname = "listenToProductOrderCreateEvent", notes = "Example of a client listener for receiving the notification ProductOrderCreateEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/productOrderCreateEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToProductOrderCreateEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody ProductOrderCreateEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity ProductOrderDeleteEvent", nickname = "listenToProductOrderDeleteEvent", notes = "Example of a client listener for receiving the notification ProductOrderDeleteEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/productOrderDeleteEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToProductOrderDeleteEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody ProductOrderDeleteEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity ProductOrderInformationRequiredEvent", nickname = "listenToProductOrderInformationRequiredEvent", notes = "Example of a client listener for receiving the notification ProductOrderInformationRequiredEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/productOrderInformationRequiredEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToProductOrderInformationRequiredEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody ProductOrderInformationRequiredEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Client listener for entity ProductOrderStateChangeEvent", nickname = "listenToProductOrderStateChangeEvent", notes = "Example of a client listener for receiving the notification ProductOrderStateChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/productOrderStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToProductOrderStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody ProductOrderStateChangeEvent body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"query\" : \"query\",\r\n  \"callback\" : \"callback\",\r\n  \"id\" : \"id\"\r\n}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ListenerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
