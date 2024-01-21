package chantapinich.pasinee.lab6;

/*
 * This class, RockPaperScissorGameVer2, is an extension of the RockPaperScissorGame class and implements the HasRule interface.
 * It represents a version 2 of the Rock, Paper, Scissors game, introducing additional rules.
 * 
 * Constructors:
 * - RockPaperScissorGameVer2(): Default constructor that calls the default constructor of RockPaperScissorGame.
 * - RockPaperScissorGameVer2(String player1Choice, String player2Choice): Constructor allowing customization of player choices,
 * calling the corresponding constructor of RockPaperScissorGame.
 * 
 * Methods:
 * - toString(): Overrides the toString method to provide a concise representation of Rock Paper Scissor Game Version 2.
 * - playGame(): Overrides the playGame method from RockPaperScissorGame to provide specific behavior for Rock Paper Scissor Version 2.
 * - gameRule(): Implements the gameRule method from the HasRule interface, providing additional Rock Paper Scissors rules.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class RockPaperScissorGameVer2 extends RockPaperScissorGame implements HasRule {

    public RockPaperScissorGameVer2() {
        super();
    }

    public RockPaperScissorGameVer2(String player1Choice, String player2Choice) {
        super(player1Choice, player2Choice);
    }

    @Override
    public String toString() {
        return "Rock Paper Scissor Game Version 2 : " + super.toString();
    }

    @Override
    public void playGame() {
        System.out.println("Playing Rock Paper Scissor Version 2");
    }

    public void gameRule() {
        System.out.println("Rock Paper Scissor Rule: ...");
    }
}
