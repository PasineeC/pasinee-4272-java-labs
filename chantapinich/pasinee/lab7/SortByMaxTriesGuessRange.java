package chantapinich.pasinee.lab7;

/*
 * This class, SortByMaxTriesGuessRange, implements the Comparator interface to define a custom sorting logic for GuessNumberGameVer4 objects.
 * It compares two GuessNumberGameVer4 instances based on both their maximum number of tries (maxTries) and the range between their minimum and maximum numbers.
 * 
 * Methods:
 * - compare(GuessNumberGameVer4 num1, GuessNumberGameVer4 num2): Overrides the compare method of the Comparator interface.
 * It calculates the range (maxNum - minNum) for each GuessNumberGameVer4 object and then compares them.
 * If the maxTries values are different, it prioritizes sorting by maxTries. Otherwise, it sorts by the range.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import java.util.*;

public class SortByMaxTriesGuessRange implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 num1, GuessNumberGameVer4 num2) {
        int range1 = num1.getMaxNum() - num1.getMinNum();
        int range2 = num2.getMaxNum() - num2.getMinNum();
        int maxTriesCompare = num1.getMaxTries() - num2.getMaxTries();

        if (maxTriesCompare != 0) {
            return maxTriesCompare;
        }
        return range2 - range1;
    }
}
