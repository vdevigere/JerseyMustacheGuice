package com.viddu.agile.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Data {
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	public Data(String title){
		this.title = title;
	}
}
