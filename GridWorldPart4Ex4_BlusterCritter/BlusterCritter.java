import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Rock;

import java.awt.Color;

import java.util.ArrayList;


/**
 * Class for BlusterCritter, which changes its shade of color based on number of
 * neighbors two steps within its current position
 *
 * @author David Cheng
 * @version 11/13/18
 * @author Period: 4
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 * @author Sources: N/A
 */
public class BlusterCritter extends Critter
{
    private int c;

    private static final double DARKENING_FACTOR = 0.05;


    /**
     * constructor for BlusterCritter
     * 
     * @param c
     *            how much courage BlusterCritter has
     */
    public BlusterCritter( int c )
    {
        this.c = c;
    }


    /**
     * creates a list of actors the critter wants to process <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();

        int blusterRow = super.getLocation().getRow();
        int blusterCol = super.getLocation().getCol();

        // System.out.println( "BlusterRow: " + blusterRow );
        // System.out.println( "BlusterCol: " + blusterCol );

        int totalRow = gr.getNumRows();
        int totalCol = gr.getNumCols();

        // System.out.println( totalRow );
        // System.out.println( totalCol );

        int startRow = blusterRow - 2;
        int startCol = blusterCol - 2;
        int endRow = blusterRow + 2;
        int endCol = blusterCol + 2;

        if ( startRow < 0 )
        {
            startRow = 0;
        }
        if ( startCol < 0 )
        {
            startCol = 0;
        }
        if ( endRow > totalRow - 1 )
        {
            endRow = totalRow - 1;
        }
        if ( endCol > totalCol - 1 )
        {
            endCol = totalCol - 1;
        }

        // System.out.println( "BlusterRow: " + blusterRow );
        // System.out.println( "BlusterCol: " + blusterCol );
        // System.out.println( "startRow: " + startRow );
        // System.out.println( "startCol: " + startCol );
        // System.out.println( "endRow: " + endRow );
        // System.out.println( "endCol: " + endCol );

        for ( int i = startRow; i <= endRow; i++ )
        {
            for ( int j = startCol; j <= endCol; j++ )
            {
                Location loc = new Location( i, j );
                Actor actor = gr.get( loc );

                if ( actor instanceof Rock )
                {
                    actors.add( actor );
                }
                
                else if (actor instanceof BlusterCritter)
                {
                    if (i != blusterRow || j != blusterCol)
                    {
                        actors.add( actor );
                    }
                }
            }
        }

        return actors;
    }


    /**
     * Counts number of actors within 2 steps of BlusterCritter <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {

        /*for ( int i = 0; i < actors.size(); i++ )
        {
            System.out.println( actors.get( i ).toString() );
        }*/

        int size = actors.size();

        if ( size >= c )
        {
            darken();
        }
        else
        {
            lighten();
        }
    }


    /**
     * Darkens the BlusterCritter
     */
    private void darken()
    {
        Color color = getColor();
        int red = (int)Math.max( color.getRed() * 
            ( 1 - DARKENING_FACTOR ), 0 );
        int green = (int)Math.max( color.getGreen() * 
            ( 1 - DARKENING_FACTOR ), 0 );
        int blue = (int)Math.max( color.getBlue() * 
            ( 1 - DARKENING_FACTOR ), 0 );

        setColor( new Color( red, green, blue ) );
    }


    /**
     * Lightens the BlusterCritter
     */
    private void lighten()
    {
        Color color = getColor();
        int red = (int)Math.min( color.getRed() * 
            ( 1 + DARKENING_FACTOR ), 255 );
        int green = (int)Math.min( color.getGreen() * 
            ( 1 + DARKENING_FACTOR ), 255 );
        int blue = (int)Math.min( color.getBlue() * 
            ( 1 + DARKENING_FACTOR ), 255 );

        setColor( new Color( red, green, blue ) );
    }
}
