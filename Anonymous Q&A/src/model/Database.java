package model;

import java.util.ArrayList;

public class Database {
	
	private static Database questionAndAnswerDB;
	private  ArrayList<UserModel> userList;
	private ArrayList<QuestionModel> questionList;
	
	Database() {
		userList = new ArrayList<>();
		questionList = new ArrayList<>();
	}
	
	public static Database getInstance() {
		if(questionAndAnswerDB==null) {
			questionAndAnswerDB = new Database();
		}
		return questionAndAnswerDB;
	}
	
	public ArrayList<UserModel> getUserList() {
		return userList;
	}
	
	public void addIntoUserList(UserModel user) {
		userList.add(user);
	}
	
	public UserModel getFromUserList(String username, String password) {
		for(UserModel user:userList) {
			if(user.getUserName().equals(username)&&user.getPassword().equals(password));
				return user;
		}
		return null;
	}
	
	public ArrayList<QuestionModel> getQuestionList() {
		return questionList;
	}	
	
}
