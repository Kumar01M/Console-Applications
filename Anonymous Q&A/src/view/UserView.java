package view;

import java.util.Scanner;

import controller.AdminController;
import controller.UserController;
import controller.Validate;

public class UserView {
	public static Scanner in = new Scanner(System.in);
	private UserController userController;
	private AdminController adminController;
	
	
	private UserView(){
		adminController = new AdminController();
		userController = new UserController();
	}
	
	public void init() {
		int choice = 0;
		System.out.println("   Welcome to Anonymous Q&A Platform...\nAsk your Questions...");
		while(choice!=4) {
			System.out.println("\t[1] Login\n\t[2] Signup\n\t[3] ADMIN\n\t[4] Exit");
			System.out.println("------------------------------------------");
			choice = Validate.validateInteger();
			if(choice == 1)
				userController.logInUser();
			else if(choice==2) userController.signUpUser();
			else if(choice==3) adminController.logIn();
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
