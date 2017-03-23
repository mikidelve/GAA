package Entita;
/**
 * Rappresenta l'entità Scheda
 * @author Giava
 *
 */
public class Scheda {
private String descr;
private String tipologia;
private String chiaveelemento;
public Scheda(String chiaveelemento, String descr, String tipologia) {
	super();
	this.descr = descr;
	this.tipologia = tipologia;
	this.chiaveelemento = chiaveelemento;
}

public Scheda() {
	// TODO Auto-generated constructor stub
}

public String getChiaveelemento() {
	return chiaveelemento;
}

public void setChiaveelemento(String chiaveelemento) {
	this.chiaveelemento = chiaveelemento;
}

public String getDescr() {
	return descr;
}
public void setDescr(String descr) {
	this.descr = descr;
}
public String getTipologia() {
	return tipologia;
}
public void setTipologia(String tipologia) {
	this.tipologia = tipologia;
}
}
