package com.viddu.agile.services;

import com.viddu.agile.model.Iteration;

public class IterationServiceImpl implements IterationService {

	@Override
	public Iteration findIterationById(Integer id) {
		return new Iteration("Iteration 1");
	}

}
