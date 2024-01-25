package commands;

import core.AbstractCommand;
import core.CommandResult;
import models.GameModel.Location;
import models.GameModel.Mission;

public class TalkCommand extends AbstractCommand {
    @Override
    protected CommandResult handleValidated() {
        var model = getModel();

        if (getNoun().equals("crewmate")) {
            if (model.getLocation() != Location.QUARTERS) {
                return CommandResult.createError("Enter to the quarters location to talk with crewmates");
            }

            model.completeMission(Mission.TALK_WITH_CREWMATES);
            return CommandResult.createSuccess("You have a nice conversation with your fellow crewmate.\n" + 
                "You got a list of missions and your next tasks are: \n" + model.getRemainingMissionDescriptions());
        }
        return CommandResult.createError("There is no one to talk to here.");
    }
}
