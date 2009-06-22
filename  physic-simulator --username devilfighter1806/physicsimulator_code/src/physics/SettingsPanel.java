package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JSpinner;
import userInfo.Calculator;
/*
 * SettingsPanel.java
 *
 * Created on 2009-5-16, 22:09:29
 */

/**
 * Settings panel.
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

    /** Creates new form SettingsPanel */
    public SettingsPanel(AnimationPanel animPnl) {
        initComponents();
        this.animPanel = animPnl;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        defaultBtnBackground = newGameBtn.getBackground();
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
        downtBtn = new javax.swing.JButton();
        upBtn = new javax.swing.JButton();
        topLbl = new javax.swing.JLabel();
        downLbl = new javax.swing.JLabel();
        upLbl = new javax.swing.JLabel();
        speedSpinner = new javax.swing.JSpinner();
        angleSpinner = new javax.swing.JSpinner();
        accelSpinner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        newGameBtn = new javax.swing.JButton();
        startBtn = new javax.swing.JButton();
        hintBtn = new javax.swing.JButton();

        speedLabel.setFont(new java.awt.Font("Arial", 1, 14));
        speedLabel.setText("Speed: ");

        angleLabel.setFont(new java.awt.Font("Arial", 1, 14));
        angleLabel.setText("Angle: ");

        accelLabel.setFont(new java.awt.Font("Arial", 1, 14));
        accelLabel.setText("Acceleration: ");

        downtBtn.setLabel("<");
        downtBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                downtBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                downtBtnMouseExited(evt);
            }
        });

        upBtn.setText(">");
        upBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                upBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                upBtnMouseExited(evt);
            }
        });
        upBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upBtnActionPerformed(evt);
            }
        });

        topLbl.setFont(new java.awt.Font("Georgia", 1, 16));
        topLbl.setText("Adjust Top Positions:");

        downLbl.setFont(new java.awt.Font("Arial", 1, 12));
        downLbl.setText("Down");

        upLbl.setFont(new java.awt.Font("Arial", 1, 12));
        upLbl.setText("   Up");

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
        accelSpinner.setModel(new javax.swing.SpinnerNumberModel(9.0d, 2.0d, 20.0d, 1.0d));
        accelSpinner.setEditor(new JSpinner.NumberEditor(accelSpinner, "#0.00"));
        accelSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                accelSpinnerStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 16));
        jLabel1.setText("Adjust Settings below:");

        newGameBtn.setText("New game");
        newGameBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newGameBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newGameBtnMouseExited(evt);
            }
        });
        newGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBtnActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(speedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                            .addComponent(angleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accelLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(speedSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accelSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(angleSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(topLbl)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(downLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(downtBtn)))
                            .addComponent(newGameBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(startBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(upLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(upBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hintBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
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
                .addGap(30, 30, 30)
                .addComponent(topLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(downLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downtBtn)
                        .addGap(47, 47, 47)
                        .addComponent(newGameBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(upLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upBtn)
                        .addGap(47, 47, 47)
                        .addComponent(startBtn)))
                .addGap(18, 18, 18)
                .addComponent(hintBtn)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void upBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upBtnActionPerformed
        setAngle(animPanel);
}//GEN-LAST:event_upBtnActionPerformed

    /**
     * Draws target on animation panel.
     * @param evt
     */
    private void newGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBtnActionPerformed
        animPanel.drawTarget();
}//GEN-LAST:event_newGameBtnActionPerformed

    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        updateCalc();        
        MovingBall b = new MovingBall(animPanel, calc);
        Thread t = new Thread(b);
        t.start();
}//GEN-LAST:event_startBtnActionPerformed

    private void newGameBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameBtnMouseEntered
        newGameBtn.setBackground(Color.YELLOW);
}//GEN-LAST:event_newGameBtnMouseEntered

    private void newGameBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newGameBtnMouseExited
        newGameBtn.setBackground(defaultBtnBackground);
}//GEN-LAST:event_newGameBtnMouseExited

    private void startBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseEntered
        startBtn.setBackground(Color.YELLOW);
}//GEN-LAST:event_startBtnMouseEntered

    private void startBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseExited
        startBtn.setBackground(defaultBtnBackground);
}//GEN-LAST:event_startBtnMouseExited

    private void downtBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downtBtnMouseEntered
        downtBtn.setBackground(Color.YELLOW);
    }//GEN-LAST:event_downtBtnMouseEntered

    private void downtBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downtBtnMouseExited
        downtBtn.setBackground(defaultBtnBackground);
    }//GEN-LAST:event_downtBtnMouseExited

    private void upBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upBtnMouseEntered
        upBtn.setBackground(Color.YELLOW);
    }//GEN-LAST:event_upBtnMouseEntered

    private void upBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upBtnMouseExited
        upBtn.setBackground(defaultBtnBackground);
    }//GEN-LAST:event_upBtnMouseExited

    private void angleSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_angleSpinnerStateChanged
        angle = (Double) angleSpinner.getValue();
        setAngle(animPanel);
    }//GEN-LAST:event_angleSpinnerStateChanged

    private void speedSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSpinnerStateChanged
        initVelocity = (Double) speedSpinner.getValue();
    }//GEN-LAST:event_speedSpinnerStateChanged

    private void accelSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_accelSpinnerStateChanged
        acceleration = (Double) accelSpinner.getValue();
    }//GEN-LAST:event_accelSpinnerStateChanged

    /**
     * Set
     * @param animPnl
     */
    private void setAngle(AnimationPanel animPnl) {
        animPnl.setAngle(angle);
    }

    private void updateCalc() {
        calc.setAcceleration(acceleration);
        calc.setAngle(angle);
        calc.setInitialVelosity(initVelocity);
        calc.setStartPoint(animPanel.getGunCoorinates());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accelLabel;
    private javax.swing.JSpinner accelSpinner;
    private javax.swing.JLabel angleLabel;
    private javax.swing.JSpinner angleSpinner;
    private javax.swing.JLabel downLbl;
    private javax.swing.JButton downtBtn;
    private javax.swing.JButton hintBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton newGameBtn;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSpinner speedSpinner;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel topLbl;
    private javax.swing.JButton upBtn;
    private javax.swing.JLabel upLbl;
    // End of variables declaration//GEN-END:variables
}
