package com.prototype.auditseverity.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prototype.auditseverity.model.QuestionsEntity;

@FeignClient(name="audit-checklist",url="${audit.checklist.url}")
public interface AuditCheckListFeign {
	
	@GetMapping("/checklist/{audit-type}")
	public ResponseEntity<List<QuestionsEntity>> getQuestions(@PathVariable("audit-type") String audit_type);
	

}
