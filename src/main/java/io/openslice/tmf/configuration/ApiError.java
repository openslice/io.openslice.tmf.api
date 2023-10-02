package io.openslice.tmf.configuration;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ApiError {
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;

	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	ApiError(HttpStatus status) {
		this();
		this.status = status;
	}

	ApiError(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = "Unexpected error";
		this.debugMessage = ex.getLocalizedMessage();
	}

	ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.status = status;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}
