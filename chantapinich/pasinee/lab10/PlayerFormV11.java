package chantapinich.pasinee.lab10;

import java.awt.event.ActionEvent;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.io.File;
import java.awt.event.KeyEvent;

/*
 * This class, PlayerFormV11, extends PlayerFormV10 and adds functionality to handle custom menu item events,
 * display file path messages for open and save operations, and enable keyboard shortcuts for menu items.
 * 
 * Methods:
 * - showFilePath(String fileType): Displays a message showing the file path for open and save operations.
 * - actionPerformed(ActionEvent e): Overrides the method to handle action events from menu items and file chooser.
 * - addListeners(): Overrides the method to add action listener to the custom menu item.
 * - enableKeyboard(): Enables keyboard shortcuts for menu items.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV11 extends PlayerFormV10 {
    protected JMenuItem customMI;
    protected JColorChooser colorChooser;
    protected Color newColor;
    protected JFileChooser fileChooser = new JFileChooser();
    protected File selectedFile;
    protected String filePath;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV11(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV11 msw = new PlayerFormV11("Player Form V11");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.enableKeyboard();
    }

    @Override
    protected void addMenus() {
        super.addMenus();
        customMI = new JMenuItem("Custom");
        colorMenu.add(customMI);
    }

    // Overrides the method to show file messages for open and save operations
    @Override
    public void showFileMessage(String itemName) {
        if (!itemName.equals("Open") && !itemName.equals("Save")) {
            super.showFileMessage(itemName);
        }
    }

    // Displays a message showing the file path for open and save operations
    public void showFilePath(String fileType) {
        selectedFile = fileChooser.getSelectedFile();
        filePath = selectedFile.getAbsolutePath();
        JOptionPane.showMessageDialog(this, fileType + " file " + filePath);
    }

    // Overrides the method to handle action events from menu items and file chooser
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        // If the custom menu item is clicked, show color chooser
        if (src == customMI) {
            newColor = JColorChooser.showDialog(this, "Choose Text Color", Color.BLACK);
            setTextFieldColor(newColor);
        }
        // If the open menu item is clicked, show file chooser for opening files
        else if (src == openMI) {
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                showFilePath("Opening");
            }
        } 
         // If the save menu item is clicked, show file chooser for saving files
        else if (src == saveMI) {
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                showFilePath("Saving in");
            }
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        customMI.addActionListener(this);
    }

    // Enables keyboard shortcuts for menu items
    public void enableKeyboard() {
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newMI.setMnemonic(KeyEvent.VK_N);
        openMI.setMnemonic(KeyEvent.VK_O);
        saveMI.setMnemonic(KeyEvent.VK_S);
        exitMI.setMnemonic(KeyEvent.VK_Q);
        newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    }
}
