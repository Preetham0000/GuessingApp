/**
 * GuessingApp - Use Case 4: Error Handling & Validation
 * 
 * MAIN CLASS 
 * 
 * This class coordinates the game execution while ensuring
 * all user inputs are safely validated before processing.
 * 
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept user input
 * - Validate input using validation service
 * - Handle game flow without crashing on invalid input
 * 
 * @author Developer
 * @version 4.0
 *
 */

import java.util.*;

public class GuessingApp {

    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");
        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;

        while (attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");

            int guess = ValidationService.validateInput(scanner.nextLine());
            attempts++;

            String result = GuessValidator.validateGuess(guess, config.getTargetNumber());

            if (!"CORRECT".equals(result) && hintsUsed < config.getMaxHints()) {
                hintsUsed++;
                System.out.println(HintService.generateHint(config.getTargetNumber(), hintsUsed));
            } else if (!"CORRECT".equals(result) && hintsUsed >= config.getMaxHints()) {
                System.out.println("No more hints available");
            }

            System.out.println(result);

            if ("CORRECT".equals(result)) {
                break;
            }
        }
    }
}