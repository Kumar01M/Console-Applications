package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private static final String INSERT_USER = "insert into users(name, email, country) values (?, ?, ?);";
	private static final String SELECT_USER = "select * from users where id = ?";
	private static final String REMOVE_USER = "delete from users where id = ?";
	private static final String SELECT_ALL_USERS = "select * from users";
	
	private static Connection connection;
	private static PreparedStatement stmt;
	private static final String URL = "jdbc:mysql://localhost:3306/UserManagement";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "fightclub";
	
	public UserDAO() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean addNewUser(User user) {
		try {
			stmt = connection.prepareStatement(INSERT_USER);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getCountry());
			return (stmt.executeUpdate() == 1)? true: false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public User getUser(int id) {
		User user = new User();
		try {
			stmt = connection.prepareStatement(SELECT_USER);
			stmt.setInt(1, id);
			ResultSet res = stmt.executeQuery();
			while (res != null && res.next()) {
				user.setId(res.getInt(1));
				user.setName(res.getString(2));
				user.setEmail(res.getString(3));
				user.setCountry(res.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void modifyUser(int id, String field, String modification) {
		try {
			stmt = connection.prepareStatement("update users set " + field + " = ? where id = ?");
			stmt.setString(1, modification);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean removeUser(int id) {
		try {
			stmt = connection.prepareStatement(REMOVE_USER);
			stmt.setInt(1, id);
			return (stmt.executeUpdate() == 1)? true: false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public List<User> selectAllUsers() {
		List<User> usersList = new ArrayList<>();
		try {
			stmt = connection.prepareStatement(SELECT_ALL_USERS);
			ResultSet res = stmt.executeQuery();
			while (res.next()) {
				usersList.add(new User(res.getInt(1), res.getString(2), res.getString(3), res.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

}
