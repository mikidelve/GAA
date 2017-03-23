package presentation;

import java.io.IOException;

import Entita.Dipendente;
import Entita.Spazio;
import Entita.Strumento;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Implementa i metodi base dei diversi controller e memorizza alcune
 * informazioni che saranno passate tra i diversi controller
 * 
 * @author Giava
 *
 */
public abstract class StageController implements StageIF {
	private static Dipendente dip = new Dipendente();
	private static Spazio spazio = new Spazio();
	private static Strumento str = new Strumento();
	private static String Permessi = "";
	private static int numPDF;

	private final String CARTELLA_CONTROLLER = "controller/fxmlclass/";
	private final String ESTENSIONE_CONTROLLER = ".fxml";
	private String CONTROLLER;
	private String percorso_finale;
	private static Stage stage = new Stage();

	public static Stage getStage() {
		return stage;
	}

	public void show() {
		try {

			percorso_finale = CARTELLA_CONTROLLER + CONTROLLER + ESTENSIONE_CONTROLLER;
			FXMLLoader fx = new FXMLLoader();
			fx.setLocation(StageController.class.getResource(percorso_finale));
			stage.setScene(new Scene((Parent) fx.load()));
			stage.show();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setController(String controller) {
		CONTROLLER = controller;
	}

	public void setTitle(String string) {
		stage.setTitle(string);
	}

	public Dipendente getDip() {
		return dip;
	}

	public void setDip(Dipendente dipendente) {
		dip = dipendente;
	}

	public static Spazio getSpazio() {
		return spazio;
	}

	public static void setSpazio(Spazio spazio) {
		StageController.spazio = spazio;
	}

	public static Strumento getStr() {
		return str;
	}

	public static void setStr(Strumento str) {
		StageController.str = str;
	}

	public static String getPermessi() {
		return Permessi;
	}

	public static void setPermessi(String permessi) {
		Permessi = permessi;
	}

	public static int getNumPDF() {
		return numPDF;
	}

	public static void setNumPDF(int numPDF) {
		StageController.numPDF = numPDF;
	}
}
