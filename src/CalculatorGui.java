import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorGui {
    private JFrame mainFrame; // Our main window
    private JPanel display_panel, keys_panel;

    public static void main(String[] args) {
        CalculatorGui calculatorGui = new CalculatorGui();
        calculatorGui.showGridBagLayoutDemo();
    }

    public CalculatorGui() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Calculator");
        display_panel = new JPanel();
        keys_panel = new JPanel();

        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        mainFrame.setSize(400, 600);
        mainFrame.add(display_panel, BorderLayout.NORTH);
        mainFrame.add(keys_panel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }

    private void showGridBagLayoutDemo() {
        keys_panel.setLayout(new GridLayout(4, 4));
    }
}

// https://www.javatpoint.com/java-gridbaglayout
// https://www.tutorialspoint.com/swing/swing_gridbaglayout.htm