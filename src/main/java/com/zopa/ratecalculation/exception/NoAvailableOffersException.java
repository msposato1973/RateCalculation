package com.zopa.ratecalculation.exception;

import com.zopa.ratecalculation.constant.QuoteConstant;

/**
 * 
 * @author maxp
 *
 */
public class NoAvailableOffersException extends RuntimeException {

	 private static final long serialVersionUID = 1L;

	public NoAvailableOffersException() {
		super(QuoteConstant.DEF_ERR_MESSAGE);
	}

	public NoAvailableOffersException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoAvailableOffersException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NoAvailableOffersException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoAvailableOffersException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
