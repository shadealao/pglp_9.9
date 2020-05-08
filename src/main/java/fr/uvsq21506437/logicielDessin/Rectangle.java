package fr.uvsq21506437.logicielDessin;

public class Rectangle extends Forme{
	private Point Hg;
	private final double largeur;
	private final double longeur;
	
	public Rectangle(String nom, Point Hg, double longeur, double largeur) {
		this.nom = nom;
		this.Hg = Hg;
		this.largeur = largeur;
		this.longeur = longeur;
	}

	@Override
	public void afficher() {
		System.out.println("Rectangle(point_HautG="+Hg.toString()+", largeur="+this.largeur+", longeur="+this.longeur+")");
	}

	@Override
	public void deplacer(Point p) {
		this.Hg.setX(this.Hg.getX()+p.getX());
		this.Hg.setY(this.Hg.getY()+p.getY());
		
	}
}