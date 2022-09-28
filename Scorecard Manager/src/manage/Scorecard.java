package manage;

import java.util.Scanner;

public class Scorecard {
	public final static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		
		Scorecard game = new Scorecard();
		game.init();

	}
	
	void init() {
		new Game();
	}
	
}
