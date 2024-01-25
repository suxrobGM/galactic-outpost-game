package commands;

import core.AbstractCommand;
import core.CommandResult;

public class QuitCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        System.exit(0);
        return CommandResult.createSuccess("");
    }
}
