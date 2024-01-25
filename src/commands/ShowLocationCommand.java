package commands;

import core.AbstractCommand;
import core.CommandResult;

public class ShowLocationCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        return CommandResult.createSuccess("You're currently in the " + getModel().getLocation() + " location.");
    }
}
