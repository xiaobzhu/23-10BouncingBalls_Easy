import javax.swing.*;

/**
 * @author xiaobzhu
 * this is the main class to run the project
 */
public class Main {
    /**
     * this method is used to do the setting of the GUI
     * @param args is the parameter of the main method
     */
    public static void main(String[] args) {
        BouncingBalls bouncingBalls = new BouncingBalls();
        bouncingBalls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// this is used to set the off option, the EXIT_ON_CLOSE is the windows constant
        bouncingBalls.setSize(400,400);
        bouncingBalls.setResizable(false);
        bouncingBalls.setVisible(true);

    }
}
