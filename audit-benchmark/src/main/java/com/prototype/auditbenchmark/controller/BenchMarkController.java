package com.prototype.auditbenchmark.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.auditbenchmark.model.BenchMark;

@RestController
public class BenchMarkController {
	
	@GetMapping("/audit-benchmark")
	public ArrayList<BenchMark> getBenchMark(){
		ArrayList<BenchMark> marksList=new ArrayList<>();
		marksList.add(new BenchMark("Internal",3));
		marksList.add(new BenchMark("SOX",1));
		return marksList;
		
	}

}
