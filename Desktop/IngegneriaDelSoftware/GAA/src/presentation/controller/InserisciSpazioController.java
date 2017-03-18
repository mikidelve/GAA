package presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import presentation.StageController;

public class InserisciSpazioController extends StageController{
	   @FXML
	    private Button InserisciDip;

	    @FXML
	    private ChoiceBox SceltaElemento1;

	    @FXML
	    private ChoiceBox SceltaElemento;

	    @FXML
	    private Button exit_btnInserisci;

	    @FXML
	    private TextField codfisc;

	    @FXML
	    private TextField nome;

	    @FXML
	    private Button LogoutInserisci;

	    @FXML
	    void InserisciSpazio(ActionEvent event) {

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
		super.setController("InserisciSpazio");
		super.setTitle("GAA - Inserimento spazio");
		super.show();
	}

}
