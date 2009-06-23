/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package physics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    private MenuBar menuBar;

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
        menuBar = new MenuBar(settingsPanel);
        setJMenuBar(menuBar.newJMenuBar());
        setVisible(true);
    }
}

/**
 * Represents menu bar in main window.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
class MenuBar {

    /**
     * Stored radio button menu items names in gravity menu.
     */
    private final String[] planetNames = {"Moon", "Saturn", "Mercury", "Earth",
        "Mars", "Neptune", "Uranus", "Jupiter", "Venus", "Sun", "Vacuum"};
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenu gravityMenu;
    private JMenu helpMenu;
    private JMenuItem gameNewMenuItem;
    private JMenuItem gameExitMenuItem;
    private JMenuItem contactMenuItem;
    private JMenuItem aboutMenuItem;
    private JRadioButtonMenuItem[] planetsItems;
    private Gravity[] planetGravity;
    private SettingsPanel settingsPanel;

    public MenuBar(SettingsPanel settingsPnl) {
        settingsPanel = settingsPnl;
    }

    /**
     * Creates new jmenu bar with relevant menu items.
     * @return JMenuBar
     */
    public JMenuBar newJMenuBar() {
        menuBar = new JMenuBar();
        planetGravity = Gravity.values();
        createGameMenu();
        createPlanetsMenu();
        createHelpMenu();
        return menuBar;
    }

    private void createGameMenu() {
        gameMenu = new JMenu("Game");
        gameNewMenuItem = new JMenuItem("New game");
        gameExitMenuItem = new JMenuItem("Exit game");
        gameNewMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settingsPanel.startNewGame();
            }
        });
        gameExitMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        gameMenu.add(gameNewMenuItem);
        gameMenu.add(gameExitMenuItem);
        menuBar.add(gameMenu);
    }

    /**
     * Planets menu represents gravities in different planets.
     */
    private void createPlanetsMenu() {
        gravityMenu = new JMenu("Gravity");
        planetsItems = new JRadioButtonMenuItem[planetNames.length];
        ButtonGroup planetsBtnGroup = new ButtonGroup();
        for (int i = 0; i < planetNames.length; i++) {
            planetsItems[i] = new JRadioButtonMenuItem(planetNames[i]);
            planetsItems[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < planetNames.length; i++) {
                        if (planetsItems[i].isSelected()) {
                            settingsPanel.setAcceleration(planetGravity[i].value());
                            break;
                        }
                    }
                }
            });
            planetsBtnGroup.add(planetsItems[i]);
            gravityMenu.add(planetsItems[i]);
        }
        menuBar.add(gravityMenu);
    }

    private void createHelpMenu() {
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About...");
        contactMenuItem = new JMenuItem("Contacts");
        helpMenu.add(aboutMenuItem);
        helpMenu.add(contactMenuItem);
        menuBar.add(helpMenu);
    }
}

/**
 * Stores all planets' gravities.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
enum Gravity {

    MOON(1.62F), SATURN(8.96F), MERCURY(3.701F), EARTH(9.81F), MARS(3.86F), NEPTUNE(11.15F),
    URANUS(8.69F), JUPITER(24.9F), VENUS(8.88F), SUN(273.95F), VACUUM(0F);
    private float value;

    Gravity(float val) {
        value = val;
    }

    public float value() {
        return value;
    }
}
