package chantapinich.pasinee.lab11;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * PlayerFormV13 extends PlayerFormV12 and implements methods to handle saving and opening files.
 * It overrides the actionPerformed method to trigger file saving and opening actions when the respective
 * menu items are clicked.
 * 
 * Attributes:
 * - fileMessage: StringBuffer to store messages read from files.
 * 
 * Methods:
 * - getTextShow: Method to retrieve text data from the form components.
 * - saveFile: Method to save the text data to a file.
 * - openFile: Method to open and read text data from a file.
 * - handleSaveFile: Method to handle saving file action.
 * - handleOpenFile: Method to handle opening file action.
 * - actionPerformed: Overridden method to handle action events for saving and opening files.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV13 extends PlayerFormV12 {
    protected StringBuffer fileMessage = new StringBuffer("");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV13(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV13 msw = new PlayerFormV13("Player Form V13");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.enableKeyboard();
    }

    protected void getTextShow() {
        getTextField();
        getGender();
        getPlayerType();
        getHobbies();
        getSport();
    }

    public void saveFile() {
        try {
            getTextShow();
            PrintWriter writeFile = new PrintWriter(filePath);
            writeFile.println(textShow);
            writeFile.close();
        } catch (IOException ex) {
            System.err.println("error in writng file");
            ex.printStackTrace(System.err);
        }
    }

    public void openFile() {
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader r = new BufferedReader(fr);
            String line;
            while ((line = r.readLine()) != null) {
                fileMessage.append(line + "\n");
            }
            JOptionPane.showMessageDialog(this, "Data read from file " + filePath + " is \n" + fileMessage.toString());
            fileMessage.setLength(0);
            r.close();
            fr.close();
        } catch (IOException ex) {
            System.err.println("Error in reading file");
            ex.printStackTrace(System.err);
        } catch (NullPointerException ex) {
        }
    }

    protected void handleSaveFile() {
        saveFile();
    }

    protected void handleOpenFile() {
        openFile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == saveMI) {
            handleSaveFile();
        } else if (src == openMI) {
            handleOpenFile();
        }
    }
}
