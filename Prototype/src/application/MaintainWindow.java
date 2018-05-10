package application;

import java.io.File;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class MaintainWindow {

	private static Stage stage;

	@SuppressWarnings("deprecation")
	public void go() throws Exception {
		try {
			Stage stage = new Stage();
			setStage(stage);
			URL url = new File("src/application/Maintain.fxml").toURL();
			Parent root1 = FXMLLoader.load(url);
			Scene scene = new Scene(root1);
			Image image = new Image(new File("src/AES2.PNG").toURI().toString());
			stage.getIcons().add(image);
			stage.setResizable(false);
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
		MaintainWindow.stage = stage;
	}

	public static void closeStage() {
		getStage().close();
	}

}
