package com.zopa.ratecalculation.model;

import java.math.BigDecimal;

public class Loan {
	
	private BigDecimal requestedAmount;
	
	/**
     * @param requestedAmount
     */
    public Loan(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Loan(String requestedAmount) {
        this.requestedAmount = BigDecimal.valueOf(Long.parseLong(requestedAmount));
    }

    /**
     * @return Requested Amount
     */
    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }
}
