package com.prototype.auditbenchmark.exception;
/**
 * This class tests the GlobalExceptionHandler class
 */
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration
public class GlobalExceptionHandlerTest {

	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;
	
	@Test
	public void contextLoads() {
		assertNotNull(globalExceptionHandler);
	}
	
	@Test
	public void testhandelWrongDateFormateException() {
		assertNotNull(globalExceptionHandler.handelFeignProxyException(new FeignProxyException()));
	}
	
		
}
