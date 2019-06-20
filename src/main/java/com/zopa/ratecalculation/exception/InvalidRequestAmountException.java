package com.zopa.ratecalculation.exception;

public class InvalidRequestAmountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidRequestAmountException() {
		super();
	}

	public InvalidRequestAmountException(String message) {
		super(message);
		 
	}

	public InvalidRequestAmountException(Throwable cause) {
		super(cause);
		 
	}

	public InvalidRequestAmountException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	public InvalidRequestAmountException(String message, Throwable cause, boolean enableSuppression,
		 boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		 
	}

}
