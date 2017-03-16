package presentation.controller;

import java.sql.SQLException;
import java.util.List;

import Entita.Dipendente;
import integration.DipendenteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
import presentation.controller.utility.FormatoData;
import presentation.controller.utility.ImageGetter;

public class FinestraAmministratoreController extends StageController {
	@FXML
	private Button exit_btn;

	@FXML
	private Button Logout;

	@FXML
	private ImageView logo;

	// TABELLA RICERCA

	@FXML
	private TableView dipendenti_table;

	@FXML
	private TableColumn COLcodfis;

	@FXML
	private TableColumn COLsede;

	@FXML
	private TableColumn COLnome;
	@FXML
	private TableColumn COLdomicilio;
	@FXML
	private TableColumn COLdata;

	@FXML
	private TableColumn COLmail;

	@FXML
	private TableColumn COLtel;
	@FXML
	private TableColumn COLsesso;

	@FXML
	private TableColumn COLcognome;
	@FXML
	private TableColumn COLmansione;
	// FINE TABELLA
	@FXML
	private TextField mansione;
	@FXML
	private TextField cognome;
	@FXML
	private TextField sede;
	@FXML
	private TextField nome;

	@FXML
	private Button Cerca;
	@FXML
	private Button Mostratutti;

	// ObservableList<String> categorie;
	ObservableList<String> sessi;
	static ObservableList<Dipendente> dipendenti = FXCollections.observableArrayList();

	DipendenteDAO dipendenteDAO = new DipendenteDAO();

	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() throws SQLException {
		logo.setImage(ImageGetter.getLogo());
		dipendenti.addAll(dipendenteDAO.getAll());
		setDatiDipendenti();
		Mostratutti.setVisible(false);
	}

	private void setDatiDipendenti() {
		dipendenti_table.setItems(dipendenti);
		this.COLnome.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Nome"));
		this.COLcognome.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Cognome"));
		this.COLsesso.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Sesso"));
		this.COLdata.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Datadinascita"));
		this.COLcodfis.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("CodiceFiscale"));
		this.COLmail.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Mail"));
		this.COLtel.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Telefono"));
		this.COLdomicilio.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Domicilio"));
		this.COLmansione.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("Mansione"));
		this.COLsede.setCellValueFactory(new PropertyValueFactory<Dipendente, String>("SedeAppartenenza"));
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

	@FXML
	void LogoutInserisci(ActionEvent event) {
		this.Logout(event);
	}

	@FXML
	void exitInserisci(ActionEvent event) {
		this.exit(event);
	}

	@Override
	public void show() {
		super.setController("FinestraAmministratore");
		super.setTitle("Gestore Anagrafica Aziendale - Amministratore");
		super.show();
	}

	@FXML
	void Ricerca(ActionEvent event) {
		String nomeric = null;
		String cognomeric = null;
		String sederic = null;
		String mansioneric = null;
		dipendenti = FXCollections.observableArrayList();
		if (nome.getText().compareToIgnoreCase("") != 0) {
			nomeric = nome.getText();
		}
		if (cognome.getText().compareToIgnoreCase("") != 0) {
			cognomeric = cognome.getText();
		}
		if (sede.getText().compareToIgnoreCase("") != 0) {
			sederic = sede.getText();
		}
		if (mansione.getText().compareToIgnoreCase("") != 0) {
			mansioneric = mansione.getText();
		}
		try {
			if (nomeric == null && cognomeric == null && sederic == null && mansioneric == null) {
				return;
			} else if (nomeric != null && cognomeric == null && sederic == null && mansioneric == null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale  WHERE Nome='" + nomeric + "'"));
			} else if (nomeric != null && cognomeric != null && sederic == null && mansioneric == null) {
				dipendenti.addAll(dipendenteDAO.search(
						"SELECT * FROM personale  WHERE Nome='" + nomeric + "' AND Cognome='" + cognomeric + "'"));
			} else if (nomeric != null && cognomeric == null && sederic != null && mansioneric == null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale  WHERE Nome='" + nomeric
						+ "' AND SedeAppartenenza='" + sederic + "'"));
			} else if (nomeric != null && cognomeric == null && sederic == null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO.search(
						"SELECT * FROM personale  WHERE Nome='" + nomeric + "' AND Mansione='" + mansioneric + "'"));
			} else if (nomeric != null && cognomeric != null && sederic != null && mansioneric == null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Nome='" + nomeric
						+ "' AND Cognome='" + cognomeric + "' AND SedeAppartenenza='" + sederic + "'"));
			} else if (nomeric != null && cognomeric != null && sederic == null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Nome='" + nomeric
						+ "' AND Cognome='" + cognomeric + "' AND Mansione='" + mansioneric + "'"));
			} else if (nomeric != null && cognomeric != null && sederic != null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO
						.search("SELECT * FROM personale WHERE Nome='" + nomeric + "' AND Cognome='" + cognomeric
								+ "' AND SedeAppartenenza='" + sederic + "' AND Mansione='" + mansioneric + "'"));
			} else if (nomeric == null && cognomeric != null && sederic == null && mansioneric == null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Cognome='" + cognomeric + "'"));
			} else if (nomeric == null && cognomeric != null && sederic != null && mansioneric == null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Cognome='" + cognomeric
						+ "' AND SedeAppartenenza='" + sederic + "'"));
			} else if (nomeric == null && cognomeric != null && sederic == null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Cognome='" + cognomeric
						+ "' AND Mansione='" + mansioneric + "'"));
			} else if (nomeric == null && cognomeric != null && sederic != null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Cognome='" + cognomeric
						+ "' AND SedeAppartenenza='" + sederic + "' AND Mansione='" + mansioneric + "'"));
			} else if (nomeric == null && cognomeric == null && sederic != null && mansioneric == null) {
				dipendenti.addAll(
						dipendenteDAO.search("SELECT * FROM personale WHERE SedeAppartenenza='" + sederic + "'"));
			} else if (nomeric == null && cognomeric == null && sederic != null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE SedeAppartenenza='" + sederic
						+ "' AND Mansione='" + mansioneric + "'"));
			} else if (nomeric == null && cognomeric == null && sederic == null && mansioneric != null) {
				dipendenti.addAll(dipendenteDAO.search("SELECT * FROM personale WHERE Mansione='" + mansioneric + "'"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDatiDipendenti();
		Mostratutti.setVisible(true);
	}

	@FXML
	void Mostratutti(ActionEvent event) throws SQLException {
		dipendenti = FXCollections.observableArrayList();
		dipendenti.addAll(dipendenteDAO.getAll());
		this.setDatiDipendenti();
		Mostratutti.setVisible(false);
	}

}
