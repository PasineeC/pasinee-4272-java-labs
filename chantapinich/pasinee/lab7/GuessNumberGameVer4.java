package chantapinich.pasinee.lab7;

/*
 * This class, GuessNumberGameVer4, is an extension of the GuessNumberGameVer3 class from the lab5 package.
 * It represents a version 4 of the Guess Number Game, inheriting the properties and behaviors of GuessNumberGameVer3
 * 
 * Constructors:
 * - GuessNumberGameVer4(): Default constructor that calls the default constructor of GuessNumberGameVer3.
 * - GuessNumberGameVer4(int minNum, int maxNum): Constructor allowing customization of minNum and maxNum, calling the corresponding constructor of GuessNumberGameVer3.
 * - GuessNumberGameVer4(int minNum, int maxNum, int maxTries): Constructor allowing customization of minNum, maxNum, and maxTries, calling the corresponding constructor of GuessNumberGameVer3.
 * 
 *  Methods:
 * - toString(): Overrides the toString method to provide a concise representation of GuessNumberGameVer4.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import chantapinich.pasinee.lab5.GuessNumberGameVer3;

public class GuessNumberGameVer4 extends GuessNumberGameVer3 {
    public GuessNumberGameVer4() {
        super();
    }

    public GuessNumberGameVer4(int minNum, int maxNum) {
        super(minNum, maxNum);
    }

    public GuessNumberGameVer4(int minNum, int maxNum, int maxTries) {
        super(minNum, maxNum, maxTries);
    }

    @Override
    public String toString() {
        return String.format("GuessNumberGameVer4 (min:%s, max:%s, max tries:%s)", minNum, maxNum, maxTries);
    }
}
