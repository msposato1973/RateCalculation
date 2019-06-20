package com.zopa.ratecalculation.service.impl;

import java.math.BigDecimal;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.exception.InvalidRequestAmountException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.service.LoanValidationService;


public class LoanValidationServiceImpl implements LoanValidationService {

	public LoanValidationServiceImpl() {}
	 
	@Override
	public boolean isNumeric(String requestedAmount) throws InvalidRequestAmountException {
		// TODO Auto-generated method stub
		return requestedAmount != null && requestedAmount.matches("[-+]?\\d*\\.?\\d+");
	}

	@Override
	public boolean validateLoad(Loan loan) throws InvalidRequestAmountException {

        if (loan.getRequestedAmount().compareTo(QuoteConstant.LOWER_RANGE) < 0 || loan.getRequestedAmount().compareTo(QuoteConstant.UPPER_RANGE) > 0) {
            throw new InvalidRequestAmountException(QuoteConstant.ERR_AMOUNT_RANGE);
        }

        BigDecimal remainder = loan.getRequestedAmount().remainder(QuoteConstant.INCREMENT_AMOUNT);

        if (remainder.intValueExact() > 0)
            throw new InvalidRequestAmountException(QuoteConstant.ERR_AMOUNT_REQUEST);

        return true;
	}

}
