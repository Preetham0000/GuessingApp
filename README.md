# 🎮 Guessing App - Use Cases

## UC-01: Game Initialization
- Starts the game and generates a random target number  
- Sets maximum attempts and hint limits  
- Displays a welcome message, rules, and basic instructions  

## UC-02: User Guess Submission
- Reads the player’s guess from console input (Scanner)  
- Validates that the input is numeric and within range  
- Compares the guess with the target number and shows feedback  

## UC-03: Hint Generation
- Provides hints after incorrect guesses (e.g., higher/lower, even/odd, range)  
- Limits the number of hints to keep the game challenging  

## UC-04: Error Handling & Validation
- Handles non-numeric and out-of-range input using validation and exceptions  
- Shows user-friendly error messages instead of crashing  

## UC-05: Game Result Storage
- Saves game results (player name, attempts, win/loss) into a `.txt` file  
- Can load and display past results as basic game history  

## UC-06: Game Restart & Exit
- At the end of a game, lets the player choose to play again or exit  
- Resets all game data on restart and closes resources on exit  
