package com.zopa.ratecalculation.service.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.service.CVSReaderService;

class QuoteCalculationServiceTest {
	
	private QuoteCalculationService calculationService;
	private CVSReaderService cvsReaderService;
	
	private String loanArg = "1000.00";
	private String csvFile = "src/test/resources/MarketDataforExercise.csv";
	
    private Loan loanRequest ;
	private List<Offer> listOffers ;
	
    @BeforeEach
	void setUp() throws Exception {
		cvsReaderService = new CsvFileReaderServiceImpl(csvFile);
        loanRequest = new Loan(new BigDecimal(loanArg));
        listOffers = cvsReaderService.getAvailableOffers();
	}
    
    @After
    public void tearDown() throws Exception {
    }
	 
	
	@Test
    public void getMonthlyPayment() throws Exception {
		
		List<Offer> offers = cvsReaderService.getLoanOffers(loanRequest.getRequestedAmount(), listOffers);
		calculationService = new QuoteCalculationService(loanRequest, offers);
		
		BigDecimal actual  = calculationService.getQuote(loanRequest.getRequestedAmount()).getMonthlyRepayment();
		BigDecimal axpected =  BigDecimal.valueOf(31).setScale(2, RoundingMode.CEILING);
		assertEquals("The monthly payment should be 30.88", axpected, actual);
        
	}

	 @Test
	    public void getAverageRateTest() throws Exception {
		// TODO Auto-generated method stub
			List<Offer> offers = cvsReaderService.getLoanOffers(loanRequest.getRequestedAmount(), listOffers);
			calculationService = new QuoteCalculationService(loanRequest, offers);
			
			double actual = calculationService.getQuote(loanRequest.getRequestedAmount()).getRate();
			double axpected = Double.parseDouble("0.07");
		    assertEquals("The rate should be 0.07", axpected, actual, 0);
		 
	    }
	 
	 @Test
	    public void getTotalPayment() throws Exception {
		// TODO Auto-generated method stub
			List<Offer> offers = cvsReaderService.getLoanOffers(loanRequest.getRequestedAmount(), listOffers);
			calculationService = new QuoteCalculationService(loanRequest, offers);
			
			BigDecimal actual = calculationService.getQuote(loanRequest.getRequestedAmount()).getTotalRepayment();
			BigDecimal axpected = BigDecimal.valueOf(1116).setScale(2, RoundingMode.CEILING);
		    assertEquals("The rate should be 1111.68", axpected, actual);
		 
	    }
	 
	 
}
