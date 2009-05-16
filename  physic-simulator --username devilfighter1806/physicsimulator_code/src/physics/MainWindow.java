/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;

/**
 * Contains all panels.
 * @author Stanislav Petrov, Krasimir Baylov
 */
public class MainWindow extends JFrame {

    private AnimationPanel animationPanel;
    private SettingsPanel settingsPanel;
    private ControllerPanel controllerPanel;
    private LogoPanel logoPanel;
    private Status status;
    private LayoutManager layout;

    public MainWindow(String name) {
        super(name);
        layout = new GridLayout(3, 3, 5, 5);
        initComponents();
    }

    private void initComponents() {
        logoPanel = new LogoPanel();
        animationPanel = new AnimationPanel();
        settingsPanel = new SettingsPanel(animationPanel);
        controllerPanel = new ControllerPanel();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(logoPanel, BorderLayout.NORTH);
        add(settingsPanel, BorderLayout.WEST);
        add(animationPanel, BorderLayout.EAST);
        add(controllerPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
