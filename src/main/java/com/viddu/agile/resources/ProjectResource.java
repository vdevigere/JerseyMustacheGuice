package com.viddu.agile.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.view.Viewable;
import com.viddu.agile.model.Context;
import com.viddu.agile.model.Project;
import com.viddu.agile.services.ProjectService;

@Path("/project")
public class ProjectResource {

	@Inject
	ProjectService projectService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Project getProject(){
		return projectService.getProject();
	}
	
	@GET
	@Path("/view")
	public Viewable projectView(){
		return new Viewable("/project", new Context());
	}
}
