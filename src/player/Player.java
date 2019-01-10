package player;

import java.util.ArrayList;
import java.util.Random;

import dice.IDice;

public class Player {
	protected String name;
	protected int point;
	
	public Player() {
		this.point = 0;
		this.name = "";
	}
	
	public IDice getDice(ArrayList<IDice> dices) {
		Random rd = new Random();
		return dices.get(rd.nextInt(dices.size()));
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
