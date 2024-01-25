package commands;

import core.AbstractCommand;
import core.CommandResult;

public class EatCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        switch (getNoun()) {
            case "food supply":
                return CommandResult.createSuccess("You eat some nutritious space food.");
            case "space snacks":
                return CommandResult.createSuccess("You enjoy a packet of delicious space snacks.");
            case "astronaut ice cream":
                return CommandResult.createSuccess("You savor the unique taste of astronaut ice cream.");
            case "protein bar":
                return CommandResult.createSuccess("You consume a high-energy protein bar.");
            default:
                return CommandResult.createError("There's nothing to eat here.");
        }
    }
}
