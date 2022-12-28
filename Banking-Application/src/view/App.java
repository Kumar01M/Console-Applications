package view;

import controller.AccountController;
import controller.Validator;
import model.CustomerModel;

public class App {
	
	public Validator input;
	AccountController accountsController;
	TransactionsView transactionsView;
	CustomerModel customer;
	
	public App() {
		input = Validator.getInstance();
		accountsController = new AccountController();
		transactionsView = new TransactionsView();
	}
	
	public void init() {
		System.out.println("Online Banking Application");
		while(true) {
			System.out.println("{1} Add Customer {2} Make Transactions {3} Exit");
			int choice = input.inputChoice(">> ");
			System.out.println();
			switch (choice) {
			case 1:
				customer = accountsController.addNewCustomer();
				System.out.println(customer.toString());
				break;
			case 2:
				accountsController.userLogin();
				break;
			case 3:
				System.out.println("Thank you for banking with us.");
				System.exit(0);
			default:
				System.out.println("Invalid input, enter valid choice");
			}
		}
	}


}
