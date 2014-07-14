package com.buildings;

import java.util.ArrayList;
import java.util.Stack;

import com.AI.Goal;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.entities.Entity;
import com.svitjod.Map;

public abstract class Building extends Entity {

	public int offsetX, offsetY;
	private Texture tex;
	public Building(int type, int tile) {
		super(tile);
		int xtile = tile % 100;
		int ytile = 100 - tile / 100;
		switch(type){
		case Map.HOUSE3X3:
			tex = new Texture(Gdx.files.internal("buildings/testhus3x3(4).png"));
			offsetX = -50;
			offsetY = 1;
			name = "Regular House";
			break;
		default:
			tex = new Texture(Gdx.files.internal("buildings/testhus3x3.png"));
			offsetX = -40;
			offsetY = +10;
			name = "Unknown Building";
			break;
		}
		s = new Sprite(tex);
		s.setPosition((xtile + ytile) * Map.tileWidth / 2 + offsetX, (ytile - xtile) * Map.tileHeight / 2 + offsetY);
		// TODO Auto-generated constructor stub
	}
}
