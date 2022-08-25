import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorGui {
    private static JFrame mainFrame = new JFrame("Calculator");
    private JPanel display_panel, keys_panel;

    public static void main() {
        CalculatorGui calculatorGui = new CalculatorGui();
        calculatorGui.KeyLayout();

        mainFrame.setVisible(true);
    }

    public CalculatorGui() {
        PrepareGUI();
    }

    private void PrepareGUI() {
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
    }

    private void KeyLayout() {
        GridBagLayout layout = new GridBagLayout();
        keys_panel.setSize(400, 500);
        keys_panel.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        keys_panel.add(new JButton("÷"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        keys_panel.add(new JButton("x"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        keys_panel.add(new JButton("-"), gbc);

        // Here we add our number keys
        KeyNums(gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        keys_panel.add(new JButton("+"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridheight = 2;
        keys_panel.add(new JButton("="), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        keys_panel.add(new JButton("0"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        keys_panel.add(new JButton("."), gbc);

        mainFrame.add(keys_panel, BorderLayout.SOUTH);
    }
    
    private void KeyNums(GridBagConstraints gbc) {
        // our x and y values for "1" key
        int x = 0;
        int y = 3;
        for (int i = 1; i < 10; i++) {
            gbc.gridx = x;
            gbc.gridy = y;
            gbc.gridwidth = 1;
            keys_panel.add(new JButton(Integer.toString(i)), gbc);

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

// https://www.javatpoint.com/java-gridbaglayout
// https://www.tutorialspoint.com/swing/swing_gridbaglayout.htm