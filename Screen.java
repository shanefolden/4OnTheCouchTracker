
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Screen extends JPanel implements ActionListener {
    private JButton b1;
    private JButton b2;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private String name = "";
    List<String> names = new ArrayList<>();
    List<String> values = new ArrayList<>();



    public Screen() {
        this.setLayout(null);

        //Button
        b1 = new JButton("Submit");
        b1.setBounds(400,50, 80, 30); //sets the location and size
        b1.addActionListener(this); //add the listener
        this.add(b1); //add to JPanel

        b2 = new JButton("Submit");
        b2.setBounds(790,150, 80, 30); //sets the location and size
        b2.addActionListener(this); //add the listener
        this.add(b2); //add to JPanel

        //TextField
        t1 = new JTextField(20);
        t1.setBounds(300,50, 100, 30);
        this.add(t1);

        t2 = new JTextField(20);
        t2.setBounds(100,150, 100, 30);
        this.add(t2);

        t3 = new JTextField(20);
        t3.setBounds(340,150, 100, 30);
        this.add(t3);

        t4 = new JTextField(20);
        t4.setBounds(690,150, 100, 30);
        this.add(t4);


        this.setFocusable(true);

    }

    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(1000,800);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //draw background
        //g.setColor(Color.white);
        //g.fillRect(0,0,800,400);

        //draw instructions
        Font font = new Font("Arial", Font.PLAIN, 20);
        Font font2 = new Font("Arial", Font.PLAIN, 70);
        Font font3 = new Font("Arial", Font.PLAIN, 18);
        g.setFont(font);
        g.setColor(Color.black);

        g.drawString("4 on the couch tracker ", 400, 20);
        g.drawString("add a player to the game:", 50, 70);
        g.setFont(font3);
        g.drawString("called the name ", 210, 170);
        g.drawString(".   The person who moved was", 440, 170);
        g.drawString("Name:       Psuedonym:    ", 100, 225);





        for(int i = 0; i<names.size(); i++)
        {
          g.drawString(names.get(i) + ":   "+values.get(i), 100, (255+20*i));
          System.out.println("yeet");
        }

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Button has been clicked");
            name = t1.getText();
            names.add(name);
            values.add("unknown");
            repaint();
        }
        if (e.getSource() == b2) {
            System.out.println("Button has been clicked");
            String player = t2.getText();
            String mover = t4.getText();
            String newVal = t3.getText();
            boolean playerExists = false;
            boolean moverExists = false;
            int playerIndex = 0;
            int moverIndex = 0;
            for(int i = 0; i<names.size();i++)
            {
                if(names.get(i).equals(player))
                {
                  playerExists = true;
                  playerIndex = i;
                }
                if(names.get(i).equals(mover))
                {
                  moverExists = true;
                  moverIndex = i;
                }

            }
            if(!playerExists || !moverExists)
            {
              JOptionPane.showMessageDialog(null, "One of your names wasnt valid, try again");
            }
            else{
            String playerValue = values.get(playerIndex);
            values.set(moverIndex, playerValue);
              values.set(playerIndex, newVal);


            }




            repaint();
        }


    }



}
