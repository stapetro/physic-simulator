/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * This class defines the basic characteristics of the target object
 * which will be drawn on the AnimationPanel.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class Target {
    //TODO Canvas field.      -----Chech this out. I don't understand it
    //TODO setters and getters, but we will add then last.  --added by Krasi

    private static final int X_LOWER_BOUND = 10;
    private static final int X_MID_BOUND = 200;
    private static final int X_UPPER_BOUND = 500;
    private static final int Y_MID_UPPER_BOUND = 350;
    private static final int Y_UPPER_BOUND = 500;
    private static final int HEIGHT = 30;
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
    private Graphics targetDrawer;

    /**
     * Default constructor
     */
    public Target() {
//        drawRandomCoordinates(g);
        rand = new Random(System.currentTimeMillis());
    }

    /**
     * general purpose constructor
     * @param xCoord    the x coordinate of the target
     * @param yCoord    the x coordinate of the target
     */
    public Target(int xCoord, int yCoord) {
    }

    /**
     * Draw the target on the panel of the specified coordinates
     *
     * @param xCoord    the x coordinate
     * @param yCoord    the y coordinate
     */
    private void drawTarget(Graphics g, int xCoord, int yCoord, int height, int width) {
        g.setColor(Color.RED);
        g.drawOval(x, y, 30, 30);
        g.fillOval(x, y, 30, 30);
    }

    /**
     * Simulates hit by making some animation
     * that attracts the attention of the user
     */
    public void simulateHit() {
        //abe tuka neshto sharenko da stava
    }

    public void drawRandomCoordinates(Graphics g) {
        x = X_LOWER_BOUND + rand.nextInt(X_UPPER_BOUND);
        if (x <= X_MID_BOUND) {
            y = rand.nextInt(Y_MID_UPPER_BOUND);
        } else {
            y = rand.nextInt(Y_UPPER_BOUND);
        }
        System.out.println("( " + x + ", " + y + " )");
        drawTarget(g, x, y, HEIGHT, HEIGHT);
    }
}
