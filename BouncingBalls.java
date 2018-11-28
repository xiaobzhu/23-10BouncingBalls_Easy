import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiaobzhu
 * This class implements the Runnable interface, so it can make the Bouncing function can excute concurrently. This class
 * extends the JFrame class. to set the frame of the bouncing ball in this class include the run() method, because when implements
 * the runnable interface, The class must define a method of no arguments called.The rest of JFrame settings are in the main class
 */
public class BouncingBalls extends JFrame implements Runnable {
    /**
     * This private value is used to call the constructor of the Bouncing class
     */
    private Bouncing bouncingBalls = new Bouncing();

    /**
     * this is the constructor of the BouncingBalls class, in this constructor, it add the MouseListener and add the ball
     * draw part at this constructor
     */
    public BouncingBalls() {
        addMouseListener(new Handler());
        add(bouncingBalls);
    }

    /**
     * This is the method that when implements the Runnabale it must define a method of no arguments called
     * The Override function from the runnable that do the multithreading
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10); // put the thread to sleep, set the sleep time
                bouncingBalls.move(); // run the move function in the Bouncing file
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }

    /**
     * This class is used to create the MounseListener
     */
    public class Handler implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        /**
         * This method is created after implements the MouseListener, because all of this method is get from the MouseListener interface
         */

        @Override
        public void mousePressed(MouseEvent e) {
            ExecutorService executorService = Executors.newCachedThreadPool();     // create the ExecutorServices to manage threads
            executorService.execute(BouncingBalls.this::run); // start the tast
            removeMouseListener(this); //after get the mouse action, it will romove the mouseListener, if it dont remove the action
            //listener, it will continouns to increase the speed
        }

        /**
         * This method is created after implements the MousListener, because all of this method is get from the MouseListener interface
         */
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * This method is created after implements the MousListener, because all of this method is get from the MouseListener interface
         */
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * This method is created after implements the MousListener, because all of this method is get from the MouseListener interface
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


}
