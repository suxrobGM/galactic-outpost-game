package commands;

import core.AbstractCommand;
import core.CommandResult;

public class InspectCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        switch (getNoun()) {
            case "console":
                return CommandResult.createSuccess("The console displays the station's operational status.");
            case "engine":
                return CommandResult.createSuccess("The engine hums quietly. All systems seem to be functioning normally.");
            default:
                return CommandResult.createError("You see nothing special about " + getNoun() + ".");
        }
    }
}
