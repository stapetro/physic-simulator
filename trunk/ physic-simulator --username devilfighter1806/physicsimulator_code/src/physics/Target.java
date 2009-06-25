package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Defines the basic characteristics of the target object
 * which will be drawn on the AnimationPanel.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 * @version 1.0
 */
public class Target {

    /**
     * Lower bound for drawing target with random x-coordinate.
     */
    private static final int X_LOWER_BOUND = 10;
    /**
     * Middle x-coordinate bound which bounds drawing target not over tha gun panel.
     */
    private static final int X_MID_BOUND = 200;
    /**
     * Upper bound which is x-coordinate offset for drawing target not outside
     * right side of the animation panel.
     */
    private static final int X_UPPER_BOUND = 50;
    /**
     * Middle y-coordinate bound which bounds drawing target not over tha gun panel.
     */
    private static final int Y_MID_UPPER_BOUND = 250;
    /**
     * Upper bound which is x-coordinate offset for drawing target not outside
     * top side of the animation panel.
     */
    private static final int Y_UPPER_BOUND = 50;
    /**
     * Offset for drawing nested ovals.
     */
    public static final int OFFSET = 10;
    /**
     * Stored colors for different nested ovals which represents the whole
     * target.
     */
    private static final Color[] targetColors = {Color.BLACK, Color.WHITE, Color.RED};
    /**
     * Size of the rectangle which is around the biggest target oval.
     */
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
    public void drawTarget(Graphics g) {
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
     * Target upper left corner coordinates setter.
     * @param x1 X-coordinate to be set.
     * @param y1 Y-coordinate to be set.
     */
    public void setTargetCoordinates(int x1, int y1) {
        x = x1;
        y = y1;
    }

    /**
     * Simulates hit by making some animation
     * that attracts the attention of the user
     */
    public void simulateHit(Graphics g, int count) {
        int tempX = x, tempY = y;
        int size = TARGET_SIZE;
        for (int i = 0; i < targetColors.length; i++) {
            g.setColor(targetColors[(count + i) % targetColors.length]);
            g.fillOval(tempX, tempY, size, size);
            tempX += OFFSET;
            tempY += OFFSET;
            size -= (2 * OFFSET);
        }
    }

    /**
     * Animation is started when target is hitted with the ball.
     * @param g Draws animation.
     */
    public void simulateHitAnimate(final Graphics g) {
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        simulateHit(g, i);
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimationPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                drawTarget(g);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0);
    }

    /**
     * Draws target with random coordinates.
     * @param g Canvas on which target will be drawn.
     * @param panelWidth Animation panel width.
     * @param panelHeight Animation panel height.
     */
    public void drawRandomCoordinates(Graphics g, int panelWidth, int panelHeight) {
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
    public void reDrawTarget(Graphics g) {
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
