package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import userManagement.User;

public class MaintainController {

	@FXML
	private Text TextGroup7;

	@FXML
	private ImageView Group7Logo;

	@FXML
	private Button logoutButton;

	public void logOutButtonHandler(ActionEvent event) throws Exception {
		MaintainWindow.getStage().close();
		LoginWindow.getStage().show();
		User.updateUserLogged(User.getActiveUser().getiD(), 0);
	}

}