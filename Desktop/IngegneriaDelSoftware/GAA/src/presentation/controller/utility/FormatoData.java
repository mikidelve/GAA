package presentation.controller.utility;

import presentation.MainController;

public class FormatoData {
	static FormatoData formatodata = new FormatoData();

	public boolean ControllaData(String data) {
		
		if(data.length()<9) return false;
		try{
		String anno = data.substring(6, 10);
		String mese = data.substring(3,5);
		String giorno = data.substring(0, 2);
		System.out.println(anno);
		System.out.println(mese);
		System.out.println(giorno);
		if (Integer.parseInt(anno) > 2017 || Integer.parseInt(anno) < 1900) {
			return false;
		} else if (Integer.parseInt(mese) < 0 && Integer.parseInt(mese) > 12) {
			return false;
		} else if (Integer.parseInt(giorno) < 0
				|| !GiornoMese(Integer.parseInt(giorno), Integer.parseInt(mese))) {
			return false;
		} else if (data.substring(4, 5).compareTo("/") == 0 && data.substring(7, 8).compareTo("/") == 0) {
			return false;
		}
		return true;
		}catch(IndexOutOfBoundsException e){
			return false;
		}
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
