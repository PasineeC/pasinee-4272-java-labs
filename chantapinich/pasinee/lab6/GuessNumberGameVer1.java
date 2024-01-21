package chantapinich.pasinee.lab6;

/*
 * This class, GuessNumberGameVer1, is a specific implementation of the Game class.
 * It represents a version 1 of the Guess Number Game, where players attempt to guess a randomly generated number.
 * 
 * Properties:
 * - minNum: Represents the minimum value for the random number.
 * - maxNum: Represents the maximum value for the random number.
 * - correctNum: Represents the randomly generated correct number for players to guess.
 * - maxTries: Represents the maximum number of tries allowed for each player.
 * - numGuess: Represents the number of guesses made by the player.
 * 
 * Constructors:
 * - GuessNumberGameVer1(): Default constructor that sets default values for minNum, maxNum, maxTries,
 * and generates a random correctNum within the specified range.
 * - GuessNumberGameVer1(int minNum, int maxNum): Constructor allowing customization of minNum, maxNum,
 * with default values for maxTries and a random correctNum.
 * GuessNumberGameVer1(int minNum, int maxNum, int maxTries): Constructor allowing customization of
 * minNum, maxNum, and maxTries, with a random correctNum.
 * 
 * Methods:
 * - setMinNum(int minNum): Setter method for minNum.
 * - getMinNum(): Getter method for minNum.
 * - setMaxNum(int maxNum): Setter method for maxNum.
 * - getMaxNum(): Getter method for maxNum.
 * - setMaxTries(int maxTries): Setter method for maxTries.
 * - getMaxTries(): Getter method for maxTries.
 * - toString(): Overrides the toString method to include information about minNum, maxNum, correctNum, and maxTries.
 * - playGame(): Implements the abstract playGame method from the Game class.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class GuessNumberGameVer1 extends Game {
    protected int minNum, maxNum, correctNum, maxTries;
    int numGuess;

    public GuessNumberGameVer1() {
        super("Guess Number Game", 1);
        minNum = 1;
        maxNum = 10;
        maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        maxTries = 3;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

    public GuessNumberGameVer1(int minNum, int maxNum, int maxTries) {
        super("Guess Number Game", 1);
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.maxTries = maxTries;
        correctNum = minNum + (int) (Math.random() * ((maxNum - minNum) + 1));
    }

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

    @Override
    public String toString() {
        return super.toString() + String.format("{ minNum='%s', maxNum='%s', correctNum='%s', maxTries='%s'}", minNum,
                maxNum, correctNum, maxTries);
    }

    @Override
    public void playGame() {
        System.out.println("Playing " + getName());
    }
}
