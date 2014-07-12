package com.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Terrain implements Things {
	private int x, y, z;
	
	@Override
	public Sprite getSprite() {
		// TODO Auto-generated method stub
		return null;
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


}
