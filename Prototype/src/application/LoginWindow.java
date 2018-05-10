package application;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class LoginWindow extends Application {

	private static Stage stage;

	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage stage) {
		try {
			setStage(stage);
			URL url = new File("src/application/Login.fxml").toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root);
			Image image = new Image(new File("src/AES2.PNG").toURI().toString());
			stage.getIcons().add(image);
			stage.setResizable(false);
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
		LoginWindow.stage = stage;
	}

	public static void closeStage() {
		getStage().close();
	}

	public static void go() {
		launch();
	}
}
