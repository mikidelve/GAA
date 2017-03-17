package presentation;

import presentation.controller.*;

public class Dispatcher {
	LoginController login;
	FinestraUtenteBaseController Hmcontroller;
	FinestraAmministratoreController fa;
	InserisciSpazioController spazioController;
	InserisciDipendenteController dipendentiController;
	InserisciStrumentoController itemController;

	public Dispatcher() {
		login = new LoginController();
		Hmcontroller = new FinestraUtenteBaseController();
		fa = new FinestraAmministratoreController();
		this.spazioController = new InserisciSpazioController();
		this.dipendentiController = new InserisciDipendenteController();
		this.itemController = new InserisciStrumentoController();
	}

	public void dispatch(String request) {
		if (request.compareToIgnoreCase("Login") == 0) {
			login.show();
		} else if (request.compareToIgnoreCase("FinestraUtenteBase") == 0) {
			Hmcontroller.show();
		} else if (request.compareToIgnoreCase("Finestraamministratore") == 0) {
			fa.show();
		}else if(request.compareToIgnoreCase("InserisciDipendente")==0){
			dipendentiController.show();
		}else if(request.compareToIgnoreCase("InserisciStrumentazione")==0){
			spazioController.show();
		}else if(request.compareToIgnoreCase("InserisciSpazio")==0){
			itemController.show();
		}
	}
}
