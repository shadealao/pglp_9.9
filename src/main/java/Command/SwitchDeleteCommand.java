package Command;

public class SwitchDeleteCommand implements Command {
	protected Action action;

	public SwitchDeleteCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		action.delete();

	}

}
