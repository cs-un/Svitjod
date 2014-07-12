package com.svitjod;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Map {
	private ArrayList<ArrayList<Object>> map = new ArrayList<ArrayList<Object>>(); 
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
				map.add(currenttile, new ArrayList<Object>());
				switch (temp.getPixel(i, j)){
				case 16711935:
					map.get(currenttile).add(1);
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
	
	public ArrayList<ArrayList<Sprite>> tiles()
	{
		//vi vill nog endast returnera listan h�r
		//uppdatera listan i entities metoder senare?
		//tror arraylist blir b�st f�r det h�r men inte 100%, kan vara b�ttre med n�gon hashmap eller dylikt
		return null;
	}

}
