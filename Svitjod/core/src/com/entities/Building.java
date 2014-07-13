package com.entities;

import java.util.ArrayList;
import java.util.Stack;

import com.AI.Goal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.svitjod.Map;

public class Building extends Entity {

	private int maxWorkers;
	private ArrayList<Person> currentWorkers;
	public int offsetX, offsetY;
	private Stack<Goal> work;
	private Texture tex;
	public Building(int type, int tile) {
		super(tile);
		int xtile = tile % 100;
		int ytile = 100 - tile / 100;
		currentWorkers = new ArrayList<Person>();
		work = new Stack<Goal>();
		switch(type){
		case Map.HOUSE3X3:
			tex = new Texture(Gdx.files.internal("buildings/testhus3x3(4).png"));
			offsetX = -50;
			offsetY = 1;
			break;
		default:
			tex = new Texture(Gdx.files.internal("buildings/testhus3x3.png"));
			offsetX = -40;
			offsetY = +10;
			break;
		}
		s = new Sprite(tex);
		s.setPosition((xtile + ytile) * Map.tileWidth / 2 + offsetX, (ytile - xtile) * Map.tileHeight / 2 + offsetY);
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
	
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return s;
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}
	
	@Override
	public int getTile() {
		return tileNumber;
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
