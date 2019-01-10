package dice;

import java.util.Random;

public class Dice4 implements IDice {
	@Override
	public int gieo() {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int rdInt = rd.nextInt(26); // random tu 1 toi 25
		if(rdInt <= 5) {
			return 5;
		}
		if(rdInt <= 9) {
			return 6;
		}
		if(rdInt <= 13) {
			return 4;
		}
		if(rdInt <= 17) {
			return 3;
		}
		if(rdInt <= 21) {
			return 2;
		}
		if(rdInt <= 25) {
			return 1;
		}
		return 0;
	}
}
