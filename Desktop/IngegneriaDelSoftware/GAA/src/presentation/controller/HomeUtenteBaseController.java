package presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.StageController;
import presentation.controller.utility.ImageGetter;

public class HomeUtenteBaseController extends StageController {

	@FXML
	private Button exit_btn;

	@FXML
	private Button Logout;

	@FXML
	private ImageView logo;

	@FXML
	private Tab Ricerca;

	@FXML
	private Tab Scheda;

	@FXML
	private Tab Home;

	@FXML
	public void initialize() {
		logo.setImage(ImageGetter.getLogo());
	}

	@FXML
	void HomeSelezionata(ActionEvent event) {

	}

	@FXML
	void Logout(ActionEvent event) {

	}

	@FXML
	void exit(ActionEvent event) {
		Stage stage = (Stage) exit_btn.getScene().getWindow();
		stage.close();
	}

	@FXML
	void RicercaSelezionata(ActionEvent event) {

	}

	@FXML
	void SchedaSelezionata(ActionEvent event) {

	}

	@Override
	public void closeStage() {
		// TODO Auto-generated method stub

	}
}
