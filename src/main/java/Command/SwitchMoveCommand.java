package Command;

public class SwitchMoveCommand implements Command {
public Action action;
	
	public SwitchMoveCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		this.action.move();
	}

}
