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
 * - createAndGetButtonPanel(): Initializes and returns the buttonPanel containing the "Reset" and "Submit" buttons.
 * - addComponents(): Sets the layout of the mainPanel and adds the buttonPanel to it.
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
    protected JPanel mainPanel = new JPanel();
    protected JPanel buttonPanel;
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

    protected JPanel createAndGetButtonPanel() {
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        buttonPanel = new JPanel();
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);
        return buttonPanel;
    }

    protected void addComponents() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(createAndGetButtonPanel(), BorderLayout.CENTER);
        add(mainPanel);
    }

    protected void setFrameFeatures() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
