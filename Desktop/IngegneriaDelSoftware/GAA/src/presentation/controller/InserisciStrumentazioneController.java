package presentation.controller;

import java.sql.SQLException;

import Entita.Strumento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;

public class InserisciStrumentazioneController extends StageController {
	@FXML
	private TextField tipo;

	@FXML
	private TextField anno;

	@FXML
	private Label ErrorCampi;

	@FXML
	private Button Esci;

	@FXML
	private TextField proprietario;

	@FXML
	private Label ErrorSQL;

	@FXML
	private Button Inserisci;

	@FXML
	private Button Indietro;

	@FXML
	private TextField nome;

	@FXML
	private TextField sede;

	@FXML
	private TextField modello;

	@FXML
	private Label successo;

	@FXML
	void Inserisci(ActionEvent event) {
		Strumento strumento;
		try {
			strumento = new Strumento(nome.getText(), modello.getText(), tipo.getText(), anno.getText(),proprietario.getText(),sede.getText());
		} catch (NullPointerException e) {
			ErrorCampi.setVisible(true);
			successo.setVisible(false);
			ErrorSQL.setVisible(false);
			return;
		}
		try {
			if (strumento.create(strumento)) {
				successo.setVisible(true);
				ErrorSQL.setVisible(false);
				ErrorCampi.setVisible(false);
				nome.setText("");
				modello.setText("");
				tipo.setText("");
				sede.setText("");
				proprietario.setText("");
				anno.setText("");
			}
		} catch (SQLException e) {
			ErrorSQL.setVisible(true);
			successo.setVisible(false);
			ErrorCampi.setVisible(false);
			e.printStackTrace();
		}
	}

	@FXML
	void Indietro(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("finestraamministratore");
	}

	@FXML
	void Esci(ActionEvent event) {
		this.closeStage();
	}

	@Override
	public void closeStage() {
		Stage stage = (Stage) Esci.getScene().getWindow();
		stage.close();
	}

	@Override
	public void show() {
		super.setController("InserisciStrumentazione");
		super.setTitle("GAA - Inserimento strumentazione");
		super.show();
	}

}
