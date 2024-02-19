package chantapinich.pasinee.lab9;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/*
 * This class, PlayerFormV7, extends PlayerFormV6 to handle item state changes of checkboxes and radio buttons, and display corresponding messages accordingly.
 * 
 * Methods:
 * - handleHobbies(JCheckBox checkBox, int stateChange): Handles item state changes of checkboxes and displays messages.
 * - handleGender(JRadioButton radioButton, int stateChange): Handles item state changes of radio buttons and displays messages.
 * - itemStateChanged(ItemEvent e): Overrides the method to handle item state changes of checkboxes and radio buttons.
 * - addListeners(): Overrides the method to add item listeners to checkboxes and radio buttons.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV7.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV7 extends PlayerFormV6 implements ItemListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV7(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV7 msw = new PlayerFormV7("Player Form V7");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }

    public void handleHobbies(JCheckBox checkBox, int stateChange) {
        String hobbies = checkBox.getActionCommand();

        if (stateChange == ItemEvent.SELECTED) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JOptionPane.showMessageDialog(null, hobbies + " is one of the hobbies");
                }
            });
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JOptionPane.showMessageDialog(null, hobbies + " is no longer one of the hobbies");
                }
            });
        }
    }

    public void handleGender(JRadioButton radioButton, int stateChange) {
        String gender = radioButton.getActionCommand();
        if (stateChange == ItemEvent.SELECTED) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JOptionPane.showMessageDialog(null, "Gender is updated to " + gender);
                }
            });
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object srcItem = e.getItemSelectable();
        if (srcItem instanceof JCheckBox) {
            handleHobbies((JCheckBox) srcItem, e.getStateChange());
        } else if (srcItem instanceof JRadioButton) {
            handleGender((JRadioButton) srcItem, e.getStateChange());
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        readCB.addItemListener(this);
        browCB.addItemListener(this);
        sleepCB.addItemListener(this);
        travelCB.addItemListener(this);
        maleRadio.addItemListener(this);
        femaleRadio.addItemListener(this);
    }

}
