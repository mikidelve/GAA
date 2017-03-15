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
	private Button InserisciDip;

	@FXML
	private TextField mansione;

	@FXML
	private TextField data;

	@FXML
	private TextField mail;

	@FXML
	private Button exit_btn;

	@FXML
	private TextField cognome;

	@FXML
	private Button exit_btnInserisci;

	@FXML
	private TextField sede;

	@FXML
	private TextField codfisc;

	@FXML
	private TextField nome;

	@FXML
	private Button LogoutRicerca;

	@FXML
	private Button exit_btnRicerca;

	@FXML
	private TextField domicilio;

	@FXML
	private Button Logout;

	@FXML
	private ImageView logo;

	@FXML
	private TextField tel;

	@FXML
	private Button LogoutInserisci;
	@FXML
	private Label ErrorCampi;

	@FXML
	private ChoiceBox sessobox;
	@FXML
	private Label ErrorCodfis;
	@FXML
	private Label ErrorData;
	@FXML
	private ChoiceBox SceltaElemento;

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

	//ObservableList<String> categorie;
	ObservableList<String> sessi;
	static ObservableList<Dipendente> dipendenti = FXCollections.observableArrayList();

	DipendenteDAO dipendenteDAO = new DipendenteDAO();

	@SuppressWarnings("unchecked")
	@FXML
	public void initialize() throws SQLException {
		logo.setImage(ImageGetter.getLogo());
		/**
		categorie = FXCollections.observableArrayList();
		categorie.add("Dipendenti");
		categorie.add("Strumenti");
		categorie.add("Spazi");
		categoria.setItems(categorie);
		*/
		sessi = FXCollections.observableArrayList();
		sessi.add("M");
		sessi.add("F");
		sessobox.setItems(sessi);
		//SceltaElemento.setItems(categorie);
		dipendenti.addAll(dipendenteDAO.getAll());
		setDatiDipendenti();
		/**
		 * SceltaElemento.getSelectionModel().selectedItemProperty().addListener
		 * (new ChangeListener<String>() {
		 * 
		 * @Override public void changed(ObservableValue<? extends String>
		 *           observable, String oldvalue, String newvalue) {
		 *           if(newvalue.compareToIgnoreCase("dipendenti")==0){
		 * 
		 *           } } });
		 */
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
	void InserisciDip(ActionEvent event) {
		String date = data.getText();
		String cod = codfisc.getText();
		try {
			Dipendente dipendente = new Dipendente(nome.getText(), cognome.getText(), sessobox.getValue().toString(),
					date, cod, mail.getText(), tel.getText(), domicilio.getText(), mansione.getText(), sede.getText());

			if (!FormatoData.getIstance().ControllaData(date)) {
				ErrorData.setVisible(true);
				return;
			}
			try {
				if (dipendente.create(dipendente)) {
					ErrorData.setVisible(false);
					ErrorCampi.setVisible(false);
					System.out.println("FATTOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NullPointerException e) {
			ErrorCampi.setVisible(true);
			return;
		}
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

}
