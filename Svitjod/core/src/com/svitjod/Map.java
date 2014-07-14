package com.svitjod;

import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.buildings.Building;
import com.buildings.decorativeBuilding;
import com.buildings.houseBuilding;
import com.entities.Entity;
import com.entities.Person;
import com.entities.Terrain;
import com.entities.Things;

public class Map {
	public static int mapWidth, mapHeight;
	private ArrayList<ArrayList<Things>> map = new ArrayList<ArrayList<Things>>(); 
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private long lastSpawn;
	private int popboost = 5; //growth of population every 60 seconds
	public static final int GRASS = 16711935, ROAD = -2108346881, BARLEY = -917249, CONSTRUCTION = -1010580481, HOUSE3X3 = 1244732159, HOUSE7X7 = -1555454721;
	public static final int tileWidth = 50, tileHeight = 30;
	
	public Map(String level) {
		//gör inget med stringen än.. senare ladda levels från filer?
		//ladda banan
		// 16711935 = grass, -2108346881 = road, -917249 = barley, 
		// -1010580481 = "construction site", 1244732159 = 3x3 house,
		// -1555454721 = 7x7 house
		Texture loadinglevel = new Texture(Gdx.files.internal("maps/" + level + ".png"));
		loadinglevel.getTextureData().prepare();
		Pixmap temp = loadinglevel.getTextureData().consumePixmap();
		mapWidth = loadinglevel.getWidth();
		mapHeight = loadinglevel.getHeight();
		for(int j = 0; j < mapHeight; j++){
			for(int i = 0; i < mapWidth; i++){
				map.add(j * loadinglevel.getWidth() + i, new ArrayList<Things>());
			}
		}
		for(int j = 0; j < mapHeight; j++){
			for(int i = 0; i < mapWidth; i++){
				//System.out.println(temp.getPixel(i, j));
				int currenttile = j * mapHeight + i;
				switch (temp.getPixel(i, j)){
				case GRASS:
					map.get(currenttile).add(new Terrain(GRASS, currenttile));
					break;
				case ROAD:
					map.get(currenttile).add(new Terrain(ROAD, currenttile));
					break;
				case HOUSE3X3:
					map.get(currenttile).add(new houseBuilding(HOUSE3X3, currenttile));
					break;
				case CONSTRUCTION:
					// do nothing
					break;
				default:
					map.get(currenttile).add(new Terrain(temp.getPixel(i, j), currenttile));
					break;
				}
			}
		}
		
	}
	
	public void update()
	{
		//vill vi uppdatera entities här?
		createPeople();
		for(Entity e : entities)
		{
			e.update();
		}
	}
	
	private void createPeople() {
		int n = newPeople();
		for(int i = 0; i < n; ++i)
		{
			Person p = new Person(80, 'm', 25, "Sven"); // ändra det här lite sen!! kanske ska namnet skapas i personklassen istället.
			entities.add(p);
			map.get(i).add(p);
			System.out.println("Person " + p.getName() + " spawned");
		}
		
	}

	private int newPeople() {
		int n = 0;
		if(System.currentTimeMillis()-lastSpawn > 60000)
		{
			n+=popboost;
			lastSpawn = System.currentTimeMillis();
		}
		return n;
	}

	public void modPopBoost(int mod)
	{
		popboost+=mod;
	}
	
	public ArrayList<ArrayList<Things>> tiles()
	{
		//vi vill nog endast returnera listan här
		//uppdatera listan i entities metoder senare?
		//tror arraylist blir bäst för det här men inte 100%, kan vara bättre med någon hashmap eller dylikt
		return map;
	}

}
