package presentation.controller.utility;

import presentation.MainController;

public class FormatoData {
	static FormatoData formatodata = new FormatoData();

	public boolean ControllaData(String data) {
		if(data.length()<9) return false;
		String anno = data.substring(0, 4);
		String mese = data.substring(5, 7);
		String giorno = data.substring(8, 10);
		if (Integer.getInteger(anno) > 2017 || Integer.getInteger(anno) < 1900) {
			return false;
		} else if (Integer.getInteger(mese) < 0 && Integer.getInteger(mese) > 12) {
			return false;
		} else if (Integer.getInteger(giorno) < 0
				|| !GiornoMese(Integer.getInteger(giorno), Integer.getInteger(mese))) {
			return false;
		} else if (data.substring(4, 5).compareTo("/") == 0 && data.substring(7, 8).compareTo("/") == 0) {
			return false;
		}
		return true;
	}

	private boolean GiornoMese(int giorno, int mese) {

		if (mese == 4 || mese == 11 || mese == 6 || mese == 9) {
			if (giorno > 30)
				return false;
		} else if (giorno > 29)
			return false;
		else if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 11
				|| mese == 12) {
			if (giorno > 31)
				return false;

		}
		return true;
	}

	public static FormatoData getIstance() {
		return formatodata;
	}
}
