package com.spring.common;

public class SessionTimeoutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2479436928624911382L;

	public SessionTimeoutException() {

	}

	public SessionTimeoutException(Throwable cause) {
		super(cause);
	}

	public SessionTimeoutException(String message) {
		super(message);
	}
}
