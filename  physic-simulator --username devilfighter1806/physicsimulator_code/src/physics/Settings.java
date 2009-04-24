/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Settings information.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class Settings extends JPanel {
    //TODO Enter angle - Up and down buttons, textField.

    /**
     * Button when clicked over changes the value of the angle of the gun.
     * The gun's possition is updated as well.
     */
    private JButton angleUpBtn;
    private JButton angleDownBtn;
    private JTextField acceleration; //a
    private JTextField initialVelocity;

    /**
     * General purpose constructor
     */
    public Settings(){}

    /**
     * Draw some of the graphical components here
     * @param g     A graphics object that is used for drawing
     */
    @Override
    public void paintComponent(Graphics g){}

    /**
     * Event handler class that handles the clicks over
     * the buttons
     */
    private class ButtonHandler implements ActionListener{

        public void actionPerformed(ActionEvent e) {
        }
    }
    
}
