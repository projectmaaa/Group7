package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import resources.Utilities;
import userManagement.User;

public class MaintainController implements Initializable {

	@FXML
	private Text TextGroup7;

	@FXML
	private ImageView Group7Logo;

	@FXML
	private Button logoutButton;

	@FXML
	private Text date;

	public void logOutButtonHandler(ActionEvent event) throws Exception {
		MaintainWindow.getStage().close();
		LoginWindow.getStage().show();
		LoginWindow.getStage().sizeToScene();
		User.updateUserLogged(User.getActiveUser().getiD(), 0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		date.setText(Utilities.setDateS());
	}

}