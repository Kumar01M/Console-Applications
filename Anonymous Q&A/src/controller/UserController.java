package controller;

import model.Database;
import model.UserModel;
import view.QuestionsFeed;
import view.UserView;

public class UserController {
	
	public void signInUser() {
		System.out.println("\t\tSIGN IN");
		UserModel obj = new UserModel();
		System.out.print("Username : ");
		obj.setUserName(UserView.in.nextLine());
		System.out.print("Email ID: ");
		obj.setEmail(UserView.in.nextLine());
		System.out.print("Password : ");
		obj.setPassword(UserView.in.nextLine());
		System.out.print("Date Of Birth : ");
		obj.setDateOfBirth(UserView.in.nextLine());		
		Database.getInstance().addIntoUserList(obj);
		System.out.println();
	}
	
	public void logInUser() {
		if(Database.getInstance().getUserList().size()==0) {
			signInUser();
		}
		else {
			System.out.println("\t\tLOG IN");
			System.out.print("Username: ");
			String username = UserView.in.nextLine();
			System.out.print("Password: ");
			String password = UserView.in.nextLine();
			if(logInController(username, password)) {
				System.out.println("\nLogin Successful...");
			new QuestionsFeed(username, password);
			}
			else {
				System.out.println("Invalid username or password.");
				logInUser();
			}
			}
		}
	
	public boolean logInController(String username, String password) {
		for(UserModel user:Database.getInstance().getUserList()) {
			return (user.getUserName().equals(username) && user.getPassword().equals(password));
	}
		return false;
	}	
	
}