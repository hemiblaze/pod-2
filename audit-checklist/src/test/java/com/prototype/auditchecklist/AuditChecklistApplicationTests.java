package com.prototype.auditchecklist;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AuditChecklistApplicationTests {

	@Mock
	AuditChecklistApplication auditChecklistApplication;
	@Test
	void contextLoads() {
		assertNotNull(auditChecklistApplication);
	}
}
