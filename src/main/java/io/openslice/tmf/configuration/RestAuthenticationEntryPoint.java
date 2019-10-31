package io.openslice.tmf.configuration;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public final class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * From https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
	 * 
	 * In a standard web application, the authentication process may
	 * automatically trigger when an un-authenticated client tries to access a
	 * secured resource. This process usually redirects to a login page so that
	 * the user can enter credentials. However, for a REST Web Service,this
	 * behaviour doesn’t make much sense. We should be able to authenticate only
	 * by a request to the correct URI and if the user is not authenticated all
	 * requests should simply fail with a 401 UNAUTHORIZED status code. Spring
	 * Security handles this automatic triggering of the authentication process
	 * with the concept of an Entry Point – this is a required part of the
	 * configuration, and can be injected via the authenticationEntryPoint
	 * method.
	 */

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}