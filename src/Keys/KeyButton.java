package Keys;

import Panels.DisplayPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyButton implements ActionListener {
    public JButton button;
    public String keyString;
    public DisplayPanel displayPanel;
    private final KeyFunction keyFunction;
    public KeyButton(JPanel panel, String str, GridBagConstraints gbc, DisplayPanel display) {
        keyString = str;
        button = new JButton(str);
        keyFunction = new KeyFunction(str, display);
        displayPanel = display;

        button.addActionListener(this);
        panel.add(button, gbc);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        keyFunction.main();
    }
}
// actions when button is pressed
// https://www.tutorialsfield.com/jbutton-click-event/#Implementing_ActionListener_Interface