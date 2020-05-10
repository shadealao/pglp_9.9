package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exception.NomVide;
import fr.uvsq21506437.logicielDessin.Cercle;
import fr.uvsq21506437.logicielDessin.Point;

public class CercleDAO extends DAO<Cercle>{

	public CercleDAO() throws SQLException {
		super();
	}

	@Override
	public Cercle create(Cercle obj) {
		String n = obj.getNom();
		int x = obj.getPoint().getX();
		int y = obj.getPoint().getY();
		double r = obj.getCentre();
		System.out.println("i"); 
		obj.afficher();
		System.out.println("j");
		System.out.println("n "+n+ " ("+x+","+y+")"+" r = "+ r);
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Cercle (nom, centrex, centrey, rayon)"
					+ "VALUES(?,?,?,?)");
			prepare.setString(1, obj.getNom());
			prepare.setInt(2, obj.getPoint().getX());
			prepare.setInt(3, obj.getPoint().getY());
			prepare.setDouble(4, obj.getCentre());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public Cercle read(String nom) throws NomVide, SQLException {
		int x = 0;
		int y = 0;
		double rayon = 0.0;
		PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Cercle  ");
		ResultSet result = prepare.executeQuery();
		while (result.next()) {
			nom = result.getString("nom");
			x = result.getInt("centrex");
			y = result.getInt("centrey");
			rayon = result.getDouble("rayon");
		}
		Cercle obj = new Cercle(nom,
				new Point(x, y),
				rayon);
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
			prepare.setDouble(3, obj.getCentre());
			prepare.setString(4, obj.getNom());
			
			int result = prepare.executeUpdate();
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
			int result = prepare.executeUpdate();
			obj = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
