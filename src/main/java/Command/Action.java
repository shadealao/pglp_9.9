package Command;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.DAO;
import DAO.GroupeFormeDAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import Exception.AbsObjet;
import Exception.EstListeVide;
import Exception.NomVide;
import composite.GroupeForme;
import fr.uvsq21506437.logicielDessin.Carre;
import fr.uvsq21506437.logicielDessin.Cercle;
import fr.uvsq21506437.logicielDessin.Forme;
import fr.uvsq21506437.logicielDessin.Point;
import fr.uvsq21506437.logicielDessin.Rectangle;
import fr.uvsq21506437.logicielDessin.Triangle;

public class Action {
	private String parametre;
	protected GroupeForme dessin = new GroupeForme("dessin");
	private DAO<GroupeForme> dessinDAO;
	
	/**
	 * Constructeur.
	 * @param parametre paramètre d'une commande entrée par l'utilisateur
	 */
	public Action(String parametre) {
		try {
			this.parametre = parametre;
			dessinDAO = new GroupeFormeDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param parametre MAJ parametres
	 */
	public void setParametre(String parametre) {
		this.parametre = parametre;
	}

	
	public void CreateCarre() {

		String nom = parametre.substring(0, parametre.indexOf("=")).replace(" ", "");
		String tmp = parametre.substring(parametre.indexOf("(")+1, parametre.length()-1).replace(" ", "");
		String t1 = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String t2 = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 
		String c = tmp.substring(tmp.indexOf(",")+1);
		c = c.substring(c.indexOf(",")+1, c.length());
		int x, y, cote;
		x = y = cote = 12;

		x = Integer.parseInt(t1);
		y = Integer.parseInt(t2);
		cote = Integer.parseInt(c);

		try {
			Carre C = new Carre(nom,new Point(x,y), cote);
			CarreDAO CDAO = new CarreDAO();
			CDAO.create(C);

			dessin.add(C);
		} catch (NomVide | SQLException e) {
			e.printStackTrace();
		}
	}

	public void CreateCercle() {
		String nom = parametre.substring(0, parametre.indexOf("=")).replace(" ", "");
		String tmp = parametre.substring(parametre.indexOf("(")+1, parametre.length()-1).replace(" ", "");
		String t1 = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String t2 = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 
		String c = tmp.substring(tmp.indexOf(",")+1);
		c = c.substring(c.indexOf(",")+1, c.length());
		int x, y, rayon;
		x = y = rayon = 12;

		x = Integer.parseInt(t1);
		y = Integer.parseInt(t2);
		rayon = Integer.parseInt(c);

		try {
			Cercle C = new Cercle(nom,new Point(x,y), rayon);
			CercleDAO CDAO = new CercleDAO();
			CDAO.create(C);
			dessin.add(C);
		} catch (NomVide | SQLException e) {
			e.printStackTrace();
		}
	}

	public void CreateTriangle() {
		String nom = parametre.substring(0, parametre.indexOf("=")).replace(" ", "");
		String tmp = parametre.substring(parametre.indexOf("(")+1, parametre.length()-1).replace(" ", "");
		String p1x = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String p1y = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 
		tmp = tmp.substring(tmp.indexOf(",")+1);
		tmp = tmp.substring(tmp.indexOf(",")+1);

		String p2x = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String p2y = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 
		tmp = tmp.substring(tmp.indexOf(",")+1);
		tmp = tmp.substring(tmp.indexOf(",")+1);

		String p3x = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String p3y = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 

		int x1, y1, x2, y2, x3, y3;
		x1 = Integer.parseInt(p1x);
		y1 = Integer.parseInt(p1y);

		x2 = Integer.parseInt(p2x);
		y2 = Integer.parseInt(p2y);

		x3 = Integer.parseInt(p3x);
		y3 = Integer.parseInt(p3y);
		System.out.println("p1("+x1+","+y1+") \t p2("+x2+","+y2+")  \t p3("+x3+","+y3+") ");
		try {
			Triangle C = new Triangle(nom,new Point(x1,y1), new Point(x2,y2), new Point(x3,y3));
			TriangleDAO CDAO = new TriangleDAO();
			CDAO.create(C);
			dessin.add(C);
		} catch (NomVide | SQLException e) {
			e.printStackTrace();
		}
	}

	public void CreateRectangle() {
		String nom = parametre.substring(0, parametre.indexOf("=")).replace(" ", "");
		String tmp = parametre.substring(parametre.indexOf("(")+1, parametre.length()-1).replace(" ", "");
		String t1 = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String t2 = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 
		String c = tmp.substring(tmp.indexOf(",")+1);
		tmp = c.substring(c.indexOf(",")+1, c.length());
		c = tmp.substring(0,tmp.indexOf(","));
		String c2 = tmp.substring(tmp.indexOf(",")+1);
		int x, y, largeur, longeur;
		x = y = largeur = longeur = 12;

		x = Integer.parseInt(t1);
		y = Integer.parseInt(t2);
		largeur = Integer.parseInt(c2);
		longeur = Integer.parseInt(c);
		System.out.println("x : "+x+" y:"+y+" L:"+largeur+" l:"+longeur);
		try {
			Rectangle C = new Rectangle(nom,new Point(x,y), longeur, largeur);
			RectangleDAO CDAO = new RectangleDAO();
			CDAO.create(C);
			dessin.add(C);
		} catch (NomVide | SQLException e) {
			e.printStackTrace();
		}
	}

	public void addGroupeForme() throws AbsObjet {
		String nom = parametre.substring(1,parametre.indexOf(","));
		String nomobjet = parametre.substring(parametre.indexOf(",")+1, parametre.length()-1);
		System.out.println("nom : "+ nom + "  nobj:"+ nomobjet);
		int i = 0;
		int k = 0;
		GroupeForme gF = null;
		boolean trouve = false;
		ArrayList<Forme> tmp = dessin.getList();
		for (Forme forme : tmp) {
			try {
				if(forme.getNom().equals(nomobjet)) {
					k= i;
					GroupeFormeDAO gFDAO = new GroupeFormeDAO();
					 gF = gFDAO.read(nom);
					trouve = true;
					if(gF.getNom().equals("")) {
						gF.setNom(nom);
						dessin.add(gF);
					}
					if(forme.getClass().getSimpleName().equals("Carre") && (trouve == true)) {
						gF.add(new CarreDAO().read(nomobjet));
					}
					else if(forme.getClass().getSimpleName().equals("Cercle") && (trouve == true)) {
						gF.add(new CercleDAO().read(nomobjet));
					}
					else if(forme.getClass().getSimpleName().equals("Rectangle") && (trouve == true)) {
						gF.add(new RectangleDAO().read(nomobjet));
					}
					else if(forme.getClass().getSimpleName().equals("Triangle") && (trouve == true)) {
						gF.add(new TriangleDAO().read(nomobjet));
						System.out.println("add tri");
					}
					else {
						throw new AbsObjet(forme.getClass().getSimpleName());
					}
					
					gF = gFDAO.create(gF);
					
				}
				i ++;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(trouve == true) {
			tmp.remove(k);
			tmp.add(gF);
		}
		
		dessin.setList(tmp);
	}

	public void move() throws AbsObjet{
		String nom = parametre.substring(parametre.indexOf("(")+1, parametre.indexOf(",")).replace(" ", "");
		String tmp = parametre.substring(parametre.indexOf(",")+1, parametre.length()-1).replace(" ", "");
		String t1 = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String t2 = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 

		int x, y;

		x = Integer.parseInt(t1);
		y = Integer.parseInt(t2);

		try {
			for (Forme forme : dessin.getList()) {
				if(forme.getNom().equals(nom)) {
					forme.deplacer(x, y);
					if(forme.getClass().getSimpleName().equals("Carre")) {
						DAO<Carre> d = new CarreDAO();
						d.update((Carre)forme);
					}
					else if(forme.getClass().getSimpleName().equals("Cercle")) {
						DAO<Cercle> d = new CercleDAO();
						d.update((Cercle)forme);
					}
					else if(forme.getClass().getSimpleName().equals("Rectangle")) {
						DAO<Rectangle> d = new RectangleDAO();
						d.update((Rectangle)forme);
					}
					else if(forme.getClass().getSimpleName().equals("Triangle")) {
						DAO<Triangle> d = new TriangleDAO();
						d.update((Triangle)forme);
					}
					else if(forme.getClass().getSimpleName().equals("GroupeForme")) {
						System.out.println("move");
						DAO<GroupeForme> d = new GroupeFormeDAO();
						d.update((GroupeForme)forme);
						
					}
					else {
						throw new AbsObjet(forme.getClass().getSimpleName());
					}
				}
			}
		} catch (EstListeVide | SQLException e) {
			e.printStackTrace();
		}


	}

	/** 
	 * Affichage d'une seule forme.
	 */
	public void affiche() {
		String nom = parametre.substring(1, parametre.length()-1);
		for (Forme forme : dessin.getList()) {
			try {
				if(forme.getNom().equals(nom)) forme.afficher();
			} catch (EstListeVide e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Affichage de toutes les formes càd dessin
	 */
	public void afficheD() {
		System.out.println("\n\n\n Affiche Dessin \n");
		for (Forme forme : dessin.getList()) {
			try {
				forme.afficher();
			} catch (EstListeVide e) {
				e.printStackTrace();
			}
		}
	}

	public void delete() throws AbsObjet {
		String nom = parametre.substring(1, parametre.length()-1);
		int k = 0;
		boolean trouve = false;
		ArrayList<Forme> GForme = dessin.getList();
		for(int i = 0; i<GForme.size(); i++) {
			if(GForme.get(i).getNom().equals(nom)) {
				k= i;
				trouve = true;
			}
		}
		if(trouve == false )
			throw new AbsObjet(nom);
		

		try {
			if(GForme.get(k).getClass().getSimpleName().equals("Carre") &&(trouve == true)) {
				CarreDAO c = new CarreDAO();
				c.delete((Carre) GForme.get(k));
				GForme.remove(k);
			}
			else if(GForme.get(k).getClass().getSimpleName().equals("Cercle") && (trouve == true)) {
				CercleDAO c = new CercleDAO();
				c.delete((Cercle) GForme.get(k));
				GForme.remove(k);
			}
			else if(GForme.get(k).getClass().getSimpleName().equals("Rectangle") && (trouve == true)) {
				RectangleDAO c = new RectangleDAO();
				c.delete((Rectangle) GForme.get(k));
				GForme.remove(k);
			}
			else if(GForme.get(k).getClass().getSimpleName().equals("Triangle") && (trouve == true)) {
				TriangleDAO c = new TriangleDAO();
				c.delete((Triangle) GForme.get(k));
				GForme.remove(k);
			}
			else if(GForme.get(k).getClass().getSimpleName().equals("GroupeForme") && (trouve == true)) {
				GroupeFormeDAO c = new GroupeFormeDAO();
				c.delete((GroupeForme) GForme.get(k));
				GForme.remove(k);
			}
			else {
				throw new AbsObjet(GForme.get(k).getClass().getSimpleName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		dessin.setList(GForme);
		dessinDAO.delete(dessin);
	}

	/**
	 * Enlever une forme d'un grp
	 */
	public void deleteG() {
		String nom = parametre.substring(1,parametre.indexOf(","));
		String nomobjet = parametre.substring(parametre.indexOf(",")+1, parametre.length()-1);

		int k = 0;
		int l = 0;
		boolean trouve = false;
		boolean trouve2 = false;
		ArrayList<Forme> GForme = dessin.getList();
		


		try {
			for(int i = 0; i<GForme.size(); i++) {
				System.out.println("liste ==> "+ GForme.get(i).getNom());
				if(GForme.get(i).getNom().equals(nom)) {
					k = i;
					trouve = true;
					if(GForme.get(k).getClass().getSimpleName().equals("GroupeForme") &&(trouve == true)) {
						ArrayList<Forme> formes = ((GroupeForme) GForme.get(k)).getList();
						for(int j = 0; j<formes.size(); j++) {
							if(formes.get(j).getNom().equals(nomobjet)) {
								l = j;
								trouve2 = true;
							}
						}
					
						
					}
				}
			}
			if(trouve2 == true) {
				System.out.println("derniere vérif ==> "+ GForme.get(k).getNom());
				GForme.remove(k);
				GroupeFormeDAO c = new GroupeFormeDAO();
				for (Forme forme : GForme) {
					//c.update((GroupeForme) forme);
				}
				dessin.setList(GForme);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//dessin.setList(GForme);
		//dessinDAO.delete(dessin);
	}


	public void quit() {
		afficheD();
		System.out.println("Fermeture logiciel dessin");
		System.exit(0);
	}
}
