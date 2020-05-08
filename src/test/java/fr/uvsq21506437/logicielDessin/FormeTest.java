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
    public FormeTest( ) throws NomVide, EstListeVide{
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
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( FormeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }
}
