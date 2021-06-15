package com.prototype.auditbenchmark.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditbenchmark.model.BenchMark;
import com.prototype.auditbenchmark.service.TokenService;
/**
 * 
 * This class is handling all the end points for returning benchmark of acceptable no of NO's for a particular
 * audit type to  Audit Severity microservice. 
 * 
 * @see tokenService is to check token with auth microservice
 *
 */
@RestController
public class BenchMarkController {

	@Autowired
	TokenService tokenService;

	/**
	 * 
	 * @param token - used to verfiy the token with auth service
	 * @return response entity which is either List of questions or error caused in application
	 */

	@GetMapping("/audit-benchmark")
	public ResponseEntity<?> getBenchMark(@RequestHeader("Authorization") String token) {
		ArrayList<BenchMark> marksList = new ArrayList<>();
		ResponseEntity<?> responseEntity = null;
		marksList.add(new BenchMark("Internal", 3));
		marksList.add(new BenchMark("SOX", 1));
		if (tokenService.checkTokenValidity(token)) {

			responseEntity = new ResponseEntity<List<BenchMark>>(marksList, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("the token is expired and not valid anymore", HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		return responseEntity;

	}

}
