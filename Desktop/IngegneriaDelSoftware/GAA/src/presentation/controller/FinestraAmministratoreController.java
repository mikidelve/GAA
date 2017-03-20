package presentation.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Entita.Dipendente;
import Entita.Spazio;
import Entita.Strumento;
import integration.DipendenteDAO;
import integration.SpazioDAO;
import integration.StrumentoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
import presentation.controller.utility.Coppia;
import presentation.controller.utility.FormatoData;
import presentation.controller.utility.ImageGetter;

public class FinestraAmministratoreController extends StageController {
	@FXML
	private Label ErrorDip;
	@FXML
	private Label ErrorSpazi;
	@FXML
	private Label ErrorStr;
	@FXML
	private Button exit_btn;

	@FXML
	private Button Logout;

	@FXML
	private ImageView logo;

	// TABELLA RICERCA DIPENDENTI

	@FXML
	private TableView<Dipendente> dipendenti_table;

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
	@FXML
	private Button InserisciSpazio;
	// TABELLA RICERCA SPAZI

	@FXML
	private TableView<Spazio> spazi_table;

	@FXML
	private TableColumn COLnomeSpazi;

	@FXML
	private TableColumn COLubicazioneSpazi;

	@FXML
	private TableColumn COLcittaSpazi;
	@FXML
	private TableColumn COLcaratteristicheSpazi;
	// FINE TABELLA
	@FXML
	private TextField sedeSpazi;
	@FXML
	private TextField nomeSpazi;

	@FXML
	private Button CercaSpazi;
	@FXML
	private Button MostratuttiSpazi;
	// TABELLA RICERCA STRUMENTI
	@FXML
	private TableView<Strumento> strumenti_table;
	@FXML
	private TableColumn COLcaratteristicheStr;
	@FXML
	private TableColumn COLmodelloStr;
	@FXML
	private TableColumn COLpropietarioStr;

	@FXML
	private TableColumn COLannoStr;

	@FXML
	private TextField AAStr;
	@FXML
	private TableColumn COLnomeStr;
	@FXML
	private TextField nomeStr;

	@FXML
	private TextField ubicazioneStr;
	@FXML
	private TableColumn COLtipoStr;

	@FXML
	private TableColumn COLubicazioneStr;
	@FXML
	private TextField proprietarioStr;
	@FXML
	private Button mostratuttistr;

	// FINE TABELLA STRUMENTI

	@FXML
	private Button InserisciDip;
	@FXML
	private Button InserisciSpazi;
	@FXML
	private Button InserisciStr;

	// ObservableList<String> categorie;
	ObservableList<String> sessi;
	static ObservableList<Dipendente> dipendenti = FXCollections.observableArrayList();
	static ObservableList<Spazio> spazi = FXCollections.observableArrayList();
	static ObservableList<Strumento> strumenti = FXCollections.observableArrayList();

	DipendenteDAO dipendenteDAO = new DipendenteDAO();
	SpazioDAO spazioDAO = new SpazioDAO();
	StrumentoDAO strumentoDAO = new StrumentoDAO();
	public static boolean flagInserimento;

	@FXML
	public void initialize() throws SQLException {

		logo.setImage(ImageGetter.getLogo());
		dipendenti.addAll(dipendenteDAO.getAll());
		setDatiDipendenti();
		Mostratutti.setVisible(false);
		MostratuttiSpazi.setVisible(false);
		this.mostratuttistr.setVisible(false);
		spazi.addAll(spazioDAO.getAll());
		setDatiSpazi();
		strumenti.addAll(strumentoDAO.getAll());
		setDatiStrumenti();
		if (this.flagInserimento == true) {
			this.InserisciDip.setVisible(true);
			this.InserisciSpazi.setVisible(true);
			this.InserisciStr.setVisible(true);
		}
	}

	// nel property va messo il nome del campo Entità(Spazio)
	@SuppressWarnings("unchecked")
	private void setDatiSpazi() {
		spazi_table.setItems(spazi);
		this.COLnomeSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Nome"));
		this.COLcittaSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Citta"));
		this.COLubicazioneSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Ubicazione"));
		this.COLcaratteristicheSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Descrizione"));

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
		this.flagInserimento = false;
		spazi.clear();
		dipendenti.clear();
		this.strumenti.clear();
		this.setDatiDipendenti();
		this.setDatiSpazi();
		this.setDatiStrumenti();
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

	public void show(String Livellopermesso) {
		super.setController("FinestraAmministratore");
		super.setTitle("Gestore Anagrafica Aziendale - Amministratore");
		if (Livellopermesso.compareToIgnoreCase("A") == 0) {
			this.flagInserimento = true;
		}
		super.show();
	}

	@FXML
	void Ricerca(ActionEvent event) throws SQLException {
		String query = "SELECT * FROM personale  WHERE ";
		String nomeric = null;
		String cognomeric = null;
		String sederic = null;
		String mansioneric = null;
		dipendenti = FXCollections.observableArrayList();
		Coppia[] parametri = new Coppia[4];

		int i = 0;
		if (nome.getText().compareToIgnoreCase("") != 0) {
			nomeric = nome.getText();
			Coppia c = new Coppia();
			c.setColonna("Nome");
			c.setValore(nomeric);
			parametri[i] = c;
			i++;
		}
		if (cognome.getText().compareToIgnoreCase("") != 0) {
			cognomeric = cognome.getText();
			Coppia c = new Coppia();
			c.setColonna("Cognome");
			c.setValore(cognomeric);
			parametri[i] = c;
			i++;
		}
		if (sede.getText().compareToIgnoreCase("") != 0) {
			sederic = sede.getText();
			Coppia c = new Coppia();
			c.setColonna("SedeAppartenenza");
			c.setValore(sederic);
			parametri[i] = c;
			i++;
		}
		if (mansione.getText().compareToIgnoreCase("") != 0) {
			mansioneric = mansione.getText();
			Coppia c = new Coppia();
			c.setColonna("Mansione");
			c.setValore(mansioneric);
			parametri[i] = c;
			i++;
		}
		if (nome == null && cognome == null && sederic == null && mansioneric == null) {
			return;
		}
		int j;
		for (j = 0; j < i - 1; j++) {
			query += parametri[j].getColonna() + "='" + parametri[j].getValore() + "' AND ";
		}
		query += parametri[j].getColonna() + "='" + parametri[j].getValore() + "'";
		dipendenti.addAll(dipendenteDAO.search(query));
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

	@FXML
	void LogoutSpazi(ActionEvent event) {
		this.Logout(event);
	}

	@FXML
	void exitSpazi(ActionEvent event) {
		this.exit(event);
	}

	@FXML
	void RicercaSpazi(ActionEvent event) throws SQLException {
		String query = "SELECT * FROM spazi WHERE ";
		String nome = null;
		String citta = null;
		spazi = FXCollections.observableArrayList();
		Coppia[] parametri = new Coppia[4];
		int i = 0;
		if (nomeSpazi.getText().compareToIgnoreCase("") != 0) {
			nome = nomeSpazi.getText();
			Coppia c = new Coppia();
			c.setColonna("Nome");
			c.setValore(nome);
			parametri[i] = c;
			i++;
		}
		if (sedeSpazi.getText().compareToIgnoreCase("") != 0) {
			citta = sedeSpazi.getText();
			Coppia c = new Coppia();
			c.setColonna("Citta");
			c.setValore(citta);
			parametri[i] = c;
			i++;
		}
		if (nome == null && citta == null) {
			return;
		}
		int j;
		for (j = 0; j < i - 1; j++) {
			query += parametri[j].getColonna() + "='" + parametri[j].getValore() + "' AND ";
		}
		query += parametri[j].getColonna() + "='" + parametri[j].getValore() + "'";
		spazi.addAll(spazioDAO.search(query));
		this.setDatiSpazi();
		this.MostratuttiSpazi.setVisible(true);
	}

	@FXML
	void MostratuttiSpazi(ActionEvent event) throws SQLException {
		spazi = FXCollections.observableArrayList();
		spazi.addAll(spazioDAO.getAll());
		this.setDatiSpazi();
		MostratuttiSpazi.setVisible(false);
	}

	@FXML
	void MostratuttiStr(ActionEvent event) throws SQLException {
		strumenti = FXCollections.observableArrayList();
		strumenti.addAll(strumentoDAO.getAll());
		this.setDatiStrumenti();
		mostratuttistr.setVisible(false);
	}

	private void setDatiStrumenti() {
		this.strumenti_table.setItems(strumenti);
		this.COLnomeStr.setCellValueFactory(new PropertyValueFactory<Strumento, String>("Nome"));
		this.COLmodelloStr.setCellValueFactory(new PropertyValueFactory<Strumento, String>("Modello"));
		this.COLtipoStr.setCellValueFactory(new PropertyValueFactory<Strumento, String>("Tipo"));
		this.COLannoStr.setCellValueFactory(new PropertyValueFactory<Strumento, String>("AnnoAcquisto"));
		this.COLpropietarioStr.setCellValueFactory(new PropertyValueFactory<Strumento, String>("Proprietario"));
		this.COLubicazioneStr.setCellValueFactory(new PropertyValueFactory<Strumento, String>("Ubicazione"));
		this.COLcaratteristicheStr
				.setCellValueFactory(new PropertyValueFactory<Strumento, String>("Caratteristiche Descrittive"));
	}

	@FXML
	void CercaStr(ActionEvent event) throws SQLException {
		String query = "SELECT * FROM Strumentazione WHERE ";
		Coppia[] parametri = new Coppia[4];
		int i = 0;
		String nomeStrric = null;
		String proprietario = null;
		String sederic = null;
		String anno = null;
		strumenti = FXCollections.observableArrayList();

		if (nomeStr.getText().compareToIgnoreCase("") != 0) {
			nomeStrric = nomeStr.getText();
			Coppia c = new Coppia();
			c.setColonna("Nome");
			c.setValore(nomeStrric);
			parametri[i] = c;
			i++;
		}
		if (proprietarioStr.getText().compareToIgnoreCase("") != 0) {
			proprietario = proprietarioStr.getText();
			Coppia c = new Coppia();

			c.setColonna("Proprietario");
			c.setValore(proprietario);
			parametri[i] = c;
			i++;
		}
		if (ubicazioneStr.getText().compareToIgnoreCase("") != 0) {
			sederic = sede.getText();
			Coppia c = new Coppia();
			c.setColonna("Ubicazione");
			c.setValore(sederic);
			parametri[i] = c;
			i++;
		}
		if (AAStr.getText().compareToIgnoreCase("") != 0) {
			anno = AAStr.getText();
			Coppia c = new Coppia();
			c.setColonna("AnnoAcquisto");
			c.setValore(anno);
			parametri[i] = c;
			i++;
		}
		if (nomeStrric == null && proprietario == null && sederic == null && anno == null) {
			return;
		}
		int j;
		for (j = 0; j < i - 1; j++) {
			query += parametri[j].getColonna() + "='" + parametri[j].getValore() + "' AND ";
		}
		query += parametri[j].getColonna() + "='" + parametri[j].getValore() + "'";
		strumenti.addAll(strumentoDAO.search(query));
		setDatiStrumenti();
		this.mostratuttistr.setVisible(true);

	}

	@FXML
	void InserisciSpazi(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("inseriscispazio");
	}

	@FXML
	void InserisciDip(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("inseriscidipendente");
	}

	@FXML
	void InserisciStr(ActionEvent event) {
		this.closeStage();
		MainController.getIstance().dispatchrequest("inseriscistrumentazione");
	}
    @FXML
    void AddStru(ActionEvent event) {

    }
    @FXML
    void AddSpazi(ActionEvent event) {

    }
    @FXML
    void AddDip(ActionEvent event) {

    }
    @FXML
    void DelStrum(ActionEvent event) throws SQLException {
    	Object[] options = {"Si","No"};
    	int choice = JOptionPane.showOptionDialog(null, "Vui davvero eliminare la Strumentazione selezionata?",
    "",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
    	if(choice==JOptionPane.YES_OPTION){
    		try{
            	Strumento str=strumenti_table.getSelectionModel().getSelectedItem();
            	str.delete(str.getNome());
            	strumenti=FXCollections.observableArrayList();
        		strumenti.addAll(strumentoDAO.getAll());
        		setDatiStrumenti();
            	}catch(NullPointerException e){
            		ErrorDip.setTextFill(Color.valueOf("#ff0505"));	
            	}
    	}
    	
        }
    

    @FXML
    void ModStrum(ActionEvent event) {

    }

    @FXML
    void DelSpazi(ActionEvent event) throws SQLException {
    	Object[] options = {"Si","No", };
    	int choice = JOptionPane.showOptionDialog(null, "Vui davvero eliminare lo spazio selezionato?",
    "",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
    	if(choice==JOptionPane.YES_OPTION){
    		try{
            	Spazio spazio=spazi_table.getSelectionModel().getSelectedItem();
            	spazio.delete(spazio.getNome());
            	spazi=FXCollections.observableArrayList();
        		spazi.addAll(spazioDAO.getAll());
        		setDatiSpazi();
            	}catch(NullPointerException e){
            		ErrorDip.setTextFill(Color.valueOf("#ff0505"));	
            	}
    	}
   
    	
        }
    

    @FXML
    void ModSpazi(ActionEvent event) {

    }
    @FXML
    void ModDip(ActionEvent event) {

    }

    @FXML
    void DelDip(ActionEvent event) throws SQLException {
    	Object[] options = {"Si","No"};
    	int choice = JOptionPane.showOptionDialog(null, "Vui davvero eliminare lo Dipendente selezionato?",
    "",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
    	if(choice==JOptionPane.YES_OPTION){
    		try{
    	    	Dipendente dip=dipendenti_table.getSelectionModel().getSelectedItem();
    	    	dip.delete(dip.getCodiceFiscale());
    	    	dipendenti=FXCollections.observableArrayList();
    			dipendenti.addAll(dipendenteDAO.getAll());
    			setDatiDipendenti();
    	    	}catch(NullPointerException e){
    	    		ErrorDip.setTextFill(Color.valueOf("#ff0505"));	
    	    	}
    	}
   
    
    }


}
