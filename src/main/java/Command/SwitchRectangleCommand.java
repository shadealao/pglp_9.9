package Command;

public class SwitchRectangleCommand implements Command {

	public Action action;
	
	public SwitchRectangleCommand(Action action) {
		this.action = action;
	}
	
	@Override
	public void execute() {
		action.CreateRectangle();
	}

}
