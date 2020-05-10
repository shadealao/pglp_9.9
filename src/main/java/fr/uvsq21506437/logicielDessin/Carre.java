package fr.uvsq21506437.logicielDessin;

import Exception.NomVide;

public class Carre extends Forme{
	private Point Hg;
	private final double cote;
	
	public Carre(String nom, Point Hg, double cote) throws NomVide{
		if(nom.equals("")) throw new NomVide();
		this.nom = nom;
		this.Hg = Hg;
		this.cote = cote;
	}

	@Override
	public void afficher() {
		System.out.println("Carre(point_HautG="+Hg.toString()+", cote="+this.cote+")");
	}

	@Override
	public void deplacer(int x, int y) {
		this.Hg.setX(this.Hg.getX()+ x);
		this.Hg.setY(this.Hg.getY()+ y);
	}
	
	public Point getPoint() {
		return this.Hg;
	}
	public double getCote() {
		return this.cote;
	}
}