package com.buildings;


public class decorativeBuilding extends Building{

	private int happinessPlus; // om dekorativa byggnader ska göra något positivt sen
	public decorativeBuilding(int type, int tile) {
		super(type, tile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// kanske ändra på texturen om årstider ska kunna ändras.. annars ingenting tror jag
	}

}
