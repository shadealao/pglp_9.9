package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.NomVide;
import fr.uvsq21506437.logicielDessin.Point;
import fr.uvsq21506437.logicielDessin.Rectangle;

public class RectangleDAO extends DAO<Rectangle>{

	public RectangleDAO() throws SQLException {
		super();
	}
	
	@Override
	public ArrayList<Rectangle> init() {
		ArrayList<Rectangle> rectangle = new ArrayList<Rectangle>();
			try {
				
				PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Rectangle ");
				ResultSet result = prepare.executeQuery();
				while (result.next()) {
				rectangle.add(new Rectangle(result.getString("nom"), new Point(result.getInt("HGx"), result.getInt("HGy")), result.getDouble("largeur"), result.getDouble("longeur")));
				}
			} catch (NomVide | SQLException e) {
				e.printStackTrace();
			}
		return rectangle;
	}

	@Override
	public Rectangle create(Rectangle obj)  {
		try {
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Rectangle (nom, HGx, HGy, largeur, longeur)"
					+ " VALUES(?,?,?,?,?)");
			prepare.setString(1, obj.getNom());
			prepare.setInt(2, obj.getPoint().getX());
			prepare.setInt(3, obj.getPoint().getY());
			prepare.setDouble(4, obj.getLongeur());
			prepare.setDouble(5, obj.getLargeur());
			int result = prepare.executeUpdate();
			assert result == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Rectangle read(String nom) {
		Rectangle obj = null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Rectangle WHERE nom = ? ");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			while (result.next()) {
				obj = new Rectangle(result.getString("nom"), new Point(result.getInt("HGx"), result.getInt("HGy")), result.getDouble("largeur"), result.getDouble("longeur"));
			}
			
		} catch (SQLException | NomVide e) {
			e.printStackTrace();
		}
		
		return obj;
	}

	@Override
	public Rectangle update(Rectangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("UPDATE Rectangle"
					+ " SET HGx = ? , HGy = ? , largeur = ? , longeur = ? "
					+ " WHERE nom = ?");
			prepare.setInt(1, obj.getPoint().getX());
			prepare.setInt(2, obj.getPoint().getY());
			prepare.setDouble(3, obj.getLongeur());
			prepare.setDouble(4, obj.getLargeur());
			prepare.setString(5, obj.getNom());
			prepare.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public void delete(Rectangle obj) {
		try {
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM Rectangle WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			prepare.executeUpdate();
			obj = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
