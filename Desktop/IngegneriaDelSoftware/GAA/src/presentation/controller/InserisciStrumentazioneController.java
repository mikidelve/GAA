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
/**
 * Controller per l'inserimento degli strumenti
 * @author Giava
 *
 */
public class InserisciStrumentazioneController extends StageController {
	@FXML
	 TextField tipo;

	@FXML
	 TextField anno;

	@FXML
	 Label ErrorCampi;

	@FXML
	 Button Esci;

	@FXML
	 TextField proprietario;

	@FXML
	 Label ErrorSQL;

	@FXML
	 Button Inserisci;

	@FXML
	 Button Indietro;

	@FXML
	 TextField nome;

	@FXML
	 TextField sede;

	@FXML
	 TextField modello;

	@FXML
	 Label successo;

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
