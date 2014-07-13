package com.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.svitjod.Map;

public class Terrain implements Things {
	private int x, y, z;
	private Texture tex;
	private Sprite s;
	private int tileNumber;
	
	public Terrain(int type, int tileNr) {
		int xtile = tileNr % 100;
		int ytile = 100 - tileNr / 100;
		switch(type){
		case Map.GRASS:
			tex = new Texture(Gdx.files.internal("terrain/tiles/testruta.png"));
			break;
		case Map.ROAD:
			tex = new Texture(Gdx.files.internal("terrain/tiles/testvag.png"));
			break;
		default:
			tex = new Texture(Gdx.files.internal("terrain/tiles/missingtexture.png"));
			System.out.println("Terrain was loaded without proper code or texture is missing!");
			break;
		}
		s = new Sprite(tex);
		//s.setPosition((tileNr % 100 + tileNr / 100) * s.getWidth() / 2, (tileNr / 100 - tileNr % 100) * s.getHeight() / 2); // det här är fel
		tileNumber = tileNr;
		s.setPosition((xtile + ytile) * s.getWidth() / 2, (ytile - xtile) * s.getHeight() / 2);
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


}
