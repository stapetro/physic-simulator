package userInfo;

import java.awt.Point;

/**
 * Data for formulas. This class represents the high level definition of
 * Physics formulas. It provides methods to help calculate and monitor the
 * motion of an flying object.
 *
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 * @version 1.0
 *
 */
public class Calculator {

    /**
     * The start point for all strikes. By default the start Point is (0, 0).
     * This represents the initial coordinates of the ball when striken .
     */
    private Point startPoint = new Point(0, 0);
    /**
     * Initial velocity. Keep in mind that to get the velocity on the
     * X and Y- axis you will need to use SIN and COS
     */
    private double initialVelocity;
    /**
     * The angle to strike at. Internally will hold RADIANS but will be set
     * with a DEGREE value and transperantly will transform the value to RADIANS
     * The same will be when returned. A DEGREE value will be returned.
     */
    private double angle;
    /**
     * The acceleration tham will be used in the simulation.
     */
    private double acceleration;
    /**
     * The length of the flight corresponding to the initially set values for
     * Velocity, Angle and Acceleration.
     */
    private int lengthOfFlight;

    /**
     * Overloaded version of the general purpose constructor.
     * @param initVel
     * @param angl
     * @param acc
     */
    public Calculator(double initVel, double angl, double acc) {
        this(initVel, angl, acc, new Point(0, 0));
    }

    /**
     * General purpose constructor.
     *
     * @param initVel   Initial Velocity
     * @param angl      Angle that the ball will be thrown at
     * @param acc       Acceleration that will be simulated
     * @param p         Initial point from where the movement will start.
     */
    public Calculator(double initVel, double angl, double acc, Point p) {
        setInitialVelosity(initVel * 10);
        setAngle(angl);
        setAcceleration(acc);
        setStartPoint(p);

        lengthOfFlight = calculateLengthOfFlight();
    }

    //Neshto ne raboti kakto trabva - da go inspektiram
    public Calculator(Calculator c) {
        this(c.getInitialVelosity(), c.getAngle(), c.getAcceleration(), c.getStartPoint());
    }

    /**
     * Default constructor
     */
    public Calculator() {
        this(10.0, 45.0, 9.82);
    }

    /**
     * Get the coordinates of the ball when it is airborne at specified
     * moment of time.
     * 
     * @time    The time when we want to get the coordinate
     * @return  The coordinate of the ball at the specified time
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

    /**
     * Getter for length of flight value
     * @return lenght of the flight
     */
    public int getLengthOfFlight() {
        return lengthOfFlight;
    }

    /**
     * Setter for initialVelosity
     * @param val   The value that will be set to initialVelocity
     */
    public void setInitialVelosity(double val) {
        if (val <= 0) {
            initialVelocity = 1;
        } else {
            initialVelocity = val * 10;
        }
    }

    /**
     * Getter for initialValocity
     * @return  initialVelocity
     */
    public double getInitialVelosity() {
        return this.initialVelocity;
    }

    /**
     * Setter for angle. A value in degrees is set but internally it is presented
     * in radians for easier calculations Values between 0 and 90 degrees are
     * accepted.
     *
     * @param val   The value of the angle in degrees
     */
    public void setAngle(double val) {
        if (val > 90 || val < 0) {
            angle = Math.toRadians(45);
        } else {
            angle = Math.toRadians(val);
        }
    }

    /**
     * Getter for angle
     * @return  Return the value of the angle in degrees
     */
    public double getAngle() {
        return Math.toDegrees(angle);
    }

    /**
     * Setter for acceleration
     * @param val   The value that will be set to acceleration.
     */
    public void setAcceleration(double val) {
        if (val < 0) {
            acceleration = 9.8;
        } else {
            acceleration = val;
        }
    }

    /**
     * Getter for acceleration
     * @return  acceleration value.
     */
    public double getAcceleration() {
        return acceleration;
    }

    /**
     * Setter for the startPoint
     * @param p     The value that will be set to startPoint
     */
    public void setStartPoint(Point p) {
        if (p != null) {
            startPoint = new Point(p.x, 200 - p.y);
        } else {
            startPoint = new Point(0, 0);
        }
    }

    /**
     * Getter for startPoint
     * @return  Return the value of startPoint
     */
    public Point getStartPoint() {
        return new Point(startPoint.x, startPoint.y);
    }
}
