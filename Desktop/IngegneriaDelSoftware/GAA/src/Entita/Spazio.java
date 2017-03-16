package Entita;

import integration.SpazioDAO;

public class Spazio {
	private String nome;
	private String citta;
	private String ubicazione;
	private String descrizione;
	private SpazioDAO dao;

	public Spazio() {
		dao = new SpazioDAO();
	}

	public Spazio(String nome, String citta, String ubicazione, String descrizione) {
		super();
		this.nome = nome;
		this.citta = citta;
		this.ubicazione = ubicazione;
		this.descrizione = descrizione;
		this.dao = new SpazioDAO();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
