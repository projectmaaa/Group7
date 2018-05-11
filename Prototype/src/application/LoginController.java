package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import resources.Utilities;
import userManagement.User;
import userManagement.Users;

public class LoginController implements Initializable {

	@FXML
	private PasswordField pw;

	@FXML
	private TextField un;

	@FXML
	private Button login;

	@FXML
	private Label loginLabel;

	@FXML
	private AnchorPane signIn;

	@FXML
	private Text date;

	public void loginButtonHandler(ActionEvent event) throws Exception {
		try {
			Users.updateList();
			User user = userExist();
			if ((user != null) && (user.getLogged() == 0)) {
				clearFields();
				user.setActiveUser(user);
				User.updateUserLogged(user.getiD(), 1);
				LoginWindow.closeStage();
				loginLabel.setVisible(false);
				MaintainWindow maintainWindow = new MaintainWindow();
				maintainWindow.go();
			} else if (user.getLogged() == 1) {
				loginLabel.setText("This user is already logged in.");	// syntax fix by AsafYus
			}
		} catch (NullPointerException ex) {
			loginLabel.setText("Incorrect username or password.");	// syntax fix by AsafYus
		} finally {
			loginLabel.setVisible(true);
		}
	}

	/**
	 * This method check if the user exist in the database.
	 * 
	 * <pre>
	 * If yes return the user.
	 * 
	 * <pre>
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
	 * This method clears the username and password fields
	 */
	private void clearFields() {
		un.clear();
		pw.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		date.setText(Utilities.setDateS());
	}
}
