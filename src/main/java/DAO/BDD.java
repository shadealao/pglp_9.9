package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class BDD {
	public Connection connect = null;
	private String dburl = "jdbc:derby:test;create=true";
	private Properties connectionProps = new Properties();
	public void connection () throws SQLException {
		/*Object userName = "shade";
		connectionProps.put("user", userName);
		Object password = "alao";
		connectionProps.put("password", password);
		try (Connection con = DriverManager.getConnection(dburl, connectionProps)){
		try (Connection con = DriverManager.getConnection(dburl,"myLogin","myPassword")) {	
			this.con = con;
			try (Statement stmt = con.createStatement()) {
			stmt.executeUpdate("CREATE TABLE utilisateur ("
					+ "id INT PRIMARY KEY NOT NULL,"
					+ " nom VARCHAR(100)"
					+ ")");
		}
			try (Statement stmt = con.createStatement()) {
			stmt.executeUpdate("INSERT INTO utilisateur(id, nom) VALUES (1, 'Alao')");
		}
			creationTableCercle(con);
		}
		*/
		connect = DriverManager.getConnection(dburl,
				"myLogin",
				"myPassword");

	}

	public void creationTableCercle() throws SQLException {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Cercle ("
					+ "nom VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "centrex Int,"
					+ "centrey Int,"
					+ "rayon double"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creationTableRectangle() throws SQLException {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Rectangle ("
					+ "nom VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "HGx Int,"
					+ "HGy Int,"
					+ "largeur double,"
					+ "longeur double"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creationTableCarre() throws SQLException {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Carre ("
					+ "nom VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "HGx Int,"
					+ "HGy Int,"
					+ "cote double"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creationTableTriangle() throws SQLException {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE Triangle ("
					+ "nom VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "p1x Int,"
					+ "p1y Int,"
					+ "p2x Int,"
					+ "p2y Int,"
					+ "p3x Int,"
					+ "p3y Int"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void creationTableGroupeForme() throws SQLException {
		try (Statement stmt = this.connect.createStatement()) {
			stmt.executeUpdate("CREATE TABLE GroupeForme ("
					+ "nom VARCHAR(100) NOT NULL,"
					+ "typeobjet VARCHAR(100) NOT NULL,"
					+ "nomobjet VARCHAR(100) NOT NULL,"
					+ "PRIMARY KEY(nom, typeobjet, nomobjet)"
					+ ")");
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void AfficheTable(String table) throws SQLException {
		String r = "";
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM "+table);
			//prepare.setString(1, table);
			ResultSet result = prepare.executeQuery();
			System.out.println("Table : "+ table);
			while(result.next()) {
				int numColumns = result.getMetaData().getColumnCount();
				 for (int i = 1; i <= numColumns; i++) {
					 r +=result.getMetaData().getColumnName(i)+ " : "+ result.getObject(i)+"\t";
				 }
				 r+="\n";
			}
			System.out.println(r);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void DropTable(String table) {
		PreparedStatement prepare;
		try {
			prepare = connect.prepareStatement("DROP TABLE "+table);
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}




