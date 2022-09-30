package manage;

public class Game {
	static int teams = 0;
	Team teamOne = new Team();
	Team teamTwo = new Team();
	Innings firstInnings = new Innings();
	Innings secondInnings = new Innings();

	void toss() {
		System.out.printf("TOSS" + " won by [1] %s [2] %s : ", teamOne.teamName, teamTwo.teamName);
		int toss = Integer.parseInt(Main.in.nextLine());
		if (toss == 1) {
			System.out.print(
					teamOne.teamName + " have won the toss" + "\n" + teamOne.teamName + " [ Choose to: 1.BAT 2.BOWL ] : ");
			chooseTo(teamOne, teamTwo);
		} else {
			System.out.print(teamTwo.teamName + " have won the toss" + "\n" + teamTwo.teamName
					+ " [ Choose to: 1.BAT 2.BOWL ] : ");
			chooseTo(teamTwo, teamOne);
		}
	}

	void chooseTo(Team tossWinner, Team tossLoser) {
		int choice = Integer.parseInt(Main.in.nextLine());
		if (choice == 1) {
			firstInnings.begin(tossWinner, tossLoser);
			secondInnings.begin(tossLoser, tossWinner);
		} else {
			firstInnings.begin(tossLoser, tossWinner);
			secondInnings.begin(tossWinner, tossLoser);
		}
	}
}
