package view;

import controller.TransactionsController;
import controller.Validator;
import model.AccountModel;
import model.BankDatabase;
import model.CustomerModel;

public class TransactionsView {
	Validator input;
	TransactionsController controller;
	BankDatabase db;
	
	public TransactionsView() {
		controller = new TransactionsController(this);
		input = Validator.getInstance();
		db = BankDatabase.getInstance();
	}
	
	public void transactionsMenu(CustomerModel customer, AccountModel account) {
		System.out.println("Welcome "+customer.getUsername()+ "\tAccount balance: " +account.getAccountBalance());
		while (true) {
			System.out.println("Select operation");
			int choice = input.inputChoice("\t{1} Withdraw Cash\n\t{2} Cash Deposit\n\t{3} Account to Account Transfer\n\t"
										 + "{4} Transaction History");
			switch(choice) {
			case 1:
				controller.withdrawCash(account);
				break;
			case 2:
				controller.depositCash(account);
				break;
			case 3:
				controller.transferMoney(account);
				break;
			case 4:
				controller.transactionHistory(account);
				break;
			default:
				System.exit(0);
			}
		}
	}
}
