package chantapinich.pasinee.lab8;

/*
 * This class, ReadImage, extends JPanel to create a panel for displaying an image.
 * 
 * Properties:
 * - img: BufferedImage instance to hold the image.
 * - imgFile: Path to the image file.
 * 
 * Methods:
 * - paintComponent(Graphics g): Overrides the paintComponent method to draw the image on the panel.
 * - ReadImage(): Constructor to initialize the image by reading it from the file.
 * - getPreferredSize(): Overrides the getPreferredSize method to return the preferred size of the panel based on the image dimensions.
 * 
 * Author: Pasinee Chantapinich
 * ID: 663040427-2
 * Sec: 1
 * 
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ReadImage extends JPanel {
    protected BufferedImage img;
    protected String imgFile = "chantapinich/pasinee/imageLab8/Football.jpg";

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    public ReadImage() {
        try {
            img = ImageIO.read(new File(imgFile));
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(), img.getHeight());
        }
    }
}
