package com.zopa.ratecalculation.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Quote {
	 public static final BigDecimal MONTHS_IN_YEAR = new BigDecimal(12);
	 
	 private final BigDecimal  requestedAmount;
	 private final double  rate;
	 private final BigDecimal monthlyRepayment;
	 private final BigDecimal totalRepayment;

	
	
	
	public Quote(BigDecimal  requestedAmount, double  rate, BigDecimal monthlyRepayment, BigDecimal totalRepayment) {
			this.requestedAmount = requestedAmount;
			this.rate = rate;
			this.monthlyRepayment = monthlyRepayment;
			this.totalRepayment = totalRepayment;
		}




	private BigDecimal  formatRate(BigDecimal rate) {
        return rate.multiply(new BigDecimal(100))
                .multiply(MONTHS_IN_YEAR)
                .setScale(1, RoundingMode.HALF_EVEN);
    }




	public BigDecimal  getRequestedAmount() {
		return requestedAmount;
	}




	public double  getRate() {
		return rate;
	}




	public BigDecimal getMonthlyRepayment() {
		return monthlyRepayment;
	}




	public BigDecimal getTotalRepayment() {
		return totalRepayment;
	}
}
