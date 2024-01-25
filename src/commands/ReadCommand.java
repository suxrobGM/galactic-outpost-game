package commands;

import core.AbstractCommand;
import core.CommandResult;

public class ReadCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("datapad")) {
            return CommandResult.createSuccess(
                "You read the latest mission updates on the datapad.\n" + 
                "Your current mission:\n" + getModel().getCurrentMissionDescription() + "\n"
            );
        }

        return CommandResult.createError("There's nothing to read here.");
    }
}
