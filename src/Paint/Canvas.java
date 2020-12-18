package Paint;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;

public class Canvas extends JComponent {
    private Image image;
    private Graphics2D graphics;
    // Mouse coordinates
    private int currentX, currentY, oldX, oldY;
    public Canvas() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // when mouce is pressed first time
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                //  when mouse is moving
                currentX = e.getX();
                currentY = e.getY();
                if (graphics != null) {
                    graphics.drawLine(oldX, oldY, currentX, currentY);
                    // refresh
                    repaint();
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }
    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics = (Graphics2D) image.getGraphics();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }
    public void clear() {
        graphics.setPaint(Color.white);
        graphics.fillRect(0, 0, getSize().width, getSize().height);
        graphics.setPaint(Color.black);
        repaint();
    }
    public void red() {
        graphics.setPaint(Color.red);
    }
    public void black() {
        graphics.setPaint(Color.black);
    }
    public void magenta() {
        graphics.setPaint(Color.magenta);
    }

    public void green() {
        graphics.setPaint(Color.green);
    }

    public void blue() {
        graphics.setPaint(Color.blue);
    }
    public void yellow(){
        graphics.setPaint(Color.yellow);
    }
    public void brown(){
        graphics.setPaint(new Color(200,150,30));
    }
    public void setSize(int a){
        graphics.setStroke(new BasicStroke(a));
    }
    public void White()
    {
        graphics.setPaint(Color.WHITE);
    }
    public void colordynamicly(Color color)
    {
        graphics.setPaint(color);
    }
}
