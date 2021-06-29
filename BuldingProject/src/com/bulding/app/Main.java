package com.bulding.app;

import java.io.File;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("MainCenter.fxml"));
			Scene scene = new Scene(root, 1280, 600);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

			File file = new File("C:\\Program Files\\buldingApplication\\ApplactionLogo.png");

			// --> file:/C:/MyImages/myphoto.jpg
			String localUrl;
			localUrl = file.toURI().toURL().toString();
			Image icon = new Image(localUrl);

			primaryStage.getIcons().add(icon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
			launch(args); 
	}

}
