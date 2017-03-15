package Entita;

import java.sql.Date;
import java.sql.SQLException;

import integration.DipendenteDAO;

public class Dipendente {
	private String username;
	private String Nome;
	private String Cognome;
	private String sesso;
	private String Datadinascita;
	private String CodiceFiscale;
	private String mail;
	private String Domicilio;
	private String Mansione;
	private String telefono;
	private String SedeAppartenenza;
	private DipendenteDAO dao;

	public void setNome(String nome) {
		Nome = nome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public void setDatadinascita(String datadinascita) {
		Datadinascita = datadinascita;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		CodiceFiscale = codiceFiscale;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}

	public void setMansione(String mansione) {
		Mansione = mansione;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setSedeAppartenenza(String sedeAppartenenza) {
		SedeAppartenenza = sedeAppartenenza;
	}

	public void setDao(DipendenteDAO dao) {
		this.dao = dao;
	}

	public Dipendente(String nome, String cognome, String sesso, String datadinascita, String codiceFiscale,
			String mail, String domicilio, String mansione, String telefono, String sedeAppartenenza) {
		Nome = nome;
		Cognome = cognome;
		this.sesso = sesso;
		Datadinascita = datadinascita;
		CodiceFiscale = codiceFiscale;
		this.mail = mail;
		Domicilio = domicilio;
		Mansione = mansione;
		this.telefono = telefono;
		SedeAppartenenza = sedeAppartenenza;
		this.dao = new DipendenteDAO();
	}

	public String getNome() {
		return Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public String getDatadinascita() {
		return Datadinascita;
	}

	public String getCodiceFiscale() {
		return CodiceFiscale;
	}

	public String getMail() {
		return mail;
	}

	public String getDomicilio() {
		return Domicilio;
	}

	public String getMansione() {
		return Mansione;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getSedeAppartenenza() {
		return SedeAppartenenza;
	}

	public DipendenteDAO getDao() {
		return dao;
	}

	public Dipendente() {
		dao = new DipendenteDAO();
	}

	public Dipendente(String username, String password) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean create(Dipendente entity) throws SQLException {
		return dao.create(entity);
	}

	public void update(Dipendente entity) {
		dao.update(entity);

	}

	public void delete(String ID) throws SQLException {
		dao.delete(ID);

	}

	public Dipendente read(String usernameC) throws SQLException {
		return dao.read(usernameC);
	}

}
