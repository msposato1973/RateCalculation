package com.zopa.ratecalculation.service;

import java.io.IOException;
import java.util.List;

import com.zopa.ratecalculation.model.Offer;

/**
 * 
 * @author maxp
 *
 */
public interface CVSReaderService {

	/**
     * Read and process a file
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    List<Offer> readAndProcessFile() throws IOException;
    
    
}
