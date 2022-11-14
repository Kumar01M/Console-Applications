package controller;

import java.util.Scanner;

public class Input {
	public final Scanner in = new Scanner(System.in);

	public int inputInteger() {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(in.nextLine());
				break;				
			} catch (Exception e) {
				System.out.println("Invalid Number!");
				System.out.println("Enter again: ");
			}
		}
		return value;
	}
	public String inputString() {
		String value = "";
		while(true) {
			try {
				value = in.nextLine();
				break;
			} catch(Exception e) {
				System.out.println("Invalid Value");
				System.out.println("Enter again: ");
			}
		}
		return value;
	}
}
