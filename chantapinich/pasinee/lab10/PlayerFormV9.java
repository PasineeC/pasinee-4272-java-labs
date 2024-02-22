package chantapinich.pasinee.lab10;

import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * This class, PlayerFormV9, extends PlayerFormV8 to handle change events of a JSlider component,
 * specifically when the user changes the value of the JSlider.
 * 
 * Methods:
 * - stateChanged(ChangeEvent e): Overrides the method to handle change events of the JSlider.
 * - addListeners(): Overrides the method to add change listener to the JSlider.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV9.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV9(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV9 msw = new PlayerFormV9("Player Form V9");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }

    // Handles change events of the JSlider
    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        if (!slider.getValueIsAdjusting()) {
            int expYear = slider.getValue();
            JOptionPane.showMessageDialog(this, "Year of experience in this sport is " + expYear);
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        expSlider.addChangeListener(this);
    }
}
