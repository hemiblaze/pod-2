package com.prototype.auditchecklist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.service.checklistService;

@RestController
public class checklistController {
	
	@Autowired
	checklistService service;
	
	@GetMapping("/checklist/{audit-type}")
	public ResponseEntity<List<QuestionsEntity>> getQuestions(@PathVariable("audit-type") String audit_type){
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<List<QuestionsEntity>> responseEntity;
		if(audit_type.equals("Internal")||audit_type.equals("SOX")) {
			questionsList=service.getQuestions(audit_type);
		 responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
		 return responseEntity;
		}
		List<QuestionsEntity> response=new ArrayList<>();
		response.add(new QuestionsEntity());
		responseEntity = new ResponseEntity<List<QuestionsEntity>>(response,HttpStatus.BAD_REQUEST);
		return responseEntity;
		
			
		
	}
	@PostMapping("/save-response")
	public ResponseEntity<?> saveRespose(@RequestBody List<QuestionsEntity> responses){
		ResponseEntity<?> responseEntity;
		 responseEntity = new ResponseEntity<List<QuestionsEntity>>(service.saveResponse(responses),HttpStatus.OK);
		return responseEntity;
	}
	

}
