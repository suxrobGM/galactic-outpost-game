package commands;

import core.AbstractCommand;
import core.CommandResult;

public class InspectCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("console")) {
            return CommandResult.createSuccess("The console displays the station's operational status.");
        }
        return CommandResult.createError("You see nothing special about " + getNoun() + ".");
    }
}
