package commands;

import core.AbstractCommand;
import core.CommandResult;

public class CollectCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("emergency kit")) {
            return CommandResult.createSuccess("You collect the emergency kit.");
        }

        return CommandResult.createError("You can't collect " + getNoun() + ".");
    }
}
