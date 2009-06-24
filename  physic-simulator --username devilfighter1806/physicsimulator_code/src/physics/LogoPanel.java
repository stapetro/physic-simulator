package physics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Logo panel displays logo image.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
public class LogoPanel extends JPanel {

    public static final String LOGO_PATH = "src/images/FMI.jpg";
    /**
     * Panel and logo image width are equal.
     */
    public static final int IMAGE_WIDTH = 800;
    /**
     * Logo panel and logo image height are equal.
     */
    public static final int IMAGE_HEIGHT = 50;
    /**
     * Stores image objet to be drawn.
     */
    private Image image;
    /**
     * For strech purposes.
     */
    private BufferedImage bufferedImage;
    private MediaTracker mediaTracker;

    public LogoPanel() {
        super();
        setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents();

    }

    /**
     * Initializes all components.
     */
    private void initComponents() {
        setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        /**
         * Path who is related to the LogoPanel class location.
         */
//        URL imgUrl = getClass().getResource(LOGO_PATH);
//        if (imgUrl == null) {
//            JOptionPane.showMessageDialog(this, "Cannot find path to logo image.", "Error Loading Logo",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//        image = Toolkit.getDefaultToolkit().getImage(imgUrl);
//        System.setProperty("java.class.path", "images");
        image = Toolkit.getDefaultToolkit().getImage(LOGO_PATH);
        mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        } catch (java.lang.InterruptedException interruptedexception) {
            JOptionPane.showMessageDialog(this, "Image loading interrupted", "Error Loading Logo",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (mediaTracker.isErrorID(0)) {
            JOptionPane.showMessageDialog(this, "Error loading image", "Error Loading Logo",
                    JOptionPane.ERROR_MESSAGE);
        }
        bufferedImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        bufferedImage.createGraphics().drawImage(image, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, this);
    }

    /**
     * Draws image on resizing the panel.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2d = (Graphics2D) g;
        graphics2d.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), this);
    }
}

