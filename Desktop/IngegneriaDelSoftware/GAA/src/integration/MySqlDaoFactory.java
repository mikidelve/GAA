package integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory {
  
  private static MySqlDaoFactory dao;
  private static String connessione;
  private static Connection con;
  
  private MySqlDaoFactory(){
    connessione="jdbc:mysql://localhost/gestoreanagrafica";

  }

  public static MySqlDaoFactory getIstance() {
    if (dao == null) {
      dao = new MySqlDaoFactory();
    }
    return dao;
  }
  public static Connection connetti() throws SQLException {
    getIstance();
    con = DriverManager.getConnection(connessione, "root", "root");
    return con;
  }
}