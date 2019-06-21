package com.zopa.ratecalculation.exception;

/***
 * 
 * @author maxp
 *
 */
public class InsufficientLoanAmountException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	 public InsufficientLoanAmountException(String message) {
	        super(message);
	 }

}
