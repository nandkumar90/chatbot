package com.journaldev.spring.model;

public class Inputtext {
	private  Text input;
	private boolean alternate_intents;
	
	
	public Inputtext() {
		// TODO Auto-generated constructor stub
	}
	
	public Text getText() {
		return input;
	}
	public void setText(Text text) {
		this.input = text;
	}
	public boolean isAlternate_intents() {
		return alternate_intents;
	}
	public void setAlternate_intents(boolean alternate_intents) {
		this.alternate_intents = alternate_intents;
	}

}
