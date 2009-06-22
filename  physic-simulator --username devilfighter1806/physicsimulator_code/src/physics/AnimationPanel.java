/*
 * AnimationPanel.java
 *
 * Created on 2009-5-16, 23:20:19
 */
package physics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.TextField;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * Display animations.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
public class AnimationPanel extends javax.swing.JPanel {

    private final int TOOLTIP_OFFSET = 40;
    /**
     * The target object that will be drawn on the panel
     */
    private Target target;
    /**
     * Graphics object for the panel
     */
    public Graphics myGraphics;
    /**
     * Indicates wheter tool tip should be redrawn or not.
     */
    private boolean drawnToolTip;
    /**
     * Indicates whether panel should be repainted for tool tip to be removed.
     */
    private boolean toBeRepainted;
    /**
     * Horizontal distance between gun and target.
     */
    private double targetHorizontalDistance;
    /**
     * Vertical distance between gun and target.
     */
    private double targetVerticalDistance;

    /**
     * Creates new Animation panel.
     */
    public AnimationPanel() {
        initComponents();
        target = new Target();
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        toBeRepainted = true;
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
        target.reDrawTarget(g, getWidth(), getHeight());
    }

    /**
     * Draws target with random coordinates.
     */
    public void drawTarget() {
        myGraphics = this.getGraphics();
        target.drawRandomCoordinates(myGraphics, getWidth(), getHeight());
        repaint();
    }

    public Point getGunCoorinates() {
        return gunPnl.getTopCoordinates();
    }

    /**
     * Getter for target point
     * @return the point of the target
     */
    public Point getTargetPoint() {
        return target.getPoint();
    }

    public Point getTargetRadiusPoint() {
        return target.getCenterPoint();
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
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout gunPnlLayout = new javax.swing.GroupLayout(gunPnl);
        gunPnl.setLayout(gunPnlLayout);
        gunPnlLayout.setHorizontalGroup(
            gunPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        gunPnlLayout.setVerticalGroup(
            gunPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gunPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(gunPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        drawToolTip(evt.getPoint());
    }//GEN-LAST:event_formMouseMoved

    private void drawToolTip(Point mousePoint) {
        Point targetRadius = target.getCenterPoint();
        if (mousePoint.x >= targetRadius.x - Target.TARGET_SIZE / 2 && mousePoint.x <= targetRadius.x + Target.TARGET_SIZE / 2 &&
                mousePoint.y >= targetRadius.y - Target.TARGET_SIZE / 2 && mousePoint.y <= targetRadius.y + Target.TARGET_SIZE / 2) {
            if (!drawnToolTip) {
                Graphics2D g = (Graphics2D) this.getGraphics();
                Point2D loc = (Point2D) mousePoint;
                Font font = new Font("Monospaced", Font.PLAIN, 15);
                FontRenderContext frc = g.getFontRenderContext();
                TextLayout layout = new TextLayout(String.format("distance: %.2f", calculateDistanceGunTarget()),
                        font, frc);
                layout.draw(g, (float) loc.getX() + TOOLTIP_OFFSET, (float) loc.getY());
                Rectangle2D bounds = layout.getBounds();
                bounds.setRect(bounds.getX() + loc.getX() + TOOLTIP_OFFSET,
                        bounds.getY() + loc.getY() - 3,
                        bounds.getWidth(),
                        bounds.getHeight() + 6);
                g.draw(bounds);
                /*
                 * Indicates if too tip is longer than free space in panel.
                 */
                double limitWidth = getWidth() - bounds.getX();
                if (limitWidth < bounds.getWidth()) {
                    g.clearRect((int) (bounds.getX() - 2), (int) (bounds.getY() - 2),
                            (int) (limitWidth + 2), (int) (bounds.getHeight() + 10));
                    target.reDrawTarget(g, getWidth(), getHeight());
                    g.setColor(Color.BLACK);
                    layout.draw(g, (float) loc.getX() - 5 * TOOLTIP_OFFSET, (float) loc.getY());
                    bounds = layout.getBounds();
                    bounds.setRect(bounds.getX() + loc.getX() - 5 * TOOLTIP_OFFSET,
                            bounds.getY() + loc.getY() - 3,
                            bounds.getWidth(),
                            bounds.getHeight() + 6);
                    g.draw(bounds);
                }
                drawnToolTip = true;
                toBeRepainted = true;
            }
        } else {
            if (toBeRepainted) {
                repaint();
                drawnToolTip = false;
                toBeRepainted = false;
            }
        }
    }

    public double calculateDistanceGunTarget() {
        Point targetCenter = target.getCenterPoint();
        Point gunPoint = gunPnl.getTopCoordinates();
        targetHorizontalDistance = Math.abs(targetCenter.x - gunPoint.x);
        targetVerticalDistance = Math.abs(getHeight() - targetCenter.y - gunPoint.y);
        double a = targetHorizontalDistance*targetHorizontalDistance;
        double b = targetVerticalDistance*targetVerticalDistance;
        return Math.sqrt(a + b) / 10;
    }

    public String getTargetHorizontalDistance(){
        return   String.format("%.0f", targetHorizontalDistance);
    }

    public String getTargetVerticalDistance(){
        return String.format("%.0f", targetVerticalDistance);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private physics.GunPanel gunPnl;
    // End of variables declaration//GEN-END:variables
}

