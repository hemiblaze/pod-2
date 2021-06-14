package com.prototype.auditwebportal.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.prototype.auditwebportal.model.AuditRequest;
import com.prototype.auditwebportal.model.AuditResponse;


@FeignClient(url="${fos.severity}",name="audit-severity")
public interface AuditSeverityProxy {
	
	@PostMapping("/execution-status")
	public ResponseEntity<AuditResponse> auditSeverity(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditRequest request);
	
}
