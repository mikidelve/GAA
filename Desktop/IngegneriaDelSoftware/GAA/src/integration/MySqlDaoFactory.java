package integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe DAO utilizzata per effettuare la connessione al  database
 * @author Giava
 *
 */
public class MySqlDaoFactory {
  
  private static MySqlDaoFactory dao;
  private static String connessione;
  private static String password;
  private static String username;
  
  private MySqlDaoFactory(){
    connessione="jdbc:mysql://localhost/gestoreanagrafica";
    username="root";
    password="root";
  }

  public static MySqlDaoFactory getIstance() {
    if (dao == null) {
      dao = new MySqlDaoFactory();
    }
    return dao;
  }
  public static Connection connetti() throws SQLException {
    getIstance();
    Connection con = DriverManager.getConnection(connessione, username, password);
    return con;
  }
}