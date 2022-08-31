package Panels;

import javax.swing.*;

public class DisplayPanel {
    public JPanel panel;
    public JLabel calcDisplay;
    public DisplayPanel() {
        panel = new JPanel();
        calcDisplay = new JLabel("");

        panel.add(calcDisplay);
    }

    public void Add(JFrame frame, String layout) {
        frame.add(panel, layout);
    }
}

