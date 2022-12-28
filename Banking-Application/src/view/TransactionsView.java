package view;

import controller.TransactionsController;
import controller.Validator;
import model.AccountModel;
import model.CustomerModel;

public class TransactionsView {
	Validator input;
	TransactionsController transactionsController;

	public TransactionsView() {
		transactionsController = new TransactionsController(this);
		input = Validator.getInstance();
	}

	public void transactionsMenu(CustomerModel customer, AccountModel account) {
		System.out.println("\nWelcome " + customer.getUsername() + "\tAccount balance: " + account.getAccountBalance());
		while (true) {
			System.out.println("Select operation");
			int choice = input
					.inputChoice("\t{1} Withdraw Cash\n\t{2} Cash Deposit\n\t{3} Account to Account Transfer\n\t"
							+ "{4} Transaction History\n\t"
							+ "{5} Change Password \n\t{6} Log out \n\t{7} Exit \n>>");
			
			switch (choice) {
			case 1:
				transactionsController.withdrawCash(account);
				break;
			case 2:
				if (transactionsController.depositCash(account));
					System.out.println("Cash deposited successfully");
				break;
			case 3:
				transactionsController.transferMoney(account);
				break;
			case 4:
				transactionsController.transactionHistory(account);
				break;
			case 5:
				transactionsController.changePassword(account);
				break;
			case 6:
				System.out.println("Logging out...\n");
				return;
			case 7:
				System.out.println("Thank you for banking with us.");
				System.exit(0);
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}
}
