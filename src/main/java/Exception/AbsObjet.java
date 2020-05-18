package Exception;

/**
 * Exception objet introuvable
 * @author user
 *
 */
public class AbsObjet extends Exception{
	/**
	 * 
	 * @param nom nom de l'objet introuvable
	 */
	public AbsObjet(String nom) {
		super("L'objet "+ nom + " est introuvable");
	}

}
