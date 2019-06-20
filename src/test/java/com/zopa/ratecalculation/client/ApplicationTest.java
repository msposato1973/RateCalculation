package com.zopa.ratecalculation.client;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.service.CVSReaderService;
import com.zopa.ratecalculation.service.impl.CsvFileReaderServiceImpl;

public class ApplicationTest {

	private CVSReaderService cvsReaderService;
	private String filePathArg = "";
	private String loanArg = "1000";
	
	@Before
	public void setUp() throws Exception {
		  filePathArg = "src/test/resources/MarketDataforExercise.csv";
	}

	@Test
	public void testMain() {
		
		try {
			Loan loan = new Loan(loanArg);
			cvsReaderService = new CsvFileReaderServiceImpl(filePathArg);
			
			List<Offer> offers = cvsReaderService.readAndProcessFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
