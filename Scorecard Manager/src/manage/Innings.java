package manage;

public class Innings {

	Player striker;
	Player nonStriker;
	Player bowler;

	int score;
	int fallOfWickets;
	int thisOver;
	int balls;
	int extras;

	static int noOfOvers;
	static boolean chase = false;
	static int total;

	int nextBatsman = 0;
	int nextBowler = 10;

	boolean maiden = true;
	boolean strikeRotated = false;

	Team battingTeam;
	Team bowlingTeam;

	static {
		System.out.print("Enter Number of Overs: ");
		noOfOvers = Scorecard.in.nextInt();
		Scorecard.in.nextLine();
	}

	void begin(Team battingTeam, Team bowlingTeam) {

		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;

		striker = battingTeam.teamList.get(nextBatsman);
		nonStriker = battingTeam.teamList.get(++nextBatsman);

		bowler = bowlingTeam.teamList.get(nextBowler--);

		while (thisOver != noOfOvers && fallOfWickets != 10) {
			System.out.println();
			scorecardUpdate();

			System.out.println(
					" [0] Dot ball\t\t[7]  Bold \t\t[13] Wide \n [1] 1 run\t\t[8]  Caught \t\t[14] No-Ball \n [2] 2 runs\t\t[9]  Stumped \t\t[ 5] 5 runs (Penalty/Overthrow)\n [3] 3 runs\t\t[10] LBW \n [4] Four\t\t[11] Run-Out \n [6] Six\t\t[12] Mankad \n");
			System.out.print("\n->>");
			int hit = Scorecard.in.nextInt();

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
				striker.takenBy = bowler.playerName;
				striker.modeOfOut = 'B';
				removePlayer(hit);
				break;
			case 8:
				striker.takenBy = bowler.playerName;
				striker.modeOfOut = 'C';
				caughtStumped();
				removePlayer(hit);
				break;
			case 9:
				striker.takenBy = bowler.playerName;
				striker.modeOfOut = 'S';
				caughtStumped();
				removePlayer(hit);
				break;
			case 10:
				striker.takenBy = bowler.playerName;
				striker.modeOfOut = 'L';
				removePlayer(hit);
				break;
			case 11:
				removePlayer(hit);
				break;
			case 12:
				striker.takenBy = bowler.playerName;
				nonStriker.modeOfOut = 'M';
				removePlayer(hit);
				break;
			case 13:
				score++;
				bowler.runsGiven++;
				break;
			case 14:
				noBall();
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			bowler.ballsBowled++;

			if (hit != 0 || (hit < 7 && hit < 11))
				maiden = false;

			if (balls == 6) {
				thisOver += 1;
				rotateStrike();

				if (maiden)
					bowler.maidenOvers++;
				if (nextBowler < 5)
					nextBowler = 10;

				bowler.oversBowled++;
				bowler = bowlingTeam.teamList.get(nextBowler--);

				balls = 0;
				maiden = true;
			}

			if (chase) {
				if (score > total)
					scorecardUpdate();
				scorecardUpdate(battingTeam);
			}
		}

		if (chase) {
			if (score == total)
				System.out.println("Match DRAW");
			else
				scorecardUpdate(bowlingTeam);
		}

		chase = true;
		total = score;

	}

	void scorecardUpdate() {

		System.out.println("_______________________________________________________________________________\n");
		System.out.println("S::");
		if (strikeRotated == false)
			System.out.printf("C::\t%3.3S %d/%d\t\t%s %d(%d)*\t%s %d(%d)\n", battingTeam.teamName, score, fallOfWickets,
					striker.playerName, striker.runsScored, striker.ballsPlayed, nonStriker.playerName,
					nonStriker.runsScored, nonStriker.ballsPlayed);
		else
			System.out.printf("C::\t%3.3S %d/%d\t\t%s %d(%d)*\t%s %d(%d)\n", battingTeam.teamName, score, fallOfWickets,
					nonStriker.playerName, nonStriker.runsScored, nonStriker.ballsPlayed, striker.playerName,
					striker.runsScored, striker.ballsPlayed);

		System.out.printf("O:: \t%3.3S %d.%d Overs \t\t%s %d-%d (%d.%d)\n", bowlingTeam.teamName, thisOver, balls,
				bowler.playerName, bowler.wicketsTaken, bowler.runsGiven, bowler.oversBowled, bowler.ballsBowled);

		if (chase == false && thisOver >= 1)
			System.out.printf("R::\t Run rate - current: %.2f\n", (float) score / (float) (thisOver));
		
		else if (thisOver >= 1)
			System.out.printf("R::\t Run rate - current: %.2f  required: %.2f\n", (float) score / (float) thisOver,
					(float) total - score / (float) noOfOvers - thisOver);
	
		else
			System.out.println("R:: ");

		if (chase == true)
			System.out.printf("E:: Total %d\t\t To win %d needed of %d balls.\n",total, total-score+1, (noOfOvers-thisOver)*6 + (6- balls));
		else
			System.out.println("E::");
		System.out.println("________________________________________________________________________________");

	}

	void scorecardUpdate(Team name) {
		System.out.println(name.teamName.toUpperCase() + " WON THE MATCH ");
	}

	void rotateStrike() {
		Player temp = striker;
		striker = nonStriker;
		nonStriker = temp;
		if (strikeRotated == false)
			strikeRotated = true;
		else
			strikeRotated = false;
	}

	void addRuns(int runs) {
		score += runs;
		striker.runsScored += runs;
		striker.ballsPlayed++;
		bowler.runsGiven += runs;
		if (runs == 1 || runs == 3)
			rotateStrike();
		else if (runs == 5) {
			System.out.println(" [0] Penalty [1] Overthrow ?");
			if (Scorecard.in.nextInt() == 1)
				rotateStrike();
		}
		balls++;
	}

	void removePlayer(int wicket) {
		balls++;
		if (fallOfWickets != 10 && wicket != 12 && wicket != 11) {
			striker.ballsPlayed++;
			striker.takenBy = bowler.playerName;
			striker = battingTeam.teamList.get(++nextBatsman);
			bowler.wicketsTaken++;
		}
		if (fallOfWickets != 10 && wicket == 12) {
			balls--;
			nonStriker.takenBy = bowler.playerName;
			nonStriker = battingTeam.teamList.get(++nextBatsman);
			bowler.wicketsTaken++;
		}
		if (fallOfWickets != 10 && wicket == 11) {
			System.out.print("[0] Striker out  [1] Non-striker out");
			int choice = Scorecard.in.nextInt();
			System.out.print("Runs >> ");
			int runs = Scorecard.in.nextInt();
			score += runs;
			striker.runsScored += runs;
			bowler.runsGiven += runs;
			striker.ballsPlayed++;
			System.out.println("Run-Out By");
			Team.displayPlayers(bowlingTeam.teamList);
			int field = Integer.parseInt(Scorecard.in.nextLine());
			if (choice == 0 && runs % 2 == 0) {
				striker.modeOfOut = 'R';
				striker.fieldedBy = battingTeam.teamList.get(field).playerName;
				striker = battingTeam.teamList.get(++nextBatsman);
			} else if (choice == 0) {
				striker.modeOfOut = 'R';
				striker.fieldedBy = battingTeam.teamList.get(field).playerName;
				striker = battingTeam.teamList.get(++nextBatsman);
				rotateStrike();
			} else if (runs % 2 == 0) {
				nonStriker.modeOfOut = 'R';
				nonStriker.fieldedBy = battingTeam.teamList.get(field).playerName;
				nonStriker = battingTeam.teamList.get(++nextBatsman);
			} else {
				nonStriker.modeOfOut = 'R';
				nonStriker.fieldedBy = battingTeam.teamList.get(field).playerName;
				nonStriker = battingTeam.teamList.get(++nextBatsman);
				rotateStrike();
			}

		}
		fallOfWickets++;
		if (fallOfWickets == 10)
			;
	}

	void caughtStumped() {
		if (striker.modeOfOut == 'C') {
			System.out.println("Caught by: ");
			int choice = 0;
			Team.displayPlayers(battingTeam.teamList);
			choice = Scorecard.in.nextInt();
			striker.fieldedBy = bowlingTeam.teamList.get(choice).playerName;
		} else if (striker.modeOfOut == 'S') {
			int choice = 0;
			for (Player player : bowlingTeam.teamList) {
				if (player.wicketKeeper) {
					striker.fieldedBy = bowlingTeam.teamList.get(choice++).playerName;
				}
			}
		}
	}

	void noBall() {
		score++;
		bowler.runsGiven++;

		System.out.println("Runs Scored in NO-BALL: ");
		int noBallRuns = Scorecard.in.nextInt();
		striker.runsScored += noBallRuns;
		score += noBallRuns;
		if (noBallRuns == 1 || noBallRuns == 3) {
			striker.ballsPlayed++;
			rotateStrike();
		} else if (noBallRuns != 0)
			striker.ballsPlayed++;
		freeHit();
		bowler.runsGiven += noBallRuns;
	}

	void freeHit() {
		System.out.print("Free-hit runs:[1-6] Runs [7] Wide  [8] No-Ball again");
		int freeHitRun = Scorecard.in.nextInt();
		if (freeHitRun == 7) {
			score++;
			bowler.runsGiven++;
			freeHit();
		} else if (freeHitRun == 8) {
			noBall();
		} else {
			score += freeHitRun;
			striker.runsScored += freeHitRun;
			striker.ballsPlayed++;
			bowler.runsGiven++;
			balls++;
		}
	}

}
