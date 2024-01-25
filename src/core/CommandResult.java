package core;

/**
 * Represents the result of a command execution.
 * Contains information about the success of the command and the result message.
 */
public class CommandResult {
    private boolean success;
    private String result;

    /**
     * Constructor for CommandResult.
     * 
     * @param success Indicates if the command was successful.
     * @param result The result message or error description.
     */
    public CommandResult(boolean success, String result) {
        this.success = success;
        this.result = result;
    }

    /**
     * Gets the result message of the command.
     * 
     * @return The result message.
     */
    public String getResult() {
        return result;
    }

    /**
     * Checks if the command was successful.
     * 
     * @return True if successful, false otherwise.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Creates a successful result instance of the {@code CommandResult}
     * @param result Description of the result. If there is no result description, pass an empty string.
     * @return The instance of the {@code CommandResult}
     */
    public static CommandResult createSuccess(String result) {
        return new CommandResult(true, result);
    }

    /**
     * Creates a unsuccessful result instance of the {@code CommandResult}
     * @param result Description of the error message.
     * @return The instance of the {@code CommandResult}
     */
    public static CommandResult createError(String errorDescription) {
        return new CommandResult(false, errorDescription);
    }
}
