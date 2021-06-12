package com.prototype.auditseverity.feignclients;

import java.util.ArrayList;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.prototype.auditseverity.pojo.AuditBenchmark;

@FeignClient(name="audit-benchmark",url="${audit.benchmark.url}")
public interface AuditBenchmarkFeign {
	@GetMapping("/audit-benchmark")
	public ArrayList<AuditBenchmark> getBenchMark();

}
