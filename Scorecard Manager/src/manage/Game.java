package manage;

public class Game {
	static int teams = 0;
	Team teamOne = new Team();
	Team teamTwo = new Team();
	Innings firstInnings = new Innings();
	Innings secondInnings = new Innings();

	public void toss() {
		System.out.printf("TOSS" + " won by [0] %s [1] %s : ", teamOne.teamName, teamTwo.teamName);
		int toss = Validate.validateInteger(1);
		if (toss == 0) {
			System.out.print(teamOne.teamName + " have won the toss" + "\n" + teamOne.teamName
					+ " Choose to: [0] BAT [1] BOWL : ");
			chooseTo(teamOne, teamTwo);
		} else {
			System.out.print(teamTwo.teamName + " have won the toss" + "\n" + teamTwo.teamName
					+ " Choose to: [0] BAT [1] BOWL  : ");
			chooseTo(teamTwo, teamOne);
		}
	}

	private void chooseTo(Team tossWinner, Team tossLoser) {
		int choice = Validate.validateInteger(1);
		if (choice == 0) {
			System.out.println("and chose to BAT first");
			firstInnings.begin(tossWinner, tossLoser);
			secondInnings.begin(tossLoser, tossWinner);
		} else {
			System.out.println("and chose to BOWL first");
			firstInnings.begin(tossLoser, tossWinner);
			secondInnings.begin(tossWinner, tossLoser);
		}
	}
}
