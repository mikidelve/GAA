package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entita.Dipendente;
import Entita.Scheda;

public class SchedaDAO extends DAOAB<Scheda> {
	private static final String DROP_TABLE = "DROP TABLE IF EXISTS scheda";
	private static final String NEW_TABLE = "CREATE TABLE scheda ("
			+ "							chiaveElemento VARCHAR(50) NOT NULL,"
										+ "stringa VARCHAR(500) NOT NULL,tipo VARCHAR(15) NOT NULL,"
										+ "PRIMARY KEY (chiaveElemento))";
	private static final String INSERT_QUERY = "INSERT INTO scheda VALUES(?,?,?)";

	@Override
	public boolean create(Scheda entity) throws SQLException {
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(INSERT_QUERY);
		String chiave = entity.getChiaveelemento();
		prepStat.setString(1, chiave);
		String str = entity.getDescr();
		prepStat.setString(2, str);
		String tipo = entity.getTipologia();
		prepStat.setString(3, tipo);
		return prepStat.executeUpdate() != 0;
	}

	public boolean NewTable() throws SQLException {
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(DROP_TABLE);
		prepStat.execute();
		PreparedStatement newtable = connessione.prepareStatement(NEW_TABLE);
		newtable.executeUpdate();
		return (true);
	}

	@Override
	public boolean update(Scheda entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Scheda> search(String conditions) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Scheda> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
