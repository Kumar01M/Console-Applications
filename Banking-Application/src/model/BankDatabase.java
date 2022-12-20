package model;

import java.util.HashMap;
import java.util.Map;

public class BankDatabase {

	public static BankDatabase database;
	private Map<Long, CustomerModel> customersList;
	private Map<Long, AccountModel> accountsList;

	private BankDatabase() {
		setCustomersList(new HashMap<>());
		setAccountsList(new HashMap<>());
	}

	public static BankDatabase getInstance() {
		if (database == null) {
			database = new BankDatabase();
		}
		return database;
	}

	public Map<Long, CustomerModel> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(Map<Long, CustomerModel> customersList) {
		this.customersList = customersList;
	}

	public Map<Long, AccountModel> getAccountsList() {
		return accountsList;
	}

	public void setAccountsList(Map<Long, AccountModel> accountsList) {
		this.accountsList = accountsList;
	}

}