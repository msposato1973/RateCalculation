package com.zopa.ratecalculation.service.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.service.CVSReaderService;

class CsvFileReaderServiceImplTest {

	private CVSReaderService cvsReaderService;
	private String filePath = "src/test/resources/MarketDataforExercise.csv";
	
	@BeforeEach
	void setUp() throws Exception {
		cvsReaderService = new CsvFileReaderServiceImpl(filePath);
	}

	@Test
	void testReadAndProcessFile() {
		System.out.println("filePath : " + filePath);
		
		try {
			
			List<Offer> offers = cvsReaderService.readAndProcessFile();
			Assert.assertNotNull(offers);
			assertEquals("Confirm that 7 offers have been loaded", 7, offers.size());
			offers.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
    public void getLastAvailableOffersSortedLast() throws IOException {
        // Arrange
        List<Offer> offers = cvsReaderService.readAndProcessFile();

        // Assert
        assertEquals("The last after sort should be Mary", "Mary", offers.get(6).getLender());
    }
	
	
	@Test
    public void getFistAvailableOffersSortedLast() throws IOException {
        // Arrange
        List<Offer> offers = cvsReaderService.readAndProcessFile();

        // Assert
        assertEquals("The first after sort should be Jane", "Jane", offers.get(0).getLender());
    }
	
	 


}
