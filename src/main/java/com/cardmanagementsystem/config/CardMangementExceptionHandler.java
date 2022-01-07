package com.cardmanagementsystem.config;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CardMangementExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		List<String> errors = fieldErrors.stream().map(err -> err.getField() + ":" + err.getDefaultMessage())
				.collect(Collectors.toList());
		Response response = new Response();
		response.setErrors(errors);
		response.setStatusCode("1");
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setStatusDescription("error");

		return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
			ServletWebRequest request) {

		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		List<String> errors = constraintViolations.stream()
				.map(err -> err.getRootBeanClass().getName() + " " + err.getPropertyPath() + ": " + err.getMessage())
				.collect(Collectors.toList());
		Response response = new Response();
		response.setErrors(errors);
		response.setStatusCode("1");
		response.setStatusDescription("error");
		response.setStatus(HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(response, new HttpHeaders(), response.getStatus());
	}

}