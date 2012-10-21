package com.viddu.agile.services;

import java.util.List;

import com.viddu.agile.model.Project;

public interface ProjectService {

	public List<Project> getAllProjects();

	public Project getProject();

}
