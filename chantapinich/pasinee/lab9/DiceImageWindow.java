package chantapinich.pasinee.lab9;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/*
 * This class, DiceImageWindow, extends JFrame to create a window for displaying dice images and buttons for rolling the dice.
 * 
 * Properties:
 * - diceImageCanvas: Represents the canvas for displaying the dice image.
 * - diceRoll: Represents the value rolled on the dice.
 * - buttonsPanel: JPanel for organizing buttons.
 * - rollButton, highButton, lowButton: JButtons for rolling the dice and selecting high or low options.
 * 
 * Constructors:
 * - DiceImageWindow(String title): Initializes the window with the given title.
 * 
 * Methods:
 * - setFrameFeatures(): Sets features for the JFrame, such as size, location, and visibility.
 * - addComponents(): Adds buttons and the dice image canvas to the window.
 * - createAndShowGUI(): Static method to create and show an instance of DiceImageWindow.
 * - main(String[] args): Entry point for running the application.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class DiceImageWindow extends JFrame {
    protected DiceImageCanvas diceImageCanvas;
    protected int diceRoll;
    protected JPanel buttonsPanel;
    protected JButton rollButton, highButton, lowButton;

    public DiceImageWindow(String title) {
        super(title);
        Random rand = new Random();
        // diceRoll = rand.nextInt(6) + 1;
        diceRoll = 1;
        diceImageCanvas = new DiceImageCanvas(diceRoll);
    }

    public void setFrameFeatures() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void addComponents() {
        buttonsPanel = new JPanel(new FlowLayout());
        rollButton = new JButton("Roll");
        highButton = new JButton("High");
        lowButton = new JButton("Low");
        buttonsPanel.add(highButton);
        buttonsPanel.add(lowButton);
        buttonsPanel.add(rollButton);

        this.setLayout(new BorderLayout());
        this.add(buttonsPanel, BorderLayout.NORTH);
        this.add(diceImageCanvas, BorderLayout.CENTER);
    }

    public static void createAndShowGUI() {
        DiceImageWindow dgw = new DiceImageWindow("DiceGameWindow Version 1");
        dgw.addComponents();
        dgw.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
