package chantapinich.pasinee.lab8;

/*
 * This class, PlayerFormV3, extends the PlayerFormV2 class to add menu functionality to the player information form.
 * 
 * Properties:
 * - menuPanel: JPanel to hold the menu bar.
 * - menuBar: JMenuBar to contain the menus.
 * - fileMenu, configMenu, colorMenu, sizeMenu: JMenu instances for file, configuration, color, and size menus.
 * - newMI, openMI, saveMI, exitMI: JMenuItems for file menu options.
 * - redMI, greenMI, blueMI, num16MI, num20MI, num24MI: JMenuItems for color and size options.
 * 
 * Constructors:
 * - PlayerFormV3(String title): Constructor that takes a title for the form.
 * 
 * Methods:
 * - createAndGetFileMenu(): Initializes and returns the fileMenu with its associated menu items.
 * - createAndGetConfigMenu(): Initializes and returns the configMenu with its associated submenus and items.
 * - addMenus(): Adds the fileMenu and configMenu to the menu bar and sets it to the JFrame.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV3.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import javax.swing.*;
import chantapinich.pasinee.lab7.PlayerFormV2;

public class PlayerFormV3 extends PlayerFormV2 {
    protected JPanel menuPanel;
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, colorMenu, sizeMenu;
    protected JMenuItem newMI, openMI, saveMI, exitMI;
    protected JMenuItem redMI, greenMI, blueMI, num16MI, num20MI, num24MI;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV3(String title) {
        super(title);
    }

    protected JMenu createAndGetFileMenu() {
        fileMenu = new JMenu("File");
        newMI = new JMenuItem("New");
        openMI = new JMenuItem("Open");
        saveMI = new JMenuItem("Save");
        exitMI = new JMenuItem("Exit");
        fileMenu.add(newMI);
        fileMenu.add(openMI);
        fileMenu.add(saveMI);
        fileMenu.addSeparator();
        fileMenu.add(exitMI);
        return fileMenu;
    }

    protected JMenu createAndGetConfigMenu() {
        configMenu = new JMenu("config");

        colorMenu = new JMenu("Color");
        redMI = new JMenuItem("Red");
        greenMI = new JMenuItem("Green");
        blueMI = new JMenuItem("Blue");
        colorMenu.add(redMI);
        colorMenu.add(greenMI);
        colorMenu.add(blueMI);

        sizeMenu = new JMenu("Size");
        num16MI = new JMenuItem("16");
        num20MI = new JMenuItem("20");
        num24MI = new JMenuItem("24");
        sizeMenu.add(num16MI);
        sizeMenu.add(num20MI);
        sizeMenu.add(num24MI);

        configMenu.add(colorMenu);
        configMenu.add(sizeMenu);
        return (configMenu);
    }

    protected void addMenus() {
        menuBar = new JMenuBar();
        menuBar.add(createAndGetFileMenu());
        menuBar.add(createAndGetConfigMenu());
        this.setJMenuBar(menuBar);
    }

    public static void createAndShowGUI() {
        PlayerFormV3 msw = new PlayerFormV3("Player Form V3");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
