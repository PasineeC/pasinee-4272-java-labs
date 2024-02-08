package chantapinich.pasinee.lab8;

/*
 * This class, PlayerFormV4, extends the PlayerFormV3 class to add additional components related to hobbies, sports, and experience.
 * 
 * Properties:
 * - hobbyLabel, sportLabel, expLabel: JLabels for displaying labels for hobbies, sports, and experience.
 * - readCB, browCB, sleepCB, travelCB: JCheckBox instances for selecting hobbies.
 * - sportList: JList for selecting a sport.
 * - expSlider: JSlider for selecting years of experience.
 * - hobbyPanel, hobbyBoxPanel, sportPanel, expPanel: JPanels for organizing components.
 * 
 * Constructors:
 * - PlayerFormV4(String title): Constructor that takes a title for the form.
 * 
 * Methods:
 * - createAndGetHobbyPanel(): Initializes and returns the hobbyPanel with hobby-related components.
 * - createAndGetSportPanel(): Initializes and returns the sportPanel with sport-related components.
 * - createAndGetExpPanel(): Initializes and returns the expPanel with experience-related components.
 * - addComponents(): Overrides the addComponents method of PlayerFormV3 to add additional components specific to PlayerFormV4.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV4.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import javax.swing.*;
import java.awt.*;

public class PlayerFormV4 extends PlayerFormV3 {
    protected JLabel hobbyLabel, sportLabel, expLabel;
    protected JCheckBox readCB, browCB, sleepCB, travelCB;
    protected JList<String> sportList;
    protected String[] sport;
    protected JSlider expSlider;
    protected JPanel hobbyPanel, hobbyBoxPanel, sportPanel, expPanel;
    protected int minSlider = 0, maxSlider = 20, valueSlider = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV4(String title) {
        super(title);
    }

    protected JPanel createAndGetHobbyPanel() {
        hobbyLabel = new JLabel("Hobbies: ");
        readCB = new JCheckBox("Reading");
        browCB = new JCheckBox("Browsing");
        sleepCB = new JCheckBox("Sleeping", true);
        travelCB = new JCheckBox("Traveling");

        hobbyBoxPanel = new JPanel();
        hobbyBoxPanel.setLayout(new FlowLayout());
        hobbyBoxPanel.add(hobbyLabel);
        hobbyBoxPanel.add(readCB);
        hobbyBoxPanel.add(readCB);
        hobbyBoxPanel.add(browCB);
        hobbyBoxPanel.add(sleepCB);
        hobbyBoxPanel.add(travelCB);

        hobbyPanel = new JPanel();
        hobbyPanel.setLayout(new BorderLayout());
        hobbyPanel.add(hobbyLabel, BorderLayout.WEST);
        hobbyPanel.add(hobbyBoxPanel, BorderLayout.SOUTH);
        return hobbyPanel;
    }

    protected JPanel createAndGetSportPanel() {
        sportLabel = new JLabel("Sport: ");
        sport = new String[] { "Badminton", "Boxing", "Football", "Running" };
        sportList = new JList<String>(sport);
        sportList.setSelectedIndex(2);

        sportPanel = new JPanel();
        sportPanel.setLayout(new GridLayout(1, 2));
        sportPanel.add(sportLabel);
        sportPanel.add(sportList);
        return sportPanel;
    }

    protected JPanel createAndGetExpPanel() {
        expLabel = new JLabel("Year of experience in this sport: ");
        expPanel = new JPanel();
        expSlider = new JSlider(minSlider, maxSlider, valueSlider);
        expSlider.setMinorTickSpacing(1);
        expSlider.setMajorTickSpacing(5);
        expSlider.setPaintTicks(true);
        expSlider.setPaintLabels(true);

        expPanel.setLayout(new BorderLayout());
        expPanel.add(expLabel, BorderLayout.NORTH);
        expPanel.add(expSlider, BorderLayout.SOUTH);
        return expPanel;
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(createAndGetHobbyPanel(), 2);
        mainPanel.add(createAndGetSportPanel(), 3);
        mainPanel.add(createAndGetExpPanel(), 4);
    }

    public static void createAndShowGUI() {
        PlayerFormV4 msw = new PlayerFormV4("Player Form V4");
        msw.addMenus();
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
