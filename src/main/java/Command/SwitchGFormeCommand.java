package Command;

import Exception.AbsObjet;

public class SwitchGFormeCommand implements Command {
	protected Action action;
	
	public SwitchGFormeCommand(Action action) {
		this.action = action;
	}
	
	@Override
	public void execute() {
		try {
			action.addGroupeForme();
		} catch (AbsObjet e) {
			e.printStackTrace();
		}

	}

}
