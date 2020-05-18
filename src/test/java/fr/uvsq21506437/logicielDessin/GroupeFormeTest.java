package fr.uvsq21506437.logicielDessin;

import java.sql.SQLException;

import Exception.EstListeVide;
import Exception.NomVide;
import composite.GroupeForme;
import junit.framework.TestCase;
/**
 * Test GroupeForme
 * @author user
 *
 */
public class GroupeFormeTest extends TestCase {
    public void testGroupeForme() {
    	try {
    	
    	Forme f1 = new Cercle("c1", new Point(5, 5), 5);
        Forme f2 = new Rectangle("r1", new Point(2, 1), 5, 10);
        Forme f3 = new Carre("car1", new Point(8, 2), 6);
        Forme f4 = new Triangle("tri1", new Point(4, 2), new Point(6, 3), new Point(5, 4));
        
        GroupeForme grp1 = new GroupeForme("grp1");
        GroupeForme grp2 = new GroupeForme("grp2");
        
        grp1.add(f1);
        grp1.add(f2);
        
        grp2.add(f3);
        grp2.add(f4);
        
        System.out.println("groupe 1");
        grp1.afficher();
        grp1.deplacer(8, 3);
        grp1.afficher();
        
        System.out.println("\n\ngroupe 2");
        grp2.afficher();
        grp2.deplacer(2, 4);
        grp2.afficher();
    	} catch (NomVide | EstListeVide e) {
			e.printStackTrace();
		}
    }

    

    /**
     * j'affiche GroupeForme vide.
     */
    public void testEstListeVide(){
    	GroupeForme grp1;
    	Throwable t = null;
    	try {
    		grp1 = new GroupeForme("grp1");
    		grp1.afficher();
    	} catch (EstListeVide e) {
    		t = e.fillInStackTrace();
    	}
    	assertNotNull(t);
    	assertSame(EstListeVide.class, t.getClass());
    }
}
