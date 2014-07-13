package com.entities;

import com.AI.Job;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Person extends Entity {
	private Job job;
	
	public Person(int tile, char sex, int age)
	{
		super(tile);
		switch(sex)
		{
		case 'f':
			//ladda textur som är lämplig för åldern
			break;
		case 'm':
			
			break;
		}
	}
	
	@Override
	public void update() {
		if(hasJob())
		{
			
		}
		else
		{
			//Map.findJob();
		}
	}

	public boolean hasJob()
	{
		return job==null;
	}
	
}
