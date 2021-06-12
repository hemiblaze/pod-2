package com.prototype.auditseverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.auditseverity.model.AuditResponse;

@Repository
public interface ResponseRepository extends JpaRepository<AuditResponse, Integer>{

}
