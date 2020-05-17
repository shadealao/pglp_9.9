package composite;

import java.util.ArrayList;

import Exception.EstListeVide;
import fr.uvsq21506437.logicielDessin.Forme;

public class GroupeForme extends Forme{
	protected ArrayList<Forme> formes;
	public GroupeForme(String nom) {
		this.nom = nom;
		formes = new ArrayList<Forme>();
	}

	@Override
	public void afficher() throws EstListeVide {
		if(this.formes.size() == 0) throw new EstListeVide("groupe de formes");
		System.out.println("Groupe : "+this.nom);
		for (Forme forme : this.formes) {
			forme.afficher();
		}
	}

	@Override
	public void deplacer(int x, int y) throws EstListeVide {
		if(this.formes.size() == 0) throw new EstListeVide("groupe de formes");
		for (Forme forme : this.formes) {
			forme.deplacer(x, y);
		}
		
	}
	
	public void add(Forme f) {
		this.formes.add(f);
	}
	
	public void remove(Forme f) {
		this.formes.remove(f);
	}
	
	public void clear() {
		this.formes.clear();
	}
	
	/*public String getNom() {
		return this.nom;
	}*/

	public ArrayList<Forme> getList() {
		return formes;
	}
	
	public void setList(ArrayList<Forme> f) {
		this.formes = f;
	}
}
