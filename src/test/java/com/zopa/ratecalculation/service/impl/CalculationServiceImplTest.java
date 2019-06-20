package com.zopa.ratecalculation.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.server.CommandService;
import com.zopa.ratecalculation.server.CommandServiceImpl;
import com.zopa.ratecalculation.service.CVSReaderService;
import com.zopa.ratecalculation.service.CalculationService;

class CalculationServiceImplTest   {

	private CalculationService calculationService;
	private CVSReaderService cvsReaderService;
	private String filePath = "src/test/resources/MarketDataforExercise.csv";
	private List<Offer> offers;
	private Loan loanRequest ;
	private CommandService commandServ;
	
	@BeforeEach
	void setUp() throws Exception {
		
		cvsReaderService = new CsvFileReaderServiceImpl(filePath);
		loanRequest = new Loan(new BigDecimal("1000.00"));
	
		offers = cvsReaderService.readAndProcessFile();
        calculationService = new CalculationServiceImpl();
        
        commandServ = new CommandServiceImpl();
	}

	@Test
	void testGetQuote() {
		Quote actual = commandServ.ivoceCalculationService(loanRequest, offers);
		assertNotNull(actual);
	}

	@Test
	void testGetAverageRate() {
		double actualQuote = calculationService.getAverageRate(offers);
		assertNotNull(actualQuote);
		 
	}

}
