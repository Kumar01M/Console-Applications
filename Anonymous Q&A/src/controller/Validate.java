package controller;

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
				System.out.print("->");
			}
		}
		return value;
	}
	
	public static String inputMultipleLines() {
		String s = "";
		int line = 0;
		while(line<5){
			s += UserView.in.nextLine();
			s += " ";
			++line;
		}
		return s;
	}
}
