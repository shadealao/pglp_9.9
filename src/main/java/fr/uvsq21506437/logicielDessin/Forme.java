package fr.uvsq21506437.logicielDessin;

import Exception.EstListeVide;

public abstract class Forme{
	public String nom;
	public String getNom() {
		return this.nom;
	}
	public abstract void afficher() throws EstListeVide;
	public abstract void deplacer(int x, int y) throws EstListeVide;

}
