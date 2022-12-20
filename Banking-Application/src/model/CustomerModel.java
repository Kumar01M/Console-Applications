package model;

public class CustomerModel {
	
	private String username, password;
	private long accountNumber, customerId;	
	private String phoneNumber, emailId, dateOfBirth;
	private int passwordChangeHist;
	
	
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
	public int getPasswordChangeHist() {
		return passwordChangeHist;
	}
	public void setPasswordChangeHist(int passwordChangeHist) {
		this.passwordChangeHist = passwordChangeHist;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return "\n\t\tACCOUNT STATEMENT \n"
				+  "\t      Name - "+this.username+"\n"
				+"\t  Account No - "+this.accountNumber+"\n"
				+"\t Customer Id - "+this.customerId+"\n";
	}
	
	
}
