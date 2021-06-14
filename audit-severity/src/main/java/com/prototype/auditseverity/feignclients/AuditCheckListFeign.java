package com.prototype.auditseverity.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.prototype.auditseverity.model.QuestionsEntity;
import com.prototype.auditseverity.pojo.AuditType;

@FeignClient(name="audit-checklist",url="${audit.checklist.url}")
public interface AuditCheckListFeign {
	
	@PostMapping("/checklist")
	public ResponseEntity<List<QuestionsEntity>> getQuestions(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType);
	

}
