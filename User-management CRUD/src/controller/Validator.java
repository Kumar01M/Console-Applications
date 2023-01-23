package controller;

import java.util.Scanner;

public class Validator {
	Scanner in;
	
	public Validator() {
		in = new Scanner(System.in);
	}
	
	public int inputInteger() {
		int val = 0;
		while (true) {
			try {
				val = Integer.parseInt(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.print("\n*invalid input, enter valid number\n>>");
			}
		}
		return val;
	}

}
