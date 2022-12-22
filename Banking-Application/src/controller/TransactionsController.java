package controller;

import model.AccountModel;
import model.BankDatabase;
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
		account.setAccountBalance(account.getAccountBalance() - amount);
		System.out.println("Cash withdrawal successful.\n");
		transaction = new TransactionModel("Withdraw", amount, account.getAccountBalance());
		account.getTransactionList().add(transaction);
		System.out.println("\n"+transaction);
	}

	public void depositCash(AccountModel account) {
		long amount = input.inputNumber("Enter deposit amount: ");
		account.setAccountBalance(account.getAccountBalance() + amount);
		System.out.println("Cash deposited successfully\n");
		transaction = new TransactionModel("Deposit", amount, account.getAccountBalance());
		account.getTransactionList().add(transaction);
		System.out.println(transaction);
	}

	public void transferMoney(AccountModel account) {
		long accountNumber = input.inputNumber("Enter recipient Account number: ");
		if (!data.getAccountsList().containsKey(accountNumber)) {
			System.out.println("Invalid Account Number - Try Again!\n");
			return;
		}
		AccountModel recipient = data.getAccountsList().get(accountNumber);
		long amount = input.inputNumber("Enter amount to transfer: ");
		if (account.getAccountBalance() - amount < 1000) {
			System.out.println("Transaction failed - Low Minimum balance.\n");
			return;
		}
		account.setAccountBalance(account.getAccountBalance() - amount);
		recipient.setAccountBalance(recipient.getAccountBalance() + amount);
		System.out.println("Transaction successful\n");
		transaction = new TransactionModel("Sent to " + recipient.getAccountNumber(), amount,
				account.getAccountBalance());
		account.getTransactionList().add(transaction);
		recipient.getTransactionList().add(new TransactionModel("Received from " + account.getAccountNumber(), amount,
				recipient.getAccountBalance(), transaction.getTransactionId()));
		System.out.println(transaction);
	}

	public void transactionHistory(AccountModel account) {
		if (account.getTransactionList() == null) {
			System.out.println("No transactions made.\n");
			return;
		}
		System.out.println();
		for (TransactionModel transaction : account.getTransactionList()) {
			System.out.println(transaction + "\n");
		}
	}

}
