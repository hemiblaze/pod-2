package com.prototype.auditauthentication.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prototype.auditauthentication.model.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<CustomErrorResponse> handleIdNotFoundexception(LoginFailedException ex) {

		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TokenExpiredException.class)
	public ResponseEntity<CustomErrorResponse> handleTokenNotFoundexception(TokenExpiredException ex) {
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"the token is expired and not valid anymore", ex.getMessage());

		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleUserNotFoundexception(UsernameNotFoundException ex) {
		CustomErrorResponse response = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND,
				"Invalid Credentials", ex.getMessage());
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
}
