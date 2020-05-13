package fr.uvsq21506437.logicielDessin;

import java.sql.SQLException;

import DAO.BDD;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ConnectionTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 * @throws SQLException 
	 */
	public void testApp() throws SQLException {
		BDD db = new BDD();
		db.connection();
		/*
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
		*/
		db.AfficheTable("Cercle");
		db.AfficheTable("Carre");
		db.AfficheTable("Rectangle");
		db.AfficheTable("Triangle");
		db.AfficheTable("GroupeForme");
		
		/*db.DropTable("GroupeForme");
		db.creationTableGroupeForme();
		db.AfficheTable("GroupeForme");
		*/
		//db.creationclass();
	}
}
