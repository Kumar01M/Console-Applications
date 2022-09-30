package manage;
import java.util.ArrayList;

public class Team {
	String teamName;
	ArrayList<Player> teamList = new ArrayList<>();
	int teamPlayers = 0;

	Team() {
		Game.teams++;
		System.out.print("Enter team name "+ Game.teams+": " );
		teamName = Main.in.nextLine();
		addTeamMembers();
	}

	private void addTeamMembers() {
		System.out.println("Enter " + teamName + " players list");
		while (teamPlayers != 11) {
			teamList.add(new Player());
			teamList.get(teamPlayers++).setPlayerName(Main.in.nextLine());
		}
		System.out.println("Choose Captain");
		displayPlayers(teamList);
		teamList.get(Integer.parseInt(Main.in.nextLine())).setCaptain(true);
		System.out.println("Choose Wicket Keeper");
		displayPlayers(teamList);
		teamList.get(Integer.parseInt(Main.in.nextLine())).setWicketKeeper(true);
	}

	public static void displayPlayers(ArrayList<Player> team) {
		int choice = 0;
		for (Player player : team) {
			System.out.print("[" + (choice++) + "] " + player.getPlayerName());
			if (player.isCaptain())
				System.out.print(" (c)");
			if (player.isWicketKeeper())
				System.out.print(" (wk)");
			System.out.println();
		}
		System.out.print("\n>>");
	}
}