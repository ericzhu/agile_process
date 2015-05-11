package com.tdd.demo1;

public class TaxCalculator {

	public Double calculate(double taxableIncome) {
		
		if(taxableIncome <= 50000) {
			return taxableIncome * (1.0/10.0);
		}
		
		return null;
	}
}
