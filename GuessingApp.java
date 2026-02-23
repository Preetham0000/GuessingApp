import java.util.*;

public class GuessingApp {

    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");
        Scanner sc = new Scanner(System.in);

        do {
            GameConfig config = new GameConfig(); 
            config.showRules();

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

        } while (GameController.restartGame(sc));
    }
}