package fr.uvsq21506437.logicielDessin;

import Exception.EstListeVide;
import Exception.NomVide;
import junit.framework.TestCase;

/**
 * Je teste les relations d'héritage entre forme et les autres forme (cercle tri etc.).
 */
public class FormeTest extends TestCase {
	/**
     * 
     * @throws NomVide regarde si le nom de la forme a bien été noté
     * @throws EstListeVide regarde si la liste est vide
     */
    public void testForme() throws NomVide, EstListeVide{
        Forme f1 = new Cercle("c1", new Point(5, 5), 5);
        Forme f2 = new Rectangle("r1", new Point(2, 1), 5, 10);
        Forme f3 = new Carre("car1", new Point(4, 2), 6);
        Forme f4 = new Triangle("tri1", new Point(4, 2), new Point(6, 3), new Point(5, 4));
        
        //System.out.println("forme  : "+ f3.getClass().getSimpleName());
        f1.afficher();
        f1.deplacer(1,1);
        f1.afficher();
        
        f2.afficher();
        f2.deplacer(1,1);
        f2.afficher();
    }

   /**
    * 
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
