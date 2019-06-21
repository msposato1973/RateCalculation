package com.zopa.ratecalculation.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.zopa.ratecalculation.exception.NoAvailableOffersException;
import com.zopa.ratecalculation.model.Offer;

/**
 * 
 * @author maxp
 *
 */
public interface CVSReaderService {

	  /**
     * @return List of offers
     */
    default List<Offer> getLoanOffers(BigDecimal requestedAmount,List<Offer> offerList) throws NoAvailableOffersException, IOException {
        return new ArrayList<>();
    }

    default List<Offer> getAvailableOffers() throws NoAvailableOffersException, IOException {
        return new ArrayList<>();
    }
    
}
