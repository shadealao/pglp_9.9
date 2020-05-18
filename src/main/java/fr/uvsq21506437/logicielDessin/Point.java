package fr.uvsq21506437.logicielDessin;

public class Point {
	private int x;
	private int y;
	
	/**
	 * Constructeur
	 * @param x abscisse
	 * @param y ordonné
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	/**
	 * 
	 * @return abscisse du point
	 */
	public int getX() {
		return this.x; 
	}
	
	/**
	 * 
	 * @return ordonnée du point
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * 
	 * @param x MAJ abscisse
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @param y MAJ ordonné
	 */
	public void setY(int y) {
		this.y = y;
	}

}
