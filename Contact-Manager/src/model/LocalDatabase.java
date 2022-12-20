package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDatabase {
	
	private static LocalDatabase database;
	private Map<Integer, ContactsModel> contacts;
	private List<String> contactNames;

	private LocalDatabase() {
		setContacts(new HashMap<>());
		setContactNames(new ArrayList<>());
	}

	public static LocalDatabase getInstance() {
		if (database == null) {
			database = new LocalDatabase();
		}
		return database;
	}

	public Map<Integer, ContactsModel> getContacts() {
		return contacts;
	}

	public void setContacts(Map<Integer, ContactsModel> contacts) {
		this.contacts = contacts;
	}

	public List<String> getContactNames() {
		return contactNames;
	}

	public void setContactNames(List<String> contactNames) {
		this.contactNames = contactNames;
	}


}
