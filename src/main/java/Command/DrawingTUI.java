package Command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DAO.CarreDAO;
import DAO.CercleDAO;
import DAO.RectangleDAO;
import DAO.TriangleDAO;
import DAO.GroupeFormeDAO;
import fr.uvsq21506437.logicielDessin.Forme;


public class DrawingTUI {
	private Switch mySwitch;
	private Scanner sc; //scanner
	private String chaine; //chaine entrée
	protected String parametre = ""; //paramètre de chaque commande entrées par l'utilisateur
	protected Action action;

	public DrawingTUI() {
		Regles();		
		sc = new Scanner(System.in);
		chaine = "";
		mySwitch = new Switch();
		this.action = new Action("");
		initForme();
		afficherDessin();
	}

	/**
	 * Affichage des règles 
	 */
	public void Regles() {
		String s = "Les règles :\n"
				+ "créer : car1 = carre((0, 2), 50)\n"
				+ "déplacer : move(car1, (10, 20))\n"
				+ "afficher : show(car1)\n"
				+ "ajouter une forme dans un groupe : groupe(grp1,car1)\n"
				+ "effacer : delete(car1)\n"
				+ "arrêter l'application : quit";
		System.out.println(s);
								
	}
	
	/**
	 * Récupération de toutes les formes précédements enregistrées dans la BDD.
	 */
	public void initForme() {
		//carre
		CarreDAO CDAO = null;
		ArrayList<?> f = null;
		try {
			CDAO = new CarreDAO();
			f = CDAO.init();
			for (Object d : f) action.dessin.add((Forme) d);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//cercle
		f = null;
		try {
			CercleDAO CeDAO = new CercleDAO();
			f = CeDAO.init();
			for (Object d : f) action.dessin.add((Forme) d);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//rectangle
		f = null;
		try {
			RectangleDAO RDAO = new RectangleDAO();
			f = RDAO.init();
			for (Object d : f) action.dessin.add((Forme) d);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//triangle
		f = null;
		try {
			TriangleDAO TDAO = new TriangleDAO();
			f = TDAO.init();
			for (Object d : f) action.dessin.add((Forme) d);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//GForme
		f = null;
		try {
			GroupeFormeDAO GfDAO = new GroupeFormeDAO();
			f = GfDAO.init();
			for (Object d : f) action.dessin.add((Forme) d);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Lecture de la commande saisie par l'utilisateur
	 */
	public void nextCommand() {
		chaine = sc.nextLine().toString();
		String cmd = "";
		if(chaine.contains("=")) {
			parametre += chaine.substring(0, chaine.indexOf("=")+ 1);
			parametre += chaine.substring(chaine.indexOf("("));
			parametre = parametre.replaceAll(" ", "");
			cmd = chaine.substring(chaine.indexOf("=") + 1);
			cmd = cmd.substring(0, cmd.indexOf("("));
			cmd = cmd.replaceAll(" ", "");
			cmd = cmd.substring(0, 1).toUpperCase()+ cmd.substring(1);
		}
		else if(chaine.contains("("))  {
			parametre += chaine.substring(chaine.indexOf("("));
			parametre = parametre.replaceAll(" ", "");

			cmd = chaine.substring(0, chaine.indexOf("("));
			cmd = cmd.replaceAll(" ", "");
			cmd = cmd.toLowerCase();
		}
		else {
			cmd = chaine.replaceAll(" ", "");
			cmd = cmd.toLowerCase();
			System.out.println("action : '"+ cmd+"'");
		}
		ajoutCmd();
		this.action.setParametre(parametre);
		this.mySwitch.execute(cmd);
		action.dessin.clear();
		initForme();
		parametre="";

	}

	/**
	 * Affiche dessin càd toutes les formes créées
	 */
	public void afficherDessin() {
		this.action.afficheD();
	}

	/**
	 * Enregistrement des commandes
	 */
	public void ajoutCmd() {

		Command carre = new SwitchCarreCommand(action);
		Command cercle = new SwitchCercleCommand(action);
		Command rectangle = new SwitchRectangleCommand(action);
		Command triangle = new SwitchTriangleCommand(action);
		Command groupeForme = new SwitchGFormeCommand(action);
		Command move = new SwitchMoveCommand(action);
		Command affiche = new SwitchAfficheCommand(action);
		Command delete = new SwitchDeleteCommand(action);
		Command deleteG = new SwitchDeleteGCommand(action);
		Command quit = new SwitchQuitCommand(action);
		
		this.mySwitch.register("Carre", carre);
		this.mySwitch.register("Cercle", cercle);
		this.mySwitch.register("Rectangle", rectangle);
		this.mySwitch.register("Triangle", triangle);
		this.mySwitch.register("groupe", groupeForme);
		this.mySwitch.register("move", move);
		this.mySwitch.register("show", affiche);
		this.mySwitch.register("delete", delete);
		this.mySwitch.register("deletegroupe", deleteG);
		this.mySwitch.register("quit", quit);

	}


}
