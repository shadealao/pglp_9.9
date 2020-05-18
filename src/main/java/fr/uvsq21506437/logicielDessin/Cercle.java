package fr.uvsq21506437.logicielDessin;

import Exception.NomVide;

public class Cercle extends Forme{
	private Point centre;
	private final double rayon;
	
	/**
	 * 
	 * @param nom nom objet
	 * @param centre point au centre du cercle
	 * @param rayon rayon du cercle
	 * @throws NomVide objet sans nom
	 */
	public Cercle(String nom, Point centre, double rayon) throws NomVide{
		if(nom.equals("")) throw new NomVide();
		this.nom = nom;
		this.centre = centre;
		this.rayon = rayon;
	}
	
	@Override
	public void afficher() {
		System.out.println(this.nom +" Cercle(centre="+centre.toString()+", rayon="+this.rayon+")");
	}

	@Override
	public void deplacer(int x, int y) {
		this.centre.setX(this.centre.getX()+ x);
		this.centre.setY(this.centre.getY()+ y);
	}
	
	/**
	 * 
	 * @return point centre du cercle
	 */
	public Point getPoint() {
		return this.centre;
	}
	
	/**
	 * 
	 * @return rayon du cercle
	 */
	public double getRayon() {
		return this.rayon;
	}

}
