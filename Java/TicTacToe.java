import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 Jerry Tac Toe - Program
 Allows someone to play Jerry Tac Toe with the generated AI
 AI moves base on ...
 @author Chris
 */

/**
 Creates and displays a Jerry Tac Toe Board
 */
class picture extends JPanel
{
    public void paintComponent(Graphics g)
    {
        // background
        g.setColor(Color.darkGray);
        g.fillRect(0,0,950,650);
        // circles
        g.setColor(Color.lightGray);
        g.fillOval(0,0,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(450,0,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(900,0,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(225,300,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(450,300,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(675,300,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(0,600,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(450,600,50,50);
        
        g.setColor(Color.lightGray);
        g.fillOval(900,600,50,50);
        
        // diagonal line from top left - bottom middle
        g.setColor(Color.lightGray);
        g.drawLine(10,10,475,625);
        // diagonal line from bottom middle - top right
        g.setColor(Color.lightGray);
        g.drawLine(940,10,475,625);
        // top horizontal line
        g.setColor(Color.lightGray);
        g.drawLine(10,20,940,20);
        // bottom horizontal line
        g.setColor(Color.lightGray);
        g.drawLine(10,630,940,625);
        // diagonal line from top middle - bottom left
        g.setColor(Color.lightGray);
        g.drawLine(475,10,20,630);
        // diagonal line from top middle - bottom right
        g.setColor(Color.lightGray);
        g.drawLine(475,10,930,625);
        // diagonal line from top left - bottom right
        g.setColor(Color.lightGray);
        g.drawLine(10,10,940,635);
        // diagonal line from top right - bottom left
        g.setColor(Color.lightGray);
        g.drawLine(10,630,930,10);
        // middle horizontal line
        g.setColor(Color.lightGray);
        g.drawLine(225,325,675,325);
        
        /**
         Creates the x's and o's that represent the players
         */
        // if statements to determine which move to draw
        if(TicTacToe.draw[1] == 1)
        {
            if(TicTacToe.type[1] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(10,10,40,40);
                    g.setColor(Color.blue);
                    g.drawLine(40,10,10,40);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(10,10,30,30);
                }
            }
            if(TicTacToe.type2[1] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(10,10,40,40);
                    g.setColor(Color.blue);
                    g.drawLine(40,10,10,40);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(10,10,30,30);
                }
            }
        }
        if(TicTacToe.draw[2] == 2)
        {
            if(TicTacToe.type[2] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(460,10,490,40);
                    g.setColor(Color.blue);
                    g.drawLine(490,10,460,40);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(460,10,30,30);
                }
            }
            if(TicTacToe.type2[2] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(460,10,490,40);
                    g.setColor(Color.blue);
                    g.drawLine(490,10,460,40);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(460,10,30,30);
                }
            }
        }
        if(TicTacToe.draw[3] == 3)
        {
            if(TicTacToe.type[3] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(910,10,940,40);
                    g.setColor(Color.blue);
                    g.drawLine(940,10,910,40);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(910,10,30,30);
                }
            }
            if(TicTacToe.type2[3] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(910,10,940,40);
                    g.setColor(Color.blue);
                    g.drawLine(940,10,910,40);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(910,10,30,30);
                }
            }
        }
        if(TicTacToe.draw[4] == 4)
        {
            if(TicTacToe.type[4] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(235,310,265,340);
                    g.setColor(Color.blue);
                    g.drawLine(265,310,235,340);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(235,310,30,30);
                }
            }
            if(TicTacToe.type2[4] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(235,310,265,340);
                    g.setColor(Color.blue);
                    g.drawLine(265,310,235,340);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(235,310,30,30);
                }
            }
        }
        if(TicTacToe.draw[5] == 5)
        {
            if(TicTacToe.type[5] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(460,310,490,340);
                    g.setColor(Color.blue);
                    g.drawLine(490,310,460,340);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(460,310,30,30);
                }
            }
            if(TicTacToe.type2[5] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(460,310,490,340);
                    g.setColor(Color.blue);
                    g.drawLine(490,310,460,340);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(460,310,30,30);
                }
            }
        }
        if(TicTacToe.draw[6] == 6)
        {
            if(TicTacToe.type[6] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(685,310,715,340);
                    g.setColor(Color.blue);
                    g.drawLine(715,310,685,340);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(685,310,30,30);
                }
            }
            if(TicTacToe.type2[6] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(685,310,715,340);
                    g.setColor(Color.blue);
                    g.drawLine(715,310,685,340);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(685,310,30,30);
                }
            }
        }
        if(TicTacToe.draw[7] == 7)
        {
            if(TicTacToe.type[7] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(10,610,40,640);
                    g.setColor(Color.blue);
                    g.drawLine(40,610,10,640);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(10,610,30,30);
                }
            }
            if(TicTacToe.type2[7] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(10,610,40,640);
                    g.setColor(Color.blue);
                    g.drawLine(40,610,10,640);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(10,610,30,30);
                }
            }
        }
        if(TicTacToe.draw[8] == 8)
        {
            if(TicTacToe.type[8] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(460,610,490,640);
                    g.setColor(Color.blue);
                    g.drawLine(490,610,460,640);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(460,610,30,30);
                }
            }
            if(TicTacToe.type2[8] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(460,610,490,640);
                    g.setColor(Color.blue);
                    g.drawLine(490,610,460,640);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(460,610,30,30);
                }
            }
        }
        if(TicTacToe.draw[9] == 9)
        {
            if(TicTacToe.type[9] == TicTacToe.you)
            {
                if(TicTacToe.you == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(910,610,940,640);
                    g.setColor(Color.blue);
                    g.drawLine(940,610,910,640);
                }
                if(TicTacToe.you == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(910,610,30,30);
                }
            }
            if(TicTacToe.type2[9] == TicTacToe.opp)
            {
                if(TicTacToe.opp == "x")
                {
                    // x - player
                    g.setColor(Color.blue);
                    g.drawLine(910,610,940,640);
                    g.setColor(Color.blue);
                    g.drawLine(940,610,910,640);
                }
                if(TicTacToe.opp == "o")
                {
                    // o - player
                    g.setColor(Color.blue);
                    g.drawOval(910,610,30,30);
                }
            }
        }
        
    }
}
/**
 Creates an action that allows the user to close the window
 */
class Closer extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        System.out.println("Goodbye.");
        System.exit(0);
    }
}
/**
 Main Class - uses button clicks and mouse clicks to function
 */
public class TicTacToe extends JFrame
implements ActionListener, MouseListener
{
    // data
    BST tree=new BST();
    Container stuff;
    JPanel panel;
    JPanel end;
    JLabel menu;
    JLabel move;
    JLabel select;
    JLabel again;
    JLabel result;
    JButton yes;
    JButton no;
    JButton x;
    JButton o;
    JButton Ayes;
    JButton Ano;
    picture perfect;
    int mousex;
    int mousey;
    int number;
    static String you;
    static String opp;
    int n;
    int count;
    int outcome = 0;
    int tie = 0;
    int results = 0;
    static int [] draw;
    static String [] type;
    static String [] type2;
    /**
     @param e activates on button click
     */
    public void actionPerformed(ActionEvent e)
    {
        // yes button onclick
        // removes the original gui display
        // displays the gui for the Jerry Tac Toe board
        if(e.getSource()==yes)
        {
            stuff.remove(panel);
            stuff.add(perfect);
            stuff.validate();
            stuff.repaint();
        }
        // no button onclick
        // makes the first move - (random)
        // removes the original gui display
        // displays the gui for the Jerry Tac Toe board
        if(e.getSource()==no)
        {
            number = (int)(1+9*Math.random());
            draw[number] = number;
            type2[number] = opp;
            tree.insert(number+opp);
            stuff.remove(panel);
            stuff.add(perfect);
            stuff.validate();
            stuff.repaint();
        }
        // x button onclick - hides the previous menu
        // displays the order of play menu
        if(e.getSource()==x)
        {
            you = "x";
            opp = "o";
            yes.setVisible(true);
            no.setVisible(true);
            move.setVisible(true);
            select.setVisible(false);
            x.setVisible(false);
            o.setVisible(false);
        }
        // o button onclick
        // displays the order of play menu
        if(e.getSource()==o)
        {
            you = "o";
            opp = "x";
            yes.setVisible(true);
            no.setVisible(true);
            move.setVisible(true);
            select.setVisible(false);
            x.setVisible(false);
            o.setVisible(false);
        }
        // yes button onclick
        // resets the game
        if(e.getSource() == Ayes)
        {
            results = 0;
            draw[1] = 0;
            type[1] = "";
            type2[1] = "";
            tree.delete(1+opp);
            x.setVisible(true);
            o.setVisible(true);
            yes.setVisible(false);
            no.setVisible(false);
            select.setVisible(true);
            move.setVisible(false);
            stuff.remove(end);
            stuff.add(panel);
            stuff.validate();
            stuff.repaint();
        }
        // no button onclick
        // terminates the program/game
        if(e.getSource() == Ano)
        {
            System.exit(0);
        }
    }
    /**
     @param e allows actions to take place when the mouse is clicked
     */
    public void mouseClicked(MouseEvent e)
    {
        // retieves the x and y coordinates
        mousex = e.getX();
        mousey = e.getY();
        // if statements for varying actions based upon the onclick coordinates
        if(mousex >= 05 && mousex <= 45 && mousey >= 10 && mousey <= 40)
        {
            n = 1;
            jerry();
        }
        // Same layout for all 9 areas -
        if(mousex >= 455 && mousex <= 495 && mousey >= 10 && mousey <= 40)
        {
            n = 2;
            jerry();
        }
        if(mousex >= 905 && mousex <= 945 && mousey >= 10 && mousey <= 40)
        {
            n = 3;
            jerry();
        }
        if(mousex >= 230 && mousex <= 270 && mousey >= 310 && mousey <= 340)
        {
            n = 4;
            jerry();
        }
        if(mousex >= 455 && mousex <= 495 && mousey >= 310 && mousey <= 340)
        {
            n = 5;
            jerry();
        }
        if(mousex >= 680 && mousex <= 720 && mousey >= 310 && mousey <= 340)
        {
            n = 6;
            jerry();
        }
        if(mousex >= 05 && mousex <= 45 && mousey >= 610 && mousey <= 640)
        {
            n = 7;
            jerry();
        }
        if(mousex >= 455 && mousex <= 495 && mousey >= 610 && mousey <= 640)
        {
            n = 8;
            jerry();
        }
        if(mousex >= 905 && mousex <= 945 && mousey >= 610 && mousey <= 640)
        {
            n = 9;
            jerry();
        }
    }
    public void mouseEntered (MouseEvent me) {}
    public void mousePressed (MouseEvent me) {}
    public void mouseReleased (MouseEvent me) {}
    public void mouseExited (MouseEvent me) {}
    
    // function to display the play again screen
    public void play()
    {
        stuff.remove(perfect);
        // displays the result of the game
        if(results == 1)
        {
            result=new JLabel("Tie Game. ");
            // panel after the game is over
            end=new JPanel();
            end.add(result,"North");
            end.add(again,"North");
            end.add(Ayes,"Center");
            end.add(Ano,"Center");
        }
        if(results == 2)
        {
            result=new JLabel("You Win!!! ");
            // panel after the game is over
            end=new JPanel();
            end.add(result,"North");
            end.add(again,"North");
            end.add(Ayes,"Center");
            end.add(Ano,"Center");
        }
        if(results == 3)
        {
            result=new JLabel("You Lose.");
            // panel after the game is over
            end=new JPanel();
            end.add(result,"North");
            end.add(again,"North");
            end.add(Ayes,"Center");
            end.add(Ano,"Center");
        }
        stuff.add(end);
        stuff.validate();
        stuff.repaint();
    }
    // function to reset the binary tree/game
    public void reset()
    {
        for(int i=0; i<10; i++)
        {
            tree.delete(i+you);
            tree.delete(i+opp);
            draw[i] = 0;
            type[i] = "";
            type2[i] = "";
        }
        tie = 0;
        outcome = 0;
    }
    // function to play Jerry Tac Toe
    public void jerry()
    {
        // if player is already there
        if(tree.lookup(n+you) != null)
        {
            //System.out.println("Can't go there.");
        }
        else
        {
            // if opponent is already there
            if(tree.lookup(n+opp) != null)
            {
                //System.out.println("Can't go there.");
            }
            else
            {
                // inserts that move into the BST
                tree.insert(n+you);
                draw[n] = n;
                type[n] = you;
                // checks to see if you win
                terminate();
                if(outcome == 0)
                {
                    // AI moves to the first availible space
                    for(int i = 1; i<10; i++)
                    {
                        if(tree.lookup(i+you) == null && tree.lookup(i+opp) == null)
                        {
                            tree.insert(i+opp);
                            draw[i] = i;
                            type2[i] = opp;
                            break;
                        }
                    }
                    // checks to see if AI wins
                    terminate();
                    // checks to see if there is a tie
                    if(tie == 0)
                    {
                        tie();
                        if(count == 9)
                        {
                            System.out.println("Tie Game.");
                            results = 1;
                            reset();
                            play();
                        }
                    }
                }
            }
        }
        // redraws the board with the correct pieces in place
        repaint();
    }
    // function to determine if there is a tie
    public void tie()
    {
        for(int i=1; i<10; i++)
        {
            if(tree.lookup(i+you) != null || tree.lookup(i+opp) != null)
            {
                count++;
            }
        }
    }
    // function to determine if someone is victorious
    public void terminate()
    {
        // if statements to determine if someone is victorious
        // also resets the tree and displays the option screen if the game is over
        if(tree.lookup(1+you) != null && tree.lookup(2+you) != null && tree.lookup(3+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(4+you) != null && tree.lookup(5+you) != null && tree.lookup(6+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(7+you) != null && tree.lookup(8+you) != null && tree.lookup(9+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(1+you) != null && tree.lookup(5+you) != null && tree.lookup(9+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(3+you) != null && tree.lookup(5+you) != null && tree.lookup(7+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(2+you) != null && tree.lookup(4+you) != null && tree.lookup(7+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(2+you) != null && tree.lookup(6+you) != null && tree.lookup(9+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(8+you) != null && tree.lookup(4+you) != null && tree.lookup(1+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(8+you) != null && tree.lookup(6+you) != null && tree.lookup(3+you) != null)
        {
            //System.out.println("You Win!!!");
            outcome = 1;
            tie = 1;
            results = 2;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(1+opp) != null && tree.lookup(2+opp) != null && tree.lookup(3+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(4+opp) != null && tree.lookup(5+opp) != null && tree.lookup(6+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(7+opp) != null && tree.lookup(8+opp) != null && tree.lookup(9+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(1+opp) != null && tree.lookup(5+opp) != null && tree.lookup(9+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(3+opp) != null && tree.lookup(5+opp) != null && tree.lookup(7+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(2+opp) != null && tree.lookup(4+opp) != null && tree.lookup(7+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(2+opp) != null && tree.lookup(6+opp) != null && tree.lookup(9+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(8+opp) != null && tree.lookup(4+opp) != null && tree.lookup(1+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
        if(tree.lookup(8+opp) != null && tree.lookup(6+opp) != null && tree.lookup(3+opp) != null)
        {
            //System.out.println("You Lose.");
            tie = 1;
            results = 3;
            reset();
            play();
        }
        else
        {
            count = 0;
        }
    }
    /**
     Constructor function
     @param menu welcome menu
     @param move menu for choosing to move first to second
     @param select menu for choosing x's or o's
     @param yes button to first
     @param no button to go second
     @param x button to use x's
     @param o button to use o's
     @param perfect picture object with the Jerry Tac Toe board
     @param again menu for choosing to play again or not
     @param Ayes button to play again
     @param Ano button to end program/game
     @param draw array to hold info on area where a move is played
     @param type array to hold the value of the move x/o for the user
     @param type2 array to hold the value of the move x/o for the AI
     */
    public TicTacToe()
    {
        addWindowListener( new Closer() );
        setTitle("Jerry Tac Toe");
        setVisible(true);
        setSize(950,672);
        
        menu=new JLabel("Welcome to Jerry Tac Toe");
        move=new JLabel("Would you like to go first?");
        select=new JLabel("Which piece would you like to use?");
        again=new JLabel("Would you like to play again?");
        yes=new JButton("Yes");
        no=new JButton("No");
        x=new JButton("x");
        o=new JButton("o");
        Ayes=new JButton("Yes");
        Ano=new JButton("No");
        perfect=new picture();
        draw = new int[10];
        type = new String[10];
        type2 = new String[10];
        
        // hides the selection menu until the player chooses x's or o's
        move.setVisible(false);
        yes.setVisible(false);
        no.setVisible(false);
        // allows actions to take place if
        // a certain section of coordinates is clicked on
        perfect.addMouseListener(this);
        // allows action to take place if a button is clicked
        yes.addActionListener(this);
        no.addActionListener(this);
        x.addActionListener(this);
        o.addActionListener(this);
        Ayes.addActionListener(this);
        Ano.addActionListener(this);
        
        // use the content pane to put stuff
        // in the window
        stuff=getContentPane();
        
        // use a layout manager to control
        // the way stuff shows up
        stuff.setLayout( new BorderLayout() );
        
        panel=new JPanel();
        // panel with menu info
        panel.add(menu,"North");
        panel.add(move,"North");
        panel.add(select,"North");
        panel.add(yes,"Center");
        panel.add(no,"Center");
        panel.add(x,"South");
        panel.add(o,"South");
        
        // adds the JPanel to the container
        stuff.add(panel,"Center");
    }
    // main method
    public static void main(String [] args)
    {
        JFrame it=new TicTacToe();
    }
}

// data structures
// Binary Search Tree
class BST
{
    private class treenode
    {
        public Comparable item;
        public treenode left, right;
    }
    treenode root;
    int count;
    
    public BST()
    { root=null; count=0; }
    public int size() { return count; }
    public boolean isEmpty()
    { return count==0; }
    public void makeEmpty()
    { root=null; count=0; }
	
    public void insert(Comparable x)
    {
        root=insert(x,root);
        count++;
    }
    private treenode insert(Comparable x,
                            treenode r)
    {
        // base case - empty tree
        if(r==null)
        {
            treenode tn=new treenode();
            tn.item=x;
            tn.left=tn.right=null;
            return tn;
        }
        // recursive cases
        //left side
        if(x.compareTo(r.item)<0)
        { r.left=insert(x,r.left); }
        // right side
        else
        { r.right=insert(x,r.right); }
        return r;
    }
    
    public void print() { print(root); }
    private void print(treenode r)
    {
        if(r==null) return;
        print(r.left);
        System.out.println(r.item);
        print(r.right);
    }
    
    public Comparable lookup(Comparable x)
    {
        return lookup(x,root);
    }
    private Comparable lookup(
                              Comparable x, treenode r)
    {
        // base case
        if(r==null) return null;
        if(x.compareTo(r.item)==0) // found it
        { return r.item; }
        // recursive cases
        else if(x.compareTo(r.item)<0)
        { return lookup(x,r.left); }
        // right side
        else
        { return lookup(x,r.right); }
    }
    
    public void delete(Comparable x)
    {
        root=delete(x,root);
    }
    private treenode delete(Comparable x,
                            treenode r)
    {
        // base case
        if(r==null) return null;
        if(x.compareTo(r.item)==0) // found it
        {
            // 3 cases
            // 0 children case
            if(r.left==null && r.right==null)
            { count--; return null; }
            // 1 child on the left
            else if(r.right==null)
            {
                count--;
                return r.left;
            }
            // 1 child on the right
            else if(r.left==null)
            {
                count--;
                return r.right;
            }
            // 2 children
            else
            {
                Comparable ins=findmin(r.right);
                r.item=ins;
                r.right=delete(ins,r.right);
                return r;
            }
        }
        // recursive cases
        else if(x.compareTo(r.item)<0)
        { 
            r.left=delete(x,r.left);
            return r;
        }
        // right side
        else
        {
            r.right=delete(x,r.right);
            return r;
        }
    }
    private Comparable findmin(treenode r)
    {
        if(r==null) return null;
        if(r.left==null)
        { return r.item; }
        return findmin(r.left);  
    }
    public Comparable getMin()
    {
        return findmin(root);
    }
    
    // iterator/traversal functions
    public static final int PREORDER=0;
    public static final int INORDER=1;
    public static final int POSTORDER=2;
    
    private Queue q;
    
    public void reset(int order)
    {
        q=new QueueLL();
        fillq(root,order);
    }
    
    private void fillq(treenode r, int order)
    {
        if(r==null) return;
        if(order==PREORDER)
            q.enqueue(r.item);
        fillq(r.left,order);
        if(order==INORDER)
            q.enqueue(r.item);
        fillq(r.right,order);
        if(order==POSTORDER)
            q.enqueue(r.item);
    }
    
    public Comparable getNext()
    {
        return (Comparable) q.dequeue();
    }
    
    public boolean hasNext()
    {
        return !q.isEmpty();
    } 
}

// Queue Linked List
class QueueLL implements Queue
{
    private class node
    {
        public Object item;
        public node next;
    }
    node front, back;
    int count;
    
    public QueueLL()
    {
        front=back=null; count=0;
    }
    
    public int size() { return count; }
    public boolean isEmpty()
    { return count==0; }
    public boolean isFull()
    { return false; }
    public void makeEmpty()
    { front=back=null; count=0; }
    public Object getFront()
    {
        return isEmpty()? null : front.item;  
    }
    public Object dequeue()
    {
        if(isEmpty()) return null;
        Object saveit=getFront();
        count--;
        front=front.next;
        if(front==null) back=null;
        return saveit;
    }
    public void enqueue(Object x)
    {
        node newnode=new node();
        newnode.next=null;
        newnode.item=x;
        if(!isEmpty())
            back.next=newnode;
        else
            front=newnode;
        back=newnode;
        count++;
    }
    
}
interface Queue
    {
        public void enqueue(Object x);
        public Object dequeue();
        public Object getFront();
        public int size();
        public boolean isEmpty();
        public boolean isFull();
        public void makeEmpty();
    }