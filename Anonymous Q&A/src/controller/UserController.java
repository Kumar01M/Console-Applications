package controller;

import model.Database;
import model.UserModel;
import view.QuestionsFeed;

public class UserController {
	QuestionsFeed feedObj = new QuestionsFeed();
	
	public void signUpUser() {
		System.out.println("\t\tSIGN UP");
		UserModel obj = new UserModel();
		System.out.print(" Username : ");
		obj.setUserName(Validate.validateName());
		System.out.print(" Email ID: ");
		obj.setEmail(Validate.validateEmail());
		System.out.print(" Password : ");
		obj.setPassword(Validate.validatePassword());
		System.out.print(" Date Of Birth : ");
		obj.setDateOfBirth(Validate.validateDOB());		
		Database.getInstance().addIntoUserList(obj);
		System.out.println(" Sign Up Complete\n");
	}
	
	public void logInUser() {
		if(Database.getInstance().getUserList().size()==0) {
			signUpUser();
		}
		else {
			System.out.println("\t\tLOG IN");
			System.out.print(" Username: ");
			String username = Validate.validateName();
			System.out.print(" Password: ");
			String password = Validate.validatePassword();
			UserModel user = logInController(username, password);
			if(user!=null) {
				System.out.println("\n Login Successful...");
				feedObj.menu(user);
			}
			else {
				System.out.println(" Invalid username or password.");
				System.out.println(" Do you want to try again? [0] yes [1] no");
				if(Validate.validateInteger()==0)
					logInUser();
			}
			}
		}
	
	public UserModel logInController(String username, String password) {
		for(UserModel user:Database.getInstance().getUserList()) {
			if(user.getUserName().equals(username) && user.getPassword().equals(password))
				return user;
	}
	return null;
	}	
	
}