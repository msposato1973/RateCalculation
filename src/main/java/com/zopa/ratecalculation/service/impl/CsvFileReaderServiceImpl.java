package com.zopa.ratecalculation.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.zopa.ratecalculation.model.Offer;
import com.zopa.ratecalculation.service.CVSReaderService;

 

public class CsvFileReaderServiceImpl implements CVSReaderService{
	 
	private final String filePath;
	
	public CsvFileReaderServiceImpl(String filepath) {
        this.filePath = filepath;
    }
	
	public List<Offer> readAndProcessFile() throws IOException {
		    
		BufferedReader reader = null;
			List<Offer> offers = null;
			
			try {
			
				offers = new ArrayList<Offer>();
			    reader = new BufferedReader(new FileReader(new File(filePath)));
				 
				int i=0;
				 for (String line; (line = reader.readLine()) != null; ) {
		            line = line.trim();
					if(i==0) {i++;continue;}
					offers.add(processInputLine(line));
				}
	
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (reader != null)
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
	
			 
			return offers.stream().sorted().collect(Collectors.toList());
		}
	
	
	
	 private Offer processInputLine(String line) throws IllegalArgumentException {
		    if (line.length() == 0) {
		            return null;
		        }
	
		        String[] splitted = line.split(",");
		        if (splitted.length == 3) {
		            String lender = splitted[0];
		            double rate = Double.parseDouble(splitted[1]);
		            
		            double amount =  Double.parseDouble(splitted[2]);
		            return  new Offer(lender, rate, amount) ;
		        } else {
		        	
		        	 return null;
		        }
		     
		 }
	


}
	
	 
	 
 
