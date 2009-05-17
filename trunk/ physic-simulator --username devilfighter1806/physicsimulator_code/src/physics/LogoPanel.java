/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class LogoPanel extends JPanel {

    private JLabel logoLabel;

    public LogoPanel() {
        super();
        setSize(800, 100);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        initComponents();
    }

    private void initComponents() {
        logoLabel = new JLabel("Here is some fucking logo!!!!<Krasi && Staskata>");
        add(logoLabel);
    }
}
