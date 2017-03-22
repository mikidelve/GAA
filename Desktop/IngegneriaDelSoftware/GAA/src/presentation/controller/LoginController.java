
package presentation.controller;

import java.sql.SQLException;

import Entita.UtenteBase;
import integration.SchedaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
	SchedaDAO schedaDAO=new SchedaDAO();

	UtenteBase ub = new UtenteBase();

	@FXML
	public void initialize() {
		logo.setImage(ImageGetter.getLogo());
	}

	@FXML
	void login(ActionEvent event) throws SQLException {
		if (ub.checkCredenzialiClienti(user.getText(), pass.getText()).compareToIgnoreCase("B") == 0) {
			this.closeStage();
			super.setPermessi("B");
			MainController.getIstance().dispatchrequest("finestrautentebase");
		} else if (ub.checkCredenzialiClienti(user.getText(), pass.getText()).compareToIgnoreCase("A") == 0) {
			this.closeStage();
			super.setPermessi("A");
			MainController.getIstance().dispatchrequest("finestraamministratore");
		} else{
			error.setText("La combinazione Username/Password e' errata");
		pass.setText("");
		}
		schedaDAO.NewTable();
	}

	@FXML
	public void exit(ActionEvent e) {
		closeStage();
	}

	@Override
	public void show() {
		super.setController("Login");
		super.setTitle("Gestore Anagrafica Aziendale - Benvenuto");
		super.show();
	}

	@Override
	public void closeStage() {
		Stage stage = (Stage) exit_btn.getScene().getWindow();
		stage.close();
	}

}
