package application;

import java.util.Scanner;

import game.Game;

public class Application {
	public static final int MAX_PLAYER = 4;
	public static final int MAX_DICE = 5;
	
	public static void main(String[] args) {
		System.out.println("input number real player(0< && <4), pls: ");
		//Scanner sc = new Scanner(System.in);
		int numberRealPlayer = 2;
		if(numberRealPlayer > MAX_PLAYER || numberRealPlayer < 0) {
			System.out.println("Input invalid");
			return;
		}
		Game game = new Game(numberRealPlayer);
		game.start();
	}
}