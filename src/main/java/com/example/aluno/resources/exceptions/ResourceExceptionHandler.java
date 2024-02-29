package com.example.aluno.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.aluno.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;


//intercepta as exceções que acontecerem para este objeto exceutar o possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	//identifica que este metodo vai interceptar todas as exceções de ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
