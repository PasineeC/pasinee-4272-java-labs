package chantapinich.pasinee.lab6;

/*
 * This class, RockPaperScissorGame, is a specific implementation of the Game class.
 * It represents a Rock, Paper, Scissors game with two players and their respective choices.
 * 
 * Properties:
 * - player1Choice: Represents the choice made by Player 1 (default is "rock").
 * - player2Choice: Represents the choice made by Player 2 (default is "rock").
 * 
 * Constructors:
 * - RockPaperScissorGame(): Default constructor that sets default values for gameName, numOfPlayers, player1Choice, and player2Choice.
 * - RockPaperScissorGame(String player1Choice, String player2Choice): Constructor allowing customization of player choices,
 * with default values for gameName and numOfPlayers.
 * 
 * Methods:
 * - setPlayer1Choice(String player1Choice): Setter method for player1Choice.
 * - getPlayer1Choice(): Getter method for player1Choice.
 * - setPlayer2Choice(String player2Choice): Setter method for player2Choice.
 * - getPlayer2Choice(): Getter method for player2Choice.
 * - toString(): Overrides the toString method to provide a concise representation of the RockPaperScissorGame.
 * - playGame(): Implements the abstract playGame method from the Game class.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class RockPaperScissorGame extends Game {
    protected String player1Choice, player2Choice;

    public RockPaperScissorGame() {
        super("Rock Paper Scissor Game", 2);
        player1Choice = "rock";
        player2Choice = "rock";
    }

    public RockPaperScissorGame(String player1Choice, String player2Choice) {
        super("Rock Paper Scissor Game", 2);
        this.player1Choice = player1Choice;
        this.player2Choice = player2Choice;
    }

    public void setPlayer1Choice(String player1Choice) {
        this.player1Choice = player1Choice;
    }

    public String getPlayer1Choice() {
        return player1Choice;
    }

    public void setPlayer2Choice(String player2Choice) {
        this.player2Choice = player2Choice;
    }

    public String getPlayer2Choice() {
        return player2Choice;
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format("{ player1Choice='%s', player2Choice='%s'}", player1Choice, player2Choice);
    }

    @Override
    public void playGame() {
        System.out.println("Playing " + getName());
    }
}
