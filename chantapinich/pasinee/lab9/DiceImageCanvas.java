package chantapinich.pasinee.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/*
 * This class, DiceImageCanvas, extends JPanel to create a canvas for displaying dice images with dots representing the dice number.
 * 
 * Properties:
 * - diceNumber: Represents the number displayed on the dice.
 * - g2d: Graphics2D object for drawing on the canvas.
 * - circleCenter, circleTopRight, circleBottomLeft, circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter: Ellipse2D objects representing the dots on the dice.
 * - square: Rectangle2D object representing the background square of the dice.
 * - squareWidth, squareHeight: Width and height of the background square.
 * - canvasWidth, canvasHeight: Width and height of the canvas.
 * - circleWidth, circleHeight: Width and height of the dots.
 * - startSquareX, startSquareY: Starting coordinates of the background square.
 * - margin: Margin between the dots and the edges of the square.
 * 
 * Constructors:
 * - DiceImageCanvas(int diceNumber): Initializes the canvas with the given dice number.
 * 
 * Methods:
 * - createCircles(): Initializes the Ellipse2D objects representing the dots on the dice.
 * - drawDiceNumber(): Draws the dots on the canvas based on the dice number.
 * - paintComponent(Graphics g): Overrides the paintComponent method to draw on the canvas.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class DiceImageCanvas extends JPanel {
    protected int diceNumber;
    protected Graphics2D g2d;
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square;
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;

    public DiceImageCanvas(int diceNumber) {
        // initialize dice number
        this.diceNumber = diceNumber;
        // set size with width canvasWidth and height canvasHeight
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        // initialize a square which is a background
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);
        // call method createCircles to place dots on a rectangle
        createCircles();
    }

    protected void createCircles() {
        circleCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + squareHeight / 2 - circleHeight / 2, circleWidth, circleHeight);
        circleTopLeft = new Ellipse2D.Double(startSquareX + margin, startSquareY + margin,
                circleWidth, circleHeight);
        circleTopCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + margin, circleWidth, circleHeight);
        circleTopRight = new Ellipse2D.Double(startSquareX + squareWidth - circleWidth - margin,
                startSquareY + margin, circleWidth, circleHeight);
        circleBottomLeft = new Ellipse2D.Double(startSquareX + margin,
                startSquareY + squareHeight - circleHeight - margin, circleWidth, circleHeight);
        circleBottomCenter = new Ellipse2D.Double(startSquareX + squareWidth / 2 - circleWidth / 2,
                startSquareY + squareHeight - circleHeight - margin, circleWidth, circleHeight);
        circleBottomRight = new Ellipse2D.Double(startSquareX + squareWidth - circleWidth - margin,
                startSquareY + squareHeight - circleHeight - margin, circleWidth, circleHeight);
    }

    protected void drawDiceNumber() {
        // depending on a dice number, place red dots properly on a rectangle

        if (diceNumber == 1) {
            g2d.fill(circleCenter);
        } else if (diceNumber >= 2) {
            g2d.fill(circleTopRight);
            g2d.fill(circleBottomLeft);
            if (diceNumber == 3) {
                g2d.fill(circleCenter);
            } else if (diceNumber >= 4) {
                g2d.fill(circleTopLeft);
                g2d.fill(circleBottomRight);
                if (diceNumber == 5) {
                    g2d.fill(circleCenter);
                } else if (diceNumber == 6) {
                    g2d.fill(circleTopCenter);
                    g2d.fill(circleBottomCenter);
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        // call paintComponent of super class
        super.paintComponent(g);
        // cast graphics object to graphics2D object
        g2d = (Graphics2D) g;
        // set paint to white and fill the quare
        g2d.setColor(Color.WHITE);
        g2d.fill(square);
        // call code to draw dice number
        g2d.setColor(Color.RED);
        drawDiceNumber();
    }
}