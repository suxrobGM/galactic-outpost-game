package controllers;

import java.util.HashMap;
import java.util.Optional;
import core.CommandDispatcher;
import models.GameModel;
import views.GameView;

/**
 * Manages the interaction between the model and the view.
 */
public class GameController {
    private GameView view;
    private CommandDispatcher commandDispatcher;
    private HashMap<String, Object> commandParameters;

    public GameController(GameModel model, GameView view) {
        this.view = view;
        commandDispatcher = new CommandDispatcher();
        commandParameters = new HashMap<>();
        commandParameters.put("model", model);
    }

    /**
     * Processes the player's input and updates the view.
     * @param input The player's input string.
     */
    public void processInput(String input) {
        var verb = parseVerb(input.toLowerCase());
        var noun = parseNoun(input.toLowerCase(), verb);

        commandParameters.put("noun", noun);
        var response = commandDispatcher.dispatch(verb, Optional.of(commandParameters));
        view.display(response.getResult());
    }

    private String parseVerb(String input) {
        try {
            return input.substring(0, input.indexOf(" ")).trim();
        }
        catch (StringIndexOutOfBoundsException e) {
            return input.trim();
        }
    }

    private String parseNoun(String input, String verb) {
        try {
            return input.substring(verb.length()).trim();
        }
        catch (StringIndexOutOfBoundsException e) {
            return "";
        }
    }
}
