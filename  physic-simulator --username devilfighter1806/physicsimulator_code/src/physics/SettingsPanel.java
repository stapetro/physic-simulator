package physics;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SwingUtilities;
import userInfo.Calculator;

/**
 * Settings panel for simulator properties tunings.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 * @version 1.0
 */
public class SettingsPanel extends javax.swing.JPanel {

    /**
     * The angle that the ball will the thrown at.
     */
    private double angle = 10;
    /**
     * The initial velocity that the ball will be thrown at.
     */
    private double initVelocity = 5;
    /**
     * The acceleration that will be simulated during strike.
     */
    private double acceleration = 9.8;
    /**
     * Referencto to panel where animation will take place.
     */
    private AnimationPanel animPanel;
    /**
     * Calculator object that will be used for acceleration Physics calculations.
     */
    Calculator calc;
    /**
     * Store default background color for buttons.
     */
    private Color defaultBtnBackground;
    /**
     * Determines whether the trajectory is draw on the panel
     */
    private boolean trajectoryDrawn = false;

    /** Creates new form SettingsPanel */
    public SettingsPanel(AnimationPanel animPnl) {
        initComponents();
        this.animPanel = animPnl;
        animPanel.addMouseMotionListener(new MouseClickHandler());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        defaultBtnBackground = newTargetBtn.getBackground();
        animPanel.setAngle((Double) angleSpinner.getValue());
        initVelocity = (Double) speedSpinner.getValue();
        angle = (Double) angleSpinner.getValue();
        acceleration = (Double) accelSpinner.getValue();
        calc = new Calculator(initVelocity, angle, acceleration, animPanel.getGunCoorinates());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speedLabel = new javax.swing.JLabel();
        angleLabel = new javax.swing.JLabel();
        accelLabel = new javax.swing.JLabel();
        speedSpinner = new javax.swing.JSpinner();
        angleSpinner = new javax.swing.JSpinner();
        accelSpinner = new javax.swing.JSpinner();
        adjustSettingsLbl = new javax.swing.JLabel();
        newTargetBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();
        hintBtn = new javax.swing.JButton();
        targetPropLbl = new javax.swing.JLabel();
        heightLbl = new javax.swing.JLabel();
        widthLbl = new javax.swing.JLabel();
        targetHeightTxt = new javax.swing.JTextField();
        targetWidthTxt = new javax.swing.JTextField();
        statusPanel = new physics.StatusPanel();

        setPreferredSize(new java.awt.Dimension(245, 500));

        speedLabel.setFont(new java.awt.Font("Arial", 1, 14));
        speedLabel.setText("Speed: ");

        angleLabel.setFont(new java.awt.Font("Arial", 1, 14));
        angleLabel.setText("Angle: ");

        accelLabel.setFont(new java.awt.Font("Arial", 1, 14));
        accelLabel.setText("Acceleration: ");

        speedSpinner.setFont(new java.awt.Font("Arial", 0, 12));
        speedSpinner.setModel(new javax.swing.SpinnerNumberModel(10.0d, 2.0d, 30.0d, 1.0d));
        speedSpinner.setEditor(new JSpinner.NumberEditor(speedSpinner, "#0.00"));
        speedSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSpinnerStateChanged(evt);
            }
        });

        angleSpinner.setFont(new java.awt.Font("Arial", 0, 12));
        angleSpinner.setModel(new javax.swing.SpinnerNumberModel(45.0d, 5.0d, 85.0d, 1.0d));
        angleSpinner.setEditor(new JSpinner.NumberEditor(angleSpinner, "#0.00"));
        angleSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                angleSpinnerStateChanged(evt);
            }
        });

        accelSpinner.setFont(new java.awt.Font("Arial", 0, 12));
        accelSpinner.setModel(new javax.swing.SpinnerNumberModel(9.0d, 0.0d, 275.0d, 1.0d));
        accelSpinner.setEditor(new JSpinner.NumberEditor(accelSpinner, "#0.00"));
        accelSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                accelSpinnerStateChanged(evt);
            }
        });

        adjustSettingsLbl.setFont(new java.awt.Font("Arial", 1, 16));
        adjustSettingsLbl.setText("Adjust Settings below:");

        newTargetBtn.setText("New target");
        newTargetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newTargetBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newTargetBtnMouseExited(evt);
            }
        });
        newTargetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTargetBtnActionPerformed(evt);
            }
        });

        startBtn.setText("Start");
        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startBtnMouseExited(evt);
            }
        });
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        hintBtn.setText("Hint");
        hintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hintBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hintBtnMouseExited(evt);
            }
        });
        hintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintBtnActionPerformed(evt);
            }
        });

        targetPropLbl.setFont(new java.awt.Font("Arial", 1, 14));
        targetPropLbl.setText("Target Properties");

        heightLbl.setFont(new java.awt.Font("Arial", 1, 14));
        heightLbl.setText("Height:");

        widthLbl.setFont(new java.awt.Font("Arial", 1, 14));
        widthLbl.setText("Width:");

        targetHeightTxt.setEditable(false);
        targetHeightTxt.setFont(new java.awt.Font("Arial", 1, 12));
        targetHeightTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        targetWidthTxt.setEditable(false);
        targetWidthTxt.setFont(new java.awt.Font("Arial", 1, 12));
        targetWidthTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(speedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(angleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(accelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(angleSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(speedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(adjustSettingsLbl))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(heightLbl)
                            .addComponent(widthLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(targetWidthTxt)
                            .addComponent(targetHeightTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(targetPropLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(newTargetBtn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(hintBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(adjustSettingsLbl)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(speedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(angleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(accelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accelLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(angleSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(targetPropLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heightLbl)
                            .addComponent(targetHeightTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(widthLbl)
                            .addComponent(targetWidthTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startBtn)
                            .addComponent(newTargetBtn))))
                .addGap(18, 18, 18)
                .addComponent(hintBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Draws target on animation panel.
     * @param evt Event when new target buttons is pressed.
     */
    private void newTargetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTargetBtnActionPerformed
        startNewSimulator();
}//GEN-LAST:event_newTargetBtnActionPerformed

    /**
     * Draws target whne new simulator is started and inizliazes all variables
     * with default values.
     */
    public void startNewSimulator() {
        statusPanel.setStatus("Simulator started");
        animPanel.drawTarget();
        animPanel.calculateDistanceGunTarget();
        targetHeightTxt.setText(animPanel.getTargetVerticalDistance());
        targetWidthTxt.setText(animPanel.getTargetHorizontalDistance());
    }

    /**
     * Starts animation in real/hint mode.
     * @param evt Action event to be handled.
     */
    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        statusPanel.setStatus("Please wait..");
        if (trajectoryDrawn) {
            angle = (Double) angleSpinner.getValue();
            setAngle(animPanel);
            animPanel.repaint();
            trajectoryDrawn = false;
        }
        startAnimation(true);
}//GEN-LAST:event_startBtnActionPerformed

    /**
     * Mouse hover effect over new target button.
     * @param evt Mouse event to be handles when mouse is over the new target
     * button.
     */
    private void newTargetBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTargetBtnMouseEntered
        newTargetBtn.setBackground(Color.YELLOW);
}//GEN-LAST:event_newTargetBtnMouseEntered

    /**
     * Mouse hover effect over new target button.
     * @param evt Mouse event to be handles when mouse leaves the new target
     * button.
     */
    private void newTargetBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newTargetBtnMouseExited
        newTargetBtn.setBackground(defaultBtnBackground);
}//GEN-LAST:event_newTargetBtnMouseExited

    private void startBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseEntered
        startBtn.setBackground(Color.YELLOW);
}//GEN-LAST:event_startBtnMouseEntered

    private void startBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseExited
        startBtn.setBackground(defaultBtnBackground);
}//GEN-LAST:event_startBtnMouseExited

    /**
     * Set gun's angle value when angle spinner is changed.
     * @param evt Angle spinner change event to be handled.
     */
    private void angleSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_angleSpinnerStateChanged
        angle = (Double) angleSpinner.getValue();
        setAngle(animPanel);
        animPanel.repaint();
        trajectoryDrawn = false;
    }//GEN-LAST:event_angleSpinnerStateChanged

    /**
     * Set gun's speed value when angle spinner is changed.
     * @param evt Angle spinner change event to be handled.
     */
    private void speedSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSpinnerStateChanged
        initVelocity = (Double) speedSpinner.getValue();
        trajectoryDrawn = false;
    }//GEN-LAST:event_speedSpinnerStateChanged

    /**
     * Set gun's acceleration(gravity) value when angle spinner is changed.
     * @param evt Angle spinner change event to be handled.
     */
    private void accelSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_accelSpinnerStateChanged
        acceleration = (Double) accelSpinner.getValue();
        trajectoryDrawn = false;
    }//GEN-LAST:event_accelSpinnerStateChanged

    /**
     * Starts animation in hint mode.
     * @param evt Event to be handled when hint button is pressed.
     */
    private void hintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintBtnActionPerformed
        animPanel.repaint();
        statusPanel.setStatus("Please wait..");
        startAnimation(false);
    }//GEN-LAST:event_hintBtnActionPerformed

    private void hintBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hintBtnMouseEntered
        hintBtn.setBackground(Color.YELLOW);
    }//GEN-LAST:event_hintBtnMouseEntered

    private void hintBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hintBtnMouseExited
        hintBtn.setBackground(defaultBtnBackground);
    }//GEN-LAST:event_hintBtnMouseExited

    /**
     * Starts animation and updates calculation members.
     * @param realMode True - if animation is in real mode, false - hint mode.
     */
    private void startAnimation(boolean realMode) {
        updateCalc();
        setEnabledSwingComponents(false);
        MovingBall b = new MovingBall(animPanel, this, calc);
        if (realMode == false) {
            b.setIsRealMode(false);
            trajectoryDrawn = true;
        } else {
            b.setIsRealMode(true);
            trajectoryDrawn = false;
        }
        SwingUtilities.invokeLater(b);
    }

    /**
     * Gun's angle setter in animation panel.
     * @param animPnl Animation panel reference.
     */
    private void setAngle(AnimationPanel animPnl) {
        animPnl.setAngle(angle);
    }

    /**
     * Sets the values for the calculator object so that they
     * match the ones in the local variables.
     */
    private void updateCalc() {
        calc.setAcceleration(acceleration);
        calc.setAngle(angle);
        calc.setInitialVelosity(initVelocity);
        calc.setStartPoint(animPanel.getGunCoorinates());
        animPanel.repaint();
    }

    /**
     * Disables the swing components during Thread execution
     * in order to prevent the user from starting several threads
     * at the same time.
     */
    public void setEnabledSwingComponents(boolean val) {
        startBtn.setEnabled(val);
        hintBtn.setEnabled(val);
        newTargetBtn.setEnabled(val);
        angleSpinner.setEnabled(val);
    }

    /**
     * Set acceleration value to acceleration spinner.
     * @param accelVal Acceleration value to be set.
     */
    public void setAcceleration(double accelVal) {
        accelSpinner.setValue((Double) accelVal);
    }

    /**
     * Sets reference to status panel.
     * @param statusPnl Reference variable to be set.
     */
    public StatusPanel getStatusPanel() {
        return statusPanel;
    }

    /**
     * Mouse click handler when mouse is dragged over the animation panel and
     * gun position follows mouse cursor.
     */
    private class MouseClickHandler extends MouseMotionAdapter {

        @Override
        public void mouseDragged(MouseEvent event) {

            if (!moveTarget(event.getPoint())) {
                int xCoord = event.getX();
                int yCoord = getHeight() - event.getY();
                double angl = Math.toDegrees(Math.atan(((double) yCoord) / xCoord));
                angle = angl;
                angleSpinner.setValue((Double) angle);
                setAngle(animPanel);
            }
        }

        /**
         * Dragging target with mouse.
         * @param mousePoint New target coordinates for drawing it.
         */
        private boolean moveTarget(Point mousePoint) {
            if (animPanel.isInsideTarget(mousePoint)) {
                animPanel.getTarget().setTargetCoordinates(mousePoint.x - Target.TARGET_SIZE / 2,
                        mousePoint.y - Target.TARGET_SIZE / 2);
                animPanel.repaint();
                animPanel.calculateDistanceGunTarget();
                targetHeightTxt.setText(animPanel.getTargetVerticalDistance());
                targetWidthTxt.setText(animPanel.getTargetHorizontalDistance());
                return true;
            }
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accelLabel;
    private javax.swing.JSpinner accelSpinner;
    private javax.swing.JLabel adjustSettingsLbl;
    private javax.swing.JLabel angleLabel;
    private javax.swing.JSpinner angleSpinner;
    private javax.swing.JLabel heightLbl;
    private javax.swing.JButton hintBtn;
    private javax.swing.JButton newTargetBtn;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSpinner speedSpinner;
    private javax.swing.JButton startBtn;
    private physics.StatusPanel statusPanel;
    private javax.swing.JTextField targetHeightTxt;
    private javax.swing.JLabel targetPropLbl;
    private javax.swing.JTextField targetWidthTxt;
    private javax.swing.JLabel widthLbl;
    // End of variables declaration//GEN-END:variables
}
