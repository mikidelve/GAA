package Entita;

import java.sql.SQLException;

import integration.DipendenteDAO;

public class Dipendente {
	private String username;
	private String passowrd;
	private DipendenteDAO DipendenteDao;
	


	public Dipendente() {
		DipendenteDao = new DipendenteDAO();
	}

	public Dipendente(String username, String password) {
		this.passowrd = password;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public void create(Dipendente entity) throws SQLException {
		DipendenteDao.create(entity);
	}

	public void update(Dipendente entity) {
		DipendenteDao.update(entity);

	}

	public void delete(String ID) throws SQLException {
		DipendenteDao.delete(ID);

	}

	public Dipendente read(String usernameC) throws SQLException {
		return DipendenteDao.read(usernameC);
	}

	

}
