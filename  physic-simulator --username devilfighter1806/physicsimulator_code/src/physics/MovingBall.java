/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JButton;
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
     * The size of the ball in simulation mode.
     */
    private static final int SIMULATION_BALL_SIZE = 10;
    /**
     * Offset that is used when the ball is drawn. This is due to some
     * unexpected result for the Y coordinate of the ball.
     */
    private static final int Y_OFFSET = 17;
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
     * If true then the ball will simulate movement
     * otherwise the trajectory will be drawn
     */
    private boolean isRealMode = false;
    /**
     * Indicates whether target is hitted.
     */
    private boolean targetHitted = false;
    //Next two variables may be deleted after
    private SettingsPanel settingsPanel;

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
        //btn.setEnabled(false);
        try {
            if (isRealMode) {
                animateRealMode();
            } else {
                animateSimulationMode();
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
//            startAnimBtn.setSelected(true);
        }

        settingsPanel.setEnabledSwingComponents(true);
    }

    /**
     * Takes care when real simulation of moving ball takes place.
     * @throws java.lang.InterruptedException
     */
    public void animateRealMode() throws InterruptedException {
        double momentOfTime = 0;
        boolean drawn = false;
        targetHitted = false;
//        startAnimBtn.setEnabled(false);
        do {
            Graphics g = animPanel.getGraphics();
            if (drawn) {
                g.setXORMode(animPanel.getBackground());
                g.fillOval(currentCoords.x, currentCoords.y - Y_OFFSET, BALL_SIZE, BALL_SIZE);
            }
            momentOfTime = momentOfTime + 0.2;
            currentCoords.x = calc.getCoordinate(momentOfTime).x;
            currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y;
            if (isTargetHit()) {
                targetHitted = true;
                settingsPanel.getStatusPanel().setStatus("Hit Target");
                break;
            }
            g.fillOval(currentCoords.x, currentCoords.y - Y_OFFSET, BALL_SIZE, BALL_SIZE);
            g.dispose();
            drawn = true;
            Thread.sleep(20);
        } while (currentCoords.x < animPanel.getWidth() + 20 && currentCoords.x < calc.getLengthOfFlight());
        if (!targetHitted) {
            settingsPanel.getStatusPanel().setStatus("Animation finished");
        }
    }

    /**
     * Takes care when drawin the ball in simulation mode. This means that
     * only the trajectory of the call will be drawn.
     * @throws java.lang.InterruptedException
     */
    public void animateSimulationMode() throws InterruptedException {
        double momentOfTime = 0;
        targetHitted = false;
        Graphics g = animPanel.getGraphics();

        do {
            momentOfTime = momentOfTime + 0.2;
            currentCoords.x = calc.getCoordinate(momentOfTime).x;
            currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y;
            if (isTargetHit()) {
                targetHitted = true;
                settingsPanel.getStatusPanel().setStatus("Hit Target");
                break;
            }
            g.drawOval(currentCoords.x, currentCoords.y - Y_OFFSET, SIMULATION_BALL_SIZE, SIMULATION_BALL_SIZE);
            Thread.sleep(20);

        } while (currentCoords.x < animPanel.getWidth() + 20 && currentCoords.x < calc.getLengthOfFlight());
        if (!targetHitted) {
            settingsPanel.getStatusPanel().setStatus("Animation finished");
        }
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

    public void setIsRealMode(boolean val) {
        isRealMode = val;
    }

    public boolean getRealMode() {
        return isRealMode;
    }

    public void setPnlRef(SettingsPanel p) {
        settingsPanel = p;
    }
}
