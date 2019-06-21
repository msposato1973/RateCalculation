package com.zopa.ratecalculation.service.impl;

import java.math.BigDecimal;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.exception.InvalidRequestAmountException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.service.LoanValidationService;


public class LoanValidationServiceImpl implements LoanValidationService {

	public LoanValidationServiceImpl() {}
	 
	/**
     * @param requestedAmountArg
     * @return
     * @throws InvalidRequestAmountException
     */
    @Override
    public boolean isNumeric(String requestedAmountArg) {
        return requestedAmountArg != null && requestedAmountArg.matches(QuoteConstant.MATCH_PATTERN);
    }

    /**
     * @param loan detail
     * @return
     * @throws InvalidRequestAmountException
     */
    @Override
    public boolean validate(Loan loan) throws InvalidRequestAmountException {

        if (loan.getRequestedAmount().compareTo(QuoteConstant.LOWER_RANGE) < 0 || loan.getRequestedAmount().compareTo(QuoteConstant.UPPER_RANGE) > 0) {
            throw new InvalidRequestAmountException(QuoteConstant.ERR_AMOUNT_RANGE);
        }

        BigDecimal remainder = loan.getRequestedAmount().remainder(QuoteConstant.INCREMENT_AMOUNT);

        if (remainder.intValueExact() > 0)
            throw new InvalidRequestAmountException(QuoteConstant.ERR_AMOUNT_REQUEST);

        return true;
    }

}
