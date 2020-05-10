package fr.uvsq21506437.logicielDessin;

import Exception.EstListeVide;
import Exception.NomVide;
import composite.GroupeForme;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class GroupeFormeTest extends TestCase {
    /**
     * 
     * @throws NomVide regarde si le nom de la forme a bien été noté
     * @throws EstListeVide regarde si la liste est vide
     */
    public void testGroupeForme() throws NomVide, EstListeVide {
    	Forme f1 = new Cercle("c1", new Point(5, 5), 5);
        Forme f2 = new Rectangle("r1", new Point(2, 1), 5, 10);
        Forme f3 = new Carre("car1", new Point(8, 2), 6);
        Forme f4 = new Triangle("tri1", new Point(4, 2), new Point(6, 3), new Point(5, 4));
        
        GroupeForme grp1 = new GroupeForme();
        GroupeForme grp2 = new GroupeForme();
        
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
    }

    

    /**
     * 
     */
    public void testEstListeVide(){
    	GroupeForme grp1;
    	Throwable t = null;
    	try {
    		grp1 = new GroupeForme();
    		grp1.afficher();
    	} catch (EstListeVide e) {
    		t = e.fillInStackTrace();
    	}
    	assertNotNull(t);
    	assertSame(EstListeVide.class, t.getClass());
    }
}
