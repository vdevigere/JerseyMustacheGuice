package com.viddu.agile;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class GuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		// Add more modules here...
		return Guice.createInjector(new JerseyServletModule());
	}

}
