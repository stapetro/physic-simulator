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
     * Reference to the JPanel where the ball will simulate movement
     */
    private AnimationPanel animPanel;
    /**
     * Calculator object that is used to get the
     * calculations for the movement of the ball
     */
    private Calculator calc;
    /**
     * The current coordinated of the moving ball
     */
    private Point currentCoords;

    /**
     * Constructor for general purpose.
     * @param pnl   reference to the panel where moving ball will be drawn
     * @param c     calculator object that will be used for physics calculations
     */
    public MovingBall(AnimationPanel pnl, Calculator c) {
        this.animPanel = pnl;
        calc = c;
        currentCoords = new Point(calc.getStartPoint());
    }

    public void run() {
//        Graphics g = animPanel.getGraphics();
//        g.setColor(Color.RED);
        double momentOfTime = 0;
        boolean drawn = false;

        try {
            do {
//                animPanel.updateUI();
//                animPanel.repaint();
//                animPanel.repaint(currentCoords.x - 30, currentCoords.y - 30, 50, 50);
//                g.drawOval(currentCoords.x - 30, currentCoords.y - 30, 50, 50);
                Graphics g = animPanel.getGraphics();
//                g.setColor(Color.RED);
                if (drawn) {
                    g.setXORMode(animPanel.getBackground());
                    g.fillOval(currentCoords.x, currentCoords.y - 15, 20, 20);
                }
                momentOfTime = momentOfTime + 0.2;
                currentCoords.x = calc.getCoordinate(momentOfTime).x;
                currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y;
                g.fillOval(currentCoords.x, currentCoords.y - 15, 20, 20);
                g.dispose();
                drawn = true;
                Thread.sleep(30);
            } while (currentCoords.x < animPanel.getWidth() + 40 && currentCoords.x < calc.getLengthOfFlight());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("DONE!!!");
    }
}
