package com.viddu.agile.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Project {
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String title;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(String title){
		this.title = title;
	}
}
