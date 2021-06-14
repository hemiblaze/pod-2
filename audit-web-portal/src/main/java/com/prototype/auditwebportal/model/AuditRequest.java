package com.prototype.auditwebportal.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This is a POJO class used to store the Audit related info and responses of questions selected by user
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class AuditRequest {

	private String projectName;

	private String managerName;

	private String ownerName;

	private AuditDetails auditDetails;
}
