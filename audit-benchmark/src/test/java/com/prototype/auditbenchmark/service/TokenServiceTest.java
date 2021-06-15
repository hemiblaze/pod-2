package com.prototype.auditbenchmark.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditbenchmark.feignclient.AuthClient;
import com.prototype.auditbenchmark.pojo.AuthResponse;


@RunWith(SpringRunner.class)
@ContextConfiguration
public class TokenServiceTest {
	
	@InjectMocks
	TokenServiceImpl tokenService;
	
	@Mock
	AuthClient authClient;
	
	@Mock
	AuthResponse authResponse;
	
	@Mock
	ResponseEntity<AuthResponse> authResponseEntity;
	
	@Test
	public void testTokenValidityWhenTokenIsValid() {
		authResponseEntity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true),HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(authResponseEntity);
        assertEquals(true, tokenService.checkTokenValidity("token"));

	}
	
	@Test
	public void testTokenValidityWhenTokenNullPointerException() {
         assertThrows(NullPointerException.class,() -> tokenService.checkTokenValidity("token"));

	}
	
	@Test
	public void testTokenValidityWhenTokenIsInvalid() {
		authResponseEntity = new ResponseEntity<AuthResponse>(new AuthResponse(null,false),HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(authResponseEntity);
		assertEquals(false, tokenService.checkTokenValidity("token"));

	}


}
