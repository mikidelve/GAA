package presentation.controller;

import java.sql.SQLException;

import Entita.Spazio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;

public class InserisciSpazioController extends StageController {
	@FXML
	private Button InserisciSpazio;

	@FXML
	private Button Esci;

	@FXML
	private Button Indietro;

	@FXML
	private TextField nome;

	@FXML
	private TextField ubicazione;

	@FXML
	private TextField citta;

	@FXML
	private TextArea desc;
	@FXML
	private Label ErrorCampi;

	@FXML
	private Label ErrorSQL;
	@FXML
	private Label successo;

	@FXML
	void InserisciSpazio(ActionEvent event) {
		Spazio spazio;
		try {
			spazio = new Spazio(nome.getText(), citta.getText(), ubicazione.getText(), desc.getText());
		} catch (NullPointerException e) {
			ErrorCampi.setVisible(true);
			successo.setVisible(false);
			ErrorSQL.setVisible(false);
			return;
		}
		try {
			if (spazio.create(spazio)) {
				successo.setVisible(true);
				ErrorSQL.setVisible(false);
				ErrorCampi.setVisible(false);
				nome.setText("");
				desc.setText("");
				citta.setText("");
				ubicazione.setText("");
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
		super.setController("InserisciSpazio");
		super.setTitle("GAA - Inserimento spazio");
		super.show();
	}

}
