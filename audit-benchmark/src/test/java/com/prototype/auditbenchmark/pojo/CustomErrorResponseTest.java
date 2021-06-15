package com.prototype.auditbenchmark.pojo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class CustomErrorResponseTest {

	private CustomErrorResponse customErrorResponse;
	
	@Before
	public void beforeTestMethod() {
		customErrorResponse = new CustomErrorResponse();
	}
	
	@After
	public void afterTestMethod() {
		log.info("Test Done Successfuly !");
	}
	
	
	@Test
	public void testCustomErrorResponse() {
		assertNotNull(customErrorResponse);
	}
	

	@Test
	public void testParameterizedConstructor() {
	      CustomErrorResponse customErrorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.OK,
				"Message","reason");
		assertNotNull(customErrorResponse);
	}

	@Test
	public void testGetStatus() {
		customErrorResponse.setStatus(HttpStatus.OK);
		assertEquals(HttpStatus.OK, customErrorResponse.getStatus());
    }
	/**
	    * to test the getter setter of message
	    */
	@Test
	public void testGetMessage() {
		customErrorResponse.setMessage("Message");
		assertEquals("Message", customErrorResponse.getMessage());
	}
	/**
	    * to test the getter setter of LocalDateTime
	    */	
	@Test
	public void testSetLocalDateTime() {
        customErrorResponse.setTimestamp(LocalDateTime.now());
    }
	  /**
	   *  to test the getter setter of Status
	   */	  
	@Test
	public void testSetStatus() {
         customErrorResponse.setStatus(HttpStatus.OK);
    }
	/**
	  *  to test the getter setter of message
	  */	
	@Test
	public void testSetMessage() {
         customErrorResponse.setMessage("Message");
    }

}
