package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
	public static DatabaseConnection connection;
	private static Connection conn;
	private static PreparedStatement preStmt;

	private DatabaseConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact_Manager", "root", "fightclub");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseConnection getDB() {
		if (connection == null) {
			connection = new DatabaseConnection();
		}
		return connection;
	}

	public void createContact(ContactsModel contact) {
		try {
			preStmt = conn.prepareStatement(
					"Insert into contacts(contactName, emailId, dateOfBirth, groupId, isFavourite) values(?, ?, ?, ?, ?);");
			preStmt.setString(1, contact.getContactName());
			preStmt.setString(2, contact.getContactEmail());
			preStmt.setString(3, contact.getContactDOB());
			preStmt.setInt(4, contact.getGroupId());
			preStmt.setInt(5, contact.getFavourite());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		createPhoneNumbers(contact.getContactEmail(), contact);
	}

	public void createPhoneNumbers(String email, ContactsModel contact) {
		List<String> numbersList = contact.getPhoneNumbers();
		int cid = 0;
		try {
			preStmt = conn.prepareStatement("select contactId from contacts where emailId = ?;");
			preStmt.setString(1, email);
			ResultSet rs = preStmt.executeQuery();
			while (rs.next()) {
				cid = rs.getInt(1);
			}
			LocalDatabase.getInstance().getContacts().put(cid, contact);
			LocalDatabase.getInstance().getContactNames().add(contact.getContactName());
			preStmt = conn.prepareStatement("insert into contactNumbers(contactId, phoneNumber) values(?, ?);");
			preStmt.setInt(1, cid);
			for (String number : numbersList) {
				preStmt.setString(2, number);
				preStmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void createGroup(GroupsModel group) {
		try {
			preStmt = conn.prepareStatement("insert into contactGroups(groupName) values(?);");
			preStmt.setString(1, group.getGroupName());
			preStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int chooseGroup(String groupName) {
		int gid = 0;
		try {
			preStmt = conn.prepareStatement("select groupId from contactGroups where groupName = ?");
			preStmt.setString(1, groupName);
			ResultSet rs = preStmt.executeQuery();
			while (rs.next())
				gid = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gid;
	}

	public List<String> readGroups() {
		List<String> groups = new ArrayList<>();
		try {
			preStmt = conn.prepareStatement("select groupName from contactGroups;");
			ResultSet rs = preStmt.executeQuery();
			while (rs.next())
				groups.add(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}

	public void readContacts() {
		ContactsModel contact;
		int contactId;
		try {
			preStmt = conn.prepareStatement("select * from contacts");
			ResultSet rs = preStmt.executeQuery();
			while (rs.next()) {
				contact = new ContactsModel();
				contactId = rs.getInt(1);
				contact.setContactName(rs.getString(2));
				contact.setContactEmail(rs.getString(3));
				contact.setContactDOB(rs.getString(4));
				contact.setGroupId(rs.getInt(5));
				contact.setFavourite(rs.getInt(6));
				LocalDatabase.getInstance().getContacts().put(contactId, contact);
				LocalDatabase.getInstance().getContactNames().add(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public ContactsModel readContact() {
//		ContactsModel contact = new ContactsModel();
//		
//	}

}
