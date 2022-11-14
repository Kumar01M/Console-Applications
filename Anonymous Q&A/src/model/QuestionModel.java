package model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class QuestionModel {
	private String question;
	public static int qId;
	private int qNo;
	private ArrayList<String> answers = new ArrayList<>();;
	private String timeAndDate;
	private int like;
	private LocalDateTime dtObj = LocalDateTime.now();
	private DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("dd-MMM HH:mm");

	public QuestionModel() {
		setTimeAndDate();
		setqNo();
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate() {
		timeAndDate = dtObj.format(formatObj);
	}
	public int getLike() {
		return like;
	}
	public void addLike() {
		this.like += 1;
	}
	public static int getqId() {
		return qId;
	}
	public int getqNo() {
		return qNo;
	}
	public void setqNo() {
		this.qNo = qId++;
	}

	//answers 
	public ArrayList<String> getAnswers() {
		return answers;
	}
}