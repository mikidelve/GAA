package presentation.controller.utility;

import javafx.scene.image.Image;
import presentation.Main;
/**
 * Imposta il logo dell'applicazione
 * @author Giava
 *
 */
public class ImageGetter {

	public static Image getLogo(){
		return new Image(Main.class.getResourceAsStream("controller/utility/logo.png"));
	}
	
}
