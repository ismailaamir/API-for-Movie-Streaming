package com.aamir.api.exceptions;

public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1595590182152904008L;
	
	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
