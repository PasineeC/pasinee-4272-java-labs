package chantapinich.pasinee.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import chantapinich.pasinee.lab8.PlayerFormV5;

/*
 * This class, PlayerFormV6, extends PlayerFormV5 to create an extended player information form with additional functionalities.
 * Properties:
 * - name, nation, birth, hobbies, type: Strings to store player information.
 * - textShow: StringBuffer to accumulate text to display.
 *  
 * Constructors:
 * - PlayerFormV6(String title): Initializes the player form with the given title.
 * 
 * Methods:
 * - getTextField(): Retrieves text field values for name, nationality, and date of birth.
 * - getGender(): Retrieves the selected gender.
 * - getPlayerType(): Retrieves the selected player type.
 * - getHobbies(): Retrieves selected hobbies.
 * - getSport(): Retrieves selected sports.
 * - actionPerformed(ActionEvent e): Handles actions performed by buttons and text fields.
 * - addListeners(): Adds action listeners to buttons and text fields.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV6.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV6 extends PlayerFormV5 implements ActionListener {
    protected String name, nation, birth, hobbies, type;
    protected StringBuffer textShow = new StringBuffer(" ");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV6(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV6 msw = new PlayerFormV6("Player Form V6");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }

    public void getTextField() {
        name = nameTextField.getText();
        nation = nationalTextField.getText();
        birth = birthTextField.getText();
        if (name.isEmpty() || nation.isEmpty() || birth.isEmpty()) {
            textShow.append("Please enter your information");
        } else {
            textShow.append(String.format("%s has nationality as %s and was born on %s", name, nation, birth));
        }
    }

    public void getGender() {
        textShow.append(", has gender as ");
        if (femaleRadio.isSelected()) {
            textShow.append("Female");
        } else if (maleRadio.isSelected()) {
            textShow.append("Male");
        }
    }

    public void getPlayerType() {
        String selectedPlayerType = (String) typeCb.getSelectedItem();
        textShow.append(String.format(", is a %s player", selectedPlayerType));
    }

    public void getHobbies() {
        textShow.append(", has hobbies as");
        if (readCB.isSelected()) {
            textShow.append(" Reading");
        }
        if (browCB.isSelected()) {
            textShow.append(" Browsing");
        }
        if (sleepCB.isSelected()) {
            textShow.append(" Sleeping");
        }
        if (travelCB.isSelected()) {
            textShow.append(" Traveling");
        }
    }

    public void getSport() {
        List<String> sportSelected = sportList.getSelectedValuesList();
        textShow.append(" and plays " + sportSelected.toString());
    }

    protected void handleSubmitButton(){
        getTextField();
        getGender();
        getPlayerType();
        getHobbies();
        getSport();
        JOptionPane.showMessageDialog(this, textShow.toString());
        textShow.setLength(0);
    }

    protected void handleResetButton(){
        nameTextField.setText(null);    
        nationalTextField.setText(null);
        birthTextField.setText(null);
    }

    protected void handleTextField(JTextField src) {
        nameTextField.setName("Name");
        nationalTextField.setName("Nationality");
        birthTextField.setName("Date of Birth");
        String textfieldName = ((JTextField) src).getName();
        String textfieldValue = ((JTextField) src).getText();
        JOptionPane.showMessageDialog(this, textfieldName + " is changed to " + textfieldValue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == submitButton) {
            handleSubmitButton();
        } else if (src == resetButton) {
            handleResetButton();
        } else if (src instanceof JTextField) {
            handleTextField((JTextField) src);
        }
    }

    public void addListeners() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        nameTextField.addActionListener(this);
        nationalTextField.addActionListener(this);
        birthTextField.addActionListener(this);
    }
}
