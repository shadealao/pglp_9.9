package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BDD {
	protected Connection con = null;
	String dburl = "jdbc:derby:test;create=true";
	Properties connectionProps = new Properties();
	public void connection () throws SQLException {
		Object userName = "shade";
		connectionProps.put("user", userName);
		Object password = "alao";
		connectionProps.put("password", password);
		//try (Connection con = DriverManager.getConnection(dburl, connectionProps)){
//		try (Connection con = DriverManager.getConnection(dburl,"myLogin","myPassword")) {	
//			this.con = con;
			/*try (Statement stmt = con.createStatement()) {
			stmt.executeUpdate("CREATE TABLE utilisateur ("
					+ "id INT PRIMARY KEY NOT NULL,"
					+ " nom VARCHAR(100)"
					+ ")");
		}*/
			/*try (Statement stmt = con.createStatement()) {
			stmt.executeUpdate("INSERT INTO utilisateur(id, nom) VALUES (1, 'Alao')");
		}*/
//			creationTableCercle(con);
//		}
		con = DriverManager.getConnection(dburl,"myLogin","myPassword");

	}

	public void creationTableCercle() throws SQLException {
		try (Statement stmt = this.con.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Cercle ("
					+ "nom VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "centrex Int,"
					+ "centrey Int,"
					+ "rayon double"
					+ ")");
		}
	}
	public void AfficheTable() throws SQLException {
		try (
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery("SELECT * FROM Cercle")
				) {
			while (rs.next()) {
				int numColumns = rs.getMetaData().getColumnCount();
				for (int i = 1; i <= numColumns; i++) {
					// Column numbers start at 1.
					// Also there are many methods on the result set to return
					//  the column as a particular type. Refer to the Sun documentation
					//  for the list of valid conversions.
					System.out.println( "COLUMN " + i + " = " + rs.getObject(i));
				}
			}
		}
	}
}




