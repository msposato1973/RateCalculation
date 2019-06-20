package com.zopa.ratecalculation.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.exception.InsufficientLoanAmountException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.service.CalculationService;
 
/**
 * 
 * @author maxp
 *
 */
public class CalculationServiceImpl implements CalculationService {
	
	public static final int DURATION = QuoteConstant.LOAN_LENGTH_MONTHS;
     
   
    public CalculationServiceImpl() {}
    
    
    @Override
	public Quote getQuote(final Loan loan,final List<Offer> offers) {
		List<Offer> offersApplied;
		
        Quote quote = new Quote(loan.getRequestedAmount());
        offersApplied = listOfOffersApplied(offers, quote);
        
        double qRate = getAverageRate(offersApplied);
        quote.setRate(qRate);
        
        double totalRepayment = calculateTotalToPay(quote);
        quote.setTotalRepayment(totalRepayment);
        quote.setMonthlyRepayment(getFormattedValue(totalRepayment / (12 * DURATION)));
        
        return quote;
	}

    @Override
    public double getAverageRate(List<Offer> listOfOffersApplied) {
    	//double averageRate = listOfOffersApplied.stream().mapToDouble(t -> t.getRate()).average().getAsDouble();
		 double rate  = listOfOffersApplied.stream().mapToDouble(t -> t.getRate()).sum() / listOfOffersApplied.size();
		
		 return Double.parseDouble(new DecimalFormat(QuoteConstant.SINGLE_DIGIT_PATTERN).format(rate));
        
		 
	}

	
	
	/**
	 * 
	 * @param quote
	 * @return
	 */
	private double calculateTotalToPay(final Quote quote) {
		//Calculate total  TotalToPay with interest.
	 
		double totalToPay = quote.getRequestedAmount().doubleValue() *  Math.pow( ( 1 + quote.getRate())/ 1200.0, (DURATION * 12));
        
		return getFormattedValue(totalToPay);
    }
	
	/**
	 * 
	 * @param offers
	 * @param quote
	 * @return
	 */
	private List<Offer> listOfOffersApplied(final List<Offer> offers, final Quote quote) {
		
		double amount = quote.getRequestedAmount().doubleValue();
        List<Offer> offersApplied = new ArrayList<Offer>();
        
        if (offers != null) {
        	
            if (amount > offers.stream().mapToDouble(offer -> offer.getAvailable()).sum()) {
                throw new InsufficientLoanAmountException(QuoteConstant.ERR_QUOTE);
            }
        
            for (Offer offer : offers) {
            
            	if (amount < offer.getAvailable()) {
                    offersApplied.add(offer);
                    break;
                } else {
                    amount = amount - offer.getAvailable();
                    offersApplied.add(offer);
                }
            }
            
        }
        
        return offersApplied;
    }
	
	/**
     * Format the input value to double with decimal up to 2 digits.
     *
     * @param value
     * @return
     */
    private double getFormattedValue(final double value) {
        return Double.parseDouble(new DecimalFormat(QuoteConstant.DOUBLE_DIGIT_PATTERN).format(value));
    }
 

}
