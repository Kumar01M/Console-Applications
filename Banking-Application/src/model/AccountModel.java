package model;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {

	private long customerId, accountNumber, accountBalance;
	private List<TransactionModel> transactionList; 

	public AccountModel(long customerId, long accountNumber) {
		this.customerId = customerId;
		this.accountNumber = accountNumber;
		accountBalance = 10000;
		transactionList = new ArrayList<>();
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<TransactionModel> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<TransactionModel> transactionList) {
		this.transactionList = transactionList;
	}
	
	

}
