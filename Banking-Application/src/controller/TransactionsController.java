package controller;

import model.AccountModel;
import model.BankDatabase;
import model.CustomerModel;
import model.TransactionModel;
import view.TransactionsView;

public class TransactionsController {
	TransactionsView view;
	Validator input;
	BankDatabase data;
	TransactionModel transaction;

	public TransactionsController(TransactionsView view) {
		input = Validator.getInstance();
		this.view = view;
		data = BankDatabase.getInstance();
	}

	public void withdrawCash(AccountModel account) {
		long amount = input.inputNumber("Enter withdraw amount: ");
		if (account.getAccountBalance() - amount < 1000) {
			System.out.println("Transaction failed - Low Minimum balance.\n");
			return;
		}
		deduct(account, amount);
		System.out.println("Cash withdrawal successful.\n");
		transaction = new TransactionModel("Withdraw", amount, account.getAccountBalance());
		account.getTransactionList().add(transaction);
		System.out.println("\n"+transaction);
		mandatoryCheck(account);
	}

	public boolean depositCash(AccountModel account) {
		long amount = input.inputNumber("Enter deposit amount: ");
		addition(account, amount);
		transaction = new TransactionModel("Deposit", amount, account.getAccountBalance());
		account.getTransactionList().add(transaction);
		System.out.println("\n"+transaction);
		mandatoryCheck(account);
		return true;
	}

	public void transferMoney(AccountModel account) {
		long accountNumber = input.inputNumber("Enter recipient Account number: ");
		AccountModel recipient = data.getAccountsList().get(accountNumber);
		if (!data.getAccountsList().containsKey(accountNumber)) {
			System.out.println("Invalid Account Number - Try Again!\n");
			return;
		}
		long amount = input.inputNumber("Enter amount to transfer: ");
		
		if (account.getAccountBalance() - amount < 1000) {
			System.out.println("Transaction failed - Low Minimum balance.\n");
			return;
		}
		deduct(account, amount);
		addition(recipient, amount);
		System.out.println("Transaction successful\n");
		transaction = new TransactionModel("Sent to " + recipient.getAccountNumber(), amount,
				account.getAccountBalance());
		account.getTransactionList().add(transaction);
		recipient.getTransactionList().add(new TransactionModel("Received from " + account.getAccountNumber(), amount,
				recipient.getAccountBalance(), transaction.getTransactionId()));
		System.out.println(transaction);
		mandatoryCheck(account);
	}

	public void transactionHistory(AccountModel account) {
		System.out.println();
		if (account.getTransactionList().size() == 0) {
			System.out.println("\nNo transactions made.\n");
			return;
		}

		for (TransactionModel transaction : account.getTransactionList()) {
			System.out.println(transaction + "\n");
		}
	}
	
	public void deduct(AccountModel account, long amount) {
		account.setAccountBalance(account.getAccountBalance() - amount);
	}
	
	public void addition(AccountModel account, long amount) {
		account.setAccountBalance(account.getAccountBalance() + amount);
	}
	
	public void mandatoryCheck(AccountModel account) {
		if (account.getTransactionList().size() % 10 != 0) {
			return;
		}
		deduct(account, 100);
		System.out.println("\n Maintenance fee of ₹100 have been charged.");
		System.out.println("\n It is mandatory to change password for every 10 transactions.\n");
		changePassword(account);
	}
	
	public void changePassword(AccountModel account) {
		CustomerModel customer = data.getCustomersList().get(account.getCustomerId());
		while (true) {
			String password = input.inputString("\nEnter New Password: ");
			
			while (!input.validatePassword(password)) {
				System.out.println("Password must contain atleast 2 A-Z, 2 a-z & 2 Nums [length: 6-8])");
				password = input.inputString("Enter Password: ");
			}
			if (customer.getPreviousPasswords().contains(input.encrypt(password))) {
				System.out.println("\nyou have given your old password again...\n"
						+ "Try again with a new Password");
				continue;
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
		if (customer.getPreviousPasswords().size() > 3) {
			customer.getPreviousPasswords().remove(0);
			System.out.println(customer.getPreviousPasswords());
		}
		System.out.println("your password has been changed successfully.");
	}

}
