package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Defines the basic characteristics of the target object
 * which will be drawn on the AnimationPanel.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 * @version 1.0
 */
public class Target {

    private static final int X_LOWER_BOUND = 10;
    private static final int X_MID_BOUND = 200;
    private static final int X_UPPER_BOUND = 50;
    private static final int Y_MID_UPPER_BOUND = 250;
    private static final int Y_UPPER_BOUND = 50;
    private static final int HEIGHT = 30;
    public static final int OFFSET = 10;
    private static final Color[] targetColors = {Color.BLACK, Color.WHITE, Color.RED};
    public static final int TARGET_SIZE = 50;
    /**
     * Random generator.
     */
    private Random rand;
    /**
     * The x coordiante of the target
     */
    private int x;
    /**
     * The y coordinate of the target
     */
    private int y;

    /**
     * Default constructor.
     */
    public Target() {
        rand = new Random(System.currentTimeMillis());
        x = -100;
        y = 0;
    }

    /**
     * Draws the target on the panel of the specified coordinates.
     *
     * @param xCoord    the x coordinate
     * @param yCoord    the y coordinate
     */
    private void drawTarget(Graphics g) {
        int tempX = x, tempY = y;
        int size = TARGET_SIZE;
        for (int i = 0; i < targetColors.length; i++) {
            g.setColor(targetColors[i]);
            g.fillOval(tempX, tempY, size, size);
            tempX += OFFSET;
            tempY += OFFSET;
            size -= (2 * OFFSET);
        }
    }

    /**
     * Simulates hit by making some animation
     * that attracts the attention of the user
     */
    public void simulateHit(AnimationPanel animPnl) {
        Graphics g = animPnl.getGraphics();
        int tempX = x, tempY = y;
        Random rand = new Random();
        int size = TARGET_SIZE;
        int cnt = 1;
        for (int k = 0; k < 10; k++) {
//            animPnl.repaint();
            for (int i = 0; i < targetColors.length; i++) {
                g.setColor(targetColors[( cnt) % targetColors.length]);
                g.fillOval(tempX, tempY, size, size);
                tempX += OFFSET;
                tempY += OFFSET;
                size -= (2 * OFFSET);
            }
            cnt++;
            try {
                System.out.println("fuck it");
                Thread.sleep(199);
            } catch (InterruptedException ex) {
                Logger.getLogger(Target.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Draws target with random coordinates.
     * @param g Canvas on which target will be drawn.
     * @param panelWidth Animation panel width.
     * @param panelHeight Animation panel height.
     */
    public void drawRandomCoordinates(Graphics g, int panelWidth, int panelHeight) {
        //TODO TO be modified rand y coord.
        x = X_LOWER_BOUND + rand.nextInt(panelWidth - X_UPPER_BOUND);
        if (x <= X_MID_BOUND) {
            y = rand.nextInt(panelHeight - Y_MID_UPPER_BOUND);
        } else {
            y = rand.nextInt(panelHeight - Y_UPPER_BOUND);
        }
        drawTarget(g);
    }

    /**
     * Redraws target.
     * @param g Canvas on which target will be drawn.
     * @param panelWidth Animation panel width.
     * @param panelHeight Animation panel height.
     */
    public void reDrawTarget(Graphics g, int panelWidth, int panelHeight) {
        drawTarget(g);
    }

    /**
     * Clears target from panel.
     * @param g
     */
    public void clearTarget(Graphics g) {
        g.clearRect(x, y, TARGET_SIZE, TARGET_SIZE);
    }

    /**
     * @return target point.
     */
    public Point getPoint() {
        return new Point(x, y);
    }

    /**
     * Target radius getter.
     * @return target radius point.
     */
    public Point getCenterPoint() {
        return new Point(x + TARGET_SIZE / 2, y + TARGET_SIZE / 2);
    }
}
