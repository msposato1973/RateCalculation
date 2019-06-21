package com.zopa.ratecalculation.client;

import java.math.BigDecimal;
import java.util.List;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.exception.InsufficientLoanAmountException;
import com.zopa.ratecalculation.exception.InvalidRequestAmountException;
import com.zopa.ratecalculation.exception.InvalideQuoteException;
import com.zopa.ratecalculation.exception.NoAvailableOffersException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.server.CommandService;
import com.zopa.ratecalculation.server.CommandServiceImpl;
 

public class Application {

    
	 
	  /**
	   * 
	   * @param args supplied file path and loan amount
	   * @throws Exception and InvalidRequestAmountException,InsufficientLoanAmountException, InvalideQuoteException
	   *    
       */
     public static void main(String[] args) {
    	 
    	 CommandService commandService = new CommandServiceImpl();
    	 List<Offer> offerList = null;
    	 try {
    		 
    		 // Offers should only be obtained if request is valid
    		 // Create and initialize the calculation service
    		 // Create and initialize the offer service
    		 
    		 if (args.length < 2 ) {
    				throw new IllegalArgumentException(QuoteConstant.ERR);
    		 }else if((args[0] ==null || args[0].equals(""))) {
    				throw new IllegalArgumentException(QuoteConstant.ERR);
    		 }else if((args[1] ==null || args[1].equals(""))) {
    			 throw new IllegalArgumentException(QuoteConstant.ERR_LOAN);
    		 }
    		 
			 String filePath = new  String(args[0]);
			 if(!filePath.endsWith(".csv")) {
 				throw new NoAvailableOffersException(QuoteConstant.OFF_ERR_MESSAGE);
 		     }else {
 		    	
 		    	offerList = commandService.invoceCvsReaderService(filePath);
 		     }
			 
			 String loanAmount = new  String(args[1]);
			 if(!commandService.invoceLoanValidationService(loanAmount)) {
				 throw new InsufficientLoanAmountException(QuoteConstant.OFF_ERR_MESSAGE);
			 }
			 
			 Loan loan = new Loan(new BigDecimal(loanAmount));
			 Quote quote =  commandService.ivoceCalculationService(loan, offerList);
			 
	        
	         commandService.printQuote(quote);
		
    	 } catch (InvalidRequestAmountException e) {
             System.out.println(e.getMessage());
         } catch (InsufficientLoanAmountException e) {
             System.out.println(e.getMessage());
         }  catch (InvalideQuoteException e) {
             System.out.println(e.getMessage());
         } catch (Exception e) {
			
			e.printStackTrace();
		 }
         
	}
     
     

}
