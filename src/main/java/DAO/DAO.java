package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exception.NomVide;

public abstract class DAO <T>{
	String dburl = "jdbc:derby:test;create=true";
	protected Connection connect; 
	public DAO() throws SQLException{
		connect =  DriverManager.getConnection(dburl,
			"myLogin",
			"myPassword");
	}
	
	public abstract T create(T obj);
	public abstract T read(String nom);
	public abstract T update(T obj);
	public abstract void delete(T obj);
}
