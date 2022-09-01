package Panels;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel {
    public JPanel panel;
    public JTextArea calcDisplay;
    public DisplayPanel() {
        panel = new JPanel();
        calcDisplay = new JTextArea("");

        panel.add(calcDisplay);
    }

    public void Update() {
        panel.setLayout(new GridLayout());
        panel.setSize(400, 100);
        panel.setBackground(Color.DARK_GRAY);
        calcDisplay.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 30));
        calcDisplay.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.updateUI();
    }

    public void Add(JFrame frame, String layout) {
        frame.add(panel, layout);
    }
}

