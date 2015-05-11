package com.tdd.demo1;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static junitparams.JUnitParamsRunner.$;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyTest {

	@SuppressWarnings("unused")
	private static final Object[] getMoney() {
		return new Object[][] { { 10, "USD" },
				{ 20, "CAD" } };
	}

	@SuppressWarnings("unused")
	private static final Object[] getMoney2() {
		return $($(10, "USD"), $(10, "USD"));
	}

	@Test
	@Parameters(method = "getMoney")
	public void test_constructor_shouldSetAmountAndCurrency(int amount, String currency) {

		Money money = new Money(amount, currency);

		assertEquals("Amount should be " + amount, amount, money.getAmount());
		assertEquals("Currency should be " + currency, currency, money.getCurrency());
	}
	
	@Test
	@Parameters(method = "getMoney2")
	public void test_constructor_shouldSetAmountAndCurrency2(int amount,
			String currency) {

		Money money = new Money(amount, currency);

		assertEquals("Amount should be " + amount, amount, money.getAmount());
		assertEquals("Currency should be " + currency, currency, money.getCurrency());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_throwExceptionWithNegativeAmount() {
		new Money(-1, "USD");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_throwExceptionWithEmptyCurrency() {
		new Money(1, "");

	}
	@Test(expected = IllegalArgumentException.class)
	public void test_constructor_throwExceptionWithNullCurrency() {
		new Money(1, null);
	}
}
