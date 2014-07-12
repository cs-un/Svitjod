package com.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract interface Things {
	
	public Sprite getSprite();
	public int getX();
	public int getY();
	public int getZ();
	public void setX(int x);
	public void setY(int y);
	public void setZ(int z);
	
}
