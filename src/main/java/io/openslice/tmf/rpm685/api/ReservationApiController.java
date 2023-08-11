package io.openslice.tmf.rpm685.api;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.openslice.tmf.rpm685.model.Reservation;
import io.openslice.tmf.rpm685.model.ReservationCreate;
import io.openslice.tmf.rpm685.model.ReservationUpdate;
import io.openslice.tmf.rpm685.reposervices.ResourceReservationRepoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
@jakarta.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-10-05T08:56:49.602231700+03:00[Europe/Athens]")
@Controller("ReservationApiController685")
@RequestMapping("/resourcePoolManagement/v1/")
public class ReservationApiController implements ReservationApi {


	private static final Logger log = LoggerFactory.getLogger(ReservationApiController.class);

	@Autowired
	ResourceReservationRepoService resourceReservationRepoService;
	
	
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ReservationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }


	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    @Override
    public ResponseEntity<Reservation> createReservation(Principal principal, @Valid ReservationCreate body) {
    	try {
			if (SecurityContextHolder.getContext().getAuthentication() != null) {
				

				Reservation c = resourceReservationRepoService.addReservation( body );

				return new ResponseEntity<Reservation>(c, HttpStatus.OK);
			} else {

				return new ResponseEntity<Reservation>(HttpStatus.FORBIDDEN);
			}

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    @Override
    public ResponseEntity<List<Reservation>> listReservation(Principal principal, @Valid String fields,
    		@Valid Integer offset, @Valid Integer limit) {
		try {
			return new ResponseEntity<List<Reservation>>( resourceReservationRepoService.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<List<Reservation>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    @Override
    public ResponseEntity<Reservation> patchReservation(Principal principal, @Valid ReservationUpdate body, String id) {
		
		Reservation c = resourceReservationRepoService.updateReservation(id, body );
		
		// TODO Auto-generated method stub
		return new ResponseEntity<Reservation>(c, HttpStatus.OK);
    }

	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')" )
    @Override
    public ResponseEntity<Reservation> retrieveReservation(Principal principal, String id) {
		try {

			return new ResponseEntity<Reservation>( resourceReservationRepoService.findByUuid(id) , HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Reservation>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
	
	
	@Override
	public ResponseEntity<Void> deleteReservation(Principal principal, String id) {
		try {

			return new ResponseEntity<Void>( resourceReservationRepoService.deleteByUuid(id), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
    
    
}
