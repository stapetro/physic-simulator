package physics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Contains all panels.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 * @version 1.0
 */
public class MainWindow extends JFrame {

    private static final Dimension MINIMUM_WINDOW_SIZE = new Dimension(680, 600);
    private static final Dimension WINDOW_SIZE = new Dimension(800, 600);
    /**
     * Animating starts here.
     */
    private AnimationPanel animationPanel;
    /**
     * Adjust settings from formulas.
     */
    private SettingsPanel settingsPanel;
    private LogoPanel logoPanel;
    private StatusPanel statusPanel;
    private LayoutManager layout;
    private Container container;
    /**
     * Menu bar with relevant menus.
     */
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
        setMinimumSize(MINIMUM_WINDOW_SIZE);
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logoPanel = new LogoPanel();
        animationPanel = new AnimationPanel();
        settingsPanel = new SettingsPanel(animationPanel);
        statusPanel = settingsPanel.getStatusPanel();
        statusPanel.setStatus("Simulator not started");
        container.add(logoPanel, BorderLayout.NORTH);
        container.add(settingsPanel, BorderLayout.WEST);
        container.add(animationPanel, BorderLayout.CENTER);
        menuBar = new MenuBar(settingsPanel);
        setJMenuBar(menuBar.newJMenuBar(this));
        /*
         * Displays frame to the center of the screen.
         */
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

/**
 * Represents menu bar in main window.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
class MenuBar {

    /**
     * Stores look names.
     */
    private final String[] LOOKS = {"Metal", "Motif", "Windows"};
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem gameNewMenuItem;
    private JMenuItem gameExitMenuItem;
    private JMenu gravityMenu;
    private JRadioButtonMenuItem[] planetsItems;
    private Gravity[] planetGravity;
    private JMenu helpMenu;
    private JMenuItem contactMenuItem;
    private JMenuItem aboutMenuItem;
    /**
     * Change main window's looks from look menu.
     */
    private JMenu lookMenu;
    private JCheckBoxMenuItem[] lookMenuItems;
    /**
     * Stores refercen to settings panel for changing acceleration value.
     */
    private SettingsPanel settingsPanel;
    /**
     * Stores different looks and feels for main window.
     */
    private UIManager.LookAndFeelInfo looks[];
    /**
     * Stores main window reference for changing window's look.
     */
    private JFrame mainWindow;

    public MenuBar(SettingsPanel settingsPnl) {
        settingsPanel = settingsPnl;
    }

    /**
     * Creates new jmenu bar with relevant menu items.
     * @return JMenuBar
     */
    public JMenuBar newJMenuBar(JFrame mainW) {
        mainWindow = mainW;
        menuBar = new JMenuBar();
        planetGravity = Gravity.values();
        createGameMenu();
        createPlanetsMenu();
        createLookAndFeelMenu();
        createHelpMenu();
        return menuBar;
    }

    /**
     * Creates game menu with new game and exit game menu items. Action 
     * listeners is added to these items. Game menu is added to the menu bar.
     */
    private void createGameMenu() {
        gameMenu = new JMenu("Simulator");
        gameNewMenuItem = new JMenuItem("New simulator");
        gameExitMenuItem = new JMenuItem("Exit");
        gameNewMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                settingsPanel.startNewSimulator();
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
     * Planets menu represents gravities in different planets. Adds action
     * listeners to planet menu items.
     */
    private void createPlanetsMenu() {
        gravityMenu = new JMenu("Gravity");
        planetsItems = new JRadioButtonMenuItem[planetGravity.length];
        ButtonGroup planetsBtnGroup = new ButtonGroup();
        for (int i = 0; i < planetGravity.length; i++) {
            planetsItems[i] = new JRadioButtonMenuItem(planetGravity[i].toString());
            planetsItems[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < planetGravity.length; i++) {
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

    /**
     * Creates look and feel menu for changing main window's look.
     */
    private void createLookAndFeelMenu() {
        looks = UIManager.getInstalledLookAndFeels();
        lookMenu = new JMenu("LookNFeel");
        lookMenuItems = new JCheckBoxMenuItem[LOOKS.length];
        ButtonGroup lookGroup = new ButtonGroup();
        for (int i = 0; i < LOOKS.length; i++) {
            lookMenuItems[i] = new JCheckBoxMenuItem(LOOKS[i]);
            lookMenu.add(lookMenuItems[i]);
            lookGroup.add(lookMenuItems[i]);
            lookMenuItems[i].addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < lookMenuItems.length; i++) {
                        if (lookMenuItems[i].isSelected()) {
                            try {
                                UIManager.setLookAndFeel(looks[i].getClassName());
                                SwingUtilities.updateComponentTreeUI(mainWindow);
                            } catch (ClassNotFoundException ex) {
                                JOptionPane.showMessageDialog(mainWindow, "Look not found");
                            } catch (InstantiationException ex) {
                                Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IllegalAccessException ex) {
                                Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            });
        }
        menuBar.add(lookMenu);
    }

    /**
     * Creates help menu with about and contacts menu items.
     */
    private void createHelpMenu() {
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About...");
        aboutMenuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            }
        });
        contactMenuItem = new JMenuItem("Contacts");
        contactMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainWindow,
                        String.format("Stanislav Petrov, fn61055, SU FMI\n" +
                        "email: devilfighter1806@gmail.com\n" +
                        "Krasimir Baylov, fn61080, SU FMI\nemail: kbailov@gmail.com"));
            }
        });
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

    MOON(1.62F, "Moon"), SATURN(8.96F, "Saturn"), MERCURY(3.701F, "Mercury"),
    EARTH(9.81F, "Earth"), MARS(3.86F, "Mars"), NEPTUNE(11.15F, "Neptune"),
    URANUS(8.69F, "Uranus"), JUPITER(24.9F, "Jupiter"), VENUS(8.88F, "Venus"),
    SUN(273.95F, "Sun"), VACUUM(0F, "Vacuum");
    private float value;
    private String name;

    Gravity(float val, String name) {
        value = val;
        this.name = name;
    }

    public float value() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gravity names getter.
     * @return Gravity names representing relevant menu items.
     */
    public String[] getGravityNames() {
        Gravity[] gravities = Gravity.values();
        String[] result = new String[gravities.length];
        for (int i = 0; i < gravities.length; i++) {
            result[i] = gravities[i].toString();
        }
        return result;
    }
}