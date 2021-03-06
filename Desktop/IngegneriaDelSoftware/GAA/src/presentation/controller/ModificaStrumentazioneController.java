package presentation.controller;

import java.sql.SQLException;

import Entita.Strumento;
import integration.StrumentoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
/**
 * Controller per la modifica della strumentazione
 * @author Giava
 *
 */
public class ModificaStrumentazioneController extends StageController {
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
	 TextField sede;

	@FXML
	 Label ErrorSQL;

	@FXML
	 Button Inserisci;

	@FXML
	 Button Indietro;

	@FXML
	 TextField nome;

	@FXML
	 TextField modello;

	@FXML
	 Label successo;

	StrumentoDAO dao = new StrumentoDAO();
	String oldnome;

	@FXML
	public void initialize() throws SQLException {
		nome.setText(super.getStr().getNome());
		modello.setText(super.getStr().getModello());
		tipo.setText(super.getStr().getTipo());
		anno.setText(super.getStr().getAnnoAcquisto());
		proprietario.setText(super.getStr().getProprietario());
		sede.setText(super.getStr().getUbicazione());
		oldnome = nome.getText();
	}

	@FXML
	void Modifica(ActionEvent event) throws SQLException {
		Strumento str;
		try {
			str = new Strumento(nome.getText(), modello.getText(), tipo.getText(), anno.getText(),
					proprietario.getText(), sede.getText());
		} catch (NullPointerException e) {
			ErrorSQL.setVisible(true);
			successo.setVisible(false);
			return;
		}
		dao.delete(oldnome);
		try {
			dao.create(str);
			successo.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@FXML
	void Indietro(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("finestraamministratore");
	}

	@Override
	public void show() {
		super.setController("ModificaStrumentazione");
		super.setTitle("GAA - Modifica Strumentazione");
		super.show();
	}

}
