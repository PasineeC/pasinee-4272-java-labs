package chantapinich.pasinee.lab5;

import java.util.Scanner;

/*
 * A simple number guessing game class with customizable settings.
 * 
 * This class allows users to create instances of a number guessing game with different settings
 * such as the range of numbers, maximum number of tries, etc.
 *
 * The game can be played using the playGame() method.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class GuessNumberGameVer1 {
    protected int minNum, maxNum, maxTries;
    protected int correctNum;
    protected static int numOfGames = 0;
    Scanner input;
    int numGuess;

    //Constructors
    public GuessNumberGameVer1() {
        minNum = 1;
        maxNum = 10;
        maxTries = 3;
        numOfGames++;
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        maxTries = 3;
        numOfGames++;

    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        numOfGames++;
    }

    // Setter and Getter methods
    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public int getMaxTries() {
        return maxTries;
    }

    // Method to play this game
    public void playGame() {
        this.correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
        int numTries = 0;
        System.out.println("Welcome to a number guessing game!");
        while (numTries < maxTries) {
            System.out.print("Enter an integer between " + minNum + " and " + maxNum + ":");
            input = new Scanner(System.in);
            numGuess = input.nextInt();
            numTries += 1;
            if (numTries == maxTries && numGuess != correctNum) {
                System.out.println("You have tried " + numTries + " times. You ran out of guesses");
                System.out.println("The answer is " + correctNum);
                break;
            } else if (numGuess > correctNum) {
                System.out.println("Try a lower number!");
            } else if (numGuess < correctNum) {
                System.out.println("Try a higher number!");
            } else if (numGuess == correctNum) {
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

    // Method to represent the state of the object
    @Override
    public String toString() {
        return "GuessNumberGame with min number as " + minNum + " max number as " + maxNum + " max number of tries as "
                + maxTries;
    }

    // Static method to get the total number of games played
    public static int getNumOfGames() {
        return numOfGames;
    }
}