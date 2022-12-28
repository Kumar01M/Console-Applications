package model;

import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

	private String username, password;
	private long accountNumber, customerId;
	private String phoneNumber, emailId, dateOfBirth;
	private List<String> previousPasswords;
	
	public CustomerModel () {
		setPreviousPasswords(new ArrayList<>());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String toString() {
		return "\n\tACCOUNT STATEMENT \n" + "\tName      - " + this.username + "\n" + "\tAccount No  - "
				+ this.accountNumber + "\n" + "\tCustomer Id - " + this.customerId + "\n";
	}

	public List<String> getPreviousPasswords() {
		return previousPasswords;
	}

	public void setPreviousPasswords(List<String> previousPasswords) {
		this.previousPasswords = previousPasswords;
	}
	
	

}
