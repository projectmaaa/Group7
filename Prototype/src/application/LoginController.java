package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mysql.MysqlConnection;
import database.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.User;

public class LoginController {

	@FXML
	PasswordField pw;

	@FXML
	TextField un;

	@FXML
	Button login;

	@FXML
	Label loginLabel;

	@FXML
	AnchorPane signIn;

	public void loginButtonHandler(ActionEvent event) throws Exception {
		try {
			User user = userExist();
			if ((user != null) && (user.isLogged() == 0)) {
				updateUserLogged(user.getiD());
				LoginWindow.closeStage();
				loginLabel.setVisible(false);
				MaintainWindow.go();
			} else if (user.isLogged() == 1) {
				loginLabel.setText("The user already logged.");
			}
		} catch (NullPointerException ex) {
			loginLabel.setText("The user name or password is incorrect.");
		} finally {
			loginLabel.setVisible(true);
		}
	}

	/**
	 * This method check if the user exist in the database. If yes return the user.
	 * Else return null.
	 */
	private User userExist() throws NullPointerException {
		User user = Users.getUser(un.getText());
		if (user != null) {
			if (user.getPassWord().equals(pw.getText())) {
				return user;
			}
		}
		return null;
	}

	/**
	 * This method will update the database when the user is logged
	 */
	private void updateUserLogged(String iD) {
		Connection conn = null;
		PreparedStatement updateUser;
		// usersScheme = ("SELECT * FROM Users WHERE idUsers=" + iD + ";");
		try {
			conn = MysqlConnection.connection();

		} catch (NullPointerException e) {
			System.out.println("No Connection");
		}
		try {
			updateUser = conn.prepareStatement("UPDATE Users SET logged = ? WHERE idUsers=" + iD + ";");
			updateUser.setInt(1, 1);
			updateUser.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
