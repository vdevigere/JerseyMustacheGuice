package com.viddu.agile.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.omg.CORBA.Context;

import com.sun.jersey.api.view.Viewable;
import com.viddu.agile.model.Data;
import com.viddu.agile.services.MyService;

@Path("/project")
public class MyResource {

	@Inject
	MyService projectService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Data getData(){
		return projectService.getData();
	}
	
	@GET
	@Path("/view")
	public Viewable getDataView(){
		return new Viewable("/project", new Data("World"));
	}
}
