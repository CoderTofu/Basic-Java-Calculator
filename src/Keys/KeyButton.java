package Keys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyButton implements ActionListener {
    JButton button;
    String string;
    public KeyButton(JPanel panel, String str, GridBagConstraints gbc) {
        string = str;
        button = new JButton(str);
        button.addActionListener(this);
        panel.add(button, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(string);
    }
}
// actions when button is pressed
// https://www.tutorialsfield.com/jbutton-click-event/#Implementing_ActionListener_Interface