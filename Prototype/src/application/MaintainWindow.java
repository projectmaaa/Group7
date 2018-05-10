package application;

import java.io.File;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class MaintainWindow {

	@SuppressWarnings("deprecation")
	public static void go() throws Exception {
		try {
			URL url = new File("src/application/Questions.fxml").toURL();
			Parent root1 = FXMLLoader.load(url);
			Stage stage = new Stage();
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

}
