package com.zopa.ratecalculation.client;

import java.math.BigDecimal;
import java.util.List;

import com.zopa.ratecalculation.constant.QuoteConstant;
import com.zopa.ratecalculation.exception.InvalidRequestAmountException;
import com.zopa.ratecalculation.exception.NoAvailableOffersException;
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.server.CommandService;
import com.zopa.ratecalculation.server.CommandServiceImpl;

public class Application {

 
	 
	public static void main(String[] args) {
		
		 CommandService commandServ = new CommandServiceImpl();
		 List<Offer> offers = null;
		
		// TODO Auto-generated method stub
		if (args.length < 2 ) {
			throw new IllegalArgumentException(QuoteConstant.ERR);
		}
		
		if (args[0] ==null || args[0].equals("") ) {
			throw new IllegalArgumentException(QuoteConstant.ERR);
		}
		
		Integer loanAmount = Integer.valueOf(args[1]);
		Loan loan = new Loan(new BigDecimal(loanAmount));
			
		try {
		
			if(!commandServ.invoceAmountValidationService(loan)) 
				throw new IllegalArgumentException(QuoteConstant.ERR);
			
		 
			String csvFile = args[0];
			offers = commandServ.invoceCvsReaderService(csvFile);
			
			Quote finalQuote = commandServ.ivoceCalculationService(loan, offers);
			displayOutputForm(finalQuote, loan);
			
			System.exit(0);
			
		} catch (InvalidRequestAmountException e) {
            System.out.println(e.getMessage());
        } catch (NoAvailableOffersException e) {
            System.out.println(e.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
		
	 
	}
	private static void displayOutputForm(final Quote finalQuote,final Loan loan) {
		
		System.out.println(QuoteConstant.MSG_Amount + String.format("%.0f", loan.getRequestedAmount()));
	    System.out.println(QuoteConstant.MSG_RATE + String.format("%.1f", finalQuote.getRate() * 100) + "%" );
        System.out.println(QuoteConstant.MSG_MonthlyRepayment +  String.format("%.2f", finalQuote.getMonthlyRepayment()));
        System.out.println(QuoteConstant.MSG_TotalRepayment + String.format("%.2f", finalQuote.getTotalRepayment()));
        
         
		
	}

}
