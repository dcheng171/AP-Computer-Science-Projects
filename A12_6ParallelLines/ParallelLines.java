import java.awt.*;
import javax.swing.*;


/**
 * Creates an illusion with parallel lines.
 * 
 * @author David Cheng
 * @version 9/12/18
 * 
 *          Period - 4 Assignment - A12.6 - ParallelLines
 * 
 *          Sources - N/A
 */
public class ParallelLines extends JPanel
{
    private int xOffset = 0;

    private int startY = 0;


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * Creates parallel line illusion
     * 
     * @param g
     *            Graphics
     * @param width
     *            width of gui
     * @param height
     *            height of gui
     * @param size
     *            size of gui
     */
    public void drawIllusion( Graphics g, int width, int height )
    {

        for ( int row = 0; row < 8; row++ )
        {
            for ( int col = 0; col < 14; col++ )
            {
                if ( col % 2 == 0 )
                {
                    g.drawLine( xOffset + col * width / 14,
                        startY,
                        xOffset + col * width / 14,
                        height / 8 + startY );
                    g.drawLine( ( col + 1 ) * width / 14,
                        xOffset,
                        ( col + 1 ) * width / 14,
                        height / 8 );
                    g.fillRect( xOffset + col * width / 14 + 1, startY, width / 14, height / 8 );
                }
                else
                {
                    g.drawLine( xOffset + col * width / 14,
                        startY,
                        xOffset + col * width / 14,
                        height / 8 + startY );
                    g.drawLine( ( col + 1 ) * width / 14,
                        xOffset,
                        ( col + 1 ) * width / 14,
                        height / 8 );
                }
            }

            g.drawLine( 0, height / 8 + startY, width, height / 8 + startY );
            startY += height / 8;
            if ( row <= 1 )
            {
                xOffset += 0.25 * width / 14;
            }
            else if ( row > 1 && row <= 3 )
            {
                xOffset -= 0.25 * width / 14;
            }
            else if ( row > 3 && row <= 5 )
            {
                xOffset += 0.25 * width / 14;
            }
            else if ( row > 5 && row <= 7 )
            {
                xOffset -= 0.25 * width / 14;
            }

        }
    }


    /**
     * Creates interface and calls parallel lines
     * 
     * @param args
     *            not used
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
