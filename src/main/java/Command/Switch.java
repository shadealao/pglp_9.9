package Command;

import java.util.HashMap;

public class Switch {
	 private final HashMap<String, Command> commandMap = new HashMap<>();
	    /**
	     * enregistrer une commande.
	     * @param commandName nom de la cmde
	     * @param command methode à exécuter
	     */
	    public void register(String commandName, Command command) {
	        commandMap.put(commandName, command);
	    }
	    
	    /**
	     * 
	     * @param commandName nom de la commande
	     */
	    public void execute(String commandName) {
	        Command command = commandMap.get(commandName);
	        if (command == null) {
	            throw new IllegalStateException("Commande " + commandName+ "  inconnue");
	        }
	        command.execute();
	    }
}
