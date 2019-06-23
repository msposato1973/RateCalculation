package com.zopa.ratecalculation.service.impl;
import java.math.BigDecimal;
 
import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.service.LoanValidationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class LoanValidationServiceImplTest {

	private String[] args;
	private String loanArg = "1000";
	private LoanValidationService loanValidationService;
	private String filePath = "src/test/resources/MarketDataforExercise.csv";
	
	@Before
	public void setUp() throws Exception {
		    args = new String[] {filePath,loanArg};
			loanValidationService = new LoanValidationServiceImpl() ;
		}
		

	@Test
	public void testIsNumeric() throws Exception {
		String requestedAmountArg = String.valueOf(args[1]);
		boolean condition = false;
	 	Assert.assertNotNull(requestedAmountArg);
		condition = loanValidationService.isNumeric(requestedAmountArg);
		Assert.assertTrue(condition);
	}

	@Test
	public void testValidate() throws Exception {
		Integer loanAmount = Integer.valueOf(args[1]);
		boolean condition = true;
		Loan loan = new Loan(new BigDecimal(loanAmount));
		Assert.assertNotNull(loan);
	 	Assert.assertTrue(loanValidationService.validate(loan));


	}
	
	 

}
