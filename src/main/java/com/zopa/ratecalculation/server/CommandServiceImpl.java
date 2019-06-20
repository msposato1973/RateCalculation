package com.zopa.ratecalculation.server;

import java.io.IOException;
import java.util.List;

import com.zopa.ratecalculation.model.Loan;
import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.model.Quote;
import com.zopa.ratecalculation.service.CVSReaderService;
import com.zopa.ratecalculation.service.CalculationService;
import com.zopa.ratecalculation.service.LoanValidationService;
import com.zopa.ratecalculation.service.impl.CalculationServiceImpl;
import com.zopa.ratecalculation.service.impl.CsvFileReaderServiceImpl;
import com.zopa.ratecalculation.service.impl.LoanValidationServiceImpl;

/**
 * 
 * @author maxp
 *
 */
public class CommandServiceImpl implements CommandService {

 
	private CVSReaderService cvsReaderService;
	private CalculationService calculationService;
	private LoanValidationService loanValidationService;
	
	@Override
	public Quote ivoceCalculationService(Loan loan, List<Offer> offers) {
		// TODO Auto-generated method stub
		calculationService = new CalculationServiceImpl();
		return calculationService.getQuote(loan, offers);
	}

	@Override
	public boolean invoceAmountValidationService(Loan loan) throws Exception {
		// TODO Auto-generated method stub
		loanValidationService = new LoanValidationServiceImpl();
		return loanValidationService.validateLoad(loan);
	}

	 

	@Override
	public List<Offer> invoceCvsReaderService(String csvFile) throws IOException {
		// TODO Auto-generated method stub
		cvsReaderService = new CsvFileReaderServiceImpl(csvFile);
		return cvsReaderService.readAndProcessFile();
	}

	 

	 

}
