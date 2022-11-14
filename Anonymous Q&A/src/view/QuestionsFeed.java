package view;

import controller.Validate;
import model.Database;
import model.QuestionModel;
import model.UserModel;

public class QuestionsFeed {
	UserModel user;
	
	public void menu(UserModel user) {
		this.user = user;
		boolean logOut = false;
		while (!logOut) {
			System.out.printf("\n Questions Feed-[%s]-?", user.getUserName());
			System.out.println("\n\t[1] View Question posts\n\t[2] Add Questions\n\t[3] Remove Questions\n\t[4] Log out\n");
			int choice = Validate.validateInteger();
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
				System.out.println(" Invalid input");
			}
		}

	}

	public void addQuestions() {
		boolean add = true;
		while(add) {
			System.out.println(" Add Your Question Here :)");
			Database.getInstance().getQuestionList().add(new QuestionModel());
			QuestionModel var = Database.getInstance().getQuestionList().get(QuestionModel.qId -1);
			user.getqNo().add(var.getqNo());
			var.setQuestion(Validate.inputMultipleLines());
			System.out.println(" Question Added Successfully..., add Other One?");
			System.out.println("Add [0] Back[1]");
			if(Validate.validateInteger()==0);
			else add = false;
		}
	}

	public void removeQuestions() {

	}

	public void viewQuestions() {
		if (Database.getInstance().getQuestionList().size() == 0) {
			System.out.println(" No Questions Available.");
		} else if (user.getAtQuestion() < 0) {
			System.out.println("\t\tEND OF QUESTIONS >>>");
			user.setAtQuestion(1);
			viewQuestions();
		} else if (user.getAtQuestion() > Database.getInstance().getQuestionList().size()-1) {
			System.out.println("\t\t<<< END OF QUESTIONS");
			user.setAtQuestion(-1);
			viewQuestions();
		} else {
			boolean quit = false;
			while (!quit) {
				QuestionModel quest = Database.getInstance().getQuestionList().get(user.getAtQuestion());
				System.out.println("\t\tQUESTION.");
				System.out.println(" Q>> "+quest.getQuestion());
				System.out.print(" posted on " + quest.getTimeAndDate().substring(0, 7) + " @ "
						+ quest.getTimeAndDate().substring(7, 12));
				System.out.printf(" %d Likes   %d Answers. ", quest.getLike(), quest.getAnswers().size());
				System.out.println("\n");
				System.out.println("<<[0]Previous                          [1]Next>>");
				System.out.println("");
				System.out.println("\t[2]Like [3]Answer [4]View  back[5] \n");
				System.out.print(">> ");
				int choice = Validate.validateInteger();
				switch (choice) {
				case 0:
					user.setAtQuestion(-1);
					viewQuestions();
					break;
				case 1:
					user.setAtQuestion(1);
					viewQuestions();
					break;
				case 2:
					quest.addLike();
					break;
				case 3:
					answerQuestion(quest);
					break;
				case 4:
					displayAnswers(quest);
					break;
				case 5:
					quit = true;
				}
			}
		}
	}

	public void answerQuestion(QuestionModel quest) {
		System.out.println(" Give your answer here: ");
		quest.getAnswers().add(Validate.inputMultipleLines());
		System.out.println(" Answer added successfully.");
	}

	public void displayAnswers(QuestionModel quest) {
		if (quest.getAnswers().size() == 0)
			System.out.println(" No Answers found.");
		else {
			for (String answer : quest.getAnswers())
				System.out.println(" $ " + answer);
		}
	}
}
