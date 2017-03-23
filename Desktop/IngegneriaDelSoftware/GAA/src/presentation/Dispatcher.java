package presentation;


import presentation.controller.*;

public class Dispatcher {
	LoginController login;
	FinestraAmministratoreController fa;
	InserisciSpazioController spazioController;
	InserisciDipendenteController dipendentiController;
	InserisciStrumentazioneController itemController;
	ModificaDipendenteController modDip;
	ModificaSpazioController modSpace;
	ModificaStrumentazioneController modstr;

	public Dispatcher() {
		login = new LoginController();
		fa = new FinestraAmministratoreController();
		this.spazioController = new InserisciSpazioController();
		this.dipendentiController = new InserisciDipendenteController();
		this.itemController = new InserisciStrumentazioneController();
		this.modDip = new ModificaDipendenteController();
		this.modSpace=new ModificaSpazioController();
		this.modstr=new ModificaStrumentazioneController();
	}

	public void dispatch(String request) {
		if (request.compareToIgnoreCase("Login") == 0) {
			login.show();
		} else if (request.compareToIgnoreCase("FinestraUtenteBase") == 0) {
			fa.show("B");
		} else if (request.compareToIgnoreCase("Finestraamministratore") == 0) {
			fa.show("A");
		} else if (request.compareToIgnoreCase("InserisciDipendente") == 0) {
			dipendentiController.show();
		} else if (request.compareToIgnoreCase("InserisciStrumentazione") == 0) {
			itemController.show();
		} else if (request.compareToIgnoreCase("InserisciSpazio") == 0) {
			spazioController.show();
		}else if(request.compareToIgnoreCase("Modificadipendente")==0){
			modDip.show();
		}else if(request.compareToIgnoreCase("Modificaspazio")==0){
			modSpace.show();
		}else if(request.compareToIgnoreCase("Modificastrumentazione")==0){
			modstr.show();
		}
	}

}
