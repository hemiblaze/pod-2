package com.prototype.auditchecklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.auditchecklist.model.QuestionsEntity;

@Repository
public interface ChecklistRepository extends JpaRepository<QuestionsEntity, Integer>{
	
	List<QuestionsEntity> findByAuditType(String auditType);

}
