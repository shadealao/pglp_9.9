package fr.uvsq21506437.logicielDessin;

public class Cercle extends Forme{
	private Point centre;
	private final double rayon;
	
	public Cercle(String nom, Point centre, double rayon) {
		this.nom = nom;
		this.centre = centre;
		this.rayon = rayon;
	}

	@Override
	public void afficher() {
		System.out.println("Cercle(centre="+centre.toString()+", rayon="+this.rayon+")");
	}

	@Override
	public void deplacer(Point p) {
		this.centre.setX(this.centre.getX()+p.getX());
		this.centre.setY(this.centre.getY()+p.getY());
	}

}
