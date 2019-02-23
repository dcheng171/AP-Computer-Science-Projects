import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author David Cheng + Aman Choudhary
 * @version 10/19/18
 * @author Period: 4
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 * @author Sources: N/A
 */
public class Jumper extends Bug implements Edible
{
    /**
     * Calls the Bug's constructor
     */
    public Jumper()
    {
        super();
    }


    /**
     * Calls the Bug's removeSelfFromGrid method
     */
    public void removeSelfFromGrid()
    {
        super.removeSelfFromGrid();
    }


    /**
     * The jumper either moves forward two spaces or turns, depending on the
     * conditions
     */
    public void act()
    {
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() );
        Location nextNext = next.getAdjacentLocation( getDirection() );
        // if wall is one space in front of actor
        // if wall is two space in front of actor
        // if another actor is two spaces in front of jumper
        // if a rock or flower is two spaces in front of jumper

        if ( !canMove() )
        {
            turn();
        }
        else
        {
            moveTo( nextNext );
        }

    }


    /**
     * Checks if the bug is capable of moving or not, depending on the current
     * conditions
     * 
     * @return whether jumper can move 
     */
    public boolean canMove()
    {

        Grid<Actor> gr = getGrid();
        if ( gr == null )
        {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation( getDirection() );
        Location nextNext = next.getAdjacentLocation( getDirection() );

        if ( !gr.isValid( nextNext ) )
        {
            return false;
        }

        Actor neighbor = gr.get( nextNext );
        return ( neighbor == null )
            || ( !( neighbor instanceof Rock ) 
                            && !( neighbor instanceof Flower ) );
    }
}