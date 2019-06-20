package com.zopa.ratecalculation.server;

import java.io.IOException;
import java.util.List;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;

public interface CommandService {
	
	 
	public List<Offer> invoceCvsReaderService(String csvFile) throws IOException;

	public Quote ivoceCalculationService(Loan loan, List<Offer> offers);
	
	public boolean invoceAmountValidationService(Loan loan) throws Exception;
		
	
}
