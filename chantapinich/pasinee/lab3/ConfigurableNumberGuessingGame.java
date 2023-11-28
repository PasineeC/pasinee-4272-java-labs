package chantapinich.pasinee.lab3;

import java.util.*;

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
