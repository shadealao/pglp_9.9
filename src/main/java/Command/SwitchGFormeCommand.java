package Command;

public class SwitchGFormeCommand implements Command {
	protected Action action;
	
	public SwitchGFormeCommand(Action action) {
		this.action = action;
	}
	
	@Override
	public void execute() {
		action.addGroupeForme();

	}

}
