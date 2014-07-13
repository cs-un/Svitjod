package com.AI;

import com.buildings.Building;
import com.buildings.productionBuilding;

public class Job {

	private productionBuilding workplace;
	
	public Job(productionBuilding workplace)
	{
		this.workplace = workplace;
	}
	
	public Goal getGoal()
	{
		return workplace.getWork();
	}
}
