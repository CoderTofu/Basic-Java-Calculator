import Panels.DisplayPanel;
import Panels.KeysPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    private static final JFrame mainFrame = new JFrame("Calculator");

    private static final DisplayPanel displayPanel = new DisplayPanel();
    private static final KeysPanel keysPanel = new KeysPanel(displayPanel);
    public static void main(String[] args) {
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        mainFrame.setSize(400, 600);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);

        displayPanel.Add(mainFrame, BorderLayout.NORTH);
        keysPanel.Add(mainFrame, BorderLayout.SOUTH);

        displayPanel.Update();
    }
}