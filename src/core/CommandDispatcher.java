package core;

import java.util.HashMap;
import java.util.Optional;
import commands.*;

/**
 * Dispatches commands to their respective handlers.
 * Manages a collection of commands and delegates the command execution.
 */
public class CommandDispatcher {
    private HashMap<String, AbstractCommand> commands = new HashMap<>();

    /**
     * Initializes the CommandDispatcher and registers available commands.
     */
    public CommandDispatcher() {
        registerCommands();
    }

    /**
     * Dispatches the command to its handler.
     * 
     * @param commandName The name of the command to dispatch.
     * @param parameters Optional parameters for the command.
     * @return The result of the command execution.
     */
    public CommandResult dispatch(String commandName, Optional<HashMap<String, Object>> paramaters) {
        var command = commands.get(commandName);
        
        if (command == null) {
            return CommandResult.createError("Invalid command: " + commandName);
        }

        return command.handle(paramaters);
    }

    /**
     * Adds a command to the dispatcher.
     * 
     * @param commandName The name of the command.
     * @param command The command to be added.
     * @return The CommandDispatcher instance for chaining.
     */
    public CommandDispatcher addCommand(String commandName, AbstractCommand command) {
        commands.put(commandName, command);
        return this;
    }

    /**
     * Registers available commands to the commands container
     */
    private void registerCommands() {
        addCommand("activate", new ActivateCommand());
        addCommand("collect", new CollectCommand());
        addCommand("eat", new EatCommand());
        addCommand("open", new OpenAirlockCommand());
        addCommand("inspect", new InspectCommand());
        addCommand("navigate", new NavigateCommand());
        addCommand("read", new ReadCommand());
        addCommand("repair", new RepairCommand());
        addCommand("show", new ShowLocationCommand());
        addCommand("talk", new TalkCommand());
        addCommand("use", new UseCommand());
        addCommand("quit", new QuitCommand());
    }
}
