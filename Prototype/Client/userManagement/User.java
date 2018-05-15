package userManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dataBaseAccessories.SqlConnection;

public class User {

	private String iD;
	private String passWord;
	private int logged;
	private String type;
	private String firstName;
	private String lastName;
	private static User activeUser;

	public User(String iD, String passWord, int logged, String type, String firstName, String lastName) {
		super();
		this.iD = iD;
		this.passWord = passWord;
		this.type = type;
		this.logged = logged;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLogged() {
		return logged;
	}

	public void setLogged(int logged) {
		this.logged = logged;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static User getActiveUser() {
		return activeUser;
	}

	public void setActiveUser(User activeUser) {
		User.activeUser = activeUser;
	}

	/**
	 * This method update the database by changing the logged status.
	 * 
	 * <pre>
	 * logged=1, discounted=0.
	 * 
	 * @param iD
	 * @param
	 */
	public static void updateUserLogged(String iD, int logged) {
		Connection conn = null;
		PreparedStatement updateUser;
		try {
			conn = SqlConnection.connection();

		} catch (NullPointerException e) {
			System.out.println("No Connection");
		}
		try {
			updateUser = conn.prepareStatement("UPDATE Users SET logged = ? WHERE idUsers=" + iD + ";");
			if (logged == 1) {
				updateUser.setInt(1, 1);
			}
			if (logged == 0) {
				updateUser.setInt(1, 0);
			}
			updateUser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "User [iD=" + iD + ", passWord=" + passWord + ", type=" + type + ", logged=" + logged + "]";
	}

}