package physics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Status information.
 * @author Krasimir Baylov(61080), Stanislav Petrov(61055)
 */
public class StatusPanel extends JPanel {

    /**
     * Represents status information.
     */
    private JLabel statusModifyLbl;

    /**
     * General purpose constructor. Sets some of the
     * parameters and values of the used objects
     */
    public StatusPanel() {
        super();
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        initComponents();
    }

    private void initComponents() {
        setPreferredSize(new Dimension(150, 30));
        statusModifyLbl = new JLabel();
        statusModifyLbl.setFont(new java.awt.Font("Arial", 1, 14));
        add(statusModifyLbl);
    }

    public void setStatus(String text) {
        statusModifyLbl.setText(text);
    }
}
