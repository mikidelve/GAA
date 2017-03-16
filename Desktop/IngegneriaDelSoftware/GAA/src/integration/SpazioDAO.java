package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Entita.Spazio;

public class SpazioDAO extends DAOAB<Spazio>{
	private static final String INSERT_QUERY="INSERT INTO Spazio VALUES(?,?,?,?,?)";
	@Override
	public boolean create(Spazio entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spazio entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<Spazio> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spazio> search(String conditions) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
