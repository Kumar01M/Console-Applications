package manage;
import java.util.Scanner;

public class Main {
	public final static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("\t\t\tSCORECARD MANAGER");
		Game start = new Game();
		start.toss();
	}

}
