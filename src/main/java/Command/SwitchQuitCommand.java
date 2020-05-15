package Command;

public class SwitchQuitCommand implements Command {
	protected Action action;
	
	public SwitchQuitCommand(Action action) {
		this.action = action;
	}
	
	@Override
	public void execute() {
		action.quit();
	}

}
