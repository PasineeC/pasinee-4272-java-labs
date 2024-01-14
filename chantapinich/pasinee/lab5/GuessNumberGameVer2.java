package chantapinich.pasinee.lab5;

import java.util.*;

/*
 * An extended version of the numberguessing game with additional features.
 * 
 * This class inherits from GuessNumberGAmeVer1 and adds functionality for keeping track of guesses,
 * displaying specific guesses, showing all guesses, and playing multiple games with user interaction.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 {
    // Additional atrributes for tracking guesses
    protected int[] guesses;
    protected int numGuesses;
    protected int MAX_GUESSES = 20;
    Scanner input;
    String choices;
    int specChoices;

    //constructors
    public GuessNumberGameVer2() {
        super();
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum) {
        super(minNum, maxNum);
        guesses = new int[MAX_GUESSES];
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
        guesses = new int[MAX_GUESSES];
    }

    // Overridden playGame() method to include guess tracking
    @Override
    public void playGame() {
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        numGuesses = 0;
        System.out.println("Welcome to a number guessing game!");
        while (numGuesses < maxTries) {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            input = new Scanner(System.in);
            numGuess = input.nextInt();
            while (numGuess < minNum || numGuess > maxNum) {
                System.out.print("Your guess should be in [" + minNum + "," + maxNum + "]:");
                numGuess = input.nextInt();
            }
            guesses[numGuesses] = numGuess;
            numGuesses++;
            if (numGuesses == maxTries && numGuess != correctNum) {
                System.out.println("You have tried " + numGuesses + " times. You ran out of guesses");
                System.out.println("The answer is " + correctNum);
                break;
            } else if (numGuess > correctNum) {
                System.out.println("Try a lower number!");
            } else if (numGuess < correctNum) {
                System.out.println("Try a higher number!");
            } else if (numGuess == correctNum) {
                System.out.println("Congratulations!");
                if (numGuesses == 1) {
                    System.out.println("You have tried " + numGuesses + " time");
                    break;
                } else {
                    System.out.println("You have tried " + numGuesses + " times");
                    break;
                }
            }
        }
    }

    // Method to display a specific guess
    public void showSpecific() {
        System.out.println("Enter which guess in the range (1-" + numGuesses + ")");
        input = new Scanner(System.in);
        specChoices = input.nextInt();
        System.out.println("Guess number " + specChoices + " is " + guesses[specChoices - 1]);
    }

    // Method to display all guesses
    public void showGuesses() {
        for (int i = 0; i < numGuesses; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    // Method to play multiple games with user choices
    public void playGames() {
        playGame();
        while (true) {
            System.out.println("If want to play again? type 'y' to continue or 'q' to quit: ");
            System.out.println("Type 'a' to see all your guesses or 'g' to see a guess on a specific play.");
            input = new Scanner(System.in);
            choices = input.nextLine();
            if (choices.equals("y")) {
                playGame();
            } else if (choices.equals("a") || choices.equals("A")) {
                showGuesses();
            } else if (choices.equals("g") || choices.equals("G")) {
                showSpecific();
            } else if (choices.equals("q")){
                input.close();
                break;
            } else {
                input.close();
                break;
            }
        }
    }
}
