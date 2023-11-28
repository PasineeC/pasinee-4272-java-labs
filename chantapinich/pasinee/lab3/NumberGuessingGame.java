package chantapinich.pasinee.lab3;

import java.util.*;

public class NumberGuessingGame {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int max = 20;
        int min = 1;
        int answer = min + (int) (Math.random() * ((max - min) + 1));
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
