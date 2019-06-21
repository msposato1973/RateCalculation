package com.zopa.ratecalculation.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.service.LoanValidationService;

class LoanValidationServiceImplTest {

	private String[] args;
	private String loanArg = "1000";
	private LoanValidationService loanValidationService;
	private String filePath = "src/test/resources/MarketDataforExercise.csv";
	
	@BeforeEach
	void setUp() throws Exception {
		    args = new String[] {filePath,loanArg};
			loanValidationService = new LoanValidationServiceImpl() ;
		}
		

	@Test
	void testIsNumeric() throws Exception {
		String requestedAmountArg = String.valueOf(args[1]);
		boolean condition = false;
	 	Assert.assertNotNull(requestedAmountArg);
		condition = loanValidationService.isNumeric(requestedAmountArg);
		assertTrue(condition);
	}

	@Test
	void testValidate() throws Exception {
		Integer loanAmount = Integer.valueOf(args[1]);
		boolean condition = false;
		Loan loan = new Loan(new BigDecimal(loanAmount));
		Assert.assertNotNull(loan);
		condition = loanValidationService.validate(loan);
		assertTrue(condition);
	}
	
	 

}
