package fr.uvsq21506437.logicielDessin;

import java.sql.SQLException;

import DAO.BDD;
import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.DAO;
import DAO.GroupeFormeDAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import Exception.EstListeVide;
import Exception.NomVide;
import composite.GroupeForme;
import junit.framework.TestCase;

public class DAOTest extends TestCase{
	
	public void testCercleDAO() throws SQLException, NomVide, EstListeVide {
		DAO<Cercle> c1 = new CercleDAO();
		Cercle f1 = new Cercle("c1", new Point(5, 5), 5);
		System.out.println("************* CERCLE *************");
		c1.create(f1);
		System.out.println("Part1 - read");
		Cercle res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
		
		System.out.println("Part2 - update");
		f1.deplacer(2, 7);
		c1.update(f1);
		res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
	}

	public void testCarreDAO() throws SQLException, NomVide, EstListeVide {
		DAO<Carre> c1 = new CarreDAO();
		Carre f1 = new Carre("c1", new Point(7, 5), 2.1);
		System.out.println("************* CARRE *************");
		c1.create(f1);
		System.out.println("Part1 - read");
		Carre res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
		
		System.out.println("Part2 - update");
		f1.deplacer(2, 7);
		c1.update(f1);
		res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
	}
	
	public void testRectangleDAO() throws SQLException, NomVide, EstListeVide {
		DAO<Rectangle> c1 = new RectangleDAO();
		Rectangle f1 = new Rectangle("c1", new Point(2, 41), 2.1, 8);
		
		System.out.println("************* RECTANGLE *************");
		c1.create(f1);
		System.out.println("Part1 - read");
		Rectangle res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
		
		System.out.println("Part2 - update");
		f1.deplacer(1, 4);
		c1.update(f1);
		res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
	}
	
	public void testTriangleDAO() throws SQLException, NomVide, EstListeVide {
		DAO<Triangle> c1 = new TriangleDAO();
		Triangle f1 = new Triangle("c1", new Point(2, 1),new Point(4, 4), new Point(7, 10) );
		
		System.out.println("************* TRIANGLE *************");
		c1.create(f1);
		System.out.println("Part1 - read");
		Triangle res = c1.read(f1.getNom());
		f1.afficher();
		res.afficher();
		
		System.out.println("Part2 - update");
		f1.deplacer(1, 4);
		c1.update(f1);
		Triangle res2 = c1.read(f1.getNom());
		f1.afficher();
		res2.afficher();
	}
	
	public void testGroupeFormeDAO() throws SQLException, NomVide, EstListeVide {
		BDD db = new BDD();
		db.connection();
		db.DropTable("GroupeForme");
		db.DropTable("Carre");
		db.DropTable("Rectangle");
		db.DropTable("Triangle");
		db.DropTable("Cercle");
		
		
		db.creationTableCercle();
		db.creationTableCarre();
		db.creationTableRectangle();
		db.creationTableTriangle();
		db.creationTableGroupeForme();
		
		db.AfficheTable("Cercle");
		db.AfficheTable("Carre");
		db.AfficheTable("Rectangle");
		db.AfficheTable("Triangle");
		db.AfficheTable("GroupeForme");
		
		DAO<GroupeForme> c1 = new GroupeFormeDAO();
		DAO<Rectangle> R = new RectangleDAO();
		DAO<Carre> C = new CarreDAO();
		DAO<Cercle> CE = new CercleDAO();
		DAO<Triangle> T = new TriangleDAO();
		
		GroupeForme grp1 = new GroupeForme("grp1");
		
		Cercle f1 = new Cercle("c1", new Point(5, 5), 5);
        Rectangle f2 = new Rectangle("r1", new Point(2, 1), 5, 10);
        Carre f3 = new Carre("car1", new Point(8, 2), 6);
        Triangle f4 = new Triangle("tri1", new Point(4, 2), new Point(6, 3), new Point(5, 4));
//        grp1.remove(f1);
//		grp1 = c1.update(grp1);
		
        grp1.add(f1);
        grp1.add(f2);
        
        System.out.println("************* GROUPE FORME *************");
        CE.create(f1);
        R.create(f2);
        C.create(f3);
        T.create(f4);
        
        CE.update(f1);
        R.update(f2);
        C.update(f3);
        T.update(f4);
     
        c1.create(grp1);
		System.out.println("\nPart1 - read");
		GroupeForme res = c1.read(grp1.getNom());
		grp1.afficher();
		System.out.println("\t ---");
		res.afficher();
		
		System.out.println("\nPart2 - update1 ");
		grp1.deplacer(1, 4);
		grp1 = c1.update(grp1);
		GroupeForme res2 = c1.read(grp1.getNom());
		grp1.afficher();
		System.out.println("\t ---");
		res2.afficher();
		
		
		System.out.println("\nPart2 - update2 ");
		grp1.add(f3);
		grp1 = c1.update(grp1);
		GroupeForme res3 = c1.read(grp1.getNom());
		grp1.afficher();
		System.out.println("\t ---");
		res3.afficher();
		
		System.out.println("\nPart2 - update3 ");
		grp1.remove(f1);
		grp1 = c1.update(grp1);
		GroupeForme res4 = c1.read(grp1.getNom());
		grp1.afficher();
		System.out.println("\t ---");
		res4.afficher();
		
		
	}
}
