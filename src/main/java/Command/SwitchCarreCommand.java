package Command;

public class SwitchCarreCommand implements Command{

	public Action action;
	
	public SwitchCarreCommand(Action action) {
		this.action = action;
	}
	
	@Override
	public void execute() {
		action.CreateCarre();
		
		
		
	}

	
}
