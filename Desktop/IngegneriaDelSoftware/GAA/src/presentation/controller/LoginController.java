
package presentation.controller;

import java.sql.SQLException;

import Entita.Amministratore;
import Entita.UtenteBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.Dispatcher;
import presentation.MainController;
import presentation.StageController;
import presentation.controller.utility.ImageGetter;

public class LoginController extends StageController {
	@FXML
	private PasswordField pass;

	@FXML
	private Button exit_btn;

	@FXML
	private ImageView logo;

	@FXML
	private Button enter;

	@FXML
	private TextField user;
	@FXML
	private Label error;

	Amministratore am = new Amministratore();
	UtenteBase ub = new UtenteBase();

	@FXML
	public void initialize() {
		logo.setImage(ImageGetter.getLogo());
	}

	@FXML
	void login(ActionEvent event) throws SQLException {
		if (ub.checkCredenzialiClienti(user.getText(), pass.getText())) {
			error.setText("SEI UN utente base");
			MainController.getIstance().dispatchrequest("homeutentebase");
			this.closeStage();
		} else if (am.checkCredenzialiClienti(user.getText(), pass.getText())) {
			error.setText("SEI UN AMMINISTRATORE");
		} else
			error.setText("La combinazione Username/Password e' errata");
	}

	@FXML
	public void exit(ActionEvent e) {
		closeStage();
	}
	@Override
	public void show() {
		super.setController("Login");
		super.show();
	}

	@Override
	public void closeStage() {
		Stage stage = (Stage) exit_btn.getScene().getWindow();
		stage.close();
	}

}
