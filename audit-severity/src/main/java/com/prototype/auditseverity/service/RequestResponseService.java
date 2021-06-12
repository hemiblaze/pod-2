package com.prototype.auditseverity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prototype.auditseverity.feignclients.AuditBenchmarkFeign;
import com.prototype.auditseverity.feignclients.AuditCheckListFeign;
import com.prototype.auditseverity.model.AuditRequest;
import com.prototype.auditseverity.model.AuditResponse;
import com.prototype.auditseverity.model.QuestionsEntity;
import com.prototype.auditseverity.pojo.AuditBenchmark;
import com.prototype.auditseverity.repository.AuditDetailRepository;
import com.prototype.auditseverity.repository.RequestRepository;
import com.prototype.auditseverity.repository.ResponseRepository;

@Service
public class RequestResponseService {

	@Autowired
	AuditDetailRepository auditDetailRepository;
	
	@Autowired
	RequestRepository  requestRepository;
	
	@Autowired
	ResponseRepository responseRepository;
	
	@Autowired
	AuditCheckListFeign auditCheckListFeign;
	
	@Autowired
	AuditBenchmarkFeign auditBenchmarkFeign;
	
	public AuditRequest saveRequest(AuditRequest request) {
		return requestRepository.save(request);
	}
	public AuditResponse saveResponse(AuditResponse response) {
		return responseRepository.save(response);
	}
	
	public ResponseEntity<List<QuestionsEntity>> getAllQuestions(String auditType){
	
		ResponseEntity<List<QuestionsEntity>> questions = auditCheckListFeign.getQuestions(auditType);
		return questions;
		
	
		
	}
	public ArrayList<AuditBenchmark> getAuditBenchmark(){
		ArrayList<AuditBenchmark> benchmarks=auditBenchmarkFeign.getBenchMark();
		return benchmarks;
	}
}