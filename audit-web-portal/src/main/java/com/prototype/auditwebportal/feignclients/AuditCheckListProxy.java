package com.prototype.auditwebportal.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.prototype.auditwebportal.model.AuditType;
import com.prototype.auditwebportal.model.QuestionsEntity;

@FeignClient(url = "${fos.checklist}", name = "audit-checklist")
public interface AuditCheckListProxy {
	
	@PostMapping("/checklist")
	public ResponseEntity<List<QuestionsEntity>> getQuestions(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType );
	
	@PostMapping("/save-response")
	public ResponseEntity<List<QuestionsEntity>> saveResponses(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<QuestionsEntity> questionsResponse);
	
	
}
