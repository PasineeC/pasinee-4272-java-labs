package chantapinich.pasinee.lab3;

import java.util.*;

/**
 * this program accepts 1 arguments:
 * - the user's guess between min and max
 * 
 * Functions:
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

public class NumberGuessingMethodGame {
    static int answer;
    final static int MIN = 1;
    final static int MAX = 20;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        genAnswer();
        playGame();
    }

    static void genAnswer() {
        answer = MIN + (int) (Math.random() * ((MAX - MIN) + 1));
    }

    static void playGame() {
        int numTries = 0;
        int maxTries = 5;
        System.out.println("Welcome to a number guessing game!");
        while (numTries < maxTries) {
            System.out.print("Enter an integer between 1 and 20:");
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
