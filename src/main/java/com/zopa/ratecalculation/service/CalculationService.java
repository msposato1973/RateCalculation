package com.zopa.ratecalculation.service;

import java.math.BigDecimal;

import com.zopa.ratecalculation.model.Quote;

public interface CalculationService {
	/**
     * @return Returns average rate
     */
	default double getAverageRate() {
		return 0;
	}

    /**
     * @return Returns monthly payment
     */
	default BigDecimal getMonthlyPayment() {
		return null;
	}

    /**
     * @return Returns Total payment
     */
	default  BigDecimal getTotalPayment() {
		return null;
	}
    
    /**
     * @return Returns Quote quote
     */
	default Quote getQuote(BigDecimal requestedAmount) {
		return null;
	}
}
