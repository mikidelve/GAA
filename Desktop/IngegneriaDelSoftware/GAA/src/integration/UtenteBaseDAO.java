package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entita.UtenteBase;

public class UtenteBaseDAO extends DAOAB<UtenteBase> {
	private static final String CHECK_QUERY="SELECT Username FROM utente WHERE Username=? AND Password=? AND LivelloPermessi='B'";

	@Override
	public boolean create(UtenteBase entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UtenteBase entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UtenteBase> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkCredenziali(String username,String password) throws SQLException{
		Connection connessione=MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(CHECK_QUERY);
		prepStat.setString(1, username);
		prepStat.setString(2, password);
		ResultSet ris=prepStat.executeQuery();
		if(ris.next()){
			return true;
		}
		else
			return false;
	}

	@Override
	public List<UtenteBase> search(String conditions) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
