package Command;

import java.util.ArrayList;
import java.util.Scanner;


public class DrawingTUI {
	public Switch mySwitch;
	public Scanner sc; //scanner
	private String chaine; //chaine entrée
	protected String parametre = "";
	protected Action action;
	public DrawingTUI() {
		sc = new Scanner(System.in);
		chaine = "";
		mySwitch = new Switch();
		this.action = new Action("");
		afficherDessin();
	}

	public void nextCommand() {
		chaine = sc.nextLine().toString();
		//chaine = "car1 = carre((0, 2), 50)";
		//chaine = "rect1 = rectangle((4, 7), 20,12)";
		//chaine = "tri1 = triangle((4, 7),(2, 14),(3, 6))";
		//chaine = "move(c1, (10, 20))";
		//chaine = "quit";

		String cmd = "";
		System.out.println("Commande : "+ chaine);
		if(chaine.contains("=")) {
			parametre += chaine.substring(0, chaine.indexOf("=")+ 1);
			parametre += chaine.substring(chaine.indexOf("("));
			parametre = parametre.replaceAll(" ", "");
			cmd = chaine.substring(chaine.indexOf("=") + 1);
			cmd = cmd.substring(0, cmd.indexOf("("));
			cmd = cmd.replaceAll(" ", "");
			cmd = cmd.substring(0, 1).toUpperCase()+ cmd.substring(1);
			System.out.println("action : '"+ cmd+"'  et parametre : "+ parametre);


		}
		else if(chaine.contains("("))  {
			parametre += chaine.substring(chaine.indexOf("("));
			parametre = parametre.replaceAll(" ", "");

			cmd = chaine.substring(0, chaine.indexOf("("));
			cmd = cmd.replaceAll(" ", "");
			cmd = cmd.toLowerCase();
			System.out.println("action : '"+ cmd+"'  et parametre : "+ parametre);
		}
		else {
			cmd = chaine.replaceAll(" ", "");
			cmd = cmd.toLowerCase();
			System.out.println("action : '"+ cmd+"'");
		}
		ajoutCmd();
		this.action.setParametre(parametre);
		this.mySwitch.execute(cmd);
		parametre="";

	}

	public void afficherDessin() {
	}

	public void ajoutCmd() {

		Command carre = new SwitchCarreCommand(action);
		Command move = new SwitchMoveCommand(action);
		Command affiche = new SwitchAfficheCommand(action);
		Command cercle = new SwitchCercleCommand(action);
		Command rectangle = new SwitchRectangleCommand(action);
		Command triangle = new SwitchTriangleCommand(action);
		Command quit = new SwitchQuitCommand();
		this.mySwitch.register("Carre", carre);
		this.mySwitch.register("Cercle", cercle);
		this.mySwitch.register("Rectangle", rectangle);
		this.mySwitch.register("Triangle", triangle);
//		this.mySwitch.register("GroupeForme", annuler);

		this.mySwitch.register("move", move);
		this.mySwitch.register("show", affiche);
		this.mySwitch.register("quit", quit);

	}


}
