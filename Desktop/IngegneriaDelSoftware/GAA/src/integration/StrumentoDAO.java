package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entita.Strumento;

public class StrumentoDAO extends DAOAB<Strumento>{
	private static final String INSERT_QUERY="INSERT INTO Strumento VALUES(?,?,?,?,?)";
	@Override
	public boolean create(Strumento entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Strumento entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Strumento read(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Strumento> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
