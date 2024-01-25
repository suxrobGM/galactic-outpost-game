package commands;

import core.AbstractCommand;
import core.CommandResult;
import models.GameModel.Location;
import models.GameModel.Mission;

public class RepairCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        var location = getModel().getLocation();
        
        if (getNoun().equals("engine")) {
            if (location != Location.ENGINE_ROOM) {
                return CommandResult.createError("Enter to the engine room location to repair the engine.");
            }

            getModel().completeMission(Mission.FIX_ENGINE);
            return CommandResult.createSuccess("You successfully repaired the engine.");
        }
        if (getNoun().equals("antenna")) {
            if (location != Location.AIRLOCK) {
                return CommandResult.createError("Enter to the airlock location and go outer space to repair the external antenna.");
            }

            getModel().completeMission(Mission.FIX_EXTERNAL_ANTENNA);
            return CommandResult.createSuccess("You successfully repaired the external antenna");
        }

        return CommandResult.createError("There is nothing to repair here.");
    }
}
