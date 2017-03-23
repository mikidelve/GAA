package presentation.controller;

import java.sql.SQLException;

import Entita.Dipendente;
import integration.DipendenteDAO;
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

public class ModificaDipendenteController extends StageController{
	@FXML
	private Button ModificaDip;

	@FXML
	private TextField mansione;

	@FXML
	private TextField data;

	@FXML
	private TextField mail;

	@FXML
	private Label ErrorCampi;

	@FXML
	private Button exit_btnInserisci;

	@FXML
	private TextField cognome;

	@FXML
	private TextField sede;

	@FXML
	private TextField codfisc;

	@FXML
	private TextField nome;

	@SuppressWarnings("rawtypes")
	@FXML
	private ChoiceBox sessobox;

	@FXML
	private TextField domicilio;

	@FXML
	private TextField tel;

	@FXML
	private Label ErrorCodfis;

	@FXML
	private Button Indietro;

	@FXML
	private Label ErrorData;
	@FXML
	private Label successo;
	
	@SuppressWarnings("rawtypes")
	static ObservableList sessi;
	
	String oldcodfis;
	
	DipendenteDAO dao=new DipendenteDAO();
	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() throws SQLException {
		sessi = FXCollections.observableArrayList();
		sessi.add("M");
		sessi.add("F");
		sessobox.setItems(sessi);
		nome.setText(super.getDip().getNome());
		cognome.setText(super.getDip().getCognome());
		sessobox.setValue(super.getDip().getSesso());
		data.setText(super.getDip().getDatadinascita());
		oldcodfis=super.getDip().getCodiceFiscale();
		codfisc.setText(super.getDip().getCodiceFiscale());
		mail.setText(super.getDip().getMail());
		tel.setText(super.getDip().getTelefono());
		domicilio.setText(super.getDip().getDomicilio());
		mansione.setText(super.getDip().getMansione());
		sede.setText(super.getDip().getSedeAppartenenza());
		successo.setVisible(false);
		
	}
	@FXML
	void ModificaDip(ActionEvent event) throws SQLException {

		Dipendente dipendente;
		try {
			dipendente = new Dipendente(nome.getText(), cognome.getText(), sessobox.getValue().toString(), data.getText(), codfisc.getText(),
					mail.getText() ,domicilio.getText(), mansione.getText(),tel.getText(), sede.getText());
		} catch (NullPointerException e) {
			ErrorCampi.setVisible(true);
			successo.setVisible(false);
			return;
		}
		dao.delete(oldcodfis);
		if (!FormatoData.getIstance().ControllaData(data.getText())) {
			ErrorData.setVisible(true);
			successo.setVisible(false);
			return;
		}
		try {
			dao.create(dipendente);
			successo.setVisible(true);
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
		super.setController("ModificaDipendente");
		super.setTitle("GAA - Modifica dipendente");
		super.show();
	}
}
