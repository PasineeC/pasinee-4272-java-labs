package chantapinich.pasinee.lab4;

import java.util.*;

/*
 * This program allows the user to configure the range of numbers,
 * set the maximum number of tries, and play a guessing game.
 * It provides feedback for each guess, list all guesses made, 
 * and allows the user to view specific guesses.
 * The game continues until the user runs out of tries or correctly guesses the number.
 * After each game, the user can choose to play again or exit the program.
 * 
 * The program uses loops, conditions, and user input
 * It also utilizes a List to store and display the user's guesses.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class GuessNumberGamesV2 {
    // Global variable for the guessing game
    static int answer, min, max, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // start the game
        configure();
        genAnswer();
        playGames();
    }

    // Method to configure the game settings
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

    // Method to generate a random answer within the specified range
    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    // Method to play the guessing game
    static void playGames() {
        List<Integer> listNumGuess = new ArrayList<>();
        int numTries = 0;
        System.out.println("Welcome to a number guessing game!");

        // Main game loop
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int numGuess = input.nextInt();
            while (numGuess < min || numGuess > max) {
                System.out.print("Your guess should be in [" + min + "," + max + "]:");
                numGuess = input.nextInt();
            }
            // Add the guess to the list of number guessing and increase the number of tries
            listNumGuess.add(numGuess);
            numTries += 1;

            // Check the guess againt the answer
            if (numTries == maxTries && numGuess != answer) {
                // Out of tries
                System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                System.out.println("The answer is " + answer);
                break;
            } else if (numGuess > answer) {
                System.out.println("Try a lower number!");
            } else if (numGuess < answer) {
                System.out.println("Try a higher number!");
            } else if (numGuess == answer) {
                // Correct guess
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

        // Users prompt to list guesses or quit
        while (true) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            String guesses = input.next();
            if (guesses.equals("a")) {
                // List all guesses
                System.out.println("All guesses: ");
                for (int allGuesses : listNumGuess) {
                    System.out.print(allGuesses);
                    System.out.print(" ");
                }
                System.out.println();
            } else if (guesses.equals("g")) {
                // Display a specific guess
                System.out.print("Enter the number of the guess you want to see (1-" + numTries + "): ");
                int specificGuess = input.nextInt();
                System.out.println("Guess " + specificGuess + ": " + listNumGuess.get(specificGuess - 1));
            } else {
                // Exit the loop
                break;
            }
        }

        // Prompt to play again or exit
        System.out.print("Want to play again (Y or y):");
        String playAgain = input.next();
        if (playAgain.equals("y") || playAgain.equals("Y")) {
            // Restart the game
            genAnswer();
            playGames();
        } else {
            // Exit the game
            System.out.println("Thank you for playing our games. Bye!");
        }
    }
}
