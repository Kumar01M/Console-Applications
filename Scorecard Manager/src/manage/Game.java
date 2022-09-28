package manage;

public class Game {
	
	static int teams = 0;
	
	Team teamOne = new Team();
	Team teamTwo = new Team();

	Innings firstInnings = new Innings();
	Innings secondInnings = new Innings();
	
	Game() {
		
		teamOne.addTeamMembers();
		teamTwo.addTeamMembers();
		
		toss();	
	}
	
	void toss() {
		
			System.out.println("TOSS\n"+teamTwo.teamName+" has the Call for toss\n[ 1.Heads or 2.Tails ]");//Toss Pending
			int toss = Integer.parseInt(Scorecard.in.nextLine());
			if(toss==2) {
				System.out.println(teamOne.teamName+" have won the toss"+"\n"+teamOne.teamName+" [ Choose to: 1.BAT 2.BOWL ]");
				chooseTo(teamOne, teamTwo);
			}
			else {
				System.out.println(teamTwo.teamName+" hava won the toss"+"\n"+teamTwo.teamName+" [ Choose to: 1.BAT	2.BOWL ]");
				chooseTo(teamTwo, teamOne);				
			}
		}
	
	void chooseTo(Team tossWinner, Team tossLoser) {
		
		int choice = Integer.parseInt(Scorecard.in.nextLine());
		
		if(choice == 1) {
			firstInnings.begin(tossWinner, tossLoser);
			secondInnings.begin(tossLoser, tossWinner);
		}
		else {
			firstInnings.begin(tossLoser, tossWinner);
			secondInnings.begin(tossWinner, tossLoser);
		}
		
	}
	
	
}
