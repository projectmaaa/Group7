package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import resources.Utilities;
import userManagement.User;

public class TeacherWindowController implements Initializable {

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Text TextGroup7;

	@FXML
	private ImageView Group7Logo;

	@FXML
	private Button logoutButton;

	@FXML
	private Text date;

	// @FXML
	// private ScrollPane scrollPaneEditOrRemoveQuestions;

	@FXML
	private Text welcomeText;

	// @FXML
	// private Button maintainQuestionButton;

	// @FXML
	// private Button addQuestion;

	// @FXML
	// private Button editOrRemoveQuestion;

	@FXML
	private TabPane tabPane;

	private boolean clickedOnMaintainQuestion;

	public void logOutButtonHandler(ActionEvent event) throws Exception {
		TeacherWindow.getStage().close();
		LoginWindow.getStage().show();
		LoginWindow.getStage().sizeToScene();
		User.updateUserLogged(User.getActiveUser().getiD(), 0);
	}

	public void openEditorRemove(ActionEvent event) {
		try {
			clickedOnMaintainQuestion = true;
			System.out.println("Enter");
			// scrollPaneEditOrRemoveQuestions.setVisible(true);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			User.updateUserLogged(User.getActiveUser().getiD(), 0);
		}
	}

	// public void maintainQuestionHideOption(MouseEvent event) {
	// try {
	// if (clickedOnMaintainQuestion) {
	// System.out.println("leave");
	// anchorPane.getChildren().remove(addQuestion);
	// anchorPane.getChildren().remove(editOrRemoveQuestion);
	// clickedOnMaintainQuestion = false;
	// }
	// } catch (ClassCastException | IllegalArgumentException e) {
	// e.printStackTrace();
	// } finally {
	// User.updateUserLogged(User.getActiveUser().getiD(), 0);
	// }
	// }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clickedOnMaintainQuestion = false;
		welcomeText.setText(welcomeText.getText() + "  " + User.getActiveUser().getFirstName() + "  "
				+ User.getActiveUser().getLastName());
		date.setText(Utilities.setDateS());
	}
}