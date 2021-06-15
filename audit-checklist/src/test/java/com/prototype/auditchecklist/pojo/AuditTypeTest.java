package com.prototype.auditchecklist.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;

public class AuditTypeTest {

	@Mock
	AuditType auditType ;

	@Test
	public void testSetAuditType() {
		auditType=new AuditType();
		auditType.setAuditType("Internal");
		assertEquals("Internal",auditType.getAuditType());
	}

	@Test
	public void testGetAuditType() {
		auditType=new AuditType();
		auditType.setAuditType("SOX");
		assertEquals("SOX",auditType.getAuditType());
	}

	@Test
	public void testAuditTypeConstructor() {
		auditType=new AuditType();
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAuditType());
	}

	@Test
	public void testAuditTypeToString() {
		auditType=new AuditType();
		String s = new AuditType().toString();
		assertEquals(s,auditType.toString());
				
	}
	
	
}
