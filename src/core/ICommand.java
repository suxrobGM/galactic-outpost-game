package core;

import java.util.HashMap;
import java.util.Optional;

/**
 * Interface for game commands.
 * Defines the method for handling commands with parameters.
 */
public interface ICommand {
    /**
     * Handles the command with given parameters.
     * 
     * @param parameters Optional parameters for the command.
     * @return The result of the command execution.
     */
    CommandResult handle(Optional<HashMap<String, Object>> parameters);
}
