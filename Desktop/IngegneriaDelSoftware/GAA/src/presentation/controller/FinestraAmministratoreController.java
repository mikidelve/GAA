package presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import presentation.StageController;
import presentation.controller.utility.ImageGetter;

public class FinestraAmministratoreController extends StageController {
    @FXML
    private Button exit_btn;

    @FXML
	private Button Logout;

    @FXML
    private ImageView logo;

    @FXML
    void Logout(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }

	@FXML
	public void initialize() {
		
		logo.setImage(ImageGetter.getLogo());
	}
	@Override
	public void show() {
		super.setController("FinestraAmministratore");
		super.setTitle("Gestore Anagrafica Aziendale - Amministratore");
		super.show();
	}

	@Override
	public void closeStage() {
		// TODO Auto-generated method stub

	}
}
