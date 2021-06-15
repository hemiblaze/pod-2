package com.prototype.auditbenchmark.model;
/**
 * test class for AuditBenchmark
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BenchmarkTest {

	private BenchMark benchmark;
	
	@Before
	public void testMethod() {
		benchmark = new BenchMark("Internal", 3);
	}
	
	@Test
	public void testGetSetAuditType() {
		assertEquals("Internal", benchmark.getAuditType());
		benchmark.setAuditType("SOX");
		assertEquals("SOX", benchmark.getAuditType());
	}
	@Test
	public void testGetSetAccNoAnswers() {
		assertEquals(3,benchmark.getNoOfnos());
		benchmark.setNoOfnos(1);
		assertEquals(1, benchmark.getNoOfnos());
	}
}
