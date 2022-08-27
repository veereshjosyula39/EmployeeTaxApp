package com.employeetax.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.employeetax.demo.dto.ResponseStatusDTO;

@ControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {
 
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(	MethodArgumentNotValidException ex,
																	HttpHeaders headers,
																	HttpStatus status,
																	WebRequest request) {
		Map<String, String> validationErrors = new HashMap<>();
		ResponseStatusDTO red = new ResponseStatusDTO();
		ex.getBindingResult()
			.getAllErrors()
			.forEach(errors -> {
				String fieldName = ((FieldError) errors).getField();
				String message = errors.getDefaultMessage();
				validationErrors.put(fieldName, message);
			});
		red.setFieldResponse(validationErrors);
		red.setStatusCode(HttpStatus.NOT_FOUND.value());
		red.setStatusMessage("error");
		return new ResponseEntity<>(red, HttpStatus.BAD_REQUEST);
	}
	// @ExceptionHandler
	// public ResponseEntity<ResponseStatusDTO> handleException(UnexpectedTypeException ex) {
	// ResponseStatusDTO errorResponse = new ResponseStatusDTO();
	// errorResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
	// errorResponse.setStatusMessage(ex.getMessage());
	// return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	// }
	//
	// @ExceptionHandler
	// public ResponseEntity<ResponseStatusDTO> handleException(Exception ex) {
	// ResponseStatusDTO errorResponse = new ResponseStatusDTO();
	// errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
	// errorResponse.setStatusMessage(ex.getMessage());
	// return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	// }
	//
	// @ExceptionHandler
	// public ResponseEntity<ResponseStatusDTO> handleException(NullPointerException ex) {
	// ResponseStatusDTO errorResponse = new ResponseStatusDTO();
	// errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
	// errorResponse.setStatusMessage(ex.getMessage());
	// return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	// }
}
