package presentation.controller;

import java.sql.SQLException;

import Entita.Spazio;
import integration.SpazioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.MainController;
import presentation.StageController;
/**
 * Controller per la modifica degli spazi
 * @author Giava
 *
 */
public class ModificaSpazioController extends StageController{
	   @FXML
	     Button ModificaSpazio;

	    @FXML
	     Button Esci;

	    @FXML
	     Label ErrorSQL;

	    @FXML
	     Button Indietro;

	    @FXML
	     TextField nome;

	    @FXML
	     TextField ubicazione;

	    @FXML
	     Label successo;

	    @FXML
	     TextField citta;

	    @FXML
	     TextArea desc;
	    SpazioDAO dao=new SpazioDAO();
	    String oldnome;
	    
		@FXML
		public void initialize() throws SQLException {
		
		nome.setText(super.getSpazio().getNome());	
		citta.setText(super.getSpazio().getCitta());
		ubicazione.setText(super.getSpazio().getUbicazione());
		desc.setText(super.getSpazio().getDescrizione());
		oldnome=nome.getText();
		}
	    @FXML
	    void ModificaSpazio(ActionEvent event) throws SQLException {
	    	Spazio spazio;
			try {
				spazio =new Spazio(nome.getText(),citta.getText(),ubicazione.getText(),desc.getText());
			} catch (NullPointerException e) {
				ErrorSQL.setVisible(true);
				successo.setVisible(false);
				return;
			}
			dao.delete(oldnome);
			try {
				dao.create(spazio);
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
			super.setController("ModificaSpazio");
			super.setTitle("GAA - Modifica spazio");
			super.show();
		}

}
