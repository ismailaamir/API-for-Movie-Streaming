package com.aamir.api.exceptions;

public class MovieNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 327691160243418818L;

	public MovieNotFoundException(String message) {
		super(message);
	}

	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
