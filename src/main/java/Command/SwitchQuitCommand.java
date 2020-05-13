package Command;

public class SwitchQuitCommand implements Command {

	
	@Override
	public void execute() {
		System.exit(0);
	}

}
