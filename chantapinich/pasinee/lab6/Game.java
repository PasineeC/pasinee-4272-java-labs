package chantapinich.pasinee.lab6;

/*
 * This abstract class, Game, serves as a base class for various games.
 * It includes properties and methods common to different types of games.
 * 
 * Properties:
 * - gameName: Represents the name of the game.
 * - numOfPlayers: Represents the number of players in the game.
 * 
 * Constructors:
 * - Game(): Default constructor that sets default values for gameName and numOfPlayers.
 * - Game(String gameName, int numOfPlayers): Constructor allowing customization of gameName and numOfPlayers.
 * 
 * Methods:
 * - setName(String gameName): Setter method for gameName.
 * - getName(): Getter method for gameName.
 * - setNumOfPlayers(int numOfPlayers): Setter method for numOfPlayers.
 * - getNumOfPlayers(): Getter method for numOfPlayers.
 * - toString(): Overrides the toString method to provide a concise representation of the game.
 * - playGame(): Abstract method that must be implemented by subclasses to define the gameplay.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public abstract class Game {
    protected String gameName;
    protected int numOfPlayers;

    public Game() {
        gameName = "unknown game";
        numOfPlayers = 0;
    }

    public Game(String gameName, int numOfPlayers) {
        this.gameName = gameName;
        this.numOfPlayers = numOfPlayers;
    }

    public void setName(String gameName) {
        this.gameName = gameName;
    }

    public String getName() {
        return gameName;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    @Override
    public String toString() {
        return String.format("{ gameName='%s', numOfPlayers='%s'} ", getName(), getNumOfPlayers());
    }

    public abstract void playGame();

}
