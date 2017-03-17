package Entita;

import java.sql.SQLException;

import integration.UtenteDAO;

public class UtenteBase {
	private String username;
	private String passowrd;
	private UtenteDAO utenteDAO;
	


	public UtenteBase() {
		utenteDAO = new UtenteDAO();
	}

	public UtenteBase(String username, String password) {
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

	public void create(UtenteBase entity) throws SQLException {
		utenteDAO.create(entity);
	}

	public void update(UtenteBase entity) {
		utenteDAO.update(entity);

	}

	public void delete(String ID) throws SQLException {
		utenteDAO.delete(ID);

	}


	public String checkCredenzialiClienti(String usernameC, String passwordC) throws SQLException {
		return utenteDAO.checkCredenziali(usernameC, passwordC);
	}
}
