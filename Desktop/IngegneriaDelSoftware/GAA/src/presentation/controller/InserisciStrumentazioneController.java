package presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import presentation.StageController;

public class InserisciStrumentazioneController extends StageController{
	 @FXML
	    private ChoiceBox SceltaElemento;

	    @FXML
	    private TextField domicilio;

	    @FXML
	    private TextField data;

	    @FXML
	    private Button InserisciStrumentazione;

	    @FXML
	    private Button exit_btnInserisci;

	    @FXML
	    private TextField cognome;

	    @FXML
	    private TextField codfisc;

	    @FXML
	    private TextField nome;

	    @FXML
	    private Button LogoutInserisci;

	    @FXML
	    void InserisciStrumentazione(ActionEvent event) {

	    }

	    @FXML
	    void LogoutInserisci(ActionEvent event) {

	    }

	    @FXML
	    void exitInserisci(ActionEvent event) {

	    }

	@Override
	public void closeStage() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		super.setController("InserisciStrumentazione");
		super.setTitle("GAA - Inserimento strumentazione");
		super.show();
	}

}
