package physics;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.SwingUtilities;
import userInfo.Calculator;

/**
 * Controls moving ball animation.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 * @version 1.0
 */
public class MovingBall implements Runnable {

    /**
     * determines the size of the ball. Inlcuding width and height.
     */
    private static final int BALL_SIZE = 15;
    /**
     * The size of the ball in simulation mode.
     */
    private static final int SIMULATION_BALL_SIZE = 10;
    /**
     * Offset that is used when the ball is drawn. This is due to some
     * unexpected result for the Y coordinate of the ball.
     */
    private static final int Y_OFFSET = 14;
    /**
     * Message that is displayed when target is hit
     */
    private static final String HIT_TARGET_MSG = "Hit Target";
    /**
     * Message that is shown when target is missed
     */
    private static final String MISS_TARGET_MSG = "Miss Target";
    /**
     * Reference to animation panel where the ball will simulate movement
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
    private Point ballCenterPoint;
    /**
     * If true then the ball will simulate movement
     * otherwise the trajectory will be drawn
     */
    private boolean isRealMode = false;
    /**
     * Indicates whether target is hitted.
     */
    private boolean targetHitted = false;
    /**
     * Reference to settings panel for changing status label in it.
     */
    private SettingsPanel settingsPanel;

    /**
     * Constructor for general purpose.
     * @param pnl   reference to the panel where moving ball will be drawn
     * @param c     calculator object that will be used for physics calculations
     */
    public MovingBall(AnimationPanel pnl, SettingsPanel settingsPnl, Calculator c) {
        this.animPanel = pnl;
        this.settingsPanel = settingsPnl;
        calc = c;
        currentCoords = new Point(calc.getStartPoint());
        ballCenterPoint = new Point();
    }

    /**
     * Executes animation in real/hint mode.
     */
    @Override
    public void run() {
        try {
            if (isRealMode) {
                animateRealMode();
            } else {
                animateSimulationMode();
            }

        } catch (InterruptedException ex) {
            ex.printStackTrace();
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
        do {
            Graphics g = animPanel.getGraphics();
            if (drawn) {
                g.setXORMode(animPanel.getBackground());
                g.fillOval(currentCoords.x, currentCoords.y, BALL_SIZE, BALL_SIZE);
            }
            momentOfTime = momentOfTime + 0.2;
            currentCoords.x = calc.getCoordinate(momentOfTime).x;
            currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y - Y_OFFSET;
            if (targetHitted = isTargetHit()) {
                settingsPanel.getStatusPanel().setStatus(HIT_TARGET_MSG);
                animPanel.getTarget().simulateHitAnimate(animPanel.getGraphics());
                break;
            }
            g.fillOval(currentCoords.x, currentCoords.y, BALL_SIZE, BALL_SIZE);
            g.dispose();
            drawn = true;
            Thread.sleep(20);
        } while (currentCoords.x < animPanel.getWidth() + 20 && currentCoords.x < calc.getLengthOfFlight() &&
                currentCoords.y < animPanel.getHeight() + 20);
        if (!targetHitted) {
            settingsPanel.getStatusPanel().setStatus(MISS_TARGET_MSG);
        }
    }

    /**
     * Takes care when drawin the ball in simulation mode. This means that
     * only the trajectory of the call will be drawn.
     * @throws java.lang.InterruptedException
     */
    public void animateSimulationMode() throws InterruptedException {
        double momentOfTime = 0;
        Graphics g = animPanel.getGraphics();

        do {
            momentOfTime = momentOfTime + 0.2;
            currentCoords.x = calc.getCoordinate(momentOfTime).x;
            currentCoords.y = animPanel.getHeight() - calc.getCoordinate(momentOfTime).y - Y_OFFSET;
            if (targetHitted = isTargetHit()) {
                settingsPanel.getStatusPanel().setStatus(HIT_TARGET_MSG);
                animPanel.getTarget().simulateHitAnimate(animPanel.getGraphics());
                break;
            }
            g.drawOval(currentCoords.x, currentCoords.y, SIMULATION_BALL_SIZE, SIMULATION_BALL_SIZE);
            Thread.sleep(20);

        } while (currentCoords.x < animPanel.getWidth() + 20 && currentCoords.x < calc.getLengthOfFlight() &&
                currentCoords.y < animPanel.getHeight() + 20);
        if (!targetHitted) {
            settingsPanel.getStatusPanel().setStatus(MISS_TARGET_MSG);
        }
    }

    /**
     * Checks whether target is hit by the thrown ball from the gun.
     * @return True - if target is hitted, false - if target is missed.
     */
    private boolean isTargetHit() {
        updateBallCenterCoordinates();
        Point targetCenterPoint = animPanel.getTargetCenterPoint();
        int targetRadius = Target.TARGET_SIZE / 2;
        int ballRadius = BALL_SIZE / 2;
        /*
         * Distance between target and ball centers.
         */
        int distance = (targetCenterPoint.x - ballCenterPoint.x) * (targetCenterPoint.x - ballCenterPoint.x) +
                (targetCenterPoint.y - ballCenterPoint.y) * (targetCenterPoint.y - ballCenterPoint.y);
        if (distance < (targetRadius + ballRadius) * (targetRadius + ballRadius)) {
            return true;
        }
        return false;
    }

    /**
     * Updates the current coordinates of the ball center
     */
    private void updateBallCenterCoordinates() {
        ballCenterPoint.x = currentCoords.x + BALL_SIZE / 2;
        ballCenterPoint.y = currentCoords.y + BALL_SIZE / 2;
    }

    /**
     * Sets real mode.
     * @param val True - real mode is turned on, false - turned off.
     */
    public void setIsRealMode(boolean val) {
        isRealMode = val;
    }

    /**
     * Real mode status getter.
     * @return True - if real mode is turned on, false - turned off.
     */
    public boolean getRealMode() {
        return isRealMode;
    }
}
