package com.zopa.ratecalculation.service;

import com.zopa.ratecalculation.exception.InvalidRequestAmountException;
import com.zopa.ratecalculation.model.Loan;

public interface LoanValidationService {
	/**
     * @param requestedAmountArg
     * @return
     */
    default boolean isNumeric(String requestedAmountArg) {
		return false;
	}

    /**
     * @param loan detail
     * @return sucess/fail
     * @throws InvalidRequestAmountException
     */
    default boolean validate(Loan loan) throws InvalidRequestAmountException {
		return false;
	}
}
