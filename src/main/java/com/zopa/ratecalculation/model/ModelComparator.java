package com.zopa.ratecalculation.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ModelComparator {
	public List<Offer> offertList = new ArrayList<Offer>();
	public double sumRate;

	public List<Offer> getOffertList() {
		return offertList;
	}

	public double getSumRate() {
		return sumRate;
	}

	public void setOffertList(List<Offer> offertList) {
		this.offertList = offertList;
	}

	public void setSumRate(double rate) {
		this.sumRate = sumRate;
	}

	public void setModelComparator() {

		Collections.sort(this.offertList, new Comparator<Offer>() {
			public int compare(Offer s1, Offer s2) {
				return Double.valueOf(s1.getRate()).compareTo(s2.getRate());
			}
		});

	}
	
	
	public List<Offer> setModelComparator(List<Offer> studList){
		
		Collections.sort(studList, new Comparator<Offer>(){
		    public int compare(Offer s1, Offer s2) {
		        return Double.valueOf(s1.getRate()).compareTo(s2.getRate());
		    }
		});
		
		return offertList;
	}
	
 
	
	public double getSumScore(List<Offer> list) {
		double total = 0.0;
		for(Offer bean:list){
			total = total + bean.getRate();
		}
		this.sumRate = Math.round(total);
		
		return this.sumRate;
	}
	

}
