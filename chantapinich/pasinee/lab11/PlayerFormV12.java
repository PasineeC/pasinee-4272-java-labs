package chantapinich.pasinee.lab11;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import chantapinich.pasinee.lab10.PlayerFormV11;

/*
 * This class, PlayerFormV12, extends PlayerFormV11 and adds functionality to handle date input validation,
 * ensuring that the entered date of birth is in the correct format. It also handles focusing on the next text field
 * when the current text field is filled.
 * 
 * Methods:
 * - textFieldName(): Assigns names to the text fields.
 * - handleDateTextField(JTextField textField, ActionEvent e): Handles the validation of the date text field.
 * - handleNormalTextField(JJTextFieldTextField textField,  nextComponent, ActionEvent e): Handles normal text fields.
 * - handleTextField(JTextField tf, ActionEvent e): // Identifies which text field caused the action event and manages it accordingly.
 * - actionPerformed(ActionEvent e): Overrides the method to handle action events from text fields.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 */

public class PlayerFormV12 extends PlayerFormV11 {
    protected LocalDate date;
    protected DateTimeFormatter formatter;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV12(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV12 msw = new PlayerFormV12("Player Form V12");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
        msw.enableKeyboard();
    }

    protected void textFieldName() {
        nameTextField.setName("Name");
        nationalTextField.setName("Nationality");
        birthTextField.setName("Date of Birth");
    }

    protected void handleDateTextField(JTextField textField, ActionEvent e) {
        try {
            textFieldName();
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            date = LocalDate.parse(textField.getText(), formatter);
            super.actionPerformed(e);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date in " + birthTextField.getName());
        }
    }

    protected void handleNormalTextField(JTextField textField, JTextField nextComponent, ActionEvent e) {
        textFieldName();
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + textField.getName());
            textField.requestFocusInWindow();
            nextComponent.setEnabled(false);
        } else {
            nextComponent.setEnabled(true);
            super.actionPerformed(e);
        }
    }

    protected void handleTextField(JTextField tf, ActionEvent e) {
        if (tf == birthTextField) {
            handleDateTextField(tf, e);
        } else if (tf == nameTextField) {
            handleNormalTextField(nameTextField, nationalTextField, e);
        } else if (tf == nationalTextField) {
            handleNormalTextField(nationalTextField, birthTextField, e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        name = nameTextField.getText();
        nation = nationalTextField.getText();
        birth = birthTextField.getText();

        if (src == nameTextField) {
            handleTextField(nameTextField, e);
        } else if (src == nationalTextField) {
            handleTextField(nationalTextField, e);
        } else if (src == birthTextField) {
            handleTextField(birthTextField, e);
        }
    }
}