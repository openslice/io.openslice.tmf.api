package io.openslice.tmf.ro652.api;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.tmf.common.model.UserPartRoleType;
import io.openslice.tmf.ro652.model.ResourceOrder;
import io.openslice.tmf.ro652.model.ResourceOrderCreate;
import io.openslice.tmf.ro652.reposervices.ResourceOrderRepoService;
import io.openslice.tmf.so641.api.ServiceOrderApiController;
import io.openslice.tmf.so641.model.ServiceOrder;
import io.openslice.tmf.so641.reposervices.ServiceOrderRepoService;
import io.openslice.tmf.util.AddUserAsOwnerToRelatedParties;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-28T23:39:08.914219800+03:00[Europe/Athens]")
@Controller
@RequestMapping("/resourceOrderingManagement/v4/")
public class ResourceOrderApiController implements ResourceOrderApi {

	private static final Logger log = LoggerFactory.getLogger( ResourceOrderApiController.class);

	
    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;


	@Autowired
	ResourceOrderRepoService resourceOrderRepoService;

    @org.springframework.beans.factory.annotation.Autowired
    public ResourceOrderApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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


	@Secured({ "ROLE_USER" })
    @Override
    public ResponseEntity<ResourceOrder> createResourceOrder(Principal principal, @Valid ResourceOrderCreate roCreate) {
    	

		try {
			//Object attr = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
			//SecurityContextHolder.setContext( (SecurityContext) attr );  
			
			
				log.info("authentication=  " + principal.toString());
				String extInfo = null;
				try {
					

					if ( principal instanceof KeycloakAuthenticationToken) {

						KeycloakAuthenticationToken pr = ( KeycloakAuthenticationToken ) principal;
						
						KeycloakPrincipal lp = (KeycloakPrincipal) pr.getPrincipal();
						extInfo = lp.getKeycloakSecurityContext().getToken().getEmail();	
						log.info("extInfo=  " + extInfo);	

						roCreate.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
								principal.getName(), 
								//user.getId()+"", 
								principal.getName(), 
								UserPartRoleType.REQUESTER,
								extInfo,
								roCreate.getRelatedParty()));
					} 
					else if ( principal instanceof UsernamePasswordAuthenticationToken ) {
						roCreate.setRelatedParty(AddUserAsOwnerToRelatedParties.addUser(
								principal.getName(), 
								//user.getId()+"", 
								principal.getName(), 
								UserPartRoleType.REQUESTER,
								extInfo,
								roCreate.getRelatedParty()));
					}
				
					
				}finally {
					
				}
				
				ResourceOrder c = resourceOrderRepoService.addResourceOrder( roCreate );

				return new ResponseEntity<ResourceOrder>(c, HttpStatus.OK);				
			

		} catch (Exception e) {
			log.error("Couldn't serialize response for content type application/json", e);
			return new ResponseEntity<ResourceOrder>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }
    
}