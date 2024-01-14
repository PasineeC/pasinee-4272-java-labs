package chantapinich.pasinee.lab5;

import java.util.Scanner;

/*
 * An extension of the number guessing game with addition statistical features.
 * 
 * This class inherits from GuessNumberGameVer2 and adds functionality for calculating and displaying
 * the average, minimum and maximum of the guessed numbers. 
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class GuessNumberGameVer3 extends GuessNumberGameVer2 {

    // Constructors
    public GuessNumberGameVer3() {
        super();
    }

    public GuessNumberGameVer3(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer3(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    // Method to calculate and display the average of guessed numbers
    public void guessAverage() {
        double sum = 0;
        for (int i = 0; i < numGuesses; i++) {
            sum += guesses[i];
        }
        double average = (double) sum / numGuesses;
        System.out.println("Average = " + average);
    }

    // Method to find and display the minimum guessed number
    public void guessMin() {
        int min = guesses[0];
        for (int i = 0; i < numGuesses; i++) {
            if (guesses[i] < min) {
                min = guesses[i];
            }
        }
        System.out.println("Min = " + min);
    }

    // Method to find and display the maximum guessed number
    public void guessMax() {
        int max = guesses[0];
        for (int i = 0; i < numGuesses; i++) {
            if (guesses[i] > max) {
                max = guesses[i];
            }
        }
        System.out.println("Max = " + max);
    }

    // Method to play game include additional commands for statistical features
    public void playGames() {
        playGame();
        while (true) {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit: ");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
            System.out.println("Type 'v' to show the average of the guesses, 'm' to show the minimum of the guesses, or 'x' show the maximum of the guesses");
            input = new Scanner(System.in);
            choices = input.nextLine();
            if (choices.equals("y")) {
                playGame();
            } else if (choices.equals("a") || choices.equals("A")) {
                showGuesses();
            } else if (choices.equals("g") || choices.equals("G")) {
                showSpecific();
            } else if (choices.equals("v") || choices.equals("V")) {
                guessAverage();
            } else if (choices.equals("m") || choices.equals("M")) {
                guessMin();
            } else if (choices.equals("x") || choices.equals("X")) {
                guessMax();
            } else if (choices.equals("q")){
                input.close();
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
    }
}
