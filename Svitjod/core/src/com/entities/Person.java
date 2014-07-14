package com.entities;

import com.AI.Job;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.svitjod.Map;

public class Person extends Entity {
	private Job job;
	public Person(int tile, char sex, int age, String name)
	{
		super(tile);
		this.name = name;
		switch(sex)
		{
		case 'f':
			//ladda textur som är lämplig för åldern
			break;
		case 'm':
			currentTexture = idleTexture = new Texture(Gdx.files.internal("hero/testgubbar/gubbe1.png"));
			s = new Sprite(currentTexture);
			s.setPosition(x, y);
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
