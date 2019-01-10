package arbitrator;

import java.util.ArrayList;
import java.util.Random;

import player.Player;

public class Arbitrator {
	public static boolean gameOver = false;
	public Player nextPlayer(ArrayList<Player> players) {
		Random rd = new Random();
		return players.get(rd.nextInt(players.size()));
	}
	/**
	 * this is function which caculate and set gameOver parametter
	 * @param player
	 * @param point
	 */
	public void caculatePoint(Player player, int point) {
		int currentPoint = player.getPoint();
		if (currentPoint  + point > 21) {
			point = 0;
			player.setPoint(point);
			return;
		}else if(currentPoint + point == 21) {
			gameOver = true;
		}else {
			player.setPoint(currentPoint + point);
		}
	}
	
}
