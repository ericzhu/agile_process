package com.tdd.demo1;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaxCalculatorTest {
	
	TaxCalculator target = new TaxCalculator();
	
	@Test
	public void test_calculate_when_income_less_than_50000() {
		Double payableTax = target.calculate(40000.00);
		System.out.println(payableTax);
		assertTrue(payableTax == 4000);
	}
	
}
