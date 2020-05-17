package Command;

public class SwitchDeleteGCommand implements Command {
	protected Action action;

	public SwitchDeleteGCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		action.deleteG();

	}

}
