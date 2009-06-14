/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.Graphics;
import java.awt.Point;
import userInfo.Calculator;

/**
 *
 * @author Administrator
 */
public class MovingBall implements Runnable {

    /**
     * determines the size of the ball. Inlcuding width and height.
     */
    private static final int BALL_SIZE = 20;
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
     * Stores ball radius coordinates.
     */
    private Point ballRadiusPoint;

    /**
     * Constructor for general purpose.
     * @param pnl   reference to the panel where moving ball will be drawn
     * @param c     calculator object that will be used for physics calculations
     */
    public MovingBall(AnimationPanel pnl, Calculator c) {
        this.animPanel = pnl;
        calc = c;
        currentCoords = new Point(calc.getStartPoint());
        ballRadiusPoint = new Point();
    }

    public void run() {
        double momentOfTime = 0;
        boolean drawn = false;

        try {
            do {
                Graphics g = animPanel.getGraphics();
                if (drawn) {
                    g.setXORMode(animPanel.getBackground());
                    g.fillOval(currentCoords.x, currentCoords.y, BALL_SIZE, BALL_SIZE);
                }
                momentOfTime = momentOfTime + 0.2;
                currentCoords.x = calc.getCoordinate(momentOfTime).x;
                currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y;
                if (isTargetHit()) {
                    System.out.println("HIT TARGET");
                    break;
                }
                g.fillOval(currentCoords.x, currentCoords.y, BALL_SIZE, BALL_SIZE);
                g.dispose();
                drawn = true;
                Thread.sleep(30);
            } while (currentCoords.x < animPanel.getWidth() + 40 && currentCoords.x < calc.getLengthOfFlight());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("DONE!!!");
    }

    private boolean isTargetHit() {
        setBallRadius();
        Point targetRadiusPoint = animPanel.getTargetRadiusPoint();
        int targetRadius = Target.TARGET_SIZE / 2;
        int ballRadius = BALL_SIZE / 2;
        /*
         * Distance between target and ball centers.
         */
        int distance = (targetRadiusPoint.x - ballRadiusPoint.x) * (targetRadiusPoint.x - ballRadiusPoint.x) +
                (targetRadiusPoint.y - ballRadiusPoint.y) * (targetRadiusPoint.y - ballRadiusPoint.y);
        if (distance < (targetRadius + ballRadius) * (targetRadius + ballRadius)) {
            return true;
        }
        return false;
    }

    /**
     * Ball radius getter.
     * @return ball radius coordinates.
     */
    private void setBallRadius() {
        ballRadiusPoint.x = currentCoords.x + BALL_SIZE / 2;
        ballRadiusPoint.y = currentCoords.y + BALL_SIZE / 2;
    }
}
