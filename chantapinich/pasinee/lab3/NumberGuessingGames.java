package chantapinich.pasinee.lab3;

import java.util.*;

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
        while (max <= 0 || max < min) {
            if (max <= 0) {
                System.out.println("The maximum number of tries must be greater than 0");
            } else if (max < min) {
                System.out.println("The max value must be at least equal to the min value");
            }
            System.out.print("Enter the max value:");
            max = input.nextInt();
        }
        System.out.print("Enter the maximum number of tries:");
        maxTries = input.nextInt();

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
