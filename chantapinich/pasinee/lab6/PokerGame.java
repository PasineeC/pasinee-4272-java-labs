package chantapinich.pasinee.lab6;

/*
 * This class, PokerGame, is a specific implementation of the CardGame class and implements the HasRule interface.
 * It represents a Poker card game with custom rules.
 * 
 * Constructors:
 * - PokerGame(): Default constructor that sets default values for numOfCardsPerPlayer, gameName, and numOfPlayers.
 * - PokerGame(int numOfCardsPerPlayer): Constructor allowing customization of numOfCardsPerPlayer, with default values for gameName and numOfPlayers.
 * 
 * Methods:
 * - toString(): Overrides the toString method to provide a concise representation of the PokerGame.
 * - playGame(): Implements the abstract playGame method from the CardGame class, specifying the behavior for playing Poker.
 * - gameRule(): Implements the gameRule method from the HasRule interface, providing Poker game rules.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class PokerGame extends CardGame implements HasRule {

    public PokerGame() {
        super(5);
        gameName = "Poker Game";
        numOfPlayers = 4;
    }

    public PokerGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        gameName = "Poker Game";
        numOfPlayers = 4;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Poker Game.");
    }

    @Override
    public void gameRule() {
        System.out.println("Poker Game Rules : ...");
    }
}
