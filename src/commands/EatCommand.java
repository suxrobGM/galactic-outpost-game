package commands;

import core.AbstractCommand;
import core.CommandResult;

public class EatCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("food supply")) {
            return CommandResult.createSuccess("You eat some nutritious space food.");
        }

        return CommandResult.createError("There's nothing to eat here.");
    }
}
