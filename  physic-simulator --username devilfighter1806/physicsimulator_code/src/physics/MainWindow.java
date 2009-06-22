/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.JFrame;

/**
 * Contains all panels.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
public class MainWindow extends JFrame {

    private AnimationPanel animationPanel;
    private SettingsPanel settingsPanel;
    private ControllerPanel controllerPanel;
    private LogoPanel logoPanel;
    private Status status;
    private LayoutManager layout;
    private Container container;

    public MainWindow(String name) {
        super(name);
        layout = new FlowLayout();
        container = getContentPane();
        initComponents();
    }

    /**
     * Adds all panels to main window.
     */
    private void initComponents() {
        logoPanel = new LogoPanel();
        animationPanel = new AnimationPanel();
        settingsPanel = new SettingsPanel(animationPanel);
        controllerPanel = new ControllerPanel();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(logoPanel, BorderLayout.NORTH);
        container.add(settingsPanel, BorderLayout.WEST);
        container.add(animationPanel, BorderLayout.CENTER);
//        container.add(controllerPanel, BorderLayout.SOUTH);
        setVisible(true);
    }
}
