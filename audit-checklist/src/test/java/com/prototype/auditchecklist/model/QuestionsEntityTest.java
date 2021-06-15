package com.prototype.auditchecklist.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class QuestionsEntityTest {

	QuestionsEntity questions=new QuestionsEntity();
	
	@Test
	public void testParameterizedConstructor() {
		QuestionsEntity questions=new QuestionsEntity(1,"SOX","Have all changes has been approved","Yes");
	    assertEquals("Yes",questions.getResponse());
	}
	
	@Test
	public void testQuestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId());
	}
	
	@Test
	public void testQuestionType() {
		questions.setAuditType("Internal");
		assertEquals("Internal",questions.getAuditType());
	}
	
	@Test
	public void testQuestion() {
		questions.setQuestions("Do you have any changes?");
		assertEquals("Do you have any changes?",questions.getQuestions());
	}
	
	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No",questions.getResponse());
	}
	
	
}