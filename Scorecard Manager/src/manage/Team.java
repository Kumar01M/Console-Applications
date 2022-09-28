package manage;

import java.util.ArrayList;

class Team {
	String teamName;
	ArrayList<Player> teamList = new ArrayList<>();
	int teamPlayers = 11;
	
	Team() {
		Game.teams++;
		System.out.print("Enter team "+Game.teams+" name: ");
		teamName = Scorecard.in.nextLine();
	}
	
	void addTeamMembers() {
		System.out.println("Enter "+teamName+" players list");
		while(teamPlayers-- != 0) {
			teamList.add(new Player());
		}
		
		System.out.println("Choose Captain");
		displayPlayers(teamList);
		teamList.get(Integer.parseInt(Scorecard.in.nextLine())).captain = true;
		
		
		System.out.println("Choose Wicket Keeper");
		displayPlayers(teamList);
		teamList.get(Integer.parseInt(Scorecard.in.nextLine())).wicketKeeper = false;
		
		
	}
	public static void displayPlayers(ArrayList<Player> team) {
		int choice = 0;
		for(Player player: team) {
			System.out.print("["+ (choice++) +"] "+  player.playerName);
			if(player.captain)System.out.print(" (c)");
			if(player.wicketKeeper)System.out.print(" (wk)");
			System.out.println();			
		}
	}
}