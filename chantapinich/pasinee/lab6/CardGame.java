package chantapinich.pasinee.lab6;

/*
 * This is an abstract class named CardGame, which extends the Game class.
 * It represents a card game and includes properties and methods related to card games.
 * 
 * Properties:
 * - numOfCardsPerPlayer: Represents the number of cards each player has in the game.
 * 
 * Constructors:
 * - CardGame(): Default constructor that sets default values for numOfCardsPerPlayer.
 * - CardGame(int numOfCardsPerPlayer): Constructor allowing customization of numOfCardsPerPlayer.
 * 
 *  Methods:
 * - setNumOfCardsPerPlayer(int numOfCardsPerPlayer): Setter method for numOfCardsPerPlayer.
 * - getNumOfCardsPerPlayer(): Getter method for numOfCardsPerPlayer.
 * - toString(): Overrides the toString method to include information about numOfCardsPerPlayer.
 * - playGame(): Abstract method that must be implemented by DungeonsAndDragonsGame and PokerGame to define the gameplay.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public abstract class CardGame extends Game {
    protected int numOfCardsPerPlayer;

    public CardGame() {
        super();
        numOfCardsPerPlayer = 0;
    }

    public CardGame(int numOfCardsPerPlayer) {
        super();
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    public void setNumOfCardsPerPlayer(int numOfCardsPerPlayer) {
        this.numOfCardsPerPlayer = numOfCardsPerPlayer;
    }

    public int getNumOfCardsPerPlayer() {
        return numOfCardsPerPlayer;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("{ numOfCardsPerPlayer='%s'}", numOfCardsPerPlayer);
    }

    public abstract void playGame();
}
