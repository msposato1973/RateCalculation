package com.zopa.ratecalculation.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.service.CalculationService;
 
/**
 * 
 * @author maxp
 *
 */
public class QuoteCalculationService implements CalculationService {
	      
    private final Loan loan;
    private final List<Offer> offers;

   
    /**
     * @param loan
     * @param offers
     */
    public QuoteCalculationService(Loan loan, List<Offer> offers){

        this.loan = loan;
        this.offers = offers;
    }

    /**
     * @return Returns average rate
     */
    @Override
    public double getAverageRate() {
        double averageRate = this.offers.stream().mapToDouble(t -> t.getRate()).average().getAsDouble();

        // set to 1 decimal places
        return Math.round(averageRate * 1000.0)/1000.0;
    }

    /**
     * @return Returns monthly payment
     * 
     * - Monthly offer rate
     * - Compound interest calculation
     * - Update offer with monthly repayment
     */
    @Override
    public BigDecimal getMonthlyPayment() {
        
       
        this.offers.forEach(offer -> {
             double offerMonthlyRate = offer.getRate()/12;
             BigDecimal offerMonthlyPayment = (offer.getNeededAmount().multiply(BigDecimal.valueOf(offerMonthlyRate))
            		 .divide(BigDecimal.valueOf((1 - Math.pow(1 + offerMonthlyRate, - QuoteConstant.LOAN_LENGTH_MONTHS))), 
            				 									new MathContext(2, RoundingMode.HALF_DOWN)));
             offer.setMonthlyPayment(offerMonthlyPayment);
        });

        // 
        BigDecimal totalMonthly = BigDecimal.valueOf(0);
        for (Offer offer : this.offers) {
            totalMonthly = totalMonthly.add(offer.getMonthlyPayment());
        }

        return totalMonthly.setScale(2, RoundingMode.UNNECESSARY);
    }

    /**
     * @return Returns Total payment
     */
    @Override
    public BigDecimal getTotalPayment() {
        return this.getMonthlyPayment().multiply(BigDecimal.valueOf(QuoteConstant.LOAN_LENGTH_MONTHS)).setScale(2, RoundingMode.UNNECESSARY);
    }

    /**
     * @return Returns Quote quote to print
     */
    @Override
	public Quote getQuote(BigDecimal requestedAmount) {
     	
    	return new Quote(requestedAmount, this.getAverageRate(), this.getMonthlyPayment(), this.getTotalPayment());
	}

	 
}