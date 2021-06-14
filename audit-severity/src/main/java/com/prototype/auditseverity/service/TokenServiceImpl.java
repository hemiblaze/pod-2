package com.prototype.auditseverity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditseverity.exception.FeignProxyException;
import com.prototype.auditseverity.feignclients.AuthClient;
import com.prototype.auditseverity.pojo.AuthResponse;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

	@Autowired
	private AuthClient authClient;

	public Boolean checkTokenValidity(String token)  {

		try {
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if(authResponse==null) throw new FeignProxyException();
			
			return authResponse.isValid();
		} catch (FeignProxyException fe) {
			
			return false;
		}catch(FeignException e) {
			return false;
		}
		
	}

}
