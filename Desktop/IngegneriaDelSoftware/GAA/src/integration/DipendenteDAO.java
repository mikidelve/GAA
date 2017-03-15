package integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Entita.Dipendente;

public class DipendenteDAO extends DAOAB<Dipendente> {
	private static final String INSERT_QUERY = "INSERT INTO personale VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL = "SELECT * FROM personale";

	@Override
	public boolean create(Dipendente entity) throws SQLException {
		boolean risultato;
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(INSERT_QUERY);
		String nome = entity.getNome();
		prepStat.setString(1, nome);
		String cognome = entity.getCognome();
		prepStat.setString(2, cognome);
		String sesso = entity.getSesso();
		prepStat.setString(3, sesso);
		String Data = entity.getDatadinascita();
		prepStat.setString(4, Data);
		String cod = entity.getCodiceFiscale();
		prepStat.setString(5, cod);
		String mail = entity.getMail();
		prepStat.setString(6, mail);
		String tel = entity.getTelefono();
		prepStat.setString(7, tel);
		String domicilio = entity.getDomicilio();
		prepStat.setString(8, domicilio);
		String mansione = entity.getMansione();
		prepStat.setString(9, mansione);
		String sede = entity.getSedeAppartenenza();
		prepStat.setString(10, sede);
		return risultato = prepStat.executeUpdate() != 0;

	}

	@Override
	public boolean update(Dipendente entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dipendente read(String ID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dipendente> getAll() throws SQLException {
		Connection connessione = MySqlDaoFactory.connetti();
		PreparedStatement prepStat = connessione.prepareStatement(GET_ALL);
		ResultSet risultato = prepStat.executeQuery();
		List<Dipendente> lista = getLista(risultato);
		return lista;
	}

	private List<Dipendente> getLista(ResultSet resultSet) throws SQLException {
		List<Dipendente> dipendenti = new LinkedList<Dipendente>();

		while (resultSet.next()) {
			Dipendente elemento = new Dipendente();
			String Nome = resultSet.getString("Nome");
			elemento.setNome(Nome);
			String Cognome = resultSet.getString("Cognome");
			elemento.setCognome(Cognome);
			String sesso = resultSet.getString("Sesso");
			elemento.setSesso(sesso);
			String Datadinascita = resultSet.getString("Datanascita");
			elemento.setDatadinascita(Datadinascita);
			String CodiceFiscale = resultSet.getString("CodiceFiscale");
			elemento.setCodiceFiscale(CodiceFiscale);
			String mail = resultSet.getString("Mail");
			elemento.setMail(mail);
			String Domicilio = resultSet.getString("Domicilio");
			elemento.setDomicilio(Domicilio);
			String Mansione = resultSet.getString("Mansione");
			elemento.setMansione(Mansione);
			String telefono = resultSet.getString("Telefono");
			elemento.setTelefono(telefono);
			String SedeAppartenenza = resultSet.getString("SedeAppartenenza");
			elemento.setSedeAppartenenza(SedeAppartenenza);
			dipendenti.add(elemento);
		}
		return dipendenti;
	}

}
