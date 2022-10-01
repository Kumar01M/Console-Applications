package manage;
import java.util.ArrayList;

public class Team {
	String teamName;
	ArrayList<Player> teamList = new ArrayList<>();
	int teamPlayers = 0;

	public Team() {
		Game.teams++;
		System.out.print("\nTeam "+ Game.teams+": " );
		teamName = Validate.validateName();
		addPlayers();
	}

	private void addPlayers() {
		System.out.println("\n\t "+ teamName.toUpperCase() + " - player's list");
		while (teamPlayers != 11) {
			teamList.add(new Player());
			teamList.get(teamPlayers++).setPlayerName(Validate.validateName());
		}
		System.out.println("\n\tChoose "+teamName.toUpperCase()+" Captain\n");
		displayPlayers(teamList);
		teamList.get(Validate.validateInteger(10)).setCaptain(true);
		System.out.println("\n\tChoose "+teamName.toUpperCase()+" Wicket Keeper");
		displayPlayers(teamList);
		teamList.get(Validate.validateInteger(10)).setWicketKeeper(true);
	}

	public static void displayPlayers(ArrayList<Player> team) {
		int choice = 0;
		System.out.println();
		for (Player player : team) {
			System.out.print("[" + (choice++) + "] " + player.getPlayerName());
			if (player.isCaptain())
				System.out.print(" (c)");
			if (player.isWicketKeeper())
				System.out.print(" (wk)");
			System.out.println();
		}
		System.out.print(">>");
	}
}