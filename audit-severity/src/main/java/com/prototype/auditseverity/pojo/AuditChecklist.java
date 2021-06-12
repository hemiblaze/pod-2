package com.prototype.auditseverity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuditChecklist {

	private int questionId;

	private String auditType;

	private String questions;

	private String response;
}
