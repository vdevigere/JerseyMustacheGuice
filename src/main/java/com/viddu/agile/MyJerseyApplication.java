package com.viddu.agile;

import com.sun.jersey.api.core.PackagesResourceConfig;

public class MyJerseyApplication extends PackagesResourceConfig {

	public MyJerseyApplication() {
		super("com.viddu.agile.resources");
	}
}
