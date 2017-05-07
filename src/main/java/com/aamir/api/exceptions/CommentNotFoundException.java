package com.aamir.api.exceptions;

public class CommentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -2991088592941472733L;
	
	public CommentNotFoundException(String message) {
		super(message);
	}

	public CommentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
