package Panels;

import Keys.KeyButton;

import javax.swing.*;
import java.awt.*;

public class KeysPanel {
    public JPanel panel;
    private final DisplayPanel displayPanel;

    public KeysPanel (DisplayPanel display) {
        panel = new JPanel();
        displayPanel = display;

        KeyLayout();
    }

    public void Add(JFrame frame, String layout) {
        frame.add(panel, layout);
    }

    private void KeyLayout() {
        GridBagLayout layout = new GridBagLayout();
        panel.setSize(400, 500);
        panel.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        new KeyButton(panel, "÷", gbc, displayPanel);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        new KeyButton(panel, "x", gbc, displayPanel);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        new KeyButton(panel, "-", gbc, displayPanel);

        // Here we add our number keys
        KeyNums(gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        new KeyButton(panel, "+", gbc, displayPanel);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        new KeyButton(panel, "=", gbc, displayPanel);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        new KeyButton(panel, "0", gbc, displayPanel);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        new KeyButton(panel, ".", gbc, displayPanel);
    }

    private void KeyNums(GridBagConstraints gbc) {
        // our x and y values for "1" key
        int x = 0;
        int y = 3;
        for (int i = 1; i < 10; i++) {
            gbc.gridx = x;
            gbc.gridy = y;
            gbc.gridwidth = 1;
            new KeyButton(panel, Integer.toString(i), gbc, displayPanel);

            // Adjustments for next number
            if (i % 3 != 0) {
                x = x + 1;
            } else {
                x = 0;
                y = y - 1;
            }
        }
    }
}
