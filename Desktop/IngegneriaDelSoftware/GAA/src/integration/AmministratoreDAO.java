package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entita.Amministratore;

public class AmministratoreDAO extends DAOAB<Amministratore>{
	private static final String CHECK_QUERY="SELECT Username FROM utente WHERE Username=? AND Password=? AND LivelloPermessi='A'";

	@Override
	public boolean create(Amministratore entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Amministratore entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Amministratore> getAll() throws SQLException {
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
	public List<Amministratore> search(String conditions) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
