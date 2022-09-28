package manage;

public class Player {
	
	String playerName;
	
	int runsScored;	//bat
	int ballsPlayed; //bat
	
	int runsGiven; //ball
	int ballsBowled; //ball
	int oversBowled; 
	int wicketsTaken; //ball
	int maidenOvers; 
	
	int teamName;
	//boolean out;
	
	boolean captain;
	boolean wicketKeeper;
	
	String takenBy; //bat
	String fieldedBy; //bat
	char modeOfOut; //bat
	
	
	Player() {
		playerName = Scorecard.in.nextLine();
	}
}
