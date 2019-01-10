package game;

import java.util.ArrayList;
import java.util.Random;

import application.Application;
import arbitrator.Arbitrator;
import dice.Dice1;
import dice.Dice2;
import dice.Dice3;
import dice.Dice4;
import dice.Dice5;
import dice.IDice;
import player.AVirtualPlayer;
import player.Player;
import player.VirtualPlayer1;
import player.VirtualPlayer2;
import player.VirtualPlayer3;
import player.VirtualPlayer4;


public class Game {
	ArrayList<Player> players;
	Arbitrator arbitrator;
	ArrayList<IDice> dices;
	boolean gameOver;

	public Game(int numberRealPlayer) {
		players = new ArrayList<Player>();
		arbitrator = new Arbitrator();
		dices = new ArrayList<IDice>();
		gameOver = false;

		generate(numberRealPlayer);
	}

	
	public void start() {
		System.out.println("vao day");
		while (!gameOver) {
			Player currentPlayer = arbitrator.nextPlayer(players);
			IDice currentDice = currentPlayer.getDice(dices);
			int currentPoint = currentDice.gieo();
			arbitrator.caculatePoint(currentPlayer, currentPoint);
			gameOver = Arbitrator.gameOver;
			if (gameOver) {
				for (Player player : players) {
					if(player instanceof AVirtualPlayer) {
						AVirtualPlayer aVirtualPlayer = (AVirtualPlayer)player;
						aVirtualPlayer.bieuLoCamXuc();
					}
					//System.out.println("comhere");
//					if (!player.equals(currentPlayer)) {
//						if (player instanceof VirtualPlayer1) {
//							VirtualPlayer1 virtualPlayer1 = (VirtualPlayer1) player;
//							virtualPlayer1.bieuLoCamXuc();
//						}
//						if (player instanceof VirtualPlayer2) {
//							VirtualPlayer2 virtualPlayer2 = (VirtualPlayer2) player;
//							virtualPlayer2.bieuLoCamXuc();
//						}
//						if (player instanceof VirtualPlayer3) {
//							VirtualPlayer3 virtualPlayer3 = (VirtualPlayer3) player;
//							virtualPlayer3.bieuLoCamXuc();
//						}
//						if (player instanceof VirtualPlayer4) {
//							VirtualPlayer4 virtualPlayer4 = (VirtualPlayer4) player;
//							virtualPlayer4.bieuLoCamXuc();
//						}
//					}
				}
			}

		}
	}

	public void generate(int numberRealPlayer) {
		for (int i = 0; i < Application.MAX_PLAYER; i++) {
			if (i < numberRealPlayer) {
				Player player = new Player();
				players.add(player);
			}else {
				Random rd = new Random();
				int rdInt = rd.nextInt(4) + 1;
				if (rdInt == 1) {
					VirtualPlayer1 virtualPlayer1 = new VirtualPlayer1();
					players.add(virtualPlayer1);
				} else if (rdInt == 2) {
					VirtualPlayer2 virtualPlayer2 = new VirtualPlayer2();
					players.add(virtualPlayer2);
				} else if (rdInt == 3) {
					VirtualPlayer3 virtualPlayer3 = new VirtualPlayer3();
					players.add(virtualPlayer3);
				} else if (rdInt == 4) {
					VirtualPlayer4 virtualPlayer4 = new VirtualPlayer4();
					players.add(virtualPlayer4);
				} 
			}
		}
		
		
		Dice1 dice1 = new Dice1();
		Dice2 dice2 = new Dice2();
		Dice3 dice3 = new Dice3();
		Dice4 dice4 = new Dice4();
		Dice5 dice5 = new Dice5();
		
		dices.add(dice1);
		dices.add(dice2);
		dices.add(dice3);
		dices.add(dice4);
		dices.add(dice5);
	}

}
