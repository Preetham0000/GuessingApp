/*
* Use Case 3: Hint Generation
* 
* This class is responsible for generating 
* controlled hints based on the number of incorrect attemps made by the player.
*
* Hint logic is isolated to avoid cluttering 
* the main game flow.
*/

class HintService {

    /*
    * Generates hints based on how many hints 
    *have already been used.
    *
    * Hints provide partial information without
    * revaling the exact number.
    */

    public static String generateHint(int target, int hintCount) {

        if(hintCount == 1) {
            return (target % 2 == 0)
                    ? "Hint: The number is even."
                    : "Hint: The number is odd.";

        } else if(hintCount == 2) {
           return(target > 50)
                    ? "Hint: The number is greater than 50."
                    : "Hint: The number is 50 or less.";
        }
        return "No more hints available!";
    }
}