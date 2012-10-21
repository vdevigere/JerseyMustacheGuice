package com.viddu.agile.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Iteration {

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	String title;
	
	public Iteration() {
		// TODO Auto-generated constructor stub
	}
	
	public Iteration(String title) {
		this.title = title;
	}

}
