package manage;

public class Innings {
	private Player striker, nonStriker, bowler;
	private int score, fallOfWickets, currentOver, balls, extras;
	private static int noOfOvers;
	private static boolean chase = false;
	private static int total;
	private int nextBatsman = 0, nextBowler = 10;
	private boolean maiden = true, strikeRotated = false;
	private Team battingTeam, bowlingTeam;
	static {
		System.out.print("\n\tEnter number of overs[1-50]: ");
		noOfOvers = Validate.validateInteger(50);
	}

	public void begin(Team battingTeam, Team bowlingTeam) {
		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;
		striker = battingTeam.teamList.get(nextBatsman);
		nonStriker = battingTeam.teamList.get(++nextBatsman);
		bowler = bowlingTeam.teamList.get(nextBowler--);
		while (currentOver != noOfOvers && fallOfWickets != 10) {
			System.out.println();
			scorecardUpdate();
			System.out
					.println(" [0] Dot ball\t\t[7]  Bold \t\t[13] Wide \n [1] 1 run\t\t[8]  Caught \t\t[14] No-Ball \n "
							+ "[2] 2 runs\t\t[9]  Stumped \t\t[ 5] 5 runs (Penalty/Overthrow)\n [3] 3 runs\t\t[10] LBW \n"
							+ " [4] Four\t\t[11] Run-Out \n [6] Six\t\t[12] Mankad \n");
			System.out.print("\n->>");
			int hit = Validate.validateInteger(14);
			switch (hit) {
			case 0:
				addRuns(0);
				break;
			case 1:
				addRuns(1);
				break;
			case 2:
				addRuns(2);
				break;
			case 3:
				addRuns(3);
				break;
			case 4:
				addRuns(4);
				break;
			case 5:
				addRuns(5);
				break;
			case 6:
				addRuns(6);
				break;
			case 7:
				striker.setTakenBy(bowler.getPlayerName());
				striker.setModeOfOut('B');
				removePlayer(hit);
				break;
			case 8:
				striker.setTakenBy(bowler.getPlayerName());
				striker.setModeOfOut('C');
				caughtStumped();
				removePlayer(hit);
				break;
			case 9:
				striker.setTakenBy(bowler.getPlayerName());
				striker.setModeOfOut('S');
				caughtStumped();
				removePlayer(hit);
				break;
			case 10:
				striker.setTakenBy(bowler.getPlayerName());
				striker.setModeOfOut('L');
				removePlayer(hit);
				break;
			case 11:
				removePlayer(hit);
				break;
			case 12:
				striker.setTakenBy(bowler.getPlayerName());
				nonStriker.setModeOfOut('M');
				removePlayer(hit);
				break;
			case 13:
				score++;
				extras++;
				bowler.setRunsGiven(1);
				break;
			case 14:
				noBall();
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}

			bowler.setBallsBowled(1);
			if (hit != 0 || (hit < 7 && hit < 11))
				maiden = false;
			if (balls == 6) {
				currentOver += 1;
				rotateStrike();
				if (maiden)
					bowler.setMaidenOvers((byte) 1);
				if (nextBowler < 5)
					nextBowler = 10;
				bowler.setOversBowled(1);
				bowler = bowlingTeam.teamList.get(nextBowler--);
				balls = 0;
				maiden = true;
			}

			if (chase) {
				scorecardUpdate();
				if (score > total) {
					scorecardUpdate();
					result(battingTeam, bowlingTeam);
				} else if (score == total) {
					System.out.println("Match DRAW");
				} else if (noOfOvers == currentOver || fallOfWickets == 10) {
					result(bowlingTeam, battingTeam);
				}
			}
		}
		if (!chase) {
			chase = true;
			total = score;
		}
	}

	private void scorecardUpdate() {
		System.out.println("_______________________________________________________________________________");
		System.out.printf("S::\t\t%S vs %S\t(%d overs)\n", battingTeam.teamName, bowlingTeam.teamName, noOfOvers);
		if (strikeRotated == false)
			System.out.printf("C:: %3.3S %d/%d\t\t%s %d(%d)*\t%s %d(%d)\n", battingTeam.teamName, score, fallOfWickets,
					striker.getPlayerName(), striker.getRunsScored(), striker.getBallsPlayed(),
					nonStriker.getPlayerName(), nonStriker.getRunsScored(), nonStriker.getBallsPlayed());
		else
			System.out.printf("C:: %3.3S %d/%d\t\t%s %d(%d)\t%s %d(%d)*\n", battingTeam.teamName, score, fallOfWickets,
					nonStriker.getPlayerName(), nonStriker.getRunsScored(), nonStriker.getBallsPlayed(),
					striker.getPlayerName(), striker.getRunsScored(), striker.getBallsPlayed());
		System.out.printf("O:: %3.3S %d.%d Overs \t\t%s %d-%d (%d.%d)\n", bowlingTeam.teamName, currentOver, balls,
				bowler.getPlayerName(), bowler.getWicketsTaken(), bowler.getRunsGiven(), bowler.getOversBowled(),
				bowler.getBallsBowled());
		if (chase == false && currentOver >= 1)
			System.out.printf("R:: Run rate - current: %.2f\n", (float) score / (float) (currentOver));
		else if (currentOver >= 1 && currentOver % 2 != 0)
			System.out.printf("R:: Run rate - current: %.2f  required: %.2f  extras: %d\n",
					(float) score / (float) currentOver, (float) total - score / (float) noOfOvers - currentOver,
					extras);
		else
			System.out.printf("R:: \textras: %d\n", extras);
		if (chase == true && currentOver % 2 == 0)
			System.out.printf("E:: Total %d\t To win %d needed of %d balls.\n", total, total - score + 1,
					(noOfOvers - currentOver) * 6 + (6 - balls));
		else
			System.out.println("E:: ");
		System.out.println("________________________________________________________________________________");
	}

	private void result(Team winningTeam, Team losingTeam) {
		if (winningTeam.equals(battingTeam))
			System.out.println("\n\t\t" + winningTeam.teamName.toUpperCase() + " won by " + (10 - fallOfWickets) + "");
		else
			System.out.println("\n\t\t" + winningTeam.teamName.toUpperCase() + " won by " + (total - score) + " runs");
		summary(winningTeam, losingTeam);
	}

	private void rotateStrike() {
		Player temp = striker;
		striker = nonStriker;
		nonStriker = temp;
		if (strikeRotated == false)
			strikeRotated = true;
		else
			strikeRotated = false;
	}

	private void addRuns(int runs) {
		score += runs;
		striker.setRunsScored(runs);
		striker.setBallsPlayed(1);
		bowler.setRunsGiven(runs);
		if (runs == 1 || runs == 3)
			rotateStrike();
		else if (runs == 5) {
			System.out.println(" [0] Penalty [1] Overthrow ?");
			if (Validate.validateInteger(1) == 1)
				rotateStrike();
		}
		balls++;
	}

	private void removePlayer(int wicket) {
		balls++;
		if (fallOfWickets != 9 && wicket != 12 && wicket != 11) {
			striker.setBallsPlayed(1);
			striker.setTakenBy(bowler.getPlayerName());
			striker = battingTeam.teamList.get(++nextBatsman);
			bowler.setWicketsTaken((byte) 1);
		}
		if (fallOfWickets != 9 && wicket == 12) {
			balls--;
			nonStriker.setTakenBy(bowler.getPlayerName());
			nonStriker = battingTeam.teamList.get(++nextBatsman);
			bowler.setWicketsTaken((byte) 1);
		}
		if (fallOfWickets != 9 && wicket == 11) {
			System.out.print("[0] Striker out  [1] Non-striker out");
			int choice = Validate.validateInteger(1);
			System.out.print("Runs >> ");
			int runs = Validate.validateInteger(1);
			score += runs;
			striker.setRunsScored(runs);
			bowler.setRunsGiven(runs);
			striker.setBallsPlayed(1);
			System.out.println("Run-Out By");
			Team.displayPlayers(bowlingTeam.teamList);
			int field = Validate.validateInteger(10);
			if (choice == 0 && runs % 2 == 0) {
				striker.setModeOfOut('R');
				striker.setFieldedBy(bowlingTeam.teamList.get(field).getPlayerName());
				striker = battingTeam.teamList.get(++nextBatsman);
			} else if (choice == 0) {
				striker.setModeOfOut('R');
				striker.setFieldedBy(bowlingTeam.teamList.get(field).getPlayerName());
				striker = battingTeam.teamList.get(++nextBatsman);
				rotateStrike();
			} else if (runs % 2 == 0) {
				nonStriker.setModeOfOut('R');
				nonStriker.setFieldedBy(bowlingTeam.teamList.get(field).getPlayerName());
				nonStriker = battingTeam.teamList.get(++nextBatsman);
			} else {
				nonStriker.setModeOfOut('R');
				nonStriker.setFieldedBy(bowlingTeam.teamList.get(field).getPlayerName());
				nonStriker = battingTeam.teamList.get(++nextBatsman);
				rotateStrike();
			}
		}
		fallOfWickets++;
		if (fallOfWickets == 10) {
			System.out.print("" + "n\t\tINNINGS OVER\n");
		}
	}

	private void caughtStumped() {
		if (striker.getModeOfOut() == 'C') {
			System.out.println("Caught by: ");
			int choice = 0;
			Team.displayPlayers(bowlingTeam.teamList);
			choice = Validate.validateInteger(10);
			striker.setFieldedBy(bowlingTeam.teamList.get(choice).getPlayerName());
		} else if (striker.getModeOfOut() == 'S') {
			int choice = 0;
			for (Player player : bowlingTeam.teamList) {
				if (player.isWicketKeeper()) {
					striker.setFieldedBy(bowlingTeam.teamList.get(choice).getPlayerName());
				}
			}
		}
	}

	private void noBall() {
		score++;
		bowler.setRunsGiven(1);
		System.out.println("Runs Scored in NO-BALL: ");
		int noBallRuns = Validate.validateInteger(6);
		striker.setRunsScored(noBallRuns);
		score += noBallRuns;
		if (noBallRuns == 1 || noBallRuns == 3) {
			striker.setBallsPlayed(1);
			rotateStrike();
		} else if (noBallRuns != 0)
			striker.setBallsPlayed(1);
		freeHit();
		bowler.setRunsGiven(noBallRuns);
	}

	private void freeHit() {
		System.out.print("Free-hit runs:[1-6] Runs [7] Wide  [8] No-Ball again");
		int freeHitRun = Validate.validateInteger(8);
		if (freeHitRun == 7) {
			score++;
			bowler.setRunsGiven(1);
			freeHit();
		} else if (freeHitRun == 8) {
			noBall();
		} else {
			score += freeHitRun;
			striker.setRunsScored(freeHitRun);
			;
			striker.setBallsPlayed(1);
			bowler.setRunsGiven(1);
			balls++;
		}
	}

	private void summary(Team winningTeam, Team losingTeam) {
		battingScorecard(losingTeam);
		bowlingScorecard(winningTeam);
		battingScorecard(winningTeam);
		bowlingScorecard(losingTeam);
	}

	private void battingScorecard(Team batting) {
		System.out.println(batting.teamName.toUpperCase());
		System.out.println("+----------------------+----------+-------------------------------------------------+");
		System.out.println("|   Batsmen Name       | Runs/Of  |            Wicket / Taken By                    |");
		System.out.println("+----------------------+----------+-------------------------------------------------+");
		for (Player player : batting.teamList) {
			System.out.printf("| %-20s | %-3d(%-3d) | %c by %-20s %c %-20s|\n", player.getPlayerName(),
					player.getRunsScored(), player.getBallsPlayed(), player.getModeOfOut(), player.getFieldedBy(),
					(char) 223, player.getTakenBy());
		}
		System.out.println("+----------------------+---------+--------------------------------------------------+\n");
	}

	private void bowlingScorecard(Team bowling) {
		System.out.println(bowling.teamName.toUpperCase());
		System.out.println("\t\t+----------------------+---------+-----+");
		System.out.println("\t\t|   Bowler Name        | Summary |  O  |");
		System.out.println("\t\t+----------------------+---------+-----+");
		for (int index = 10; index > 5; index--) {
			Player player = bowling.teamList.get(index);
			System.out.printf("\t\t| %-20s | %3d-%-3d | %-3d |\n", player.getPlayerName(), player.getWicketsTaken(),
					player.getOversBowled(), player.getRunsGiven());
		}
		System.out.println("\t\t+---------------------+----------+-----+");
	}
}