/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.9).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.openslice.tmf.am666.api;

import io.openslice.tmf.am666.model.BillingAccountAttributeValueChangeEvent;
import io.openslice.tmf.am666.model.BillingAccountStateChangeEvent;
import io.openslice.tmf.am666.model.Error;
import io.openslice.tmf.am666.model.EventSubscription;
import io.openslice.tmf.am666.model.FinancialAccountAttributeValueChangeEvent;
import io.openslice.tmf.am666.model.FinancialAccountCreateEvent;
import io.openslice.tmf.am666.model.FinancialAccountDeleteEvent;
import io.openslice.tmf.am666.model.FinancialAccountStateChangeEvent;
import io.openslice.tmf.am666.model.PartyAccountAttributeValueChangeEvent;
import io.openslice.tmf.am666.model.PartyAccountStateChangeEvent;
import io.openslice.tmf.am666.model.SettlementAccountAttributeValueChangeEvent;
import io.openslice.tmf.am666.model.SettlementAccountStateChangeEvent;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-19T23:49:45.251+03:00")

@Api(value = "listener", description = "the listener API")
public interface ListenerApi {

    Logger log = LoggerFactory.getLogger(ListenerApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Client listener for entity BillingAccountAttributeValueChangeEvent", nickname = "listenToBillingAccountAttributeValueChangeEvent", notes = "Example of a client listener for receiving the notification BillingAccountAttributeValueChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/billingAccountAttributeValueChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToBillingAccountAttributeValueChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody BillingAccountAttributeValueChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity BillingAccountStateChangeEvent", nickname = "listenToBillingAccountStateChangeEvent", notes = "Example of a client listener for receiving the notification BillingAccountStateChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/billingAccountStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToBillingAccountStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody BillingAccountStateChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity FinancialAccountAttributeValueChangeEvent", nickname = "listenToFinancialAccountAttributeValueChangeEvent", notes = "Example of a client listener for receiving the notification FinancialAccountAttributeValueChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/financialAccountAttributeValueChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToFinancialAccountAttributeValueChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountAttributeValueChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity FinancialAccountCreateEvent", nickname = "listenToFinancialAccountCreateEvent", notes = "Example of a client listener for receiving the notification FinancialAccountCreateEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/financialAccountCreateEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToFinancialAccountCreateEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountCreateEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity FinancialAccountDeleteEvent", nickname = "listenToFinancialAccountDeleteEvent", notes = "Example of a client listener for receiving the notification FinancialAccountDeleteEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/financialAccountDeleteEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToFinancialAccountDeleteEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountDeleteEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity FinancialAccountStateChangeEvent", nickname = "listenToFinancialAccountStateChangeEvent", notes = "Example of a client listener for receiving the notification FinancialAccountStateChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/financialAccountStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToFinancialAccountStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody FinancialAccountStateChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity PartyAccountAttributeValueChangeEvent", nickname = "listenToPartyAccountAttributeValueChangeEvent", notes = "Example of a client listener for receiving the notification PartyAccountAttributeValueChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/partyAccountAttributeValueChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToPartyAccountAttributeValueChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody PartyAccountAttributeValueChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity PartyAccountStateChangeEvent", nickname = "listenToPartyAccountStateChangeEvent", notes = "Example of a client listener for receiving the notification PartyAccountStateChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/partyAccountStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToPartyAccountStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody PartyAccountStateChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity SettlementAccountAttributeValueChangeEvent", nickname = "listenToSettlementAccountAttributeValueChangeEvent", notes = "Example of a client listener for receiving the notification SettlementAccountAttributeValueChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/settlementAccountAttributeValueChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToSettlementAccountAttributeValueChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody SettlementAccountAttributeValueChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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


    @ApiOperation(value = "Client listener for entity SettlementAccountStateChangeEvent", nickname = "listenToSettlementAccountStateChangeEvent", notes = "Example of a client listener for receiving the notification SettlementAccountStateChangeEvent", response = EventSubscription.class, tags={ "notification listeners (client side)", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Notified", response = EventSubscription.class),
        @ApiResponse(code = 400, message = "Bad Request", response = Error.class),
        @ApiResponse(code = 401, message = "Unauthorized", response = Error.class),
        @ApiResponse(code = 403, message = "Forbidden", response = Error.class),
        @ApiResponse(code = 404, message = "Not Found", response = Error.class),
        @ApiResponse(code = 405, message = "Method Not allowed", response = Error.class),
        @ApiResponse(code = 409, message = "Conflict", response = Error.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
    @RequestMapping(value = "/listener/settlementAccountStateChangeEvent",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json;charset=utf-8" },
        method = RequestMethod.POST)
    default ResponseEntity<EventSubscription> listenToSettlementAccountStateChangeEvent(@ApiParam(value = "The event data" ,required=true )  @Valid @RequestBody SettlementAccountStateChangeEvent data) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"query\" : \"query\",  \"callback\" : \"callback\",  \"id\" : \"id\"}", EventSubscription.class), HttpStatus.NOT_IMPLEMENTED);
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
