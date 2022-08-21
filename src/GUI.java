
//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;

public class GUI {
    JFrame frame;
    public GUI() {
        //Creating the Frame
        this.frame = new JFrame("Calculator");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(400, 400);

        /*
        * Here are the things we will need to do
        * 1. Learn JPanel
        * 2. Learn JButton
        * 3. Learn JLabel
        *
        * Two panels will be made.
        * One is the display for our calculator.
        * The other would be for our buttons.
        * The buttons have to have a layout that matches your traditional calculators.
        * */

        this.frame.setVisible(true);
    }
}