package com.svitjod;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.entities.Terrain;
import com.entities.Things;

public class Map {
	private ArrayList<ArrayList<Things>> map = new ArrayList<ArrayList<Things>>(); 
	public static final int GRASS = 16711935, ROAD = -2108346881, BARLEY = -917249, CONSTRUCTION = -1010580481;
	
	public Map(String level) {
		//g�r inget med stringen �n.. senare ladda levels fr�n filer?
		//ladda banan
		// 16711935 = grass, -2108346881 = road, -917249 = barley, 
		// -1010580481 = "construction site", 1244732159 = 3x3 house,
		// -1555454721 = 7x7 house
		Texture loadinglevel = new Texture(Gdx.files.internal("maps/" + level + ".png"));
		loadinglevel.getTextureData().prepare();
		Pixmap temp = loadinglevel.getTextureData().consumePixmap();
		for(int j = 0; j < loadinglevel.getHeight(); j++){
			for(int i = 0; i < loadinglevel.getWidth(); i++){
				int currenttile = j*loadinglevel.getWidth()+i;
				map.add(currenttile, new ArrayList<Things>());
				switch (temp.getPixel(i, j)){
				case GRASS:
					map.get(currenttile).add(new Terrain(GRASS));
					break;
				default:
					break;
				}
			}
		}
		
	}
	
	public void update()
	{
		//vill vi uppdatera entities h�r?
	}
	
	public ArrayList<ArrayList<Things>> tiles()
	{
		//vi vill nog endast returnera listan h�r
		//uppdatera listan i entities metoder senare?
		//tror arraylist blir b�st f�r det h�r men inte 100%, kan vara b�ttre med n�gon hashmap eller dylikt
		return map;
	}

}
