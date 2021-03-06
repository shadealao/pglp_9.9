package fr.uvsq21506437.logicielDessin;

import Exception.NomVide;

public class Rectangle extends Forme{
	private Point Hg;
	private final double largeur;
	private final double longeur;
	
	/**
	 * 
	 * @param nom nom de l'objet
	 * @param Hg point en haut à gauche de l'objet
	 * @param longeur longeur du rect
	 * @param largeur largeur du rect
	 * @throws NomVide objet sans nom
	 */
	public Rectangle(String nom, Point Hg, double longeur, double largeur)  throws NomVide{
		if(nom.equals("")) throw new NomVide();
		this.nom = nom;
		this.Hg = Hg;
		this.largeur = largeur;
		this.longeur = longeur;
	}

	@Override
	public void afficher() {
		System.out.println(this.nom +" Rectangle(point_HautG="+Hg.toString()+", largeur="+this.largeur+", longeur="+this.longeur+")");
	}

	@Override
	public void deplacer(int x, int y) {
		this.Hg.setX(this.Hg.getX()+ x);
		this.Hg.setY(this.Hg.getY()+ y);
		
	}
	
	public Point getPoint() {
		return this.Hg;
	}
	
	public double getLargeur() {
		return this.largeur;
	}
	
	public double getLongeur() {
		return this.longeur;
	}
}