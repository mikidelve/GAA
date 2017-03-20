package Entita;

import java.sql.SQLException;
import java.util.List;

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

	public boolean create(Spazio entity) throws SQLException {
		return dao.create(entity);
	}

	public void update(Spazio entity) {
		dao.update(entity);

	}

	public void delete(String ID) throws SQLException {
		dao.delete(ID);

	}

	public List<Spazio> search(String conditions) throws SQLException {
		return dao.search(conditions);
	}
}
