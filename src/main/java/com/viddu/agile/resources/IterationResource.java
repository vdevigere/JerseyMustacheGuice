package com.viddu.agile.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.viddu.agile.model.Iteration;
import com.viddu.agile.services.IterationService;

@Path("/iteration")
@Produces(MediaType.APPLICATION_JSON)
public class IterationResource {

	@Inject
	IterationService iterationService;
	
	@GET
	@Path("/{id}")
	public Iteration getIteration(@PathParam("id") Integer id){
		return iterationService.findIterationById(id);
	}
}
