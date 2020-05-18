package Exception;


/**
 * Exception liste vide
 * @author user
 *
 */
public class EstListeVide extends Exception{
	/**
	 * 
	 * @param nom nom de la liste vide
	 */
	public EstListeVide(String nom) {
		super("Liste "+ nom + " vide");
	}

}
