package controller;

import java.util.Scanner;

public class InputValidator {
	Scanner in;
	int num;
	long longNum;
	String str;
	
	public InputValidator() {
		in = new Scanner(System.in);
	}
	
	public int inputInteger(String query) {
		System.out.print(query);
		while(true) {
			try {
				num = Integer.parseInt(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid Input..!");
				System.out.print(query);
			}
		}
		return num;
	}
	
	public long inputLong(String query) {
		System.out.print(query);
		while (true) {
			try {
				longNum = Long.parseLong(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid Input..!");
				System.out.print(query);
			}
		}
		return longNum;
	}
	
	public String inputString(String query) {
		System.out.print(query);
		while (true) {
			try {
				str = in.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("Invalid Input..!");
				System.out.println(query);
			}
		}
		return str;
	}	

}
