package com.viddu.agile;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.viddu.agile.services.MyService;
import com.viddu.agile.services.MyServiceImpl;

public class JerseyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(MyService.class).to(MyServiceImpl.class);
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("javax.ws.rs.Application", "com.viddu.agile.MyJerseyApplication");
//		initParams.put("com.sun.jersey.mustache.templateBasePath", "resources");
//		filter("/*").through(GuiceContainer.class, initParams);
		serve("/*").with(GuiceContainer.class, initParams);
	}

}
