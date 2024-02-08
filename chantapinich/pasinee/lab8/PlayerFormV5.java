package chantapinich.pasinee.lab8;

/*
 * This class, PlayerFormV5, extends the PlayerFormV4 class to add icons to the file menu items and display an image component.
 * 
 * Properties:
 * - newIcon, openIcon, saveIcon: ImageIcon instances for the "New", "Open", and "Save" icons.
 * 
 * Constructors:
 * - PlayerFormV5(String title): Constructor that takes a title for the form.
 * 
 * Methods:
 * - createAndGetFileMenu(): Overrides the createAndGetFileMenu method of PlayerFormV4 to add icons to the file menu items.
 * - addComponents(): Overrides the addComponents method of PlayerFormV4 to add an image component.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV5.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import javax.swing.*;

public class PlayerFormV5 extends PlayerFormV4 {
    protected ImageIcon newIcon, openIcon, saveIcon;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV5(String title) {
        super(title);
    }

    @Override
    protected JMenu createAndGetFileMenu() {
        super.createAndGetFileMenu();
        newIcon = new ImageIcon("chantapinich\\pasinee\\lab8\\image\\New-icon.png");
        openIcon = new ImageIcon("chantapinich\\pasinee\\lab8\\image\\Open-icon.png");
        saveIcon = new ImageIcon("chantapinich\\pasinee\\lab8\\image\\Save-icon.png");

        newMI.setIcon(newIcon);
        openMI.setIcon(openIcon);
        saveMI.setIcon(saveIcon);
        return fileMenu;
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        ReadImage image = new ReadImage();
        mainPanel.add(image, 6);
    }

    public static void createAndShowGUI() {
        PlayerFormV5 msw = new PlayerFormV5("Player Form V5");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
