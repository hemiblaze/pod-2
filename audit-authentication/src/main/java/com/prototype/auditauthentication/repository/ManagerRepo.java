package com.prototype.auditauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.auditauthentication.model.ProjectManager;

@Repository
public interface ManagerRepo extends JpaRepository<ProjectManager, String>{

}
