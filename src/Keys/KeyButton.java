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
    public KeyButton(JPanel panel, String str, GridBagConstraints gbc, DisplayPanel display) {
        keyString = str;
        button = new JButton(str);
        displayPanel = display;
        button.addActionListener(this);
        panel.add(button, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        KeyFunction keyFunc = new KeyFunction(keyString);
        displayPanel.label.setText(keyString);
        System.out.println(displayPanel.label.getText());
    }
}
// actions when button is pressed
// https://www.tutorialsfield.com/jbutton-click-event/#Implementing_ActionListener_Interface