package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Entita.Dipendente;
import Entita.Spazio;

public class SpazioDAO extends DAOAB<Spazio> {
	private static final String INSERT_QUERY = "INSERT INTO Spazio VALUES(?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM spazi";

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
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(GET_ALL);
		ResultSet risultato = prepStat.executeQuery();
		List<Spazio> lista = getLista(risultato);
		return lista;
	}

	private List<Spazio> getLista(ResultSet risultato) throws SQLException {
		List<Spazio> spazi = new LinkedList<Spazio>();
		while (risultato.next()) {
			Spazio elemento = new Spazio();
			String nome = risultato.getString("Nome");
			elemento.setNome(nome);
			String citta = risultato.getString("Citta");
			elemento.setCitta(citta);
			String ubicazione = risultato.getString("Ubicazione");
			elemento.setUbicazione(ubicazione);
			String desc = risultato.getString("CaratteristicheDescrittive");
			elemento.setDescrizione(desc);
			spazi.add(elemento);
		}
		return spazi;
	}

	@Override
	public List<Spazio> search(String query) throws SQLException {
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(query);
		ResultSet risultato = prepStat.executeQuery();
		List<Spazio> lista = getLista(risultato);
		return lista;
	}

}
