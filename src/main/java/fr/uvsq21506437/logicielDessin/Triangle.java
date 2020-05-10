package fr.uvsq21506437.logicielDessin;

import Exception.NomVide;

public class Triangle extends Forme{
	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(String nom, Point p1, Point p2, Point p3)  throws NomVide{
		if(nom.equals("")) throw new NomVide();
		this.nom = nom;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	@Override
	public void afficher() {
		System.out.println("Triangle(p1="+p1.toString()+", p2="+p2.toString()+", p3="+p3.toString()+")");
	}

	@Override
	public void deplacer(int x, int y) {
		this.p1.setX(this.p1.getX()+ x);
		this.p1.setY(this.p1.getY()+ y);
		
		this.p2.setX(this.p2.getX()+ x);
		this.p2.setY(this.p2.getY()+ y);
		
		this.p3.setX(this.p3.getX()+ x);
		this.p3.setY(this.p3.getY()+ y);
		
	}
	
	public Point getPoint1() {
		return this.p1;
	}
	
	public Point getPoint2() {
		return this.p2;
	}
	
	public Point getPoint3() {
		return this.p3;
	}
}