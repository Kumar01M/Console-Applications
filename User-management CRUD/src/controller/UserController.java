package controller;

import java.util.List;
import java.util.Scanner;

import model.User;
import model.UserDAO;

public class UserController {
	private static UserDAO access;
	private static Validator scan;
	private static Scanner in;
	
	public UserController() {
		access = new UserDAO();
		in = new Scanner(System.in);
		scan = new Validator();
	}
	
	public void showUsers() {
		List<User> usersList = access.selectAllUsers();
		if (usersList.size() == 0) {
			System.out.println("No users");
			return;
		}
		System.out.printf("%-3s|%-25s|%-30s|%s\n\n", "Id", "Name", "Email", "Country");
		for (User user: usersList)
			System.out.printf("%-3d|%-25s|%-30s|%s\n", user.getId(), user.getName(), user.getEmail(), user.getCountry());
		System.out.println();
	}
	
	public void addUser() {
		System.out.print("Enter user name: ");
		String name = in.nextLine();
		System.out.print("Enter user email: ");
		String email = in.nextLine();
		System.out.print("Enter user country: ");
		String country = in.nextLine();
		if (access.addNewUser(new User(name, email, country)))
			System.out.println("\n*new user added\n");
		else 
			System.out.println("\n*operation failed\n");
	}
	
	public void readUser() {
		System.out.print("Enter user id: ");
		User selectedUser = access.getUser(scan.inputInteger());
		if (selectedUser.getId() == 0) {
			System.out.println("\n*Invalid id\n");
			return;
		}
		System.out.println("\n*requested user\n Name: "+ selectedUser.getName() + "\n Email: " + selectedUser.getEmail()
		+"\n Country: "+ selectedUser.getCountry() +"\n");
	}
	
	public boolean modifyUser() {
		System.out.print("Enter the user id to be modified: ");
		int id = scan.inputInteger();
		System.out.print("Enter the field to be modified 1.Name 2.Email 3.Country: ");
		int choice = scan.inputInteger();
		System.out.print("Enter the Modification: ");
		String modifiedValue = in.nextLine();
		switch (choice) {
			case 1:
				access.modifyUser(id, "name", modifiedValue);
				break;
			case 2:
				access.modifyUser(id, "email", modifiedValue);
				break;
			case 3:
				access.modifyUser(id, "country", modifiedValue);
				break;
			default:
				System.out.println("\n*Invalid choice\n");
				return false;				
		}
		return true;
	}
	
	public void removeUser() {
		System.out.print("Enter the user id to be removed: ");
		if(access.removeUser(scan.inputInteger()))
			System.out.println("\n*user removed\n");
		else
			System.out.println("\n*Invalid id\n");
	}

}
