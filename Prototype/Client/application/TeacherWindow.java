package application;

import java.io.File;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import userManagement.User;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class TeacherWindow {

	private static Stage stage;


	@SuppressWarnings("deprecation")
	public void go() throws Exception {
		try {
			Stage stage = new Stage();
			setStage(stage);
			URL url = new File("Client/application/TeacherWindow.fxml").toURL();
			Parent root1 = FXMLLoader.load(url);
			Scene scene = new Scene(root1);
			Image image = new Image(new File("src/AES2.PNG").toURI().toString());
			stage.getIcons().add(image);
			stage.setResizable(false);
			stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent event) {
					User.updateUserLogged(User.getActiveUser().getiD(), 0);
				}
			});
			stage.sizeToScene();
			stage.setScene(scene);
			stage.setTitle("AES");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		TeacherWindow.stage = stage;
	}

	public static void closeStage() {
		getStage().close();
	}

}