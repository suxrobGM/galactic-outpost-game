package commands;

import core.AbstractCommand;
import core.CommandResult;

public class UseCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("toolkit")) {
            return CommandResult.createSuccess("You use the toolkit to tighten some loose screws.");
        }

        return CommandResult.createError("You can't use " + getNoun() + ".");
    }
}
