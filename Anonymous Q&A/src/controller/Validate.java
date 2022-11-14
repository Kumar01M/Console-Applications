package controller;

import java.util.regex.Pattern;

import view.UserView;

public class Validate {
	public static int validateInteger() {
		int value = 0;
		boolean handled = false;
		while(!handled){
			try {
				value = Integer.parseInt(UserView.in.nextLine());
				handled = true;
			}
			catch(Exception e) {
				System.out.print("Enter valid integer: ");
			}
		}
		return value;
	}
	
	public static String inputMultipleLines() {
		String s = "";
		int line = 0;
		System.out.println("-------------------------------------------5LINES");
		while(line<5){
			s += UserView.in.nextLine();
			s += " ";
			++line;
		}
		System.out.println("-------------------------------------------------");
		return s;
	}
	
	public static String validateEmail() {
		boolean match = false;
		String email = "";
		while(!match) {
			email = UserView.in.nextLine();
			if(Pattern.matches("^(.+)@(.+)$", email)) {
				break;
			}
			System.out.println("Enter valid Email Address.");
		}
		return email;
	}
	
	public static String validateName() {
		boolean match = false;
		String name = "";
		while(!match) {
			name = UserView.in.nextLine();
			if(Pattern.matches("\\w{5,25}", name)) {
				break;
			}
			System.out.println("Enter valid name :");
		}
		return name;
	}
	
	public static String validatePassword() {
		String password = "";
		while(!false) {
			password = UserView.in.nextLine();
			if(Pattern.matches("\\w{8,16}", password)) {
				break;
			}
			System.out.println("Enter valid password : (8 characters)");
		}
		return password;
	}
	
	public static String validateDOB() {
		String dob = "";
		while(!false) {
			dob = UserView.in.nextLine();
			if(Pattern.matches("(?:0[1-9]|[12][0-9]|3[01])[-/.](?:0[1-9]|1[012])[-/.](?:19\\d{2}|20[01][0-9]|2020)\\b", dob)) {
				break;
			}
			System.out.println("Enter Date Of Birth in proper format : [DD:MM:YYYY]");
		}
		return dob;
	}
}
