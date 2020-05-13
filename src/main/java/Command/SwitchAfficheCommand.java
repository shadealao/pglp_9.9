package Command;

public class SwitchAfficheCommand implements Command {

	public Action action;
	
	public SwitchAfficheCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		action.afiche();

	}

}
