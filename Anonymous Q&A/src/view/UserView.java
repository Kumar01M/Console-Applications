package view;

import java.util.Scanner;

import controller.UserController;
import controller.Validate;

public class UserView {
	
	public static Scanner in = new Scanner(System.in);
	private UserController userController;
	
	private UserView(){
		userController = new UserController();
	}
	
	public void init() {
		int choice = 0;
		while(choice!=3) {
			System.out.println("Welcome to Anonymous Q&A Platform...\nAsk your Questions...");
			System.out.println("\t[1] Login");
			System.out.println("\t[2] Signin");
			System.out.println("\t[3] Exit");
			System.out.println("------------------------------------------");
			choice = Validate.validateInteger();
			if(choice == 1)
				userController.logInUser();
			else if(choice==2) userController.signInUser();
			else {
				System.out.println("Thank you for using AnOneMyUs Q&A.");
			}
		}
			
	}

	public static void main(String[] args) {
		UserView start = new UserView();
		start.init();
	}

}
