package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Entita.Spazio;
import Entita.Strumento;

public class StrumentoDAO extends DAOAB<Strumento> {
	private static final String INSERT_QUERY = "INSERT INTO Strumentazione VALUES(?,?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM Strumentazione";

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
	public List<Strumento> getAll()  {
		try{
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(GET_ALL);
		ResultSet risultato = prepStat.executeQuery();
		List<Strumento> lista = getLista(risultato);
		return lista;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Strumento> search(String query) throws SQLException {
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(query);
		ResultSet risultato = prepStat.executeQuery();
		List<Strumento> lista = getLista(risultato);
		return lista;
	}

	private List<Strumento> getLista(ResultSet risultato) throws SQLException {
		List<Strumento> strumenti = new LinkedList<Strumento>();
		while (risultato.next()) {
			Strumento elemento = new Strumento();
			String nome = risultato.getString("Nome");
			elemento.setNome(nome);
			String modello = risultato.getString("Modello");
			elemento.setModello(modello);
			String tipo = risultato.getString("Tipo");
			elemento.setTipo(tipo);
			String annoacquisto = risultato.getString("AnnoAcquisto");
			elemento.setAnnoAcquisto(annoacquisto);
			String proprietario = risultato.getString("Proprietario");
			elemento.setProprietario(proprietario);
			String ubicazione = risultato.getString("Ubicazione");
			elemento.setUbicazione(ubicazione);
			strumenti.add(elemento);
		}
		return strumenti;
	}

}
