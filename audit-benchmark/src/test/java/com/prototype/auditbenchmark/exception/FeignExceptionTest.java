package com.prototype.auditbenchmark.exception;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 
 * This class test the FeignProxyException class
 * 
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
public class FeignExceptionTest{
	
	
	
	@Mock
	FeignProxyException feignProxyException;
	
	@Test
	public void contextLoads() {
		assertNotNull(feignProxyException);
	}
	
	@Test 
	public void testFeignConstructor() {
		assertNotNull(new FeignProxyException());
	}

}
