package com.entities;

import java.util.ArrayList;
import java.util.Stack;

import com.AI.Goal;

public class Building extends Entity {

	private int maxWorkers;
	private ArrayList<Person> currentWorkers;
	public int offsetX, offsetY;
	private Stack<Goal> work;
	public Building(int tile, int maxW) {
		super(tile);
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
