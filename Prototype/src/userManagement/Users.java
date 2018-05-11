package userManagement;

import java.util.ArrayList;
import dataBaseAccessories.MysqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Users {

	private static ArrayList<User> userList;

	public Users() {
		updateList();
	}

	public static void updateList() {
		Connection conn = null;
		Statement stmt;
		ResultSet rs;
		String usersScheme = ("SELECT * FROM Users;");
		userList = new ArrayList<User>();
		try {
			conn = MysqlConnection.connection();
		} catch (NullPointerException e) {
			System.out.println("No Connection");
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(usersScheme);
			while (rs.next()) {
				userList.add(new User(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public static User getUser(String iD) throws NullPointerException {
		if (iD != null) {
			for (User user : userList) {
				if (user.getiD().equals(iD))
					return user;
			}
		} 
		/* Arkady */
		return (null);
	}

	public void printList() {
		if (!userList.isEmpty()) {
			for (User user : userList) {
				System.out.println(user);
			}
		} else {
			System.out.println("Empty");
		}
	}
}