package core;

import java.util.HashMap;
import java.util.Optional;
import models.GameModel;

/**
 * Abstract base class for all game commands.
 * Implements common functionalities for command handling.
 */
public abstract class AbstractCommand implements ICommand {
    private GameModel model;
    private String noun;

    /**
     * Handles the command execution with provided parameters.
     * Extracts the game model and noun from parameters before handling the command.
     * 
     * @param parameters Optional parameters for the command.
     * @return The result of the command execution.
     */
    @Override
    public CommandResult handle(Optional<HashMap<String, Object>> parameters) {
        model = extractGameModel(parameters);
        noun = extractNoun(parameters);

        if (model == null) {
            return CommandResult.createError("The 'model' parameter is not provided");
        }
        
        return handleValidated();
    }

    /**
     * Gets the game model.
     * 
     * @return Current game model.
     */
    public GameModel getModel() {
        return model;
    }

    /**
     * Gets the noun associated with the command.
     * 
     * @return The noun of the command.
     */
    public String getNoun() {
        return noun;
    }

    /**
     * Extract the noun parameter from the paramerters hash map
     * @param parameters Command parameters
     * @return The noun string if found from the paramters map otherwise empty string
     */
    private String extractNoun(Optional<HashMap<String, Object>> parameters) {
        if (parameters.isPresent() && parameters.get().get("noun") instanceof String) {
            return (String)parameters.get().get("noun");
        }
        return "";
    }

    /**
     * Extract the noun parameter from the paramerters hash map
     * @param parameters Command parameters
     * @return The instance of the {@code GameModel} class if found from the parameters map otherwise {@code null}
     */
    private GameModel extractGameModel(Optional<HashMap<String, Object>> parameters) {
        if (parameters.isPresent() && parameters.get().get("model") instanceof GameModel) {
            return (GameModel)parameters.get().get("model");
        }

        return null;
    }

    /**
     * Handles the command after validating required parameters
     * @return The result of the command execution
     */
    protected abstract CommandResult handleValidated();
}
