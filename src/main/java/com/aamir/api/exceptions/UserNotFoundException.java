package com.aamir.api.exceptions;

public class UserNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 744417630192866010L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
