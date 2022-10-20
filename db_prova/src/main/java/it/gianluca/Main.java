package it.gianluca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {

	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	  static final String DB_URL = "jdbc:mysql://localhost/gestione_officina";
	  static final String USER = "gianluca";
	  static final String PASS = "gianluca";

	  public static void main(String[] args) {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	      Class.forName(JDBC_DRIVER);
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      stmt = conn.createStatement();
	      String sql = "SELECT * FROM veicolo WHERE 1; ";
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	        int id = rs.getInt("n_telaio");
	        int modello = rs.getInt("cod_modello");
	        String targa = rs.getString("targa");
	        String colore = rs.getString("colore");

	        System.out.print("ID: " + id);
	        System.out.print(", Cod_Modello: " + modello);
	        System.out.print(", Targa: " + targa);
	        System.out.println(", Colore: " + colore);
	      }
	      rs.close();
	      stmt.close();
	      conn.close();
	    } catch (SQLException se) {
	      se.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (stmt != null)
	          stmt.close();
	        if (conn != null)
	          conn.close();
	      } catch (SQLException se) {
	        se.printStackTrace();
	      }
	    }
	  }
		}
	


