package fr.uvsq21506437.logicielDessin;

import java.sql.SQLException;

import DAO.BDD;
import junit.framework.TestCase;
/**
 * test connexion BDD.
 * @author user
 *
 */
public class ConnectionTest extends TestCase {

	/**
	 * test création tables BDD
	 * @throws SQLException exception SQL
	 */
	public void testApp() throws SQLException {
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

		
	}
}
