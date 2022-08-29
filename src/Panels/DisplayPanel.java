package Panels;

import javax.swing.*;

public class DisplayPanel {
    public JPanel panel;
    public JLabel calcDisplay;
    public JLabel resDisplay;
    public DisplayPanel() {
        panel = new JPanel();
        resDisplay = new JLabel("");
        calcDisplay = new JLabel("");

        panel.add(resDisplay);
        panel.add(calcDisplay);
    }

    public void Add(JFrame frame, String layout) {
        frame.add(panel, layout);
    }
}

