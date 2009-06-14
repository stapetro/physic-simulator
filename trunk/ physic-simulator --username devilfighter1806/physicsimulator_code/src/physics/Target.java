package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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
    private static final int TARGET_SIZE = 30;
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
        g.setColor(Color.RED);
//        g.drawOval(x, y, TARGET_SIZE, TARGET_SIZE);
        g.fillOval(x, y, TARGET_SIZE, TARGET_SIZE);
    }

    /**
     * Simulates hit by making some animation
     * that attracts the attention of the user
     */
    public void simulateHit() {
        //abe tuka neshto sharenko da stava
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
    public void reDrawTarget(Graphics g, int panelWidth, int panelHeight){
        drawTarget(g);
    }
}
