package controller;

import java.util.List;

import model.DatabaseConnection;
import model.GroupsModel;
import view.GroupsView;

public class GroupsController {
	InputValidator in;
	DatabaseConnection conn;
	GroupsView groupsView;
	List<String> allGroups;
	
	public GroupsController() {
		in = new InputValidator();
		conn = DatabaseConnection.getDB();
		groupsView = new GroupsView(this);
	}
	
	public void addGroup() {
		GroupsModel group = new GroupsModel();
		group.setGroupName(in.inputString("Enter Group Name: "));
		conn.createGroup(group);
	}
	
	public void displayGroups() {
		allGroups = conn.readGroups();
		int idx = 0;
		for (String groupName: allGroups)
			System.out.println(++idx + " " + groupName);
	}
	
	public int chooseGroup() {
		System.out.println();
		if(in.inputInteger("{1} Add to Existing groups. {2} Create new group.") == 2) {
			addGroup();
		}
		displayGroups();
		int gid =  conn.chooseGroup(allGroups.get(in.inputInteger("Select group: ") - 1));
		return gid;
	}
}
