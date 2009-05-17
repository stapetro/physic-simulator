/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInfo;

import java.awt.Point;

/**
 * Data for formulas.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class Calculator {

    /**
     * the start point for all strikes
     */
    private static final Point startPoint = new Point(0, 0);
    /**
     * Initial velocity. Keep in mind that to get the velocity on the
     * X and Y-axis you will need to use SIN and COS
     */
    private double initialVelocity;
    /**
     * The angle to strike from. Internally will hold RADIANS but will be set
     * with a DEGREE value and transperantly will transform the value to RADIANS
     * The same will be when returned
     */
    private double angle;
    /**
     * the acceleration tham will be used in the simulation
     */
    private double acceleration;
    /**
     * Help variable to present the current velocity on the Y-axis
     */
    private double velocityYCoord;
    /**
     * Help variable to present if the ball is moveing up or down
     */
    private boolean isMoveUp;

    /**
     * general purpose constructor
     */
    public Calculator(double initVel, double angl, double acc) {
        setInitialVelosity(initVel);
        setAngle(angl);
        setAcceleration(acc);

        isMoveUp = true;
    }

    /**
     * Default constructor
     */
    public Calculator() {
        this(10.0, 45.0, 9.82);
    }

    /**
     * initialize the values if the object is already created
     * and prepara it for next use of calculations
     */
    public void initialize() {
        isMoveUp = false;
    }

    /**
     * Initialize the values of the component and prepare it for future use
     *
     * @param initVel   initial velocity
     * @param angl      angle
     * @param acc       acceleration
     */
    public void initialize(double initVel, double angl, double acc) {
        setInitialVelosity(initVel);
        setAngle(angl);
        setAcceleration(acc);

        isMoveUp = true;
    }

    /**
     * Get the coordinates of the ball when it is airborne.
     * 
     * @time    The time when we want to get the coordinate
     * @return the coordinate of the ball at the specified time
     */
    public Point getCoordinate(int time) {
        int xCoord; //the coordinate on the X-axis
        int yCoord; //the coordinate on the Y-axis

        xCoord = (int) (initialVelocity * Math.cos(angle) * time);

        if (isMovingUp(time)) {
            yCoord = (int) (initialVelocity * Math.sin(angle) * time - (acceleration * time * time) / 2);
        } else {
            yCoord = (int) (initialVelocity * Math.sin(angle) * time + (acceleration * time * time) / 2);
        }

        return new Point(xCoord, yCoord);
    }

    /**
     * Determinte if the ball is moving up or down at the specified time
     * 
     * @param time  the moment in which we are checking
     * @return  retur TRUE if the ball is moving up
     *          and FALSE if it is falling down
     */
    private boolean isMovingUp(int time) {
        boolean retVal = true;

        //calculate the current speed on the Y-axis
        velocityYCoord = initialVelocity * Math.sin(angle) - acceleration * time;

        /**
         * if the speed is greater than 0.1 and if we are still moving up - OK
         * when the speed comes less then the ball starts fallind down and speed
         * starts accelerating again
         */
        if (velocityYCoord > 0.1 && isMoveUp == true) {
            retVal = true;
        } else {
            isMoveUp = false;
            retVal = false;
        }

        return retVal;
    }

    /**
     * setter for initialVelosity
     * @param val
     */
    public void setInitialVelosity(double val) {
        if (val <= 0) {
            initialVelocity = 1;
        } else {
            initialVelocity = val;
        }
    }

    /**
     * getter for initialValocity
     * @return
     */
    public double getInitialVelosity() {
        return this.initialVelocity;
    }

    /**
     * Setter for angle. A value in degrees is set but internally it is presented
     * in radians for easier calculations
     *
     * @param val   the value of the angle in degrees
     */
    public void setAngle(double val) {
        if (val > 90 || val < 0) {
            angle = Math.toRadians(45);
        } else {
            angle = Math.toRadians(val);
        }
    }

    /**
     * getter for angle
     * @return  return the value of the angle in degrees
     */
    public double getAngle() {
        return Math.toDegrees(angle);
    }

    /**
     * setter for acceleration
     * @param val
     */
    public void setAcceleration(double val) {
        if (val <= 0) {
            acceleration = 9.8;
        } else {
            acceleration = val;
        }
    }

    /**
     * getter for acceleration
     * @return
     */
    public double getAcceleration() {
        return acceleration;
    }

    //TODO Fields - speed, angle, acceleration, etc.
}
