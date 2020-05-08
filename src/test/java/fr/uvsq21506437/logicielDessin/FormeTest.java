package fr.uvsq21506437.logicielDessin;

import Exception.EstListeVide;
import Exception.NomVide;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Je teste les relations d'héritage entre forme et les autres forme (cercle tri etc.).
 */
public class FormeTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws NomVide 
     * @throws EstListeVide 
     */
    public void testForme() throws NomVide, EstListeVide{
        Forme f1 = new Cercle("c1", new Point(5, 5), 5);
        Forme f2 = new Rectangle("r1", new Point(2, 1), 5, 10);
        Forme f3 = new Carre("car1", new Point(4, 2), 6);
        Forme f4 = new Triangle("tri1", new Point(4, 2), new Point(6, 3), new Point(5, 4));
        
        f1.afficher();
        f1.deplacer(1,1);
        f1.afficher();
        
        f2.afficher();
        f2.deplacer(1,1);
        f2.afficher();
    }

   
    /**
     * Rigourous Test :-)
     * @throws NomVide 
     */
    public void testNomvide() {
    	Forme f1 ;
    	Throwable t = null;
    	try {
    		f1 = new Cercle("", new Point(5, 5), 5);
    	} catch (NomVide e) {
    		t = e.fillInStackTrace();
    	}
    	assertNotNull(t);
    	assertSame(NomVide.class, t.getClass());
    }
}
