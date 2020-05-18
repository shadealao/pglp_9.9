package fr.uvsq21506437.logicielDessin;

import Exception.EstListeVide;

public abstract class Forme{
	protected String nom;
	/**
	 * 
	 * @return nom de l'objet
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * 
	 * @param nom MAJ nom de l'objet
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * affichage d'une forme avec ses parametres
	 * @throws EstListeVide regarde s'il y a une forme dessinée
	 */
	public abstract void afficher() throws EstListeVide;
	
	/**
	 * déplacement d'une forme
	 * @param x déplacement en abscice dun point
	 * @param ydéplacement en ordonné d'un point
	 * @throws EstListeVide regarde s'il y a quelque chose à déplacer
	 */
	public abstract void deplacer(int x, int y) throws EstListeVide;

}
