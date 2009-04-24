/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

/**
 * This class defines the basic characteristics of the target object
 * which will be drawn on the AnimationPanel.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class Target {
    //TODO Canvas field.      -----Chech this out. I don't understand it
    //TODO setters and getters, but we will add then last.  --added by Krasi

    /**
     * The x coordiante of the target
     */
    private int x;
    /**
     * The y coordinate of the target
     */
    private int y;
    /**
     * The width of the target
     */
    private int width;
    /**
     * The height of the target
     */
    private int height;

    /**
     * Default constructor
     */
    public Target() {
    }

    /**
     * general purpose constructor
     * @param xCoord    the x coordinate of the target
     * @param yCoord    the x coordinate of the target
     */
    public Target(int xCoord, int yCoord) {
    }

    /**
     * Draw the target according to the corresponding
     * current coordinates
     */
    public void drawTarget() {
        this.drawTarget(x, y);
    }

    /**
     * Draw the target on the panel of the specified coordinates
     *
     * @param xCoord    the x coordinate
     * @param yCoord    the y coordinate
     */
    public void drawTarget(int xCoord, int yCoord) {
    }

    /**
     * Simulates hit by making some animation
     * that attracts the attention of the user
     */
    public void simulateHit(){
        //abe tuka neshto sharenko da stava
    }
}
