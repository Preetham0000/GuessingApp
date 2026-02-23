/**
 * GuessingApp - Use Case 1: Game Initialization
 * 
 * This class serces as the application entry point.
 * It initializes the game configuration and displays game rules.
 * 
 * No user input or gameplay logic is implemented at this stage.
 * 
 * @author Developer
 * @version 1.0
 *
 */

public class GuessingApp {
        public static void main(String[] args) {
            System.out.println("Welcome to Guessing APP");
            GameConfig gameConfig = new GameConfig();
            gameConfig.showRules();
        }
    }
