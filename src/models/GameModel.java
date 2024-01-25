package models;

import java.util.ArrayList;
import core.Pair;

/**
 * Represents the data and logic of the game.
 * Manages player location, missions, and their completion status.
 */
public class GameModel {
    /**
     * Enum representing various locations in the game.
     */
    public enum Location {
        CENTRAL_HUB,
        AIRLOCK,
        QUARTERS,
        ENGINE_ROOM
    }

    /**
     * Enum representing different missions in the game.
     */
    public enum Mission {
        TALK_WITH_CREWMATES,
        FIX_ENGINE,
        FIX_EXTERNAL_ANTENNA,
        RESTORE_COMMUNICATION,
    }

    /**
     * Current location of the player
     */
    private Location location;

    /**
     * Current mission of the player.
     */
    private Mission currentMission;

    /**
     * List of completed missions, paired with their completion status.
     */
    private ArrayList<Pair<Mission, Boolean>> completedMissions;

    /**
     * Constructor for GameModel. Initializes missions and sets starting location and mission.
     */
    public GameModel() {
        completedMissions = new ArrayList<>();
        currentMission = Mission.TALK_WITH_CREWMATES; // Starting mission
        location = Location.CENTRAL_HUB; // Starting location
        completedMissions.add(new Pair<GameModel.Mission, Boolean>(Mission.TALK_WITH_CREWMATES, false));
        completedMissions.add(new Pair<GameModel.Mission, Boolean>(Mission.FIX_ENGINE, false));
        completedMissions.add(new Pair<GameModel.Mission, Boolean>(Mission.FIX_EXTERNAL_ANTENNA, false));
        completedMissions.add(new Pair<GameModel.Mission, Boolean>(Mission.RESTORE_COMMUNICATION, false));
    }

    /**
     * Gets the current location of the player.
     * @return The current location.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets the location of the player.
     * @param value The new location to be set.
     */
    public void setLocation(Location value) {
        location = value;
    }

    /**
     * Marks a mission as completed.
     * @param mission The mission to be marked complete.
     */
    public void completeMission(Mission mission) {
        for (int i = 0; i < completedMissions.size(); i++) {
            if (completedMissions.get(i).getKey() == mission) {
                completedMissions.get(i).setValue(true);
                var nextMissionIndex = (i + 1) % (completedMissions.size() - 1);
                currentMission = completedMissions.get(nextMissionIndex).getKey();
                break;
            }
        }
    }

     /**
     * Checks if all missions are completed.
     * @return true if all missions are completed, false otherwise.
     */
    public boolean areAllMissionsCompleted() {
        return completedMissions.stream().allMatch(i -> i.getValue() == true);
    }

    /**
     * Gets the name of the current location.
     * @return Name of the current location.
     */
    public String getLocationName() {
        switch (location) {
            case CENTRAL_HUB:
                return "central hub";
            case AIRLOCK:
                return "airlock";
            case QUARTERS:
                return "quarters";
            case ENGINE_ROOM:
                return "engine room";
            default:
                return "Unknown location";
        }
    }

    /**
     * Gets descriptions of the remaining missions.
     * @return Descriptions of all incomplete missions.
     */
    public String getRemainingMissionDescriptions() {
        var strBuilder = new StringBuilder();

        completedMissions.stream()
            .filter(i -> i.getValue() == false)
            .forEach(i -> {
                strBuilder.append(getMissionDescription(i.getKey()));
                strBuilder.append("\n");
            });
        
        return strBuilder.toString();
    }

    /**
     * Gets the description of the current mission.
     * @return Description of the current mission.
     */
    public String getCurrentMissionDescription() {
        return getMissionDescription(currentMission);
    }

    /**
     * Gets the description of a specific mission.
     * @param mission The mission for which the description is needed.
     * @return Description of the specified mission.
     */
    public String getMissionDescription(Mission mission) {
        switch (mission) {
            case TALK_WITH_CREWMATES:
                return "-Talk with crewmates to get list of tasks";
            case FIX_ENGINE:
                return "-The main engine has some issues. Please go to the engine room and fix engine issues.";
            case FIX_EXTERNAL_ANTENNA:
                return "-The external antenna has some issues. It's located on the back frame of the spacecraft. Please go to airlock then go to outdoor space and fix the external antenna.";
            case RESTORE_COMMUNICATION:
                return "-We have some issues with our communication system. I think you can fix it, please fix the communication system in the central hub location.";
            default:
                return "Unknown mission.";
        }
    }

    /**
     * Resets the game state to the initial conditions.
     */
    public void resetGameState() {
        setLocation(Location.CENTRAL_HUB);
        completedMissions.forEach(i -> i.setValue(false));
        currentMission = Mission.TALK_WITH_CREWMATES;
    }
}
