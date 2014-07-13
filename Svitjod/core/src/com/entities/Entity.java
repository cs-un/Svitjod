package com.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class Entity implements Things {
	protected int x, y, z;
	protected int tileNumber;
	protected Sprite s;
	protected Texture idleTexture, currentTexture;
	
	public Entity(int tile)
	{
		tileNumber = tile;
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
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public int getTile() {
		return tileNumber;
	}
	
	public abstract void update();
	
}
