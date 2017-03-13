package presentation;

import presentation.controller.FinestraAmministratoreController;
import presentation.controller.FinestraUtenteBaseController;
import presentation.controller.LoginController;

public class Dispatcher {
	LoginController login;
	FinestraUtenteBaseController Hmcontroller;
	FinestraAmministratoreController fa;

	public Dispatcher() {
		login = new LoginController();
		Hmcontroller = new FinestraUtenteBaseController();
		fa = new FinestraAmministratoreController();
	}

	public void dispatch(String request) {
		if (request.compareToIgnoreCase("Login") == 0) {
			login.show();
		} else if (request.compareToIgnoreCase("FinestraUtenteBase") == 0) {
			Hmcontroller.show();
		} else if (request.compareToIgnoreCase("Finestraamministratore") == 0) {
			fa.show();
		}
	}
}
