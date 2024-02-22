package chantapinich.pasinee.lab10;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import chantapinich.pasinee.lab9.PlayerFormV7;

/*
 * This class, PlayerFormV8, extends PlayerFormV7 to handle list selection events,
 * specifically when the user selects or deselects items from the sport list.
 * 
 * Methods:
 * - valueChanged(ListSelectionEvent e): Overrides the method to handle list selection events.
 * - addListeners(): Overrides the method to add list selection listener to the sport list.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV8.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    // StringBuffer to store the selected sports
    StringBuffer sportOutput = new StringBuffer("");
    ListSelectionModel listSelectionModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV8(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        PlayerFormV8 msw = new PlayerFormV8("Player Form V8");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
        msw.addListeners();
    }

    // Handles list selection events
    @Override
    public void valueChanged(ListSelectionEvent e) {
        listSelectionModel = (ListSelectionModel) e.getSource();
        boolean isAdjusting = e.getValueIsAdjusting();
        if (!isAdjusting) {
            if (listSelectionModel.isSelectionEmpty()) {
                sportOutput.append("none!");
            } else {
                sportOutput.append("Selected sports are ");
                List<String> selectedSport = sportList.getSelectedValuesList();
                int numSelectedSport = selectedSport.size();
                for (int i = 0; i < numSelectedSport; i++) {
                    sportOutput.append(" " + selectedSport.get(i));
                }
            }

            JOptionPane.showMessageDialog(this, sportOutput);
            // Clear the StringBuffer
            sportOutput.setLength(0);
        }
    }

    @Override
    public void addListeners() {
        super.addListeners();
        listSelectionModel = sportList.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
    }

}
