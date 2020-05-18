package Command;

import Exception.AbsObjet;

public class SwitchMoveCommand implements Command {
public Action action;
	
	public SwitchMoveCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		try {
			this.action.move();
		} catch (AbsObjet e) {
			e.printStackTrace();
		}
	}

}
