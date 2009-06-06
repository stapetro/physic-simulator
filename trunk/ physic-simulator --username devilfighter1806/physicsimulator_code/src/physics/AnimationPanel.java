/*
 * AnimationPanel.java
 *
 * Created on 2009-5-16, 23:20:19
 */
package physics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.BorderFactory;

/**
 * Display animations.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
public class AnimationPanel extends javax.swing.JPanel {

    private Target target;
    Graphics myGraphics;

    /**
     * Creates new Animation panel.
     */
    public AnimationPanel() {
        initComponents();
        target = new Target();
        myGraphics = getGraphics();
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }

    /**
     * Set the angle in the gun panel.
     * @param angleValue Angle value to be set.
     */
    public void setAngle(double angleValue) {
        gunPnl.setAngle(angleValue);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        myGraphics = g;
        target.reDrawTarget(g, getWidth(), getHeight());
    }

    /**
     * Draws target with random coordinates.
     */
    public void drawTarget() {
        target.drawRandomCoordinates(myGraphics, getWidth(), getHeight());
        repaint();
    }

    public Point getGunCoorinates() {
        return gunPnl.getTopCoordinates();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gunPnl = new physics.GunPanel();

        setPreferredSize(new java.awt.Dimension(550, 500));

        javax.swing.GroupLayout gunPnlLayout = new javax.swing.GroupLayout(gunPnl);
        gunPnl.setLayout(gunPnlLayout);
        gunPnlLayout.setHorizontalGroup(
            gunPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        gunPnlLayout.setVerticalGroup(
            gunPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gunPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(gunPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private physics.GunPanel gunPnl;
    // End of variables declaration//GEN-END:variables
}
