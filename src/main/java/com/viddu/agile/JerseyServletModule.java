package com.viddu.agile;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.viddu.agile.services.IterationService;
import com.viddu.agile.services.IterationServiceImpl;
import com.viddu.agile.services.ProjectService;
import com.viddu.agile.services.ProjectServiceImpl;

public class JerseyServletModule extends ServletModule {

	@Override
	protected void configureServlets() {
		bind(ProjectService.class).to(ProjectServiceImpl.class);
		bind(IterationService.class).to(IterationServiceImpl.class);
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("javax.ws.rs.Application", "com.viddu.agile.AgileDashboardApplication");
//		initParams.put("com.sun.jersey.mustache.templateBasePath", "resources");
//		filter("/*").through(GuiceContainer.class, initParams);
		serve("/*").with(GuiceContainer.class, initParams);
	}

}
