/**
 * GuessingApp - Use Case 2: USer Guess Submission
 * 
 * MAIN CLASS 
 * 
 * Coordinate the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 * 
 * @author Developer
 * @version 3.0
 *
 */

import java.util.*;

public class GuessingApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Guessing App");
        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintsUsed = 0;

        while (attempts < gameConfig.getMaxAttempts()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            String result = GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
            if (!"Correct".equalsIgnoreCase(result)) {
                if (hintsUsed < gameConfig.getMaxHints()) {
                    hintsUsed++;
                    String hint = HintService.generateHint(gameConfig.getTargetNumber(), hintsUsed);
                    System.out.println(hint);
                } else {
                    System.out.println("No more hints available!");
                }
            }

            System.out.println(result);
            if ("Correct".equalsIgnoreCase(result)) {
                break;
            }
        }
    }
}
