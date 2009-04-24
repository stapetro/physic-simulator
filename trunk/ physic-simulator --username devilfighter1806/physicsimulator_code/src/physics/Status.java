/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import javax.swing.JPanel;

/**
 * Status information.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class Status extends JPanel {
    //TODO Status for all values of formulas.
    //Shows user input values.
    //TODO:  add setters and getters but do this last        -added by Krasi

    /**
     * Determines the speed that the ball will be
     * thrown with.
     */
    private double speed;

    /**
     * Determines the accleration that will be simulater.
     * For example the Earth acceleration (g) is g=9.82...m/s.s
     */
    private double acceleration;

    /**
     * The value of the angle that is made between
     * the gun and the the x-axis.
     */
    private double angle;

    /**
     * General purpose constructor. Sets some of the
     * parameters and values of the used objects
     */
    public Status(){}

    /**
     * Initialize default values for the status fields
     */
    public void initializeStatusValues(){}

    /**
     * draw the status fields. This includes drawing the
     * text boxes, labels, as well as showing their
     * default(initial) values
     */
    public void drawStatusFields(){}

}
