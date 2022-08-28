package Panels;

import javax.swing.*;

public class DisplayPanel {
    public JPanel panel;
    public JLabel label;
    public DisplayPanel() {
        panel = new JPanel();
        label = new JLabel("GOOD MORNING");

        panel.add(label);
    }

    public void Add(JFrame frame, String layout) {
        frame.add(panel, layout);
    }
}
