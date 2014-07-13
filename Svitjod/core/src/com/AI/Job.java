package com.AI;

import com.entities.Building;

public class Job {

	private Building workplace;
	
	public Job(Building workplace)
	{
		this.workplace = workplace;
	}
	
	public Goal getGoal()
	{
		return workplace.getWork();
	}
}
