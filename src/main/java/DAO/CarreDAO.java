package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.NomVide;
import fr.uvsq21506437.logicielDessin.Carre;
import fr.uvsq21506437.logicielDessin.Point;

public class CarreDAO extends DAO<Carre>{

	public CarreDAO() throws SQLException {
		super();
	}

	@Override
	public ArrayList<Carre> init() {
		ArrayList<Carre> carre = new ArrayList<Carre>();
			try {
				
				PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Carre ");
				ResultSet result = prepare.executeQuery();
				while (result.next()) {
				carre.add(new Carre(result.getString("nom"), new Point(result.getInt("HGx"), result.getInt("HGy")), result.getDouble("cote")));
				}
			} catch (NomVide | SQLException e) {
				e.printStackTrace();
			}
		return carre;
	}
	
	@Override
	public Carre create(Carre obj)  {
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Carre (nom, HGx, HGy, cote)"
					+ " VALUES(?,?,?,?)");
			prepare.setString(1, obj.getNom());
			prepare.setInt(2, obj.getPoint().getX());
			prepare.setInt(3, obj.getPoint().getY());
			prepare.setDouble(4, obj.getCote());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Carre read(String nom) {
		Carre obj = null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Carre WHERE nom = ? ");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				obj = new Carre(result.getString("nom"), new Point(result.getInt("HGx"), result.getInt("HGy")), result.getDouble("cote"));
			}
			
		} catch (SQLException | NomVide e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Carre update(Carre obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Carre"
					+ " SET HGx = ? , HGy = ? , cote = ?"
					+ " WHERE nom = ?");
			prepare.setInt(1, obj.getPoint().getX());
			prepare.setInt(2, obj.getPoint().getY());
			prepare.setDouble(3, obj.getCote());
			prepare.setString(4, obj.getNom());
			
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public void delete(Carre obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM Carre WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			prepare.executeUpdate();
			obj = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
