package com.cms.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		}

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
