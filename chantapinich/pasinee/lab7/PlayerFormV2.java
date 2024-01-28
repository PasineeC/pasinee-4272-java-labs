package chantapinich.pasinee.lab7;

/*
 * This class, PlayerFormV2, extends the PlayerFormV1 class to create an extended player information form.
 * It introduces additional components such as a JComboBox for player type and a JTextArea for notes.
 * 
 * Properties:
 * - typeLabel, noteLabel: JLabels for displaying labels for player type and notes.
 * - typeCb: JComboBox for selecting player type (Beginner, Amateur, Professional).
 * - noteTa: JTextArea for entering notes with a JScrollPane for scrolling.
 * - typePanel, notePanel, middlePanel: JPanels for organizing components in the form.
 * 
 * Constructors:
 * - PlayerFormV2(String title): Constructor that takes a title for the form.
 * 
 * Methods:
 * - addComponents(): Overrides the addComponents method of PlayerFormV1 to add additional components specific to PlayerFormV2.
 * - setFrameFeatures(): Overrides the setFrameFeatures method of PlayerFormV1.
 * - createAndShowGUI(): Static method to create and show an instance of PlayerFormV2.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import javax.swing.*;
import java.awt.*;

public class PlayerFormV2 extends PlayerFormV1 {
    protected JLabel typeLabel, noteLabel;
    protected JComboBox<String> typeCb;
    protected JTextArea noteTa;
    protected JScrollPane scrollPane;
    protected JPanel typePanel, notePanel, middlePanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public PlayerFormV2(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        super.addComponents();
        typeLabel = new JLabel("Player Type: ");
        noteLabel = new JLabel("Note: ");

        typeCb = new JComboBox<String>();
        typeCb.addItem("Beginner");
        typeCb.addItem("Amateur");
        typeCb.addItem("Professional");
        typeCb.setSelectedItem("Amateur");

        noteTa = new JTextArea(3, 35);
        noteTa.setText(
                "Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
        noteTa.setLineWrap(true);
        noteTa.setWrapStyleWord(true);
        scrollPane = new JScrollPane(noteTa);

        typePanel = new JPanel(new BorderLayout());
        typePanel.add(typeLabel, BorderLayout.WEST);
        typePanel.add(typeCb, BorderLayout.EAST);

        notePanel = new JPanel(new BorderLayout());
        notePanel.add(noteLabel, BorderLayout.WEST);
        notePanel.add(scrollPane, BorderLayout.SOUTH);

        middlePanel = new JPanel(new BorderLayout());
        middlePanel.add(typePanel, BorderLayout.NORTH);
        middlePanel.add(notePanel, BorderLayout.SOUTH);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(middlePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    @Override
    protected void setFrameFeatures() {
        super.setFrameFeatures();
    }

    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
