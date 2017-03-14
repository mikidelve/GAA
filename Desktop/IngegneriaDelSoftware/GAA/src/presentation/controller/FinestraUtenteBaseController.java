package presentation.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
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

	@FXML
	void Logout(ActionEvent event) {

	}

	@FXML
	void exit(ActionEvent event) {

	}

	@Override
	public void show() {
		super.setController("FinestraUtenteBase");
		super.setTitle("Gestore Anagrafica Aziendale - UtenteStandard");
		super.show();
	}

	@Override
	public void closeStage() {
		// TODO Auto-generated method stub

	}
}
