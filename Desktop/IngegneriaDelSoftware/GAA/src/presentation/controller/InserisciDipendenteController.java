package presentation.controller;

import java.sql.SQLException;

import Entita.Dipendente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
import presentation.controller.utility.FormatoData;

/**
 * Controller per l'inserimento dei dipendenti
 * 
 * @author Giava
 *
 */
public class InserisciDipendenteController extends StageController {
	@FXML
	Button InserisciDip;

	@FXML
	TextField mansione;

	@FXML
	TextField data;

	@FXML
	TextField mail;

	@FXML
	Label ErrorCampi;

	@FXML
	Button exit_btnInserisci;

	@FXML
	TextField cognome;

	@FXML
	TextField sede;

	@FXML
	TextField codfisc;

	@FXML
	TextField nome;

	@FXML
	ChoiceBox sessobox;

	@FXML
	TextField domicilio;

	@FXML
	TextField tel;

	@FXML
	Label ErrorCodfis;

	@FXML
	Button Indietro;

	@FXML
	Label ErrorData;
	@FXML
	Label successo;

	@SuppressWarnings("rawtypes")
	static ObservableList sessi;

	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() throws SQLException {
		sessi = FXCollections.observableArrayList();
		sessi.add("M");
		sessi.add("F");
		sessobox.setItems(sessi);
	}

	@FXML
	void InserisciDip(ActionEvent event) {
		String date = data.getText();
		String cod = codfisc.getText();
		Dipendente dipendente;
		try {
			dipendente = new Dipendente(nome.getText(), cognome.getText(), sessobox.getValue().toString(), date, cod,
					mail.getText(), domicilio.getText(), mansione.getText(), tel.getText(), sede.getText());
		} catch (NullPointerException e) {
			ErrorCampi.setVisible(true);
			successo.setVisible(false);
			return;
		}
		if (!FormatoData.getIstance().ControllaData(date)) {
			ErrorData.setVisible(true);
			successo.setVisible(false);
			return;
		}
		try {
			if (dipendente.create(dipendente)) {
				ErrorData.setVisible(false);
				ErrorCampi.setVisible(false);
				successo.setVisible(true);
				nome.setText("");
				cognome.setText("");
				sessobox.setValue("");
				data.setText("");
				codfisc.setText("");
				mail.setText("");
				tel.setText("");
				domicilio.setText("");
				mansione.setText("");
				sede.setText("");
			} else {
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void Indietro(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("finestraamministratore");
	}

	@FXML
	void exitInserisci(ActionEvent event) {
		this.closeStage();
	}

	@Override
	public void closeStage() {
		Stage stage = (Stage) exit_btnInserisci.getScene().getWindow();
		stage.close();
	}

	@Override
	public void show() {
		super.setController("InserisciDipendente");
		super.setTitle("GAA - Inserimento dipendente");
		super.show();
	}

}
