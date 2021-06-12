package com.prototype.auditseverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.auditseverity.model.AuditDetails;
@Repository
public interface AuditDetailRepository extends JpaRepository<AuditDetails, Integer>{


}
