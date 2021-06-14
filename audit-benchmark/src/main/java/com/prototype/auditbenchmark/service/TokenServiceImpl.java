package com.prototype.auditbenchmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.prototype.auditbenchmark.exception.FeignProxyException;
import com.prototype.auditbenchmark.feignclient.AuthClient;
import com.prototype.auditbenchmark.pojo.AuthResponse;

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
