package model;

import java.util.ArrayList;
import java.util.List;

public class ContactsModel {

	private String contactName, contactEmail, contactDOB;
	private int favourite, groupId;
	private List<String> phoneNumbers;
	
	public ContactsModel() {
		phoneNumbers = new ArrayList<>(3);
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactDOB() {
		return contactDOB;
	}

	public void setContactDOB(String contactDOB) {
		this.contactDOB = contactDOB;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public int getFavourite() {
		return favourite;
	}

	public void setFavourite(int favourite) {
		this.favourite = favourite;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
