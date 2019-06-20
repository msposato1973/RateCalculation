package com.zopa.ratecalculation.service;

import com.zopa.ratecalculation.exception.InvalidRequestAmountException;
import com.zopa.ratecalculation.model.Loan;

public interface LoanValidationService {
	  boolean isNumeric(String requestedAmountArg) throws InvalidRequestAmountException;
	  boolean validateLoad(Loan loan) throws  Exception; 
}
