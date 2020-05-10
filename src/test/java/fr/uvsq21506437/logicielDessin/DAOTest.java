package fr.uvsq21506437.logicielDessin;

import java.sql.SQLException;

import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.DAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import Exception.EstListeVide;
import Exception.NomVide;
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
}
