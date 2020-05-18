package fr.uvsq21506437.logicielDessin;

import Exception.NomVide;

public class Carre extends Forme {
	private Point Hg;
	private final double cote;
	
	/**
	 * Constructeur.
	 * @param nom nom de l'objet
	 * @param Hg point en haut à gauche de l'objet
	 * @param cote longeur d'un côté
	 * @throws NomVide exception lancée si l'objet n'a pas de nom
	 */
	public Carre(String nom, Point Hg, double cote) throws NomVide{
		if(nom.equals("")) throw new NomVide();
		this.nom = nom;
		this.Hg = Hg;
		this.cote = cote;
	}

	@Override
	public void afficher() {
		System.out.println(this.nom +" Carre(point_HautG="+Hg.toString()+", cote="+this.cote+")");
	}

	@Override
	public void deplacer(int x, int y) {
		this.Hg.setX(this.Hg.getX()+ x);
		this.Hg.setY(this.Hg.getY()+ y);
	}
	
	/**
	 * 
	 * @return Point haut gauche du carre
	 */
	public Point getPoint() {
		return this.Hg;
	}
	
	/**
	 * 
	 * @return longeur côté carre
	 */
	public double getCote() {
		return this.cote;
	}

	
}