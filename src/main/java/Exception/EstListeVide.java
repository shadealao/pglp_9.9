package Exception;

public class EstListeVide extends Exception{
	public EstListeVide(String nom) {
		super("Liste "+ nom + " vide");
	}

}
