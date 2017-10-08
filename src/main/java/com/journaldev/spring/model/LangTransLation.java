package com.journaldev.spring.model;

import java.util.ArrayList;
import java.util.List;

public class LangTransLation {

	private String model_id;

	private String source;

	private String target;

	private List<String> text = new ArrayList<String>();

	
	public void setText(String str) {
		this.text.add(str);
	}


	public String getModel_id() {
		return model_id;
	}


	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}

	
	
}
