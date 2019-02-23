
// This applet displays a message moving horizontally
// across the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BannerAlt extends JApplet implements ActionListener
{
    private int xPos, yPos; // hold the coordinates of the banner

    private int msgID = 1;


    public void init()
    {
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        xPos = c.getWidth();
        yPos = c.getHeight() / 2;
        Timer clock = new Timer( 2000, this ); // fires every 30 milliseconds
        clock.start();
    }


    // Called automatically after a repaint request
    public void paint( Graphics g )
    {
        Container c = getContentPane();
        int xPos = c.getWidth() / 2 - 30;
        int yPos = c.getHeight() / 2;
        super.paint( g );
        if ( msgID == 1 )
        {
            g.drawString( "East or West", xPos, yPos );
        }
        else // if msgID == -1
        {
            g.drawString( "Java is Best", xPos, yPos );
        }
    }


    // Called automatically when the timer fires
    public void actionPerformed( ActionEvent e )
    {
        Container c = getContentPane();

        msgID = -msgID;

        repaint();

        // Adjust the horizontal position of the banner:
        xPos--;
        if ( xPos < -100 )
        {
            xPos = c.getWidth();
        }

        // Set the vertical position of the banner:
        yPos = c.getHeight() / 2;

        repaint();
    }
}
