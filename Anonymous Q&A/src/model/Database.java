package model;

import java.util.ArrayList;

public class Database {
	
	private static Database qaDb;
	private  ArrayList<UserModel> userList;
	private ArrayList<QuestionModel> questionList;
	
	Database() {
		userList = new ArrayList<>();
		questionList = new ArrayList<>();
	}
	
	public static Database getInstance() {
		if(qaDb==null) {
			qaDb = new Database();
		}
		return qaDb;
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
	
	public int getQuestionListSize() {
		return questionList.size();
	}
	
	public QuestionModel getQuesFromList(int index) {
		return questionList.get(index);
	}
	
	public void addIntoQuestionList(QuestionModel Question) {
		questionList.add(Question);
	}
	
}
