package com.security.oauth2.auth.server.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice(annotations = { RestController.class, Controller.class })
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ AccessDeniedException.class })
	protected ResponseEntity<ErrorResponse> accessDeniedException(AccessDeniedException ex) {
		log.error(ex.getMessage(), ex);
		return buildResponseEntity(ex, HttpStatus.FORBIDDEN);
	}
	
	private ResponseEntity<ErrorResponse> buildResponseEntity(Exception ex, HttpStatus status) {

        String message    = ex.getMessage();
        //String stackTrace = ExceptionUtils.getStackTrace(ex);

        ErrorResponse body = new ErrorResponse(message);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(body, headers, status);
    }
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ErrorResponse {
		private String descripton;
		
	}

}
