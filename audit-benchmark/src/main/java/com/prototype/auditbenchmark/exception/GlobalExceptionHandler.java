package com.prototype.auditbenchmark.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.prototype.auditbenchmark.pojo.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * This class handles all the exceptions. Whenever an exception occurs
 * anywhere then first it will be checked whether there is {@link GlobalErrorHandler} 
 * declared or not. This has an annotation
 * RestControllerAdvice so it works for all controllers and classes.
 *          
 * @see ResponseEntityExceptionHandler
 *
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 
	 * @param ex
	 * @return ResponseEntity<CustomErrorResponse>
	 * 
	 * This method is to Handle Exception when Feign client  is not  working
	 */


	@ExceptionHandler(FeignProxyException.class)
	public ResponseEntity<CustomErrorResponse> handelFeignProxyException(FeignProxyException ex) {

		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason("feign is null");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
