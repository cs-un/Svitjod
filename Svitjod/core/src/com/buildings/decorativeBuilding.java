package com.buildings;


public class decorativeBuilding extends Building{

	private int happinessPlus; // om dekorativa byggnader ska g�ra n�got positivt sen
	public decorativeBuilding(int type, int tile) {
		super(type, tile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// kanske �ndra p� texturen om �rstider ska kunna �ndras.. annars ingenting tror jag
	}

}
