import java.util.Scanner;

import controllers.GameController;
import models.GameModel;
import views.GameView;

/**
 * The main driver of the game, an entry point of the program.
 */
public class GameMain {
    public static void main(String[] args) {
        var model = new GameModel();
        var view = new GameView();
        var controller = new GameController(model, view);

        try (var scanner = new Scanner(System.in)) {
            displayWelcomeMessage();
            displayAvailableCommands();

            // Game loop
            while (true) {
                System.out.print("> ");
                var input = scanner.nextLine();
                controller.processInput(input);

                if (model.areAllMissionsCompleted()) {
                    System.out.println("All missions accomplished! You have successfully managed the outpost.");
                    System.out.println("Do you want to play again? (yes/no)");
                    input = scanner.nextLine();

                    if (input == "yes") {
                        model.resetGameState();
                        System.out.println("The game has been reset. Let's start a new adventure!");
                        continue;
                    }
                    else {
                        System.out.println("Thank you for playing!");
                        break;
                    }
                }
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("***************************************");
        System.out.println("*                                     *");
        System.out.println("*     /\\                              *");
        System.out.println("*    /  \\        Galactic Outpost     *");
        System.out.println("*   /    \\       Space Adventure      *");
        System.out.println("*  /______\\                           *");
        System.out.println("*  |      |                           *");
        System.out.println("*  |      |                           *");
        System.out.println("*  |      |                           *");
        System.out.println("*  |      |                           *");
        System.out.println("*  |______|                           *");
        System.out.println("*    /||\\                             *");
        System.out.println("*   / || \\                            *");
        System.out.println("*     ||                              *");
        System.out.println("*                                     *");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("Welcome to Galactic Outpost!");
    }

    private static void displayAvailableCommands() {
        System.out.println("\nAvailable Commands:");
        System.out.println(" - inspect [object] (e.g., 'inspect console')");
        System.out.println(" - talk [person] (e.g., 'talk crewmate')");
        System.out.println(" - repair [object] (e.g., 'repair engine')");
        System.out.println(" - navigate [location] (e.g., 'navigate quarters')");
        System.out.println(" - use [object] (e.g., 'use toolkit')");
        System.out.println(" - read [object] (e.g., 'read datapad')");
        System.out.println(" - activate [system] (e.g., 'activate communication system')");
        System.out.println(" - collect [item] (e.g., 'collect emergency kit')");
        System.out.println(" - open [location] door (e.g., 'open airlock door')");
        System.out.println(" - eat [item] (e.g., 'eat food supply')");
        System.out.println(" - show: display player's current location");
        System.out.println(" - quit: exit from the game");
        System.out.println();
        System.out.println("Type commands to interact with the station and crew.\n");
        System.out.println("Read your datapad to get your current mission\n");
    }
}
