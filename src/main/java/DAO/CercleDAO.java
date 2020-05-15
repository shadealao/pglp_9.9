package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.NomVide;
import fr.uvsq21506437.logicielDessin.Cercle;
import fr.uvsq21506437.logicielDessin.Point;

public class CercleDAO extends DAO<Cercle> {
	

	public CercleDAO() throws SQLException {
		super();
	}
	@Override
	public ArrayList<Cercle> init() {
		ArrayList<Cercle> cercle = new ArrayList<Cercle>();
			try {
				
				PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Cercle  ");
				ResultSet result = prepare.executeQuery();
				while (result.next()) {
				cercle.add(new Cercle(result.getString("nom"), new Point(result.getInt("centrex"), result.getInt("centrey")), result.getDouble("rayon")));
				}
			} catch (NomVide | SQLException e) {
				e.printStackTrace();
			}
		return cercle;
	}

	@Override
	public Cercle create(Cercle obj) {
	
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Cercle (nom, centrex, centrey, rayon)"
					+ "VALUES(?,?,?,?)");
			prepare.setString(1, obj.getNom());
			prepare.setInt(2, obj.getPoint().getX());
			prepare.setInt(3, obj.getPoint().getY());
			prepare.setDouble(4, obj.getRayon());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Cercle read(String nom) {
		Cercle obj = null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Cercle WHERE nom = ? ");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				obj = new Cercle(result.getString("nom"), new Point(result.getInt("centrex"), result.getInt("centrey")), result.getDouble("rayon"));
			}
			
		} catch (SQLException | NomVide e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Cercle update(Cercle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Cercle"
					+ " SET centrex = ? , centrey = ? , rayon = ?"
					+ " WHERE nom = ?");
			prepare.setInt(1, obj.getPoint().getX());
			prepare.setInt(2, obj.getPoint().getY());
			prepare.setDouble(3, obj.getRayon());
			prepare.setString(4, obj.getNom());
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public void delete(Cercle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM Cercle WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			prepare.executeUpdate();
			obj = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
