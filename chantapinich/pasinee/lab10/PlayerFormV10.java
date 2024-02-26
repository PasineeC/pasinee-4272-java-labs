package chantapinich.pasinee.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/*
 * This class, PlayerFormV10, extends PlayerFormV9 and adds functionality to change text field color,
 * show file-related messages, and handle menu item events.
 * 
 * Methods:
 * - setTextFieldColor(Color color): Sets the foreground color of text fields.
 * - showFileMessage(String itemName): Displays a message indicating which menu item is clicked.
 * - actionPerformed(ActionEvent e): Overrides the method to handle action events from menu items.
 * - addListeners(): Overrides the method to add action listeners to menu items.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV10 extends PlayerFormV9 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV10(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV10 msw = new PlayerFormV10("Player Form V10");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }

    // Sets the foreground color of text fields
    public void setTextFieldColor(Color color) {
        nameTextField.setForeground(color);
        nationalTextField.setForeground(color);
        birthTextField.setForeground(color);
    }

    // Displays a message indicating which menu item is clicked
    public void showFileMessage(String itemName) {
        JOptionPane.showMessageDialog(this, "You click menu " + itemName);
    }

    // Handles action events from menu items
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        // If a color menu item is clicked
        if (src == redMI || src == greenMI || src == blueMI) {
            setTextFieldColor((src == redMI) ? Color.RED : (src == greenMI) ? Color.GREEN : Color.BLUE);
        }
        // If a size menu item is clicked
        else if (src == num16MI || src == num20MI || src == num24MI) {
            noteTa.setFont(new Font("Serif", Font.BOLD, (src == num16MI) ? 16 : (src == num20MI) ? 20 : 24));
        }
        // If a file-related menu item is clicked
        else if (src == newMI || src == openMI || src == saveMI) {
            showFileMessage((src == newMI) ? "New" : (src == openMI) ? "Open" : "Save");
        }
        // If the exit menu item is clicked
        else if (src == exitMI) {
            this.dispose();
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        redMI.addActionListener(this);
        greenMI.addActionListener(this);
        blueMI.addActionListener(this);
        sizeMenu.addActionListener(this);
        num16MI.addActionListener(this);
        num20MI.addActionListener(this);
        num24MI.addActionListener(this);
        newMI.addActionListener(this);
        openMI.addActionListener(this);
        saveMI.addActionListener(this);
        exitMI.addActionListener(this);
    }
}
