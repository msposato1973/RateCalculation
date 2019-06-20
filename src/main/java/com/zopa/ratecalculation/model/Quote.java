package com.zopa.ratecalculation.model;

import java.math.BigDecimal;

public class Quote {
	/**
     * Requested Amount.
     */
    private BigDecimal requestedAmount;

    /**
     * rate.
     */
    private double rate;

    /**
     * Monthly repayment.
     */
    private double monthlyRepayment;

    /**
     * Total Repayment.
     */
    private double totalRepayment;

	public Quote(BigDecimal requestedAmount, double rate, double monthlyRepayment, double totalRepayment) {
		super();
		this.requestedAmount = requestedAmount;
		this.rate = rate;
		this.monthlyRepayment = monthlyRepayment;
		this.totalRepayment = totalRepayment;
	}
	
	/**
     * Constructor
     *
     * @param requestedAmount
     */
    public Quote(BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }
    
    /**
     * Get Requested Amount.
     *
     * @return requested amount
     */
    public BigDecimal getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Set Requested Amount
     *
     * @param requestedAmount
     */
    public void setRequestedAmount(final BigDecimal requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    /**
     * Get Rate.
     *
     * @return rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * Set Rate
     *
     * @param rate
     */
    public void setRate(final double rate) {
        this.rate = rate;
    }

    /**
     * Get Monthly Repayment
     *
     * @return Monthly Repayment
     */
    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    /**
     * Set Monthly Repayment.
     *
     * @param monthlyRepayment
     */
    public void setMonthlyRepayment(final double monthlyRepayment) {
        this.monthlyRepayment = monthlyRepayment;
    }

    /**
     * Get Total Repayment.
     *
     * @return total repayment
     */
    public double getTotalRepayment() {
        return totalRepayment;
    }

    /**
     * Set Total Repayment
     *
     * @param totalRepayment
     */
    public void setTotalRepayment(final double totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

	@Override
	public String toString() {
		return "Quote [requestedAmount=" + requestedAmount + ", rate=" + rate + ", monthlyRepayment=" + monthlyRepayment
				+ ", totalRepayment=" + totalRepayment + "]";
	}

	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(monthlyRepayment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((requestedAmount == null) ? 0 : requestedAmount.hashCode());
		temp = Double.doubleToLongBits(totalRepayment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (Double.doubleToLongBits(monthlyRepayment) != Double.doubleToLongBits(other.monthlyRepayment))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (requestedAmount == null) {
			if (other.requestedAmount != null)
				return false;
		} else if (!requestedAmount.equals(other.requestedAmount))
			return false;
		if (Double.doubleToLongBits(totalRepayment) != Double.doubleToLongBits(other.totalRepayment))
			return false;
		return true;
	}
}
