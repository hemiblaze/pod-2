package com.prototype.auditseverity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsEntity {

	private int questionId;
	private String auditType;
	private String questions;
	private String response;
	
	

}
