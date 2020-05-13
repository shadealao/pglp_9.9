package Command;

public class SwitchCercleCommand implements Command {

	public Action action;
	public SwitchCercleCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		action.CreateCercle();
	}

}
