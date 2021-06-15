package com.prototype.auditchecklist.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.prototype.auditchecklist.feignclients.AuthClient;
import com.prototype.auditchecklist.pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class TokenServiceTest {
	
	@InjectMocks
	TokenService tokenService;
	@Mock
	AuthClient authClient;
	
	@Mock
	AuthResponse authResponse;

	@Mock
	ResponseEntity<AuthResponse> entity;

	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true),HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		assertEquals(true, tokenService.checkTokenValidity("token"));
		

	}

	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {

		assertThrows(NullPointerException.class,() -> tokenService.checkTokenValidity("token"));
	

	}

	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
	
		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null,false),HttpStatus.FORBIDDEN);
		when(authClient.getValidity("token")).thenReturn(entity);
		assertEquals(false, tokenService.checkTokenValidity("token"));


	}


}
