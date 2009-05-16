/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package physics;

import javax.swing.JFrame;

/**
 * Contains all panels.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class MainWindow extends JFrame{

    private AnimationPanel animationPanel;
    private Settings settings;
    private Status status;

    public MainWindow(){
        super();
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
