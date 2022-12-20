package controller;

import model.AccountModel;
import model.BankDatabase;
import model.TransactionModel;
import view.TransactionsView;

public class TransactionsController {
	TransactionsView view;
	Validator input;
	BankDatabase data;
	
	public TransactionsController(TransactionsView view) {
		input = Validator.getInstance();
		this.view = view;
		data = BankDatabase.getInstance();
	}
	
	public void withdrawCash(AccountModel account) {
		long amount = input.inputNumber("Enter withdraw amount: ");
		if (account.getAccountBalance() - amount < 1000) {
			System.out.println("Transaction failed - Low Minimum balance.");
		}
		else {
			account.setAccountBalance(account.getAccountBalance() - amount);
			System.out.println("Cash withdrawal successful.");
			account.getTransactionList().add(new TransactionModel("Withdraw" , amount, account.getAccountBalance()));
		}
	}
	
	public void depositCash(AccountModel account) {
		long amount = input.inputNumber("Enter deposit amount: ");
		account.setAccountBalance(account.getAccountBalance() + amount);
		System.out.println("Cash deposited successfully");
		account.getTransactionList().add(new TransactionModel("Deposit" , amount, account.getAccountBalance()));
	}
	
	public void transferMoney(AccountModel account) {
		long accountNumber = input.inputNumber("Enter recipient Account number: ");
		if (data.getAccountsList().containsKey(accountNumber)) {
			AccountModel recipient = data.getAccountsList().get(accountNumber);
			long amount = input.inputNumber("Enter amount");
			if (account.getAccountBalance() - amount < 1000) {
				System.out.println("Transaction failed - Low Minimum balance.");
			}
			else {
				account.setAccountBalance(account.getAccountBalance() - amount);
				recipient.setAccountBalance(recipient.getAccountBalance() + amount);
				System.out.println("Transaction successful");
				TransactionModel obj = new TransactionModel("Sent to "+ recipient.getAccountNumber() , amount, account.getAccountBalance());
				account.getTransactionList().add(obj);
				recipient.getTransactionList().add(new TransactionModel("Received from "+ account.getAccountNumber(), amount, 
				recipient.getAccountBalance(), obj.getTransactionId()));
			}
			
		}
		else {
			System.out.println("Invalid Account Number - Try Again!");
		}
	}
	
	public void transactionHistory(AccountModel account) {
		if (account.getTransactionList() != null) {
			System.out.println();
			for (TransactionModel transaction: account.getTransactionList()) {
				System.out.println(transaction.toString() + "\n");
			}
		}
		
	}

}
