package commands;

import core.AbstractCommand;
import core.CommandResult;
import models.GameModel.Location;
import models.GameModel.Mission;

public class ActivateCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("communication system")) {
            if (getModel().getLocation() != Location.CENTRAL_HUB) {
                return CommandResult.createError("Enter to the central hub to activate communication systems.");
            }

            getModel().completeMission(Mission.RESTORE_COMMUNICATION);
            return CommandResult.createSuccess("You activate the communication system and contact Earth.");
        }

        return CommandResult.createError("You can't activate " + getNoun() + ".");
    }
}
