package Command;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.DAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import Exception.EstListeVide;
import Exception.NomVide;
import fr.uvsq21506437.logicielDessin.Carre;
import fr.uvsq21506437.logicielDessin.Cercle;
import fr.uvsq21506437.logicielDessin.Forme;
import fr.uvsq21506437.logicielDessin.Point;
import fr.uvsq21506437.logicielDessin.Rectangle;
import fr.uvsq21506437.logicielDessin.Triangle;

public class Action {
	private String parametre;
	protected ArrayList <Forme>dessin = new ArrayList<Forme>();
	public Action(String parametre) {
		this.parametre = parametre;
	}
	public void setParametre(String parametre) {
		this.parametre = parametre;
	}

	public void CreateCarre() {
		System.out.println("param dans Action CreateCarre : '"+ this.parametre+"'");

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
		System.out.println("param dans Action CreateCercle : '"+ this.parametre+"'");

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
		System.out.println("param dans Action CreateTriangle : '"+ this.parametre+"'");

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
		//x1 = y1 = largeur = longeur = 12;

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
		System.out.println("param dans Action CreateRectangle : '"+ this.parametre+"'");

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

	public void move() {
		System.out.println("param dans Action move(): '"+ this.parametre+"'");
		String nom = parametre.substring(parametre.indexOf("(")+1, parametre.indexOf(",")).replace(" ", "");
		String tmp = parametre.substring(parametre.indexOf(",")+1, parametre.length()-1).replace(" ", "");
		String t1 = tmp.substring(tmp.indexOf("(")+1, tmp.indexOf(","));
		String t2 = tmp.substring(tmp.indexOf(",")+1, tmp.indexOf(")")); 

		int x, y;

		x = Integer.parseInt(t1);
		y = Integer.parseInt(t2);

		try {
			for (Forme forme : dessin) {
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
					else {
						//Exception
					}
				}
			}
		} catch (EstListeVide | SQLException e) {
			e.printStackTrace();
		}


	}

	public void afiche() {
		String nom = parametre.substring(1, parametre.length()-1);
		for (Forme forme : dessin) {
			try {
				if(forme.getNom().equals(nom)) forme.afficher();
			} catch (EstListeVide e) {
				e.printStackTrace();
			}
		}
	}
}
