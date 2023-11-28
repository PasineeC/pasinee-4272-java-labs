package chantapinich.pasinee.lab3;

import java.util.*;

/**
 * this program accepts 4 arguments:
 * - the minimum value for guessing 
 * - the maximum value for guessing 
 * - the maximum number of tries
 * - the user's guess between min and maxS 
 * 
 * Functions:
 * - configure(): Allows the user to set the min, max, and maxTries
 *  (ensures max >= min and max > 0)
 * - genAnswer() : Generates a random answer
 * - playGame() : Runs the game, reading input, displaying output, and tracking remaining guesses
 *  (checks if <numGuess> is within the range)
 * 
 * Output:
 * - Correct guess: Congratulations! You tried <numTries> times(s)
 * - Incorrect guess: Try a lower/higher number!
 * - Out of guesses: You tried 5 times. You ran out of guesses. The answer is <answer>
 * - Option to play again after the game ends
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class NumberGuessingGames {
    static int answer, min, max, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGames();
    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        while (max < min) {
            System.out.println("The max value must be at least equal to the min value");
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
        while (maxTries <= 0) { 
            System.out.println("The maximum number of tries must be greater than 0");
            System.out.print("Enter the maximum number of tries:");
            maxTries = input.nextInt();
        }
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGames() {
        int numTries = 0;
        System.out.println("Welcome to a number guessing game!");
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int numGuess = input.nextInt();
            while (numGuess < min || numGuess > max) {
                System.out.println("The number must be between " + min + " and " + max);
                System.out.print("Enter an integer between " + min + " and " + max + ":");
                numGuess = input.nextInt();
            }
            numTries += 1;
            if (numTries == maxTries && numGuess != answer) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
                break;
            } else if (numGuess > answer) {
                System.out.println("Try a lower number!");
            } else if (numGuess < answer) {
                System.out.println("Try a higher number!");
            } else if (numGuess == answer) {
                System.out.println("Congratulations!");
                if (numTries == 1) {
                    System.out.println("You have tried " + numTries + " time");
                    break;
                } else {
                    System.out.println("You have tried " + numTries + " times");
                    break;
                }
            }
        }
        System.out.print("Want to play again (Y or y):");
        String playAgain = input.next();
        if (playAgain.equals("y") || playAgain.equals("Y")) {
            genAnswer();
            playGames();
        } else {
            System.out.println("Thank you for playing our games. Bye!");
        }
    }
}
