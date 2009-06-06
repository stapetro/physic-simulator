/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInfo;

import java.awt.Point;

/**
 * Data for formulas.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
public class Calculator {

    /**
     * the start point for all strikes
     */
    private Point startPoint = new Point(0, 0);
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
    private double velocityY;
    /**
     * Help variable to present if the ball is moveing up or down
     */
    private boolean isMoveUp;
    private int lengthOfFlight;

    /**
     * general purpose constructor
     */
    public Calculator(double initVel, double angl, double acc) {
        setInitialVelosity(initVel * 10);
        setAngle(angl);
        setAcceleration(acc);

        lengthOfFlight = calculateLengthOfFlight();
    }

    public Calculator(double initVel, double angl, double acc, Point p) {
        setInitialVelosity(initVel * 10);
        setAngle(angl);
        setAcceleration(acc);
        setStartPoint(p);

        lengthOfFlight = calculateLengthOfFlight();
    }

    //Neshto ne raboti kakto trabva - da go inspektiram
    public Calculator(Calculator c){
        this(c.getInitialVelosity(), c.getAngle(), c.getAcceleration(), c.getStartPoint());
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
        this.initialize(initVel, angl, acc, new Point(0, 0));
    }

    /**
     * Initialize the values of the component and prepare it for future use
     *
     * @param initVel   initial velocity
     * @param angl      angle
     * @param acc       acceleration
     * @param initCoords the starting position where the movement will start from
     */
    public void initialize(double initVel, double angl, double acc, Point initCoords) {
        setInitialVelosity(initVel * 10);
        setAngle(angl);
        setAcceleration(acc * 10);

        isMoveUp = true;
    }

    /**
     * Get the coordinates of the ball when it is airborne.
     * 
     * @time    The time when we want to get the coordinate
     * @return the coordinate of the ball at the specified time
     */
    public Point getCoordinate(double time) {
        int xCoord; //the coordinate on the X-axis
        int yCoord; //the coordinate on the Y-axis

        xCoord = startPoint.x + (int) (initialVelocity * Math.cos(angle) * time);

        if (xCoord < (lengthOfFlight / 2)) {
            yCoord = startPoint.y + (int) (initialVelocity * Math.sin(angle) * time - (acceleration * time * time) / 2);

        } else {
            yCoord = startPoint.y + (int) (initialVelocity * Math.sin(angle) * time + (acceleration * time * time) / 2);
        }

        return new Point(xCoord, yCoord);
    }

    /**
     * Calculate the length of the flight of the ball
     * 
     * @return  return the length of the flight
     */
    private int calculateLengthOfFlight() {
        return (int) ((10 * 2 * initialVelocity * initialVelocity * Math.sin(angle) * Math.cos(angle)) / (acceleration));
    }

    public int getLengthOfFlight() {
        return lengthOfFlight;
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

    /**
     * setter for the startPoint
     * @param p     the value that will ne set to startPoint
     */
    public void setStartPoint(Point p) {
        if (p != null) {
            startPoint = new Point(p.x, 200 - p.y);
        } else {
            startPoint = new Point(0, 0);
        }
    }

    /**
     * getter for startPoint
     * @return  return the value of startPoint
     */
    public Point getStartPoint() {
        return new Point(startPoint.x, startPoint.y);
    }
    //TODO Fields - speed, angle, acceleration, etc.
}
