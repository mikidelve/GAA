package integration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory {
  
  private static MySqlDaoFactory dao;
  private static String connessione;
  private static String password;
  private static String username;
  private static Connection con;
  
  private MySqlDaoFactory(){
    //connessione="jdbc:mysql://localhost/gestoreanagrafica";
                connessione="jdbc:mysql://athena.pixelstyle.it/giava_fm";
    username="giava_fm";
    password="arsg&ZWfwXPHw7S@IKE";
                //database="giava_fm";
  }

  public static MySqlDaoFactory getIstance() {
    if (dao == null) {
      dao = new MySqlDaoFactory();
    }
    return dao;
  }
  public static Connection connetti() throws SQLException {
    getIstance();
    con = DriverManager.getConnection(connessione, username, password);
    return con;
  }
}