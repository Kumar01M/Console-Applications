package controller;

import java.util.Collections;

import model.ContactsModel;
import model.DatabaseConnection;
import model.LocalDatabase;
import view.ContactsView;

public class ContactsController {
	ContactsView contactsView;
	GroupsController groupsController;
	InputValidator in;
	DatabaseConnection connection;
	
	public ContactsController(ContactsView contactsView) {
		this.contactsView = contactsView;
		groupsController = new GroupsController();
		in = new InputValidator();
		connection = DatabaseConnection.getDB();
		connection.readContacts();
	}
	
	public void addContact() {
		ContactsModel contact = new ContactsModel();
		contact.setContactName(in.inputString("Enter contact name: "));
		contact.getPhoneNumbers().add(in.inputString("Enter contact number: "));
		while (contact.getPhoneNumbers().size() < 3) {
			System.out.println("add another number");
			if (in.inputInteger("(1) YES (2) NO") != 2) {
				contact.getPhoneNumbers().add(in.inputString("Enter Number: "));
			} else
				break;
		}
		contact.setContactEmail(in.inputString("Enter contact email: "));
		contact.setContactDOB(in.inputString("Enter contact DOB: "));
		contact.setFavourite(in.inputInteger("Set as Favorite (1) yes (2) no : "));
		contact.setGroupId(groupsController.chooseGroup());
		connection.createContact(contact);
	}

	public void viewContacts() {
		
		boolean menu = true;
		while(menu) {
			int choice = in.inputInteger("{1} Contacts {2} Groups {3} Favourites");
			switch (choice) {
			case 1:
				contactNamesList();
				break;
			case 2:
				
				break;
			case 3:
				break;
			default:
				menu = false;
				break;
			}
		}
				
		
				
	}
	
	public void contactNamesList() {
		int count = 0; 
		System.out.println("Nos.  Name");
		Collections.sort(LocalDatabase.getInstance().getContactNames());
		for (String name: LocalDatabase.getInstance().getContactNames())
			System.out.printf("%3d   %s\n",++count,name);
		System.out.println();
		int choice = in.inputInteger("Choose contact to the corresponding number: ");
		
		//showDetails(connection.readContact());
		
	}
	
	public void showDetails(ContactsModel contact) {
		
	}

}
