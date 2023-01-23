package view;

import controller.UserController;
import controller.Validator;

public class UserApp {
	UserController control;
	private static Validator scan;
	
	public UserApp() {
		control = new UserController();
		scan = new Validator();
	}
	
	public void init() {
		while (true) {
			control.showUsers();
			System.out.println("1.Add user 2.Modify user 3.Remove user 4.Select user 5.Exit ");
			int choice = scan.inputInteger();
			switch (choice) {
				case 1:
					control.addUser();
					break;
				case 2:
					if (control.modifyUser())
						System.out.println("user modified\n");
					break;
				case 3:
					control.removeUser();
					break;
				case 4:
					control.readUser();
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input\n");
			}
		}
	}
	
	public static void main(String[] args) {
		new UserApp().init();
	}

}