package application;

import java.net.URL;
import java.util.ResourceBundle;

import dataBaseAccessories.TeacherController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import resources.Question;
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

	@FXML
	private MenuItem editOrRemoveQuestion;
	@FXML
	private TableView<Question> tableView;
	@FXML
	private TableColumn questionIDColumn;
	@FXML
	private TableColumn authorColumn;
	@FXML
	private TableColumn questionTextColumn;
	@FXML
	private TableColumn possibleAnswersColumn;
	@FXML
	private TableColumn correctAnswerColumn;

	private boolean clickedOnMaintainQuestion;
	private TeacherController controller;

	public void logOutButtonHandler(ActionEvent event) throws Exception {
		TeacherWindow.getStage().close();
		LoginWindow.getStage().show();
		LoginWindow.getStage().sizeToScene();
		User.updateUserLogged(User.getActiveUser().getiD(), 0);
	}

	/* Edit\Remove Question was pressed */
	public void openEditorRemove(ActionEvent event) {
		try {
			ObservableList<Question> data = controller.getQuestions();
			clickedOnMaintainQuestion = true;
			System.out.println("Enter");
			tableView.setVisible(true);
			tableView.setItems(data);
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
		controller = new TeacherController();
		welcomeText.setText(welcomeText.getText() + "  " + User.getActiveUser().getFirstName() + "  "
				+ User.getActiveUser().getLastName());
		date.setText(Utilities.setDateS());
		tableView.setVisible(false);
	}
}