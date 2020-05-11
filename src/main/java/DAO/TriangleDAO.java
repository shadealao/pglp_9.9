package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.NomVide;
import fr.uvsq21506437.logicielDessin.Carre;
import fr.uvsq21506437.logicielDessin.Point;
import fr.uvsq21506437.logicielDessin.Rectangle;
import fr.uvsq21506437.logicielDessin.Triangle;

public class TriangleDAO extends DAO<Triangle>{

	public TriangleDAO() throws SQLException {
		super();
	}

	@Override
	public Triangle create(Triangle obj)  {
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Triangle (nom, p1x, p1y, p2x, p2y, p3x, p3y)"
					+ " VALUES(?,?,?,?,?,?,?)");
			prepare.setString(1, obj.getNom());
			prepare.setInt(2, obj.getPoint1().getX());
			prepare.setInt(3, obj.getPoint1().getY());
			prepare.setInt(4, obj.getPoint2().getX());
			prepare.setInt(5, obj.getPoint2().getY());
			prepare.setInt(6, obj.getPoint3().getX());
			prepare.setInt(7, obj.getPoint3().getY());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Triangle read(String nom) {
		Triangle obj = null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Triangle WHERE nom = ? ");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				obj = new Triangle(result.getString("nom"), new Point(result.getInt("p1x"), result.getInt("p1y")),  new Point(result.getInt("p2x"), result.getInt("p2y")),  new Point(result.getInt("p3x"), result.getInt("p3y")));
			}
			
		} catch (SQLException | NomVide e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Triangle update(Triangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Triangle"
					+ " SET p1x = ? , p1y = ? , p2x = ? , p2y = ? , p3x = ? , p3y = ? "
					+ " WHERE nom = ?");
			prepare.setInt(1, obj.getPoint1().getX());
			prepare.setInt(2, obj.getPoint1().getY());
			prepare.setInt(3, obj.getPoint2().getX());
			prepare.setInt(4, obj.getPoint2().getY());
			prepare.setInt(5, obj.getPoint3().getX());
			prepare.setInt(6, obj.getPoint3().getY());
			prepare.setString(7, obj.getNom());
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public void delete(Triangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM Triangle WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			int result = prepare.executeUpdate();
			obj = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
