package chantapinich.pasinee.lab6;

/*
 * This class, DungeonsAndDragonsGame, is a specific implementation of the CardGame class.
 * It represents a Dungeons and Dragons card game and includes functionalities related to game rules,
 * using a game board, and rolling dice.
 * 
 * Constructors:
 * - DungeonsAndDragonsGame(): Default constructor that sets default values for gameName, numOfPlayers,
 * and numOfCardsPerPlayer, specifically for Dungeons and Dragons.
 * - DungeonsAndDragonsGame(int numOfCardsPerPlayer): Constructor allowing customization of numOfCardsPerPlayer.
 * 
 * Methods:
 * - toString(): Overrides the toString method to provide a concise representation of the Dungeons and Dragons game.
 * - playGame(): Implements the abstract playGame method from the CardGame class.
 * - gameRule(): Implements the gameRule method from the HasRule interface, providing Dungeons and Dragons game rules.
 * - setUpBoard(): Implements the setUpBoard method from the UseBoard interface, setting up the game board.
 * - rollDice(): Implements the rollDice method from the UseDice interface, simulating the rolling of dice.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class DungeonsAndDragonsGame extends CardGame implements HasRule, UseBoard, UseDice {

    public DungeonsAndDragonsGame() {
        super();
        gameName = "Dugeons And Dragons Game";
        numOfPlayers = 3;
    }

    public DungeonsAndDragonsGame(int numOfCardsPerPlayer) {
        super(numOfCardsPerPlayer);
        gameName = "Dugeons And Dragons Game";
        numOfPlayers = 3;
    }

    @Override
    public String toString() {
        return "Dungeons And Dragons Game : " + super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Dungeons And Dragons Game");
    }

    @Override
    public void gameRule() {
        System.out.println("Dungeons And Dragons Game Rules : ...");
    }

    @Override
    public void setUpBoard() {
        System.out.println("Setting up board for Dungeons And Dragons Game");
    }

    @Override
    public void rollDice() {
        System.out.println("Rolling 2 dices for Dungeons And Dragons Game");
    }
}
