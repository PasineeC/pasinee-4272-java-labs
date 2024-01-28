package chantapinich.pasinee.lab7;

/*
 * This class, SortByMaxTries, implements the Comparator interface to define a custom sorting logic for GuessNumberGameVer4 objects.
 * It compares two GuessNumberGameVer4 instances based on their maximum number of tries (maxTries).
 * 
 * Methods:
 * - compare(GuessNumberGameVer4 num1, GuessNumberGameVer4 num2): Overrides the compare method of the Comparator interface.
 * It compares two GuessNumberGameVer4 objects by subtracting the maxTries of num2 from the maxTries of num1.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import java.util.*;

public class SortByMaxTries implements Comparator<GuessNumberGameVer4> {
    public int compare(GuessNumberGameVer4 num1, GuessNumberGameVer4 num2) {
        return num1.getMaxTries() - num2.getMaxTries();
    }
}
