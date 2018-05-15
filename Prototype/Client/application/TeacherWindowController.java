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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
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
	@FXML
	private Text welcomeText;
	@FXML
	private MenuItem editOrRemoveQuestion;
	@FXML
	private TableView<Question> tableView;
	@FXML
	private TableColumn<Question, String> questionIDColumn;
	@FXML
	private TableColumn<Question, String> authorColumn;
	@FXML
	private TableColumn<Question, String> questionTextColumn;
	@FXML
	private TableColumn<Question, String> possibleAnswersColumn;
	@FXML
	private TableColumn<Question, String> correctAnswerColumn;

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
			clickedOnMaintainQuestion = true;
			System.out.println("Enter");
			setColumns();
			tableView.setItems(controller.getQuestions());
			tableView.refresh();
			tableView.setVisible(true);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			User.updateUserLogged(User.getActiveUser().getiD(), 0);
		}
	}

	/* define the columns */
	private void setColumns() {
		questionIDColumn.setCellValueFactory(new PropertyValueFactory<>("questionID"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		questionTextColumn.setCellValueFactory(new PropertyValueFactory<>("questionText"));
		possibleAnswersColumn.setCellValueFactory(new PropertyValueFactory<>("possibleAnswers"));
		correctAnswerColumn.setCellValueFactory(new PropertyValueFactory<>("correctAnswer"));
	}

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