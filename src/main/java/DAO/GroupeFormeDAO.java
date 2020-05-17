package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Exception.EstListeVide;
import Exception.NomVide;
import composite.GroupeForme;
import fr.uvsq21506437.logicielDessin.Carre;
import fr.uvsq21506437.logicielDessin.Cercle;
import fr.uvsq21506437.logicielDessin.Forme;
import fr.uvsq21506437.logicielDessin.Point;
import fr.uvsq21506437.logicielDessin.Rectangle;
import fr.uvsq21506437.logicielDessin.Triangle;

public class GroupeFormeDAO extends DAO<GroupeForme>{

	public GroupeFormeDAO() throws SQLException {
		super();
	}

	@Override
	public ArrayList<Forme> init() {
		ArrayList<Forme> GF = new ArrayList<Forme>();

		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM GroupeForme ");
			ResultSet result = prepare.executeQuery();

			while (result.next()) {
				PreparedStatement prep = connect.prepareStatement("SELECT * FROM "+ result.getString("typeobjet") +" WHERE nom = '"+ result.getString("nomobjet")+"'");
				ResultSet res = prep.executeQuery();
				GroupeForme GForme = new GroupeForme(result.getString("nom"));
				while (res.next()) {
					if(result.getString("typeobjet").equals("Carre")) {
						GForme.add( new Carre(res.getString("nom"), new Point(res.getInt("HGx"), res.getInt("HGy")), res.getDouble("cote")));
					}
					else if(result.getString("typeobjet").equals("Cercle")) {
						GForme.add( new Cercle(res.getString("nom"), new Point(res.getInt("centrex"), res.getInt("centrey")), res.getDouble("rayon")));

					}
					else if(result.getString("typeobjet").equals("Rectangle")) {
						GForme.add( new Rectangle(res.getString("nom"), new Point(res.getInt("HGx"), res.getInt("HGy")), res.getDouble("largeur"), res.getDouble("longeur")));

					}
					else if(result.getString("typeobjet").equals("Triangle")) {
						GForme.add( new Triangle(res.getString("nom"), new Point(res.getInt("p1x"), res.getInt("p1y")),  new Point(res.getInt("p2x"), res.getInt("p2y")),  new Point(res.getInt("p3x"), res.getInt("p3y"))));
					}

				}

				GF.add(GForme);
			}
		} catch (SQLException | NomVide e) {
			e.printStackTrace();
		}
		return GF;
	}

	@Override
	public GroupeForme create(GroupeForme obj)  {
		ArrayList<Forme> formes = obj.getList();
		

		for (Forme forme : formes) {
			try {
				PreparedStatement prepare = connect.prepareStatement("SELECT * FROM GroupeForme WHERE nom = ? AND typeobjet = ? AND nomobjet = ?");
				prepare.setString(1, obj.getNom());
				prepare.setString(2, forme.getClass().getSimpleName().toString());
				prepare.setString(3, forme.getNom());
				ResultSet res = prepare.executeQuery();
				if(!res.next()) {

					prepare = connect.prepareStatement("INSERT INTO GroupeForme (nom, typeobjet, nomobjet)"
							+ " VALUES(?,?,?)");
					prepare.setString(1, obj.getNom());
					prepare.setString(2, forme.getClass().getSimpleName().toString());
					prepare.setString(3, forme.getNom());
					int result = prepare.executeUpdate();
					assert result == 1;
				}
			} catch (SQLException e) {
				//System.out.println(e.getMessage()+ "\n\n"+e.getSQLState()+"\n\n"+e.fillInStackTrace()+"\n\n "+e.);
				e.printStackTrace();
			}
		}

		return obj;
	}

	@Override
	public GroupeForme read(String nom) {
		GroupeForme obj = null;
		try {
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM GroupeForme WHERE nom = ? ");
			prepare.setString(1, nom);
			ResultSet result = prepare.executeQuery();
			obj = new GroupeForme(nom);
			//ArrayList<Forme> formes;
			while (result.next()) {

				try {

					PreparedStatement prep = connect.prepareStatement("SELECT * FROM "+ result.getString("typeobjet") +" WHERE nom = '"+ result.getString("nomobjet")+"'");
					ResultSet res = prep.executeQuery();
					while (res.next()) {
						if(result.getString("typeobjet").equals("Carre")) {
							obj.add( new Carre(res.getString("nom"), new Point(res.getInt("HGx"), res.getInt("HGy")), res.getDouble("cote")));

						}
						else if(result.getString("typeobjet").equals("Cercle")) {
							obj.add( new Cercle(res.getString("nom"), new Point(res.getInt("centrex"), res.getInt("centrey")), res.getDouble("rayon")));

						}
						else if(result.getString("typeobjet").equals("Rectangle")) {
							obj.add( new Rectangle(res.getString("nom"), new Point(res.getInt("HGx"), res.getInt("HGy")), res.getDouble("largeur"), res.getDouble("longeur")));

						}
						else if(result.getString("typeobjet").equals("Triangle")) {
							obj.add( new Triangle(res.getString("nom"), new Point(res.getInt("p1x"), res.getInt("p1y")),  new Point(res.getInt("p2x"), res.getInt("p2y")),  new Point(res.getInt("p3x"), res.getInt("p3y"))));
						}
					}
				}catch (SQLException | NomVide e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public GroupeForme update(GroupeForme obj) {
		try {


			ArrayList<Forme> formes = obj.getList();
			for (Forme forme : formes) {
				String table = forme.getClass().getSimpleName();
				if(table.equalsIgnoreCase("Carre")) {
					PreparedStatement prep = connect.prepareStatement("UPDATE Carre"
							+ " SET HGx = ? , HGy = ? , cote = ?"
							+ " WHERE nom = ?");

					prep.setInt(1, ((Carre) forme).getPoint().getX());
					prep.setInt(2, ((Carre) forme).getPoint().getY());
					prep.setDouble(3, ((Carre)forme).getCote());
					prep.setString(4, ((Carre)forme).getNom());
					prep.executeUpdate();
				} else if(table.equalsIgnoreCase("Cercle")) {
					PreparedStatement prep = connect.prepareStatement("UPDATE Cercle"
							+ " SET centrex = ? , centrey = ? , rayon = ?"
							+ " WHERE nom = ?");
					prep.setInt(1, ((Cercle) forme).getPoint().getX());
					prep.setInt(2, ((Cercle) forme).getPoint().getY());
					prep.setDouble(3, ((Cercle) forme).getRayon());
					prep.setString(4, ((Cercle) forme).getNom());
					prep.executeUpdate();

				} else if(table.equalsIgnoreCase("Rectangle")) {
					PreparedStatement prep = connect.prepareStatement("UPDATE Rectangle"
							+ " SET HGx = ? , HGy = ? , largeur = ? , longeur = ? "
							+ " WHERE nom = ?");
					prep.setInt(1, ((Rectangle) forme).getPoint().getX());
					prep.setInt(2, ((Rectangle) forme).getPoint().getY());
					prep.setDouble(3, ((Rectangle) forme).getLongeur());
					prep.setDouble(4, ((Rectangle) forme).getLargeur());
					prep.setString(5, ((Rectangle) forme).getNom());
					prep.executeUpdate();
				} else if(table.equalsIgnoreCase("Triangle")) {
					String nom = forme.getNom();
					System.out.println("tri : nom => "+nom+ "   ");
					forme.afficher();
					PreparedStatement prep = connect.prepareStatement("UPDATE Triangle"
							+ " SET p1x = ? , p1y = ? , p2x = ? , p2y = ? , p3x = ? , p3y = ? "
							+ " WHERE nom = ?");
					prep.setInt(1, ((Triangle) forme).getPoint1().getX());
					prep.setInt(2, ((Triangle) forme).getPoint1().getY());
					prep.setInt(3, ((Triangle) forme).getPoint2().getX());
					prep.setInt(4, ((Triangle) forme).getPoint2().getY());
					prep.setInt(5, ((Triangle) forme).getPoint3().getX());
					prep.setInt(6, ((Triangle) forme).getPoint3().getY());
					prep.setString(7, nom);
					int res = prep.executeUpdate();
					System.out.println("res ==> "+ res);
					//assert res == 1;
					
					 prep = connect.prepareStatement("SELECT * FROM Triangle"
							+ " WHERE nom = ?");
					prep.setString(1, nom);
					ResultSet resu = prep.executeQuery();
					if(!resu.next()) System.out.println("r");
					else System.out.println("r2");
						System.out.println(" je vérifie  \t nom :"+ resu.getString("nom")+ "  ("+resu.getInt("p1x")+","+resu.getInt("p1y")+")");
					
					
					
					
				} 
			}


			GroupeForme bis = obj;
			delete(bis);

			create(obj);



		} catch (SQLException | EstListeVide e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(GroupeForme obj) {
		try {
			//obj.getList();
			PreparedStatement prepare = connect.prepareStatement("DELETE FROM GroupeForme WHERE nom = ? ");
			prepare.setString(1, obj.getNom());
			prepare.executeUpdate();
			obj = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
