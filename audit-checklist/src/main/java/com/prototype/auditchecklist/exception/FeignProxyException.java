package com.prototype.auditchecklist.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


public class FeignProxyException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public FeignProxyException() {
		super();
	}

}
