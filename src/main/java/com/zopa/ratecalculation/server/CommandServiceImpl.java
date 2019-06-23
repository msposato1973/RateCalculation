package com.zopa.ratecalculation.server;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.exception.InsufficientLoanAmountException;
import com.zopa.ratecalculation.exception.InvalideQuoteException;
import com.zopa.ratecalculation.exception.NoAvailableOffersException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.service.CVSReaderService;
import com.zopa.ratecalculation.service.CalculationService;
import com.zopa.ratecalculation.service.LoanValidationService;
import com.zopa.ratecalculation.service.impl.CsvFileReaderServiceImpl;
import com.zopa.ratecalculation.service.impl.LoanValidationServiceImpl;
import com.zopa.ratecalculation.service.impl.QuoteCalculationService;

/**
 * 
 * @author maxp
 *
 */
public class CommandServiceImpl  implements CommandService{

	 
 
	private CVSReaderService cvsReaderService;
	private CalculationService calculationService;
	private LoanValidationService validationService ;
	
	public CommandServiceImpl() {}
	
	@Override
	public List<Offer> invoceCvsReaderService(String csvFile) throws IOException {
		// TODO Auto-generated method stub
		 
		cvsReaderService = new CsvFileReaderServiceImpl(csvFile);
		List<Offer> offers = cvsReaderService.getAvailableOffers();
	 	
		 return offers;
	}
	 
	@Override
	public boolean invoceLoanValidationService(String loanAmount) throws InsufficientLoanAmountException {
		// TODO Auto-generated method stub
	 	
		 boolean validation = false;
		 validationService = new LoanValidationServiceImpl();
		
		 validation = validationService.isNumeric(loanAmount);
		 if(!validation) throw new InsufficientLoanAmountException(QuoteConstant.OFF_ERR_MESSAGE);
		 
		 validation = validationService.validate(new Loan(new BigDecimal(loanAmount)));
		 if(!validation) throw new InsufficientLoanAmountException(QuoteConstant.OFF_ERR_MESSAGE);
		  
		 return validation;
	}
	
	@Override
	public Quote ivoceCalculationService(Loan loan, List<Offer> offerList) throws NoAvailableOffersException, IOException {
		 // TODO Auto-generated method stub
		List<Offer> offers = cvsReaderService.getLoanOffers(loan.getRequestedAmount(), offerList);
		calculationService = new QuoteCalculationService(loan, offers);
		
		return calculationService.getQuote(loan.getRequestedAmount());
	}
	 
	
	public  void printQuote(Quote quote) throws InvalideQuoteException{
		  
		 if(quote!=null) {
	    	 
	    	 System.out.println(QuoteConstant.MSG_RA + String.format("%.0f", quote.getRequestedAmount()));
			 System.out.println(QuoteConstant.MSG_RATE + String.format("%.1f", quote.getRate() * 100) + "%");
			 System.out.println(QuoteConstant.MSG_MonthlyRepayment + String.format("%.2f", quote.getMonthlyRepayment()));
			 System.out.println(QuoteConstant.MSG_TotalRepayment + String.format("%.2f", quote.getTotalRepayment()));
	    
		 } else {
	    	 throw new InvalideQuoteException(QuoteConstant.ERR_NO_QUOTE);
	     }
		 
		 
	} 
     
    
    
	 		 
	 

}
