package controller;

import model.AccountModel;
import model.BankDatabase;
import model.CustomerModel;
import view.TransactionsView;

public class AccountController {
	Validator input;
	CustomerModel customer;
	AccountModel account;
	BankDatabase data;
	TransactionsView transactionsView;

	public AccountController() {
		input = Validator.getInstance();
		data = BankDatabase.getInstance();
		transactionsView = new TransactionsView();
	}

	public CustomerModel addNewCustomer() {
		customer = new CustomerModel();
		customer.setUsername(input.inputString("Enter Customer Name: "));
		while (true) {
			String password = input.inputString("Enter Password: ");
			while (!input.validatePassword(password)) {
				System.out.println("Password must contain atleast 2 A-Z, 2 a-z & 2 Nums [length: 6-8])");
				password = input.inputString("Enter Password: ");
			}
			String confirmPassword = input.inputString("Enter Password again to confirm: ");
			if (input.confirmPassword(confirmPassword, password)) {
				customer.setPassword(input.encrypt(password));
				customer.getPreviousPasswords().add(customer.getPassword());
				break;
			} else {
				System.out.println("Password does not match enter again.");
			}
		}

		generateCredentials(customer);
		account = new AccountModel(customer.getCustomerId(), customer.getAccountNumber());
		data.getCustomersList().put(customer.getCustomerId(), customer);
		data.getAccountsList().put(account.getAccountNumber(), account);
		account.setAccountBalance(10000);
		System.out.println("\nCustomer Added Succesfully and initial amount of 10,000₹ deposited");
		return customer;
	}

	public void generateCredentials(CustomerModel customer) {
		customer.setAccountNumber(2022100 + data.getCustomersList().size() + 1);
		customer.setCustomerId(100 + data.getCustomersList().size() + 1);
	}

	public void userLogin() {
		Long customerId = input.inputNumber("Enter Customer ID: ");
		String password = input.inputString("Enter Password: ");
		if (authenticateUser(customerId, input.encrypt(password))) {
			System.out.println();
			CustomerModel customer = data.getCustomersList().get(customerId);
			transactionsView.transactionsMenu(customer, data.getAccountsList().get(customer.getAccountNumber()));
		} else
			System.out.println("Invalid username and password! try again...");
	}

	public boolean authenticateUser(Long customerId, String password) {
		if (data.getCustomersList().containsKey(customerId)
				&& data.getCustomersList().get(customerId).getPassword().equals(password))
			return true;
		return false;
	}

}
