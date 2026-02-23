/**
 * GuessingApp - Use Case 5: GAME RESULT STORAGE
 * 
 * MAIN CLASS 
 * 
 * This class coordinates the complete game flow
 * and persists the final result after completion.
 * 
 *
 * Responsibilities:
 * - Initialize game configuration
 * - Accept and validate user guesses
 * - Generate hints when applicable
 * - Store game results at the end
 * 
 * @author Developer
 * @version 5.0
 *
 */

import java.util.*;

public class GuessingApp {

    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");
        GameConfig config = new GameConfig();
        config.showRules();
        // System.out.println("Target Number: " + config.getTargetNumber());

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Player name:");
        String player = sc.nextLine();
        int attempts = 0;
        int hintsUsed = 0;
        boolean win = false; 

        while (attempts < config.getMaxAttempts()) {
            System.out.print("Enter your guess: ");

            int guess = ValidationService.validateInput(sc.nextLine());
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
                win = true;
                break;
            }
        }
        System.out.println("Target Number: " + config.getTargetNumber());
        StorageService.saveResult(player, attempts, win);
    }
}