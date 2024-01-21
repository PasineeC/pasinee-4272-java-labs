package chantapinich.pasinee.lab6;

/*
 * This class, GuessNumberGameVer2, is an extension of GuessNumberGameVer1 and implements the HasRule interface.
 * It represents a version 2 of the Guess Number Game, introducing additional rules.
 * 
 * Constructors:
 * - GuessNumberGameVer2(): Default constructor that calls the default constructor of GuessNumberGameVer1.
 * - GuessNumberGameVer2(int minNum, int maxNum, int maxTries): Constructor allowing customization of minNum,
 * maxNum, and maxTries, calling the corresponding constructor of GuessNumberGameVer1.
 * 
 * Methods:
 * - toString(): Overrides the toString method to provide a concise representation of Guess Number Game Version 2.
 * - playGame(): Implements the playGame method from GuessNumberGameVer1.
 * - gameRule(): Implements the gameRule method from the HasRule interface, providing additional rules.
 * 
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class GuessNumberGameVer2 extends GuessNumberGameVer1 implements HasRule {

    public GuessNumberGameVer2() {
        super();
    }

    public GuessNumberGameVer2(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return "Guess Number Game Version 2 : " + super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Guess Number Game Version 2");
    }

    public void gameRule() {
        System.out.println("Guess Number Game Rules : ...");
    }
}
