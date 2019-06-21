package com.zopa.ratecalculation.client;

import org.junit.Before;
import org.junit.Test;

public class ApplicationTest {

	private String[] args;
	private String loanArg = "1000";
	private String filePath = "src/test/resources/MarketDataforExercise.csv";
	
	@Before
	public void setUp() throws Exception {
		args = new String[] {filePath,loanArg};
	}

	@Test
	public void testMain() {
		
	     new Application().main(args);
		 
	}

}
