package com.prototype.auditauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditauthentication.exception.LoginFailedException;
import com.prototype.auditauthentication.model.AuthResponse;
import com.prototype.auditauthentication.model.ProjectManager;
import com.prototype.auditauthentication.model.UserCredentials;
import com.prototype.auditauthentication.service.JwtUtil;
import com.prototype.auditauthentication.service.ManagerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuthController {

	@Autowired
	ManagerService managerService;

	@Autowired
	JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userCredentials) throws Exception {

		final UserDetails userDetails = managerService.loadUserByUsername(userCredentials.getUserId());

		if (userDetails.getPassword().equals(userCredentials.getPassword())) {
			String token = jwtUtil.generateToken(userDetails);
			ProjectManager projectManager = new ProjectManager(userCredentials.getUserId(),
					userCredentials.getPassword(), token);
			managerService.saveUser(projectManager);
			return new ResponseEntity<>(projectManager, HttpStatus.OK);

		} else {
			throw new LoginFailedException("Invalid Credentials");
		}
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token) {
		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		ResponseEntity<?> response = null;
		try {
			if (jwtUtil.validateToken(token)) {

				res.setUid(jwtUtil.extractUsername(token));
				res.setValid(true);

			}
		} catch (Exception e) {
			res.setValid(false);
			if (e.getMessage().contains("token expired"))
				;
			response = new ResponseEntity<String>("token expired", HttpStatus.FORBIDDEN);
			if (e.getMessage().contains("auth failed"))
				response = new ResponseEntity<String>("auth failed", HttpStatus.FORBIDDEN);
			response = new ResponseEntity<>(res, HttpStatus.FORBIDDEN);
			return response;
		}
		response = new ResponseEntity<AuthResponse>(res, HttpStatus.OK);
		return response;

	}

}
