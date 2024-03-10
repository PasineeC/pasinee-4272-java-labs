package chantapinich.pasinee.lab11;

import java.io.*;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

/*
 * PlayerFormV14 extends PlayerFormV13 and adds functionality to handle saving and opening Player objects to and from files.
 * It introduces a new menu item and radio button group to control whether to save or open Player objects as serialized files.
 * 
 * Attributes:
 * - fillMenu: JMenu for the new "Fill" menu.
 * - yesRMI, noRMI: JRadioButtonMenuItems for selecting whether to save or open Player objects as serialized files.
 * - groupFillButton: ButtonGroup to group the radio buttons.
 * - name, nationality, dob, playerType, gender: String variables to store player information.
 * - hobbies, sports: ArrayLists to store player hobbies and sports.
 * - year: Integer variable to store the number of years of experience.
 * 
 * Methods:
 * - addFillMenu: Method to create and add the "Fill" menu to the menu bar.
 * - addMenus: Overridden method to add menus including the "Fill" menu.
 * - getTextTF: Method to retrieve text data from text fields.
 * - setTextTF: Method to set text data to text fields.
 * - getGenderRadio: Method to retrieve gender data from radio buttons.
 * - setGenderRadio: Method to set gender data to radio buttons.
 * - getPlayerTypeCb: Method to retrieve player type data from combo box.
 * - setPlayerTypeCb: Method to set player type data to combo box.
 * - getHobbiesCheckBox: Method to retrieve hobbies data from check boxes.
 * - setHobbiesCheckBox: Method to set hobbies data to check boxes.
 * - getSportList: Method to retrieve selected sports data from list.
 * - setSportList: Method to set selected sports data to list.
 * - getYear: Method to retrieve years of experience data from slider.
 * - setYear: Method to set years of experience data to slider.
 * - getObject: Method to retrieve data from form components.
 * - setObject: Method to set data to form components.
 * - saveFileObject: Method to save Player object to a file.
 * - openFileObject: Method to open and read Player object from a file.
 * - ReadFileObject: Method to display the read data from the file.
 * - handleSaveFile: Overridden method to handle saving file action and saving Player object if selected.
 * - handleOpenFile: Overridden method to handle opening file action and opening Player object if selected.
 * - addListeners: Overridden method to add action listeners to the radio buttons.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV14 extends PlayerFormV13 {
    protected JMenu fillMenu;
    protected JRadioButtonMenuItem yesRMI, noRMI;
    protected ButtonGroup groupFillButton;
    protected String name, nationality, dob, playerType, gender;
    protected ArrayList<String> hobbies, sports;
    protected int year;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV14(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV14 msw = new PlayerFormV14("Player Form V14");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.enableKeyboard();
    }

    protected JMenu addFillMenu() {
        fillMenu = new JMenu("Fill");
        groupFillButton = new ButtonGroup();

        yesRMI = new JRadioButtonMenuItem("Yes");
        noRMI = new JRadioButtonMenuItem("No");

        groupFillButton.add(yesRMI);
        groupFillButton.add(noRMI);
        noRMI.setSelected(true);

        fillMenu.add(yesRMI);
        fillMenu.add(noRMI);
        return fillMenu;
    }

    @Override
    protected void addMenus() {
        super.addMenus();
        menuBar.add(addFillMenu());
    }

    protected void getTextTF() {
        name = nameTextField.getText();
        nationality = nationalTextField.getText();
        dob = birthTextField.getText();
    }

    protected void setTextTF() {
        nameTextField.setText(name);
        nationalTextField.setText(nationality);
        birthTextField.setText(dob);
    }

    protected void getGenderRadio() {
        if (maleRadio.isSelected()) {
            gender = "Male";
        } else if (femaleRadio.isSelected()) {
            gender = "Female";
        }
    }

    protected void setGenderRadio() {
        if (gender.equals("Male")) {
            maleRadio.setSelected(true);
        } else if (gender.equals("Female")) {
            femaleRadio.setSelected(true);
        }
    }

    protected void getPlayerTypeCb() {
        playerType = (String) typeCb.getSelectedItem();
    }

    protected void setPlayerTypeCb() {
        typeCb.setSelectedItem(playerType);
    }

    protected void getHobbiesCheckBox() {
        hobbies = new ArrayList<>();
        if (readCB.isSelected()) {
            hobbies.add("Reading");
        }
        if (browCB.isSelected()) {
            hobbies.add("Browsing");
        }
        if (sleepCB.isSelected()) {
            hobbies.add("Sleeping");
        }
        if (travelCB.isSelected()) {
            hobbies.add("Traveling");
        }
    }

    protected void setHobbiesCheckBox() {
        for (String hobby : hobbies) {
            if (hobby.equals("Reading")) {
                readCB.setSelected(true);
            }
            if (hobby.equals("Browsing")) {
                browCB.setSelected(true);
            }
            if (hobby.equals("Sleeping")) {
                sleepCB.setSelected(true);
            }
            if (hobby.equals("Traveling")) {
                travelCB.setSelected(true);
            }
        }
    }

    protected void getSportList() {
        sports = new ArrayList<>();
        for (String sport : sportList.getSelectedValuesList()) {
            sports.add(sport);
        }
    }

    protected void setSportList() {
        for (String sport : sports) {
            if (sport.equals("Badminton")) {
                sportList.addSelectionInterval(0, 0);
            }
            if (sport.equals("Boxing")) {
                sportList.addSelectionInterval(1, 1);
            }
            if (sport.equals("Football")) {
                sportList.addSelectionInterval(2, 2);
            }
            if (sport.equals("Running")) {
                sportList.addSelectionInterval(3, 3);
            }
        }
    }

    protected void getYear() {
        year = expSlider.getValue();
    }

    protected void setYear() {
        expSlider.setValue(year);
    }

    protected void getObject() {
        getTextTF();
        getGenderRadio();
        getPlayerTypeCb();
        getHobbiesCheckBox();
        getSportList();
        getYear();
    }

    protected void setObject() {
        setTextTF();
        setGenderRadio();
        setPlayerTypeCb();
        setHobbiesCheckBox();
        setSportList();
        setYear();
    }

    protected void saveFileObject(String file) {
        getObject();
        Player player = new Player(name, nationality, dob, playerType, gender, hobbies, sports, year);
        try {
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(player);
            output.close();
            fileOutput.close();
            System.out.println("Writing Object " + textShow + " and has experience years as " + year);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void openFileObject(String file) {
        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Player player = (Player) input.readObject();
            name = player.getName();
            nationality = player.getNationality();
            dob = player.getDob();
            playerType = player.getPlayerType();
            gender = player.getGender();
            hobbies = player.getHobbies();
            sports = player.getSports();
            year = player.getYear();

            fileInput.close();
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    protected void ReadFileObject() {
        String textRead = name + " has nationality as " + nationality + " and was born on " + dob + ", has gender as "
                + gender + " is a " + playerType + " player, has hobbies as " + hobbies + " and plays " + sports + " and has experience years as " + year;
        JOptionPane.showMessageDialog(this, "Data read from file " + filePath + "is \n" + textRead);
        System.out.println("Reading Object " + textRead);
    }

    @Override
    protected void handleSaveFile() {
        super.handleSaveFile();
        if (yesRMI.isSelected()) {
            saveFileObject(filePath);
        }
    }

    @Override
    protected void handleOpenFile() {
        if (yesRMI.isSelected()) {
            openFileObject(filePath);
            setObject();
            if (filePath.endsWith(".obj")) {
                ReadFileObject();
            }
        } else if (noRMI.isSelected()) {
            if (filePath.endsWith(".obj")) {
                openFileObject(filePath);
                ReadFileObject();
            } else {
                super.handleOpenFile();
            }
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        yesRMI.addActionListener(this);
        noRMI.addActionListener(this);
    }
}
