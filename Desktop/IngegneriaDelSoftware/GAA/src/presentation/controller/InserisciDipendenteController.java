package presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.StageController;

public class InserisciDipendenteController extends StageController{
	  @FXML
	    private Button InserisciDip;

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

	    @FXML
	    private ChoiceBox sessobox;

	    @FXML
	    private TextField domicilio;

	    @FXML
	    private TextField tel;

	    @FXML
	    private Label ErrorCodfis;

	    @FXML
	    private Button LogoutInserisci;

	    @FXML
	    private Label ErrorData;

	    @FXML
	    void InserisciDip(ActionEvent event) {

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
		super.setController("InserisciDipendente");
		super.setTitle("GAA - Inserimento dipendente");
		super.show();
	}

}
