package view;

import controller.Validate;
import model.Database;
import model.QuestionModel;
import model.UserModel;

public class QuestionsFeed {
	UserModel user;
	public QuestionsFeed(String username, String password) {
		user = Database.getInstance().getFromUserList(username, password); 
		menu();
	}

	public void menu() {
		boolean logOut = false;
		while (!logOut) {
			System.out.printf("\nQuestions Feed-[%s]-?",user.getUserName());
			System.out.println("\n[1] View Question posts\n[2] Add Questions\n[3] Remove Questions\n[4] Log out\n");
			int choice = UserView.in.nextInt();
			switch (choice) {
			case 1:
				viewQuestions();
				break;
			case 2:
				addQuestions();
				break;
			case 3:
				removeQuestions();
				break;
			case 4:
				logOut = true;
				break;
			default:
				System.out.println("Invalid input");
			}
		}

	}

	public void addQuestions() {
		System.out.println("Add Your Question Here :)");
		Database.getInstance().addIntoQuestionList(new QuestionModel());
		QuestionModel var = Database.getInstance().getQuesFromList(QuestionModel.qId);
		var.setQuestion(Validate.inputMultipleLines());
		System.out.println("Question Added Successfully...");
	}

	public void removeQuestions() {
		
	}

	public void viewQuestions() {
		if(Database.getInstance().getQuestionListSize()==0) {
			System.out.println("No Questions Availabale.");
		}
		else if(user.getAtQuestion()<0) {
			System.out.println("\t\tEnd Of Questions >>");
			user.setAtQuestion(1);
		}
		else if(user.getAtQuestion()>Database.getInstance().getQuestionListSize()) {
			System.out.println("\t\t<< End of Questions");
			user.setAtQuestion(-1);
		}
		else {
			QuestionModel var = Database.getInstance().getQuesFromList(user.getAtQuestion());
			System.out.println(var.getQuestion());
			System.out.println("posted on " + var.getTimeAndDate().substring(0,7)+"at "+var.getTimeAndDate().substring(7,12));
			System.out.println("-------------------------------------------------");
			System.out.println("<< Previous[0]\t\t\t\t[1]Next >>");
			System.out.println("-------------------------------------------------");
		}
		
	}

}
