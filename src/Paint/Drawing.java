package Paint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Drawing {
    //creating buttons
    JButton clear, black, blue, green, red, pink,yellow,brown,eresor,colorChooser;
    JMenu menu;
    JMenuItem s1,s2,s3,s4;
    // DrawArea canvas
    Canvas canvas;
    //eventListener for all button
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == clear) {
                canvas.clear();
            } else if (e.getSource() == black) {
                canvas.black();
            } else if (e.getSource() == blue) {
                canvas.blue();
            } else if (e.getSource() == green) {
                canvas.green();
            } else if (e.getSource() == red) {
                canvas.red();
            } else if (e.getSource() == pink) {
                canvas.magenta();
            }
            else if(e.getSource()==yellow){
                canvas.yellow();
            }
            else if(e.getSource()==brown){
                canvas.brown();
            }else if (e.getSource()==s1){
                   canvas.setSize(3);
            }else if (e.getSource()==s2){
                canvas.setSize(8);

            }else if (e.getSource()==s3){
                canvas.setSize(12);
            }else if (e.getSource()==s4){
                canvas.setSize(20);
            }else if(e.getSource()==eresor){
                canvas.White();
            }
        }
    };

    public static void main(String[] args) {
        new Drawing().show();
    }

    public void show() {
        // create main frame
        JFrame frame = new JFrame("Paint Application");
        Container content = frame.getContentPane();
        // set layout on content pane
        content.setLayout(new BorderLayout());
        // create draw area
        canvas = new Canvas();
        content.add(canvas, BorderLayout.CENTER);
        // panel for all buttons
        JPanel panel = new JPanel();
        black = new JButton("Black");
        black.setBackground(Color.BLACK);
        black.addActionListener(actionListener);
        blue = new JButton("Blue");
        blue.setBackground(Color.BLUE);
        blue.addActionListener(actionListener);
        green = new JButton("Green");
        green.setBackground(Color.GREEN);
        green.addActionListener(actionListener);
        red = new JButton("Red");
        red.setBackground(Color.RED);
        red.addActionListener(actionListener);
        pink = new JButton("pink");
        pink.setBackground(Color.PINK);
        pink.addActionListener(actionListener);
        yellow=new JButton("yellow");
        yellow.setBackground(Color.YELLOW);
        yellow.addActionListener(actionListener);
        brown=new JButton("brown");
        brown.setBackground(new Color(200,150,30));
        brown.addActionListener(actionListener);
        clear = new JButton("Clear");
        clear.addActionListener(actionListener);
        eresor=new JButton("eresor");
        eresor.addActionListener(actionListener);
        colorChooser=new JButton("color");
        colorChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color initial=Color.red;
                Color color=JColorChooser.showDialog(content,"select the color",initial);
                canvas.colordynamicly(color);
            }
        });
        //menu
        menu=new JMenu("brush size");
        JMenuBar menuBar=new JMenuBar();
        s1=new JMenuItem("10");
        s2=new JMenuItem("50");
        s3=new JMenuItem("80");
        s4=new JMenuItem("110");
        menu.add(s1);
        menu.add(s2);
        menu.add(s3);
        menu.add(s4);
        menuBar.add(menu);
        s1.addActionListener(actionListener);
        s2.addActionListener(actionListener);
        s3.addActionListener(actionListener);
        s4.addActionListener(actionListener);
        // add to panel
        panel.add(green);
        panel.add(blue);
        panel.add(black);
        panel.add(red);
        panel.add(pink);
        panel.add(yellow);
        panel.add(brown);
        panel.add(clear);
        panel.add(eresor);
        panel.add(menuBar);
        panel.add(colorChooser);
        // add to content pane
        panel.setLayout(new GridLayout(6,1));
        content.add(panel, BorderLayout.WEST);
        frame.setSize(1000, 500);
        // can close frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // show the swing paint result
        frame.setVisible(true);
    }
}
