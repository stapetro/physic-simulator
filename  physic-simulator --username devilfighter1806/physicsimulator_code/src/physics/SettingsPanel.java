package physics;

import java.awt.Color;
import java.awt.Graphics;
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
 */
public class SettingsPanel extends javax.swing.JPanel {

    private int angle = 10;
    private AnimationPanel animPanel;

    /** Creates new form SettingsPanel */
    public SettingsPanel(AnimationPanel animPnl) {
        initComponents();
        this.animPanel = animPnl;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        startBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();

        speedLabel.setFont(new java.awt.Font("Arial", 1, 14));
        speedLabel.setText("Speed: ");

        angleLabel.setFont(new java.awt.Font("Arial", 1, 14));
        angleLabel.setText("Angle: ");

        accelLabel.setFont(new java.awt.Font("Arial", 1, 14));
        accelLabel.setText("Acceleration: ");

        downtBtn.setLabel("<");

        upBtn.setText(">");
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
        speedSpinner.setModel(new javax.swing.SpinnerNumberModel());
        speedSpinner.setEditor(new JSpinner.NumberEditor(speedSpinner, "#0.00"));

        angleSpinner.setFont(new java.awt.Font("Arial", 0, 12));
        angleSpinner.setModel(new javax.swing.SpinnerNumberModel());
        angleSpinner.setEditor(new JSpinner.NumberEditor(angleSpinner, "#0.00"));

        accelSpinner.setFont(new java.awt.Font("Arial", 0, 12));
        accelSpinner.setModel(new javax.swing.SpinnerNumberModel());
        accelSpinner.setEditor(new JSpinner.NumberEditor(accelSpinner, "#0.00"));

        jLabel1.setFont(new java.awt.Font("Georgia", 1, 16));
        jLabel1.setText("Adjust Settings below:");

        startBtn.setText("Start");
        startBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startBtnActionPerformed(evt);
            }
        });

        stopBtn.setText("Stop");
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });

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
                            .addComponent(startBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stopBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(upLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(upBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addComponent(startBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(upLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upBtn)
                        .addGap(47, 47, 47)
                        .addComponent(stopBtn)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void upBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upBtnActionPerformed
        setAngle(animPanel);
}//GEN-LAST:event_upBtnActionPerformed

    /**
     * Draws target on animation panel.
     * @param evt
     */
    private void startBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startBtnActionPerformed
        animPanel.drawTarget();
    }//GEN-LAST:event_startBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        //IMPORTANT: This is just for test. This methid will NOT have the
        //following functionality!
        Graphics g = animPanel.getGraphics();
        g.setColor(Color.BLUE);
        Calculator calc = new Calculator(10, angle, 9.82);
        double i = 0;
        int x;
        int y;
        do {
            i = i + 0.5;
            x = calc.getCoordinate(i).x;
            y = animPanel.getHeight() - calc.getCoordinate(i).y;
            g.drawOval(x, y, 10, 10);
        } while (x < calc.getLengthOfFlight() && x < animPanel.getWidth());
    }//GEN-LAST:event_stopBtnActionPerformed

    private void setAngle(AnimationPanel animPnl) {
        animPnl.setAngle(angle);
        angle += 2F;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accelLabel;
    private javax.swing.JSpinner accelSpinner;
    private javax.swing.JLabel angleLabel;
    private javax.swing.JSpinner angleSpinner;
    private javax.swing.JLabel downLbl;
    private javax.swing.JButton downtBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSpinner speedSpinner;
    private javax.swing.JButton startBtn;
    private javax.swing.JButton stopBtn;
    private javax.swing.JLabel topLbl;
    private javax.swing.JButton upBtn;
    private javax.swing.JLabel upLbl;
    // End of variables declaration//GEN-END:variables
}
