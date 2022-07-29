package com.odc.model;

import java.time.LocalDate;

public class Card {
	
	private String cardName;
	private String cardNumber;
    private LocalDate cardExpiry;
    private int cvv;
    
    public Card() {
    	super();
    }
	public Card(String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "Card [cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry + ", cvv="
				+ cvv + "]";
	}
    
}
