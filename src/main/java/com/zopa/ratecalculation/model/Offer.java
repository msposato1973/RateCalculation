package com.zopa.ratecalculation.model;

import java.math.BigDecimal;

/**
 * 
 * @author maxp
 *
 */
public class Offer implements Comparable<Offer> {

	/**
     * Lender Name Lender,Rate,Available
     */
    private String lender;

    /**
     * Rate.
     */
    private double rate;

    /**
     * Amount available with lenders.
     */
    private double available;
    
    public Offer( double rate, double available) {
         this.rate = rate;
        this.available = available;
    }

    public Offer(String lender, double rate, double available) {
        this.lender = lender;
        this.rate = rate;
        this.available = available;
    }

   

    @Override
    public int compareTo(Offer offer) {
        if (this.getRate() == offer.getRate())
            return 0;
        else {
            return this.getRate() > offer.getRate() ? 1 : -1;
        }
    }

	@Override
	public String toString() {
		return "Offer [lender=" + lender + ", rate=" + rate + ", available=" + available + "]";
	}

	public String getLender() {
		return lender;
	}

	public void setLender(String lender) {
		this.lender = lender;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setAvailable(double available) {
		this.available = available;
	}
	 /**
     * Get the Rate.
     *
     * @return rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * Get Available Amount.
     *
     * @return Available Amount
     */
    public double getAvailable() {
        return available;
    }


}