package chantapinich.pasinee.lab11;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import chantapinich.pasinee.lab10.PlayerFormV11;

/*
 * This class, PlayerFormV12, extends PlayerFormV11 and implements additional functionality for handling
 * date input validation. It overrides the handleTextField method to handle date input validation separately.
 * 
 * Attributes:
 * - date: LocalDate object to store the parsed date.
 * - formatter: DateTimeFormatter object to specify the date format.
 * 
 * Methods:
 * - handleDateTextField: Method to handle date input validation.
 * - handleNormalTextField: Method to handle validation for normal text fields.
 * - handleTextField: Overridden method to handle text field input based on the text field type.
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

    protected void handleDateTextField(JTextField textField) {
        try {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            date = LocalDate.parse(textField.getText(), formatter);
            super.handleTextField(textField);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date in " + birthTextField.getName());
        }
    }

    protected void handleNormalTextField(JTextField textField, JTextField nextComponent) {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter some data in " + textField.getName());
            nextComponent.setEnabled(false);
        } else {
            nextComponent.requestFocusInWindow();
            nextComponent.setEnabled(true);
            super.handleTextField(textField);
        }
    }

    @Override
    protected void handleTextField(JTextField tf) {
        if (tf == birthTextField) {
            handleDateTextField(tf);
        } else if (tf == nameTextField) {
            handleNormalTextField(nameTextField, nationalTextField);
        } else if (tf == nationalTextField) {
            handleNormalTextField(nationalTextField, birthTextField);
        }
    }
}