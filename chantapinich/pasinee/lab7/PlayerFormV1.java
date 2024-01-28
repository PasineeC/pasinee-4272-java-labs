package chantapinich.pasinee.lab7;

/*
 * This class, PlayerFormV1, extends the MySimpleWindow class to create a player information form with text fields and radio buttons for gender.
 * 
 * Properties:
 * - nameTextField, nationalTextField, birthTextField: JTextFields for entering name, nationality, and date of birth.
 * - nameLabel, nationalLabel, birthLabel, genderLabel: JLabels for displaying labels for corresponding fields.
 * - maleRadio, femaleRadio: JRadioButtons for selecting gender.
 * - genderPanel, topPanel: JPanels for organizing components.
 *  
 * Constructors:
 * - PlayerFormV1(String title): Constructor that takes a title for the form.
 * 
 * Methods:
 * - addComponents(): Overrides the addComponents method of MySimpleWindow to add additional components specific to PlayerFormV1.
 * - setFrameFeatures(): Overrides the setFrameFeatures method of MySimpleWindow.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV1.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import javax.swing.*;
import java.awt.*;

public class PlayerFormV1 extends MySimpleWindow {
    protected JTextField nameTextField, nationalTextField, birthTextField;
    protected JLabel nameLabel, nationalLabel, birthLabel, genderLabel;
    protected JRadioButton maleRadio, femaleRadio;
    protected JPanel genderPanel, topPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV1(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        super.addComponents();

        genderLabel = new JLabel("Gender: ");
        nameLabel = new JLabel("Name: ");
        nationalLabel = new JLabel("Nationality: ");
        birthLabel = new JLabel("Date of Birth (eg.,31-01-2005): ");

        nameTextField = new JTextField(15);
        nationalTextField = new JTextField(15);
        birthTextField = new JTextField(15);

        ButtonGroup genderGroup = new ButtonGroup();
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female", true);
        genderGroup.add(femaleRadio);
        genderGroup.add(maleRadio);
        genderPanel = new JPanel(new FlowLayout());
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);

        topPanel = new JPanel(new GridLayout(4, 2));
        topPanel.add(nameLabel);
        topPanel.add(nameTextField);

        topPanel.add(nationalLabel);
        topPanel.add(nationalTextField);

        topPanel.add(birthLabel);
        topPanel.add(birthTextField);

        topPanel.add(genderLabel);
        topPanel.add(genderPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    @Override
    protected void setFrameFeatures() {
        super.setFrameFeatures();
    }

    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
