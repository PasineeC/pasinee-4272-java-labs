package chantapinich.pasinee.lab7;

/*
 * This class, MySimpleWindow, extends the JFrame class to create a simple window with two buttons: "Reset" and "Submit"
 * 
 * Properties:
 * - mainPanel: Represents the main panel of the window.
 * - buttonPanel: Represents the panel containing the buttons.
 * - resetButton, submitButton: JButton instances for the "Reset" and "Submit" buttons.
 * 
 * Constructors:
 * - MySimpleWindow(String title): Constructor that takes a title for the window.
 * 
 * Methods:
 * - addComponents(): Initializes and adds the buttons to the buttonPanel, and then adds the buttonPanel to the mainPanel.
 * - setFrameFeatures(): Sets features for the JFrame, such as visibility, location, default close operation, and packing.
 * - createAndShowGUI(): Static method to create and show an instance of MySimpleWindow.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import javax.swing.*;
import java.awt.*;

public class MySimpleWindow extends JFrame {
    protected JPanel mainPanel,buttonPanel;
    protected JButton resetButton, submitButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public MySimpleWindow(String title) {
        super(title);
    }

    protected void addComponents() {
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        buttonPanel = new JPanel();

        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    protected void setFrameFeatures() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
