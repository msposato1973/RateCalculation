package com.zopa.ratecalculation.service.impl;
 

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.service.CVSReaderService;

@RunWith(JUnit4.class)
public class QuoteCalculationServiceTest {
	
	private QuoteCalculationService calculationService;
	private CVSReaderService cvsReaderService;
	
	private String loanArg = "1000.00";
	private String csvFile = "src/test/resources/MarketDataforExercise.csv";
	
    private Loan loanRequest ;
	private List<Offer> listOffers ;
	
	@Before
	public void setUp() throws Exception {
		cvsReaderService = new CsvFileReaderServiceImpl(csvFile);
        loanRequest = new Loan(new BigDecimal(loanArg));
        listOffers = cvsReaderService.getAvailableOffers();
	}
    
   
	
	@Test
    public void getMonthlyPayment() throws Exception {
		
		List<Offer> offers = cvsReaderService.getLoanOffers(loanRequest.getRequestedAmount(), listOffers);
		calculationService = new QuoteCalculationService(loanRequest, offers);
		
		BigDecimal actual  = calculationService.getQuote(loanRequest.getRequestedAmount()).getMonthlyRepayment();
		BigDecimal axpected =  BigDecimal.valueOf(31).setScale(2, RoundingMode.CEILING);
		Assert.assertEquals("The monthly payment should be 30.88", axpected, actual);
        
	}

	 @Test
	    public void getAverageRateTest() throws Exception {
		// TODO Auto-generated method stub
		 List<Offer> offers = cvsReaderService.getLoanOffers(loanRequest.getRequestedAmount(), listOffers);
			calculationService = new QuoteCalculationService(loanRequest, offers);
			
			Double actual = calculationService.getQuote(loanRequest.getRequestedAmount()).getRate();
			Double axpected = Double.valueOf(0.07);
			Assert.assertEquals("The rate should be 0.07", axpected, actual);
		 
		 
	    }
	 
	 @Test
	    public void getTotalPayment() throws Exception {
		// TODO Auto-generated method stub
			List<Offer> offers = cvsReaderService.getLoanOffers(loanRequest.getRequestedAmount(), listOffers);
			calculationService = new QuoteCalculationService(loanRequest, offers);
			
			BigDecimal actual = calculationService.getQuote(loanRequest.getRequestedAmount()).getTotalRepayment();
			BigDecimal axpected = BigDecimal.valueOf(1116).setScale(2, RoundingMode.CEILING);
			Assert.assertEquals("The rate should be 1111.68", axpected, actual);
		 
	    }
	 
	 
}
