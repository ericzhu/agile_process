package com.tdd.demo1;

public class Money {
	
	private final int amount;
	private final String currency;
	
	public Money(int amount, String currency) {
		
		if(amount < 0) {
			throw new IllegalArgumentException("Illegal amount [" + amount + "]");
		}
		
		if(currency == null || currency.trim().length() == 0) {
			throw new IllegalArgumentException("Illegal currency [" + currency + "]");
		}
		
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Money) {
			Money money = (Money)obj;
			return this.amount == money.getAmount() && this.currency.equals(money.getCurrency());
		}
		return false;
	}
}
