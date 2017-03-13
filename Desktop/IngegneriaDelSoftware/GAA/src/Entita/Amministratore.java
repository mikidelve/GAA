package Entita;

import java.sql.SQLException;

import integration.AmministratoreDAO;

public class Amministratore {
	private String username;
	private String passowrd;
	private AmministratoreDAO AmministratoreDao;
	


	public Amministratore() {
		AmministratoreDao = new AmministratoreDAO();
	}

	public Amministratore(String username, String password) {
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

	public void create(Amministratore entity) throws SQLException {
		AmministratoreDao.create(entity);
	}

	public void update(Amministratore entity) {
		AmministratoreDao.update(entity);

	}

	public void delete(String ID) throws SQLException {
		AmministratoreDao.delete(ID);

	}

	public Amministratore read(String usernameC) throws SQLException {
		return AmministratoreDao.read(usernameC);
	}

	public boolean checkCredenzialiClienti(String usernameC, String passwordC) throws SQLException {
		return AmministratoreDao.checkCredenziali(usernameC, passwordC);
	}

}
