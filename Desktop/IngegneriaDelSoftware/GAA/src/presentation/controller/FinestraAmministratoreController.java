package presentation.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;

import Entita.Dipendente;
import Entita.Scheda;
import Entita.Spazio;
import Entita.Strumento;
import integration.DipendenteDAO;
import integration.SchedaDAO;
import integration.SpazioDAO;
import integration.StrumentoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
import presentation.controller.utility.Coppia;
import presentation.controller.utility.ImageGetter;
import presentation.controller.utility.PDFschedaGenerator;

/**
 * Gestisce tutta l'interfaccia del sistema, con le diverse tab. Nasconde i
 * button di inserimento e modifica se l'accesso � effettuato da un utente con
 * permessi standard
 * 
 * @author Giava
 *
 */
@SuppressWarnings("rawtypes")
public class FinestraAmministratoreController extends StageController {
	@FXML
	Label ErrorDip;
	@FXML
	Label ErrorSpazi;
	@FXML
	Label ErrorStr;
	@FXML
	Label ErrorDipA;
	@FXML
	Label ErrorSpaziA;
	@FXML
	Label ErrorStrA;
	@FXML
	Label ErrorDoppiodip;
	@FXML
	Label ErrorDoppiostr;
	@FXML
	Label ErrorDoppiospazio;
	@FXML
	Button exit_btn;

	@FXML
	Button Logout;

	@FXML
	ImageView logo;

	// TABELLA RICERCA DIPENDENTI

	@FXML
	TableView<Dipendente> dipendenti_table;

	@FXML
	TableColumn COLcodfis;

	@FXML
	TableColumn COLsede;

	@FXML
	TableColumn COLnome;
	@FXML
	TableColumn COLdomicilio;
	@FXML
	TableColumn COLdata;

	@FXML
	TableColumn COLmail;

	@FXML
	TableColumn COLtel;
	@FXML
	TableColumn COLsesso;

	@FXML
	TableColumn COLcognome;
	@FXML
	TableColumn COLmansione;
	// FINE TABELLA
	@FXML
	TextField mansione;
	@FXML
	TextField cognome;
	@FXML
	TextField sede;
	@FXML
	TextField nome;
	@FXML
	Button Cerca;
	@FXML
	Button Mostratutti;
	@FXML
	Button InserisciSpazio;
	// TABELLA RICERCA SPAZI

	@FXML
	TableView<Spazio> spazi_table;

	@FXML
	TableColumn COLnomeSpazi;

	@FXML
	TableColumn COLubicazioneSpazi;

	@FXML
	TableColumn COLcittaSpazi;
	@FXML
	TableColumn COLcaratteristicheSpazi;
	// FINE TABELLA
	@FXML
	TextField sedeSpazi;
	@FXML
	TextField nomeSpazi;

	@FXML
	Button CercaSpazi;
	@FXML
	Button MostratuttiSpazi;
	// TABELLA RICERCA STRUMENTI
	@FXML
	TableView<Strumento> strumenti_table;
	@FXML
	TableColumn COLcaratteristicheStr;
	@FXML
	TableColumn COLmodelloStr;
	@FXML
	TableColumn COLpropietarioStr;

	@FXML
	TableColumn COLannoStr;

	@FXML
	TextField AAStr;
	@FXML
	TableColumn COLnomeStr;
	@FXML
	TextField nomeStr;

	@FXML
	TextField ubicazioneStr;
	@FXML
	TableColumn COLtipoStr;

	@FXML
	TableColumn COLubicazioneStr;
	@FXML
	TextField proprietarioStr;
	@FXML
	Button mostratuttistr;

	// FINE TABELLA STRUMENTI

	@FXML
	Button InserisciDip;
	@FXML
	Button InserisciSpazi;
	@FXML
	Button InserisciStr;
	@FXML
	Button ModDipendente;
	@FXML
	Button DelDipendente;
	@FXML
	Button ModSpazio;
	@FXML
	Button DelSpazio;
	@FXML
	Button ModStr;
	@FXML
	Button DelStr;
	// TAB SCHEDA
	@FXML
	TextArea txtscheda;
	@FXML
	Label DataOra;
	@FXML
	Button partistatiche;
	@FXML
	TextArea txtend;
	@FXML
	TextArea txtintro;
	@FXML
	Button partidinamiche;
	@FXML
	Tab tabScheda;
	@FXML
	Label savesuc;

	// ObservableList<String> categorie;
	ObservableList<String> sessi;
	ObservableList<Dipendente> dipendenti = FXCollections.observableArrayList();
	ObservableList<Spazio> spazi = FXCollections.observableArrayList();
	ObservableList<Strumento> strumenti = FXCollections.observableArrayList();

	DipendenteDAO dipendenteDAO = new DipendenteDAO();
	SpazioDAO spazioDAO = new SpazioDAO();
	StrumentoDAO strumentoDAO = new StrumentoDAO();
	SchedaDAO schedaDAO = new SchedaDAO();
	List<Scheda> elementi;
	/**
	 * Flag utilizzato per settare o meno a visible le funzionalit� di
	 * inserimento
	 */
	public static boolean flagInserimento;
	boolean flagdip = false;
	boolean flagstr = false;
	boolean flagspazio = false;

	@FXML
	public void initialize() throws SQLException {
		if (super.getPermessi().compareToIgnoreCase("B") == 0) {
			ModDipendente.setVisible(false);
			DelDipendente.setVisible(false);
			ModSpazio.setVisible(false);
			DelSpazio.setVisible(false);
			ModStr.setVisible(false);
			DelStr.setVisible(false);
			partistatiche.setVisible(false);
			this.ErrorDip.setVisible(true);
			this.ErrorSpazi.setVisible(true);
			this.ErrorStr.setVisible(true);
		}
		if (super.getPermessi().compareToIgnoreCase("A") == 0) {
			this.ErrorDipA.setVisible(true);
			this.ErrorSpaziA.setVisible(true);
			this.ErrorStrA.setVisible(true);
		}
		dipendenti = FXCollections.observableArrayList();
		spazi = FXCollections.observableArrayList();
		strumenti = FXCollections.observableArrayList();
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
		tabScheda.setOnSelectionChanged(new EventHandler<Event>() {
			@Override
			public void handle(Event t) {
				txtscheda.setText("");
				try {
					if (flagdip) {
						setElencoDip();
					}
					if (flagspazio) {
						setElencoSpazi();
					}
					if (flagstr) {
						setElencoStr();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Calendar gc = Calendar.getInstance();
		String data = gc.get(Calendar.DAY_OF_MONTH) + "/" + ((gc.get(Calendar.MONTH)) + 1) + "/"
				+ gc.get(Calendar.YEAR);
		DataOra.setText("   " + data);
	}

	private void setElencoDip() throws SQLException {
		elementi = schedaDAO.getAll();
		txtscheda.setText(txtscheda.getText() + "Elenco dipendenti :" + "\n");
		Iterator<Scheda> it = elementi.iterator();
		while (it.hasNext()) {
			Scheda scheda = it.next();
			if (scheda.getTipologia().compareToIgnoreCase("dipendente") == 0) {
				txtscheda.setText(txtscheda.getText() + "			" + "�  " + scheda.getDescr() + "\n" + "\n");
			}
		}
	}

	private void setElencoStr() throws SQLException {
		elementi = schedaDAO.getAll();
		txtscheda.setText(txtscheda.getText() + "Elenco strumentazione :" + "\n");
		Iterator<Scheda> it = elementi.iterator();
		while (it.hasNext()) {
			Scheda scheda = it.next();
			if (scheda.getTipologia().compareToIgnoreCase("strumentazione") == 0) {
				txtscheda.setText(txtscheda.getText() + "			" + "�  " + scheda.getDescr() + "\n" + "\n");
			}
		}

	}

	private void setElencoSpazi() throws SQLException {
		elementi = schedaDAO.getAll();
		txtscheda.setText(txtscheda.getText() + "Elenco spazi :" + "\n");
		Iterator<Scheda> it = elementi.iterator();
		while (it.hasNext()) {
			Scheda scheda = it.next();
			if (scheda.getTipologia().compareToIgnoreCase("spazio") == 0) {
				txtscheda.setText(txtscheda.getText() + "			" + "�  " + scheda.getDescr() + "\n" + "\n");
			}
		}
	}

	// nel property va messo il nome del campo Entit�(Spazio)
	@SuppressWarnings("unchecked")
	private void setDatiSpazi() {
		spazi_table.setItems(spazi);
		this.COLnomeSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Nome"));
		this.COLcittaSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Citta"));
		this.COLubicazioneSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Ubicazione"));
		this.COLcaratteristicheSpazi.setCellValueFactory(new PropertyValueFactory<Spazio, String>("Descrizione"));

	}

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("static-access")
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

	@SuppressWarnings("static-access")
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

	@SuppressWarnings("unchecked")
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
	void AddStru(ActionEvent event) throws SQLException {
		Strumento str = strumenti_table.getSelectionModel().getSelectedItem();
		try {
			Scheda scheda = new Scheda(str.getNome(), str.toString(), "Strumentazione");
			schedaDAO.create(scheda);
		} catch (NullPointerException e) {
			if (super.getPermessi().compareToIgnoreCase("B") == 0)
				ErrorStr.setTextFill(Color.valueOf("#ff0505"));
			else
				ErrorStrA.setTextFill(Color.valueOf("#ff0505"));
		} catch (SQLException e) {
			ErrorDoppiostr.setVisible(true);
		}
		this.flagstr = true;
	}

	@FXML
	void AddSpazi(ActionEvent event) throws SQLException {
		Spazio spazio = spazi_table.getSelectionModel().getSelectedItem();
		try {
			Scheda scheda = new Scheda(spazio.getNome(), spazio.toString(), "Spazio");
			schedaDAO.create(scheda);
		} catch (NullPointerException e) {
			if (super.getPermessi().compareToIgnoreCase("B") == 0)
				ErrorSpazi.setTextFill(Color.valueOf("#ff0505"));
			else
				ErrorSpaziA.setTextFill(Color.valueOf("#ff0505"));
		} catch (

		SQLException e) {
			ErrorDoppiospazio.setVisible(true);
		}
		this.flagspazio = true;
	}

	@FXML
	void AddDip(ActionEvent event) throws SQLException {
		Dipendente dip = dipendenti_table.getSelectionModel().getSelectedItem();
		try {
			Scheda scheda = new Scheda(dip.getCodiceFiscale(), dip.toString(), "Dipendente");
			schedaDAO.create(scheda);
		} catch (NullPointerException e) {
			if (super.getPermessi().compareToIgnoreCase("B") == 0)
				ErrorDip.setTextFill(Color.valueOf("#ff0505"));
			else
				ErrorDipA.setTextFill(Color.valueOf("#ff0505"));
		} catch (SQLException e) {
			ErrorDoppiodip.setVisible(true);
		}
		this.flagdip = true;
	}

	@FXML
	void DelStrum(ActionEvent event) throws SQLException {
		try {
			Strumento str = strumenti_table.getSelectionModel().getSelectedItem();
			str.getNome();
			Object[] options = { "Si", "No" };
			int choice = JOptionPane.showOptionDialog(null, "Vui davvero eliminare la Strumentazione selezionata?", "",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if (choice == JOptionPane.YES_OPTION) {
				str.delete(str.getNome());
				strumenti = FXCollections.observableArrayList();
				strumenti.addAll(strumentoDAO.getAll());
				setDatiStrumenti();
			}
		} catch (NullPointerException e) {
			ErrorDip.setTextFill(Color.valueOf("#ff0505"));
		}

	}

	@FXML
	void ModStrum(ActionEvent event) {
		try {
			Strumento str = strumenti_table.getSelectionModel().getSelectedItem();
			super.setStr(str);
			System.out.println(str.getNome());
			MainController.getIstance().dispatchrequest("Modificastrumentazione");
		} catch (NullPointerException e) {
			ErrorDip.setTextFill(Color.valueOf("#ff0505"));
		}
	}

	@FXML
	void DelSpazi(ActionEvent event) throws SQLException {
		try {
			Spazio spazio = spazi_table.getSelectionModel().getSelectedItem();
			spazio.getNome();
			Object[] options = { "Si", "No", };
			int choice = JOptionPane.showOptionDialog(null, "Vui davvero eliminare lo spazio selezionato?", "",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if (choice == JOptionPane.YES_OPTION) {
				spazio.delete(spazio.getNome());
				spazi = FXCollections.observableArrayList();
				spazi.addAll(spazioDAO.getAll());
				setDatiSpazi();
			}
		} catch (NullPointerException e) {
			ErrorDip.setTextFill(Color.valueOf("#ff0505"));
		}

	}

	@FXML
	void ModSpazi(ActionEvent event) {
		Spazio spazio = spazi_table.getSelectionModel().getSelectedItem();
		if (spazi_table.getSelectionModel().getSelectedItem() == null) {
			ErrorSpazi.setTextFill(Color.valueOf("#ff0505"));
		} else {
			super.setSpazio(spazio);
			MainController.getIstance().dispatchrequest("Modificaspazio");
		}
	}

	@FXML
	void ModDip(ActionEvent event) {
		Dipendente dip = dipendenti_table.getSelectionModel().getSelectedItem();
		if (dipendenti_table.getSelectionModel().getSelectedItem() == null) {
			ErrorDip.setTextFill(Color.valueOf("#ff0505"));
		} else {
			super.setDip(dip);
			MainController.getIstance().dispatchrequest("ModificaDipendente");
		}
	}

	@FXML
	void DelDip(ActionEvent event) throws SQLException {
		try {
			Dipendente dip = dipendenti_table.getSelectionModel().getSelectedItem();
			dip.getCodiceFiscale();
			Object[] options = { "Si", "No" };
			int choice = JOptionPane.showOptionDialog(null, "Vui davvero eliminare lo Dipendente selezionato?", "",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			if (choice == JOptionPane.YES_OPTION) {

				dip.delete(dip.getCodiceFiscale());
				dipendenti = FXCollections.observableArrayList();
				dipendenti.addAll(dipendenteDAO.getAll());
				setDatiDipendenti();
			}
		} catch (NullPointerException e) {
			ErrorDip.setTextFill(Color.valueOf("#ff0505"));
		}

	}

	/**
	 * TAB SCHEDA
	 */

	@FXML
	void modstatiche(ActionEvent event) {
		this.txtintro.setEditable(true);
		this.txtend.setEditable(true);
	}

	@FXML
	void Stampa(ActionEvent event) throws IOException {
		this.Salva(event);
		PDFschedaGenerator.getIstance().StampaPDF(super.getNumPDF());
	}

	@FXML
	void Salva(ActionEvent event) {
		try {
			PDFschedaGenerator.getIstance().createPdf(super.getNumPDF(), DataOra.getText(), txtintro.getText(),
					txtscheda.getText(), txtend.getText());
			savesuc.setVisible(true);
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void moddinamiche(ActionEvent event) {
		this.txtscheda.setEditable(true);
	}

	@FXML
	void NuovaScheda(ActionEvent event) throws SQLException {
		super.setNumPDF(super.getNumPDF() + 1);
		this.schedaDAO.NewTable();
		this.txtscheda.setText("");
		savesuc.setVisible(false);
	}

}
