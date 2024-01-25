package commands;

import core.AbstractCommand;
import core.CommandResult;
import models.GameModel.Location;

public class InspectCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        var location = getModel().getLocation();

        if (getNoun().equals("console")) {
            if (location != Location.CENTRAL_HUB) {
                return CommandResult.createError("Go to the central hub to interact with the console.");
            }
            return CommandResult.createSuccess("The console displays the station's operational status.");
        }
        else if (getNoun().equals("engine")) {
            if (location != Location.ENGINE_ROOM) {
                return CommandResult.createError("Go to the engine room to interact with the console.");
            }
            return CommandResult.createSuccess("The engine hums quietly. All systems seem to be functioning normally.");
        }
        
        return CommandResult.createError("You see nothing special about " + getNoun() + ".");
    }
}
