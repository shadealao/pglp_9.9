package fr.uvsq21506437.logicielDessin;

import java.sql.SQLException;

import DAO.CercleDAO;
import DAO.DAO;
import Exception.EstListeVide;
import Exception.NomVide;
import junit.framework.TestCase;

public class DAOTest extends TestCase{
	public void testCercleDAO() throws SQLException, NomVide, EstListeVide {
		DAO<Cercle> c1 = new CercleDAO();
		Cercle f1 = new Cercle("c1", new Point(5, 5), 5);
		
		//c1.create(f1);
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

}
