package com.viddu.agile.services;

import java.util.ArrayList;
import java.util.List;

import com.viddu.agile.model.Project;

public class ProjectServiceImpl implements ProjectService {

	public List<Project> getAllProjects() {
		Project socialShopping = new Project("Social Shopping");
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(socialShopping);
		return projectList;
	}

	@Override
	public Project getProject() {
		return new Project("Social Shopping");
	}

}
