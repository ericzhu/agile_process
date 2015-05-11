package com.tdd.demo1;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MonyIATest {
	
	private final static String VALID_CURRENCY = "USA";
	private final static int VALID_AMOUNT = 1;
	
	public static final Object[] getInvalidAmount() {
		return new Integer[][] {{-10000}, {-100}};
	}
	
	public static final Object[] getInvalidCurrency() {
		return new Object[][]{{""}, {null}};
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidAmount")
	public void test_constructor_throwExceptionWithInvalidAmount(int amount) {
		new Money(amount, VALID_CURRENCY);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Parameters(method = "getInvalidCurrency")
	public void test_constructor_throwExceptionWithInvalidCurrency(String currency) {
		new Money(VALID_AMOUNT, currency);
	}
	
}
