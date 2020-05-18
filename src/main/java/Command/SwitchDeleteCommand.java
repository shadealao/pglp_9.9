package Command;

import Exception.AbsObjet;

public class SwitchDeleteCommand implements Command {
	protected Action action;

	public SwitchDeleteCommand(Action action) {
		this.action = action;
	}
	@Override
	public void execute() {
		try {
			action.delete();
		} catch (AbsObjet e) {
			e.printStackTrace();
		}

	}

}
