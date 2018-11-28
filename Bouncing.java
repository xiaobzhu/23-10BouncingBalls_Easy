import javax.swing.*;
import java.awt.*;

/**
 * @author xiaobzhu
 * This class is working on the balls part, in this class it extend the JPanel class
 * it will set the the inital position, and the size of the ball and the inital speed
 */
public class Bouncing extends JPanel{

    private int x = (int) (Math.random() * 400);
    private int y = (int) (Math.random() * 400);
    private int radius = (int) (Math.random() * 50);
    private int speed = (int) (Math.random() * 25);
    private int dx = (int) (Math.random() * 25);
    private int dy = (int) (Math.random() * 25);

    /**
     * This is the constructor of this class, there doesnt have any thing because I inital all the things before, But it
     * has to be here, if want to remove this constructor, I have to make all the call and method to be static
     */
    public Bouncing(){
    }

    /**
     * This class is overriding the method from the JCompoent.java.
     * @param g it is the parameter in the paintCompoent, in this part, it need to set the color of the
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE); // this is used to set the balls color
        g.fillOval(x, y, radius, radius); // this is used to set the balls position

    }

    /**
     * this method is used to do the move part of the ball, everytime when the sleep end, it will run this method, after
     * this method redraw the balls
     */
    public void move(){
        if(x <= 0){
            dx = speed;
        } else if(x+radius >= this.getWidth()){
            dx = -speed;
        }
        x = x + dx;
        if(y <= 0){
            dy = speed;
        } else if(y + radius>= this.getHeight()){
            dy = -speed;
        }
        y = y + dy;
        repaint(); // this is used to redraw the balls
    }

}

