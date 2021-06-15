package com.prototype.auditbenchmark.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.prototype.auditbenchmark.feignclient.AuthClient;
import com.prototype.auditbenchmark.model.BenchMark;
import com.prototype.auditbenchmark.service.TokenService;
/**
 * 
 * Test class for BenchmarkController 
 */

@RunWith(SpringRunner.class)
@ContextConfiguration 
public class BenchMarkControllerTest {

	/**
	 * Mocking all required objects
	 */
	@Mock
	AuthClient authClient;
		
	@Mock
	TokenService tokenService;
	
	@Mock
	BenchMark benchmark;
	
	@InjectMocks
	BenchMarkController benchmarkcontroller;
	/**
	 * Testing the methods
	 */	
    @Test
	public void testGetBenchmark() {
		List<BenchMark> benchmarkList = new ArrayList<>();
		
		benchmarkList.add(new BenchMark("Internal", 3));
		benchmarkList.add(new BenchMark("SOX", 1));
		
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		assertEquals(benchmarkList,benchmarkcontroller.getBenchMark("token").getBody());
	}
	
	@Test
	public void testTokenIsInvalid() {
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		assertEquals(HttpStatus.FORBIDDEN,benchmarkcontroller.getBenchMark("token").getStatusCode());
	}
}
