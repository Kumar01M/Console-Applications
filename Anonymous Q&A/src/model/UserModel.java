package model;

import java.util.ArrayList;

public class UserModel {
	private String userName;
	private String password;
	private String dateOfBirth;
	private String email;
	private ArrayList<Integer> qNo = new ArrayList<>();
	private int atQuestion;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String date) {
		this.dateOfBirth = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAtQuestion(int n) {
		this.atQuestion+=n;
	}
	public int getAtQuestion() {
		return atQuestion;
	}
	public ArrayList<Integer> getqNo() {
		return qNo;
	}
	public void setqNo(ArrayList<Integer> qNo) {
		this.qNo = qNo;
	}
}
