package com.zopa.ratecalculation.server;

import java.io.IOException;
import java.util.List;

import com.zopa.ratecalculation.exception.InsufficientLoanAmountException;
import com.zopa.ratecalculation.exception.InvalideQuoteException;
import com.zopa.ratecalculation.exception.NoAvailableOffersException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;

public interface CommandService {

	List<Offer> invoceCvsReaderService(String csvFile) throws IOException;

	boolean invoceLoanValidationService(String loanAmount) throws InsufficientLoanAmountException;

	Quote ivoceCalculationService(Loan loan, List<Offer> offerList) throws NoAvailableOffersException, IOException;

	void printQuote(Quote quote) throws InvalideQuoteException;

}
