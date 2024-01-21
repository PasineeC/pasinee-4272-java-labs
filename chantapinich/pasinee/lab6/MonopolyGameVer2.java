package chantapinich.pasinee.lab6;

/*
 * This class, MonopolyGameVer2, is an extension of the MonopolyGame class and implements the HasRule, UseBoard, and UseDice interfaces.
 * It represents a version 2 of the Monopoly board game, introducing additional rules, board setup, and dice rolling features.
 * 
 * Constructors:
 * - MonopolyGameVer2(): Default constructor that calls the default constructor of MonopolyGame.
 * - MonopolyGameVer2(String[] gamePieces): Constructor allowing customization of gamePieces, calling the corresponding constructor of MonopolyGame.
 * 
 * Methods:
 * - playGame(): Overrides the playGame method from MonopolyGame to provide the specific behavior for Monopoly Game Version 2.
 * - toString(): Overrides the toString method to provide a concise representation of Monopoly Game Version 2.
 * - gameRule(): Implements the gameRule method from the HasRule interface, providing additional Monopoly rules.
 * - setUpBoard(): Implements the setUpBoard method from the UseBoard interface, setting up the Monopoly board.
 * - rollDice(): Implements the rollDice method from the UseDice interface, simulating the rolling of dice for Monopoly.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class MonopolyGameVer2 extends MonopolyGame implements HasRule, UseBoard, UseDice {

    public MonopolyGameVer2() {
        super();
    }

    public MonopolyGameVer2(String[] gamePieces) {
        super(gamePieces);
    }

    @Override
    public void playGame() {
        System.out.println("Play Monopoly Game Version 2");

    }

    @Override
    public String toString() {
        return "Monopoly Game Version 2 : " + super.toString();
    }

    public void gameRule() {
        System.out.println("Monopoly Rules: ...");
    }

    public void setUpBoard() {
        System.out.println("Set up monopoly board");
    }

    public void rollDice() {
        System.out.println("Roll 2 dice for monopoly game");
    }
}
