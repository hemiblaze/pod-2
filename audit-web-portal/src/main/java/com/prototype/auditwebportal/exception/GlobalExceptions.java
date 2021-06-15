package com.prototype.auditwebportal.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleError405(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView("/405");
		mav.addObject("exception", e);
		// mav.addObject("errorcode", "405");
		return mav;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView Error500(Exception ex, HttpServletRequest request) {
		ModelAndView mav1 = new ModelAndView("/internalServerError");
		mav1.addObject("exception", ex);
		if (ex instanceof NullPointerException) {
			return mav1;
		}
		return mav1;
	}
}
