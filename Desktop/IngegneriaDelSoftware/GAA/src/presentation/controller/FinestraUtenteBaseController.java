package presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
import presentation.controller.utility.ImageGetter;

public class FinestraUtenteBaseController extends StageController {
	@FXML
	private Button exit_btn;

	@FXML
	private Button Logout;

	@FXML
	private ImageView logo;
	@FXML
	private ChoiceBox categoria;

	ObservableList<String> categorie;

	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() {
		logo.setImage(ImageGetter.getLogo());
		categorie = FXCollections.observableArrayList();
		categorie.add("Dipendenti");
		categorie.add("Strumenti");
		categorie.add("Spazi");
		categoria.setItems(categorie);

	}
@Override
	public void show() {
		super.setController("FinestraUtenteBase");
		super.setTitle("Gestore Anagrafica Aziendale - UtenteStandard");
		super.show();
	}
	@FXML
	void Logout(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("Login");
	}

	@FXML
	void exit(ActionEvent event) {
		closeStage();
	}

	

	@Override
	public void closeStage() {
		Stage stage = (Stage) exit_btn.getScene().getWindow();
		stage.close();
	}
}
