package presentation;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	Stage primary;
	AnchorPane root;

	@Override
	public void start(Stage primaryStage) {
		try {
			primary = primaryStage;
			primary.setTitle("Gestore Anagrafica Aziendale - Benvenuto");
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(getClass().getResource("controller/fxmlclass/Login.fxml"));
			root = (AnchorPane) fx.load();
			Scene scene = new Scene(root);
			primary.setScene(scene);
			primary.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
