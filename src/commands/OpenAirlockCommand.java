package commands;

import core.AbstractCommand;
import core.CommandResult;

public class OpenAirlockCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("airlock")) {
            return CommandResult.createSuccess("You have opened the airlock door and are going out into outer space.");
        }

        return CommandResult.createError("You can't open the " + getNoun() + ".");
    }
}
