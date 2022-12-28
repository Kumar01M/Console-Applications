package controller;

import java.util.Scanner;

public class Validator {
	Scanner in;
	private static Validator validator;
	
	private Validator() {
		in = new Scanner(System.in);
	}
	
	public static Validator getInstance() {
		if(validator == null) {
			validator = new Validator();
		}
		return validator;
	}
	
	public int inputChoice(String query) {
		System.out.print(query);
		int val = 0;
		while (true) {
			try {
				val = Integer.parseInt(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid input !");
				System.out.print(query);
			}
		}
		return val;
	}
	
	public long inputNumber(String query) {
		System.out.print(query);
		long val = 0;
		while (true) {
			try {
				val = Long.parseLong(in.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Invalid input !");
				System.out.print(query);
			}
		}
		return val;
	}
	
	public String inputString(String query) {
		System.out.print(query);
		String val = "";
		while(true) {
			try {
				val = in.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("Invalid input !");
				System.out.print(query);
			}
		}
		return val;
	}
	
	public boolean validatePassword(String password) {
		return password.matches("^(?=.*[0-9]{2})(?=.*[a-z]{2})(?=.*[A-Z]{2}).{6,8}$");
	}
	
	public boolean validateName(String name) {
		return name.length() >= 5;
	}
	
	public boolean confirmPassword(String confirmPassword, String password) {
		return confirmPassword.equals(password);
	}
	
	public String encrypt(String plaintext) {
		String cipher = "";
		for (char ch: plaintext.toCharArray()) {
			if(ch >= 'A' && ch <= 'Z') {
				ch %= 64;
				cipher += (char) ((ch % 26) + 65);
			}
			else if(ch >= 'a' && ch <= 'z') {
				ch %= 96;
				cipher += (char) ((ch % 26) + 97);
			}
			else if(ch >= '0' && ch <= '9'){
				ch %= 47;
				cipher += (char) ((ch % 10) + 48);
			}
			else
				cipher += ch;
		}
		return cipher;
	}

}
