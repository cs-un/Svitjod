package com.buildings;

import java.util.ArrayList;

import com.entities.Person;
import com.svitjod.Map;

public class houseBuilding extends Building {

	private ArrayList<Person> residents;
	private int maxResidents;
	
	public houseBuilding(int type, int tile) {
		super(type, tile);
		residents = new ArrayList<Person>();
		switch(type)
		{
		case Map.HOUSE3X3:
			maxResidents = 5;
			break;
		default:
			maxResidents = 1;
			break;
		}
	}

	@Override
	public void update() {
		if(!fullHouse())
		{
			/**
			for(int i = 0; i < maxResidents - residents.size;++i)
			{
				Map.createHomeListing(this, i); // använd en hashmap i map sen så att inga duplicates skapas!
			}
			 */
		}
		
	}

	public boolean addResident(Person p)
	{
		if(!fullHouse())
			return residents.add(p);
		return false;
	}
	
	public boolean fullHouse()
	{
		return residents.size()<maxResidents;
	}
}
