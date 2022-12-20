package view;

import controller.ContactsController;
import controller.GroupsController;
import controller.InputValidator;

public class ContactsView {
	ContactsController contactsControl;
	GroupsController groupsController;
	InputValidator in;
	
	public ContactsView() {
		contactsControl = new ContactsController(this);
		groupsController  = new GroupsController();
		in = new InputValidator();	
	}
	
	public void menu() {
		while (true) {
			int check = in.inputInteger("{1} Add Contacts {2} Contacts List\n");
			if (check == 1) {
				contactsControl.addContact();
			}
			else if (check == 2) {
				contactsControl.viewContacts();
				
			}
			else
				break;
			
		}
		
	}

	public static void main(String[] args) {
		ContactsView run = new ContactsView();
		run.menu();
	}

}
