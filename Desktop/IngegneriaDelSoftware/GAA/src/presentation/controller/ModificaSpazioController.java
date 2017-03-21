package presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import presentation.StageController;

public class ModificaSpazioController extends StageController{
	   @FXML
	    private Button ModificaSpazio;

	    @FXML
	    private Button Esci;

	    @FXML
	    private Label ErrorSQL;

	    @FXML
	    private Button Indietro;

	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField ubicazione;

	    @FXML
	    private Label successo;

	    @FXML
	    private TextField citta;

	    @FXML
	    private TextArea desc;

	    @FXML
	    void ModificaSpazio(ActionEvent event) {

	    }

	    @FXML
	    void Indietro(ActionEvent event) {

	    }

	    @FXML
	    void Esci(ActionEvent event) {

	    }

	@Override
	public void closeStage() {
		// TODO Auto-generated method stub
		
	}

}
