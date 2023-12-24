package chantapinich.pasinee.lab4;

import java.util.*;

/* 
 * This program allows the user to configure the range of numbers,
 * set the maximum number of tries, and play a guessing game.
 * It tracks game statis tics such as the total number of games played,
 * total wins, win ratio, average number of guesses per game, and high score. 
 * The user can view game logs, replay, and exit the program.
 * 
 * The program uses additional variables and logic to calculate and display game statistics.
 * It also maintains lists to store all guesses and track the number of guesses for guesses for each game.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 *
*/

public class GuessNumberGamesV3 {
    static int answer, min, max, maxTries, sumNumguess, totalGameplay, totalWin;
    static float winRatio, averageNumguess;
    static String winCheck;
    static Scanner input = new Scanner(System.in);
    static List<Integer> allNumGuess = new ArrayList<>();

    public static void main(String[] args) {
        totalGameplay = 1;
        totalWin = 0;
        configure();
        genAnswer();
        playGames();
    }

    // Method to configure game settings
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
        List<Integer> listNumGuess = new ArrayList<>();
        int numTries = 0;
        System.out.println("Welcome to a number guessing game!");
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + min + " and " + max + ":");
            int numGuess = input.nextInt();
            while (numGuess < min || numGuess > max) {
                System.out.print("Your guess should be in [" + min + "," + max + "]:");
                numGuess = input.nextInt();
            }
            listNumGuess.add(numGuess);
            numTries += 1;
            if (numTries == maxTries && numGuess != answer) {
                if (numTries == 1) {
                    System.out.println("You have tried 1 time. You ran out of guesses");
                } else {
                    System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                }
                System.out.println("The answer is " + answer);
                break;
            } else if (numGuess > answer) {
                System.out.println("Try a lower number!");
            } else if (numGuess < answer) {
                System.out.println("Try a higher number!");
            } else if (numGuess == answer) {
                System.out.println("Congratulations!");
                totalWin++;

                if (numTries == 1) {
                    System.out.println("You have tried " + numTries + " time");
                    break;
                } else {
                    System.out.println("You have tried " + numTries + " times");
                    break;
                }
            }
        }

        allNumGuess.add(listNumGuess.size());

        while (true) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit: ");
            String guesses = input.next();
            if (guesses.equals("a")) {
                System.out.println("All guesses: ");
                for (int allGuesses : listNumGuess) {
                    System.out.print(allGuesses);
                    System.out.print(" ");
                }
                System.out.println();
            } else if (guesses.equals("g")) {
                System.out.print("Enter the number of the guess you want to see (1-" + numTries + "):");
                int specificGuess = input.nextInt();
                System.out.println("Guess " + specificGuess + ": " + listNumGuess.get(specificGuess - 1));
            } else {
                break;
            }
        }

        if (numTries < maxTries) {
            winCheck = "true";
        } else {
            winCheck = "false";
        }

        System.out.println("Game Log: " + "Answer: " + answer + ", Guesses: " + numTries + ", Win: " + winCheck);

        System.out.print("Want to play again (Y or y):");
        String playAgain = input.next();
        if (playAgain.equals("y") || playAgain.equals("Y")) {
            totalGameplay++;
            genAnswer();
            playGames();
        } else {
            sumNumguess = 0;
            for (int i = 0; i < allNumGuess.size(); i++) {
                sumNumguess += allNumGuess.get(i);
            }
            winRatio = (float) totalWin / (float) totalGameplay * 100;
            averageNumguess = (float) sumNumguess / (float) allNumGuess.size();
            System.out.println("----- Game Statistics -----");
            System.out.println("Total games played: " + totalGameplay);
            System.out.println("Total wins: " + totalWin);
            System.out.println("Win Ratio: " + winRatio + "%");
            System.out.println("Average guess per game: " + averageNumguess);
            if (totalWin == 0) {
                System.out.println("High Score (Least Guesses): N/A");
            } else {
                System.out.println("High Score (Least Guesses): " + Collections.min(allNumGuess));
            }
        }
    }
}
