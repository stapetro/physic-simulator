/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;
import userInfo.Calculator;

/**
 *
 * @author Administrator
 */
public class MovingBall implements Runnable {

    /**
     * reference to the JPanel where the ball will simulate movement
     */
    private JPanel animPanel;
    /**
     * calculator object that will be used to get the
     * calculations for the movement of the ball
     */
    private Calculator calc;
    /**
     * Constructor
     * @param pnl   reference to the panel where moving ball will be drawn
     * @param c     calculator object that will be used for physics calculations
     */
    /**
     * the current coordinated of the moving ball
     */
    private Point currentCoords;

    public MovingBall(JPanel pnl, Calculator c) {
        this.animPanel = pnl;
        calc = c;

        currentCoords = new Point(calc.getStartPoint());
    }

    public void run() {
        Graphics g = animPanel.getGraphics();
        g.setColor(Color.RED);
        double momentOfTime = 0;

        try {
            do {
                animPanel.repaint(currentCoords.x-30, currentCoords.y - 30, 50, 50);
                
                momentOfTime = momentOfTime + 0.2;
                currentCoords.x = calc.getCoordinate(momentOfTime).x;
                currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y;
                g.fillOval(currentCoords.x, currentCoords.y, 20, 20);

                Thread.sleep(20);

            } while (currentCoords.x < animPanel.getWidth() && currentCoords.x < calc.getLengthOfFlight());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

         System.out.println("DONE!!!");
    }
}
