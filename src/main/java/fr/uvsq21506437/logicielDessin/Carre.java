package fr.uvsq21506437.logicielDessin;

public class Carre extends Forme{
	private Point Hg;
	private final double cote;
	
	public Carre(String nom, Point Hg, double cote) {
		this.nom = nom;
		this.Hg = Hg;
		this.cote = cote;
	}

	@Override
	public void afficher() {
		System.out.println("Carre(point_HautG="+Hg.toString()+", cote="+this.cote+")");
	}

	@Override
	public void deplacer(Point p) {
		this.Hg.setX(this.Hg.getX()+p.getX());
		this.Hg.setY(this.Hg.getY()+p.getY());
	}
}