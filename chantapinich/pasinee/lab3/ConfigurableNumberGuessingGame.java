package chantapinich.pasinee.lab3;

import java.util.*;

/**
 * this program accepts 4 arguments:
 * - the minimum value for guessing 
 * - the maximum value for guessing
 * - the maximum number of tries
 * - the user's guess between min and max
 * 
 * Functions:
 * - configure(): Allows the user to set the min, max, and maxTries
 * - genAnswer() : Generates a random answer
 * - playGame() : Runs the game, reading input, displaying output, and tracking remaining guesses
 * 
 * Output:
 * - Correct guess: Congratulations! You tried <numTries> times(s)
 * - Incorrect guess: Try a lower/higher number!
 * - Out of guesses: You tried 5 times. You ran out of guesses. The answer is <answer>
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class ConfigurableNumberGuessingGame {
    static int answer, min, max, numTries, maxTries;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        configure();
        genAnswer();
        playGame();
    }

    static void configure() {
        System.out.print("Enter the min value:");
        min = input.nextInt();
        System.out.print("Enter the max value:");
        max = input.nextInt();
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();
    }

    static void genAnswer() {
        answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    static void playGame() {
        numTries = 0;
        System.out.println("Welcome to a number guessing game!");
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int numGuess = input.nextInt();
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
    }
}
