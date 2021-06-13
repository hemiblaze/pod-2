package com.prototype.auditchecklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditchecklist.exception.FeignProxyException;
import com.prototype.auditchecklist.feignclients.AuthClient;
import com.prototype.auditchecklist.pojo.AuthResponse;

@Service
public class TokenService implements TokenServiceInt{

	@Autowired
	private AuthClient authClient;
	
	public Boolean checkTokenValidity(String token)  {
		try {
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if(authResponse==null) throw new FeignProxyException();
			return authResponse.isValid();	
		}catch (FeignProxyException fe) {
			return false;
		}
	}
}
