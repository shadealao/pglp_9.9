package Command;

public class SwitchTriangleCommand implements Command {

	public Action action;
	
	public SwitchTriangleCommand(Action action) {
		this.action = action;
	}
	
	@Override
	public void execute() {
		action.CreateTriangle();
	}

}
