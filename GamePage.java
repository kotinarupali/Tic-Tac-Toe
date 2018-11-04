

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author kotin
 */
public class GamePage extends Applet implements ActionListener{
    

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    String[] arr;
    String winner;
    JFrame frame;
    int tries;
    private String currentPlayer = "O";
    
    @Override
    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setResizable(true);
	frame.setLocationRelativeTo(null);
        tries = 0;
        winner = null;
        arr = new String[]{null, null, null ,null, null, null, null, null, null};
        b1 = new Button();
        b2 = new Button();
        b3 = new Button();
        b4 = new Button();
        b5 = new Button();
        b6 = new Button();
        b7 = new Button();
        b8 = new Button();
        b9 = new Button();
        setLayout(new GridLayout(3,3));
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this); 
        
    }
    
    // checking if any player wins
    public boolean playerWins()
    {
        String[] line = new String[8];
        line[0] = arr[0] + arr[1] + arr[2];
        line[1] = arr[3] + arr[4] + arr[5];
        line[2] = arr[6] + arr[7] + arr[8];
        line[3] = arr[0] + arr[3] + arr[6];
        line[4] = arr[1] + arr[4] + arr[7];
        line[5] = arr[2] + arr[5] + arr[8];
        line[6] = arr[0] + arr[4] + arr[8];
        line[7] = arr[2] + arr[4] + arr[6];
        
        for(int i = 0; i < 8; i++)
        {
            if (line[i].equals("XXX"))
            {
                winner = "X";
                return true;
            }
            else if (line[i].equals("OOO"))
            {
                winner = "O";
                return true;
            }
        }
        return false;
    }
   
    // changing the player after every turn
    public void changePlayer()
    {
        if (currentPlayer == "X")
            currentPlayer = "O";
        else 
            currentPlayer = "X";
    }
    
    public void paint(Graphics g)
    {
        if (tries == 9)
        {
           if(winner == null)
           {
               JOptionPane.showMessageDialog(frame, "It's a Tie!");
               
           }
        }
        if(playerWins() && tries < 9)
        {
            if(winner == "X")
               JOptionPane.showMessageDialog(frame, "X Wins!");
            else if(winner == "O")
               JOptionPane.showMessageDialog(frame, "O Wins!");
        }
        if (!playerWins())
        {
            tries++;
            changePlayer();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
        {
            b1.setLabel(currentPlayer);
            arr[0] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b2)
        {
            b2.setLabel(currentPlayer);
            arr[1] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b3)
        {
            b3.setLabel(currentPlayer);
            arr[2] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b4)
        {
            b4.setLabel(currentPlayer);
            arr[3] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b5)
        {
            b5.setLabel(currentPlayer);
            arr[4] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b6)
        {
            b6.setLabel(currentPlayer);
            arr[5] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b7)
        {
            b7.setLabel(currentPlayer);
            arr[6] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b8)
        {
            b8.setLabel(currentPlayer);
            arr[7] = currentPlayer;
            repaint();
        }
        else if (e.getSource() == b9)
        {
            b9.setLabel(currentPlayer);
            arr[8] = currentPlayer;
            repaint();
        }
    }
    
}

