package com.prototype.auditchecklist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.auditchecklist.model.QuestionsEntity;
import com.prototype.auditchecklist.repository.ChecklistRepository;

@Service
public class checklistService {

	@Autowired
	ChecklistRepository repository;
	
	
	public List<QuestionsEntity> getQuestions(String auditType)throws IndexOutOfBoundsException{
		if(repository.findByAuditType(auditType).isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return repository.findByAuditType(auditType);
		}
	}
	
	public List<QuestionsEntity> saveResponse(List<QuestionsEntity> responses){
		return repository.saveAll(responses);
	}
	
}
