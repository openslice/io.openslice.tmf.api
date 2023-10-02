package io.openslice.tmf.configuration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
		protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
				HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		String error = "Malformed JSON request";
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, error, ex);
		return new ResponseEntity<Object>(apiError, apiError.getStatus());
		}


	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	// other exception handlers below

}