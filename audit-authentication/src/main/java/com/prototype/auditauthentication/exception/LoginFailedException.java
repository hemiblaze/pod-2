package com.prototype.auditauthentication.exception;

import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
public class LoginFailedException extends RuntimeException {

	public LoginFailedException(String message) {
		super(message);
	}
}
