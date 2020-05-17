package fr.uvsq21506437.logicielDessin;

import Exception.NomVide;

public class Cercle extends Forme{
	private Point centre;
	private final double rayon;
	
	
	public Cercle(String nom, Point centre, double rayon) throws NomVide{
		if(nom.equals("")) throw new NomVide();
		this.nom = nom;
		this.centre = centre;
		this.rayon = rayon;
	}
	
	public Cercle() {
		this.rayon = 0.0;
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
	
	public Point getPoint() {
		return this.centre;
	}
	public double getRayon() {
		return this.rayon;
	}

}
