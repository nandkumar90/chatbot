package com.journaldev.spring.model;

public class RankAndRetrive {
	
	private String id;
	
	private String title;
	
	private Source source;
	
	private String contents;

	public String getId() {
	return id;
	}

	public void setId(String id) {
	this.id = id;
	}

	public String getTitle() {
	return title;
	}

	public void setTitle(String title) {
	this.title = title;
	}

	public Source getSource() {
	return source;
	}

	public void setSource(Source source) {
	this.source = source;
	}

	public String getContents() {
	return contents;
	}

	public void setContents(String contents) {
	this.contents = contents;
	}

}
