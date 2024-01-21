package chantapinich.pasinee.lab6;

/*
 * This class, MonopolyGame, is a specific implementation of the Game class.
 * It represents a Monopoly board game, featuring various game pieces.
 * 
 * Properties:
 * - gamePieces: Represents an array of strings containing different Monopoly game pieces.
 * 
 * Constructors:
 * - MonopolyGame(): Default constructor that sets default values for gameName, numOfPlayers, and gamePieces.
 * - MonopolyGame(String[] gamePieces): Constructor allowing customization of gamePieces, with default values for gameName and numOfPlayers.
 * 
 * Methods:
 * - setGamePieces(String[] gamePieces): Setter method for gamePieces.
 * - getGamePieces(): Getter method for gamePieces, returning a formatted string of game pieces.
 * - toString(): Overrides the toString method to include information about game pieces.
 * - playGame(): Implements the abstract playGame method from the Game class.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class MonopolyGame extends Game {
    protected String[] gamePieces;

    public MonopolyGame() {
        super("Monopoly Game", 4);
        gamePieces = new String[] { "car", "top hat", "thimble", "boot" };

    }

    public MonopolyGame(String[] gamePieces) {
        super("Monopoly Game", 4);
        this.gamePieces = gamePieces;
    }

    public void setGamePieces(String[] gamePieces) {
        this.gamePieces = gamePieces;
    }

    public String getGamePieces() {
        String stringGamePieces = "";
        for (String i : gamePieces) {
            stringGamePieces += i + " ";
        }
        return stringGamePieces;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("{ game pieces='%s'}", getGamePieces());
    }

    @Override
    public void playGame() {
        System.out.println("Playing " + getName());
    }

}
