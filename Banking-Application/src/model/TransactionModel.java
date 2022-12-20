package model;

public class TransactionModel {
	private Long customerId, amount, balance;
	private int transactionId;
	private String transactionType;
	private static int transaction;
	
	public TransactionModel(String transactionType, Long amount, Long balance) {
		transactionId = ++transaction;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}
	
	public TransactionModel(String transactionType, Long amount, Long balance, int transactionId) {
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public String toString() {
		return "Transaction no: "+ this.transactionId + "\nType: "+ this.transactionType +"\nAmount: "
				+ this.amount +"\nBalance: "+ this.balance;
	}

}
