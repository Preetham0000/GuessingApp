/**
 * Custom exception used when
 * user input failts validation
 * 
 * This allows the game to fail gracefully with a
 * meaningful message.
 */

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}