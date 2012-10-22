package com.viddu.agile.services;

import com.viddu.agile.model.Data;


public class MyServiceImpl implements MyService {

	@Override
	public Data getData() {
		return new Data("Hello World");
	}

}