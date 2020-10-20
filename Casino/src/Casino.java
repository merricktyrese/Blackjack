import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import java.awt.event.*;

public class Casino extends JPanel{
    JPanel topPanel = new JPanel();
    JPanel dcardPanel = new JPanel();
    JPanel pcardPanel = new JPanel();
    JTextPane winlosebox = new JTextPane();
    JButton hitbutton = new JButton();
    JButton dealbutton = new JButton();
    JButton staybutton = new JButton();
    JButton playagainbutton = new JButton();
    JLabel dealerlabel = new JLabel();
    JLabel playerlabel = new JLabel();

    JLabel playercard1;
    JLabel playercard2;
    JLabel playercardhit;
    JLabel dealercard0;
    JLabel dealercard2;
    JLabel dealercard1;
    JLabel dealercardhit;

    public void CasinoGUI() {

        JFrame myFrame = new JFrame("BlackJack");

        topPanel.setBackground(new Color(0, 122, 0));
        dcardPanel.setBackground(new Color(0, 122, 0));
        pcardPanel.setBackground(new Color(0, 122, 0));

        topPanel.setLayout(new FlowLayout());
        winlosebox.setText(" ");
        winlosebox.setFont(new java.awt.Font("Helvetica Bold", 1, 20));
        dealbutton.setText("  Deal");

        dealbutton.addActionListener(new DealButton());
        hitbutton.setText("  Hit");
        hitbutton.addActionListener(new HitButton());
        hitbutton.setEnabled(false);
        staybutton.setText("  Stay");
        staybutton.addActionListener(new StayButton());
        staybutton.setEnabled(false);
        playagainbutton.setText("  Play Again");
       // playagainbutton.addActionListener(new playagainbutton());
        playagainbutton.setEnabled(false);

        dealerlabel.setText("  Dealer:  ");
        playerlabel.setText("  Player:  ");

        topPanel.add(winlosebox);
        topPanel.add(dealbutton);
        topPanel.add(hitbutton);
        topPanel.add(staybutton);
        topPanel.add(playagainbutton);
        pcardPanel.add(playerlabel);
        dcardPanel.add(dealerlabel);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(dcardPanel, BorderLayout.CENTER);
        add(pcardPanel, BorderLayout.SOUTH);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setContentPane(this);
        myFrame.setPreferredSize(new Dimension(700, 550));

        //Display the window.
        myFrame.pack();
        myFrame.setVisible(true);
    }

        public static void main(String[] args){
            Casino gui = new Casino();
            gui.CasinoGUI();
        }

}
