package Entita;

import java.sql.SQLException;

import integration.UtenteBaseDAO;

public class UtenteBase {
	private String username;
	private String passowrd;
	private UtenteBaseDAO SegreteriaDao;
	


	public UtenteBase() {
		SegreteriaDao = new UtenteBaseDAO();
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
		SegreteriaDao.create(entity);
	}

	public void update(UtenteBase entity) {
		SegreteriaDao.update(entity);

	}

	public void delete(String ID) throws SQLException {
		SegreteriaDao.delete(ID);

	}


	public boolean checkCredenzialiClienti(String usernameC, String passwordC) throws SQLException {
		return SegreteriaDao.checkCredenziali(usernameC, passwordC);
	}
}
