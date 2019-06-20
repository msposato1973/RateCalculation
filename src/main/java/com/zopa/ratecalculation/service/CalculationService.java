package com.zopa.ratecalculation.service;

import java.util.List;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;

public interface CalculationService {
   /**
	     * @return 
	     * @return Returns average rate
	     */
	     double getAverageRate(List<Offer> availableOffers) ;

	    /**
	     * @return Returns monthly payment
	     */
	     
	     
	    
	     
	    
	    /**
	     * 
	     * @param loan
	     * @param offers
	     * @return
	     */
	    Quote getQuote(Loan loan, List<Offer> offers);
	 
}
