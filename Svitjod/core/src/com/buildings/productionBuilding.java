package com.buildings;

import java.util.ArrayList;
import java.util.Stack;

import com.AI.Goal;
import com.entities.Person;

public class productionBuilding extends Building {
	
	private int maxWorkers;
	private ArrayList<Person> currentWorkers;
	private Stack<Goal> work;
	
	public productionBuilding(int type, int tile) {
		super(type, tile);
		currentWorkers = new ArrayList<Person>();
		work = new Stack<Goal>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		if(!fullyEmployed())
		{
			/**
			for(int i = 0; i < maxWorkers - currentWorkers.size;++i)
			{
				Map.createJobListing(this, i); // använd en hashmap i map sen så att inga duplicates skapas!
			}
			 */
		}
		
		
	}

	
	public boolean fullyEmployed()
	{
		return currentWorkers.size()==maxWorkers;
	}

	public Goal getWork() {
		// TODO Auto-generated method stub
		return work.pop();
	}
	
}
