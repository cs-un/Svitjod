package com.svitjod;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Map {

	public Map(String level) {
		//gör inget med stringen än.. senare ladda levels från filer?
		//ladda banan
	}
	
	public void update()
	{
		//vill vi uppdatera entities här?
	}
	
	public ArrayList<ArrayList<Sprite>> tiles()
	{
		//vi vill nog endast returnera listan här
		//uppdatera listan i entities metoder senare?
		//tror arraylist blir bäst för det här men inte 100%, kan vara bättre med någon hashmap eller dylikt
		return null;
	}

}
