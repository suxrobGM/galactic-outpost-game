package commands;

import core.AbstractCommand;
import core.CommandResult;
import models.GameModel.Location;

public class NavigateCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        if (getNoun().equals("quarters")) {
            getModel().setLocation(Location.QUARTERS);
            return CommandResult.createSuccess("You navigate to the crew quarters.") ;
        }
        else if (getNoun().equals("central hub")) {
            getModel().setLocation(Location.CENTRAL_HUB);
            return CommandResult.createSuccess("You navigate to the central hub.");
        }
        else if (getNoun().equals("airlock")) {
            getModel().setLocation(Location.AIRLOCK);
            return CommandResult.createSuccess("You navigate to the airlock.");
        }
        else if (getNoun().equals("engine room")) {
            getModel().setLocation(Location.ENGINE_ROOM);
            return CommandResult.createSuccess("You navigate to the engine room.");
        }

        return CommandResult.createError("You can't navigate to " + getNoun() + ".");
    }
}
