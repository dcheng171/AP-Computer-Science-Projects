import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.Color;


/**
 * Creates the world and bugs that will do the circle run
 * 
 * @author David Cheng
 * @version 9/1/18
 * 
 * @author Period - 4
 * @author Assignment - GridWorld Part 2, Random Bugs - CircleBugRunner
 * 
 * @author Sources - None
 */
public class CircleBugRunner
{

    /**
     * Creates a gridworld with bugs
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        CircleBug alice = new CircleBug( 6 );
        alice.setColor( Color.ORANGE );
        CircleBug bob = new CircleBug( 3 );
        world.add( new Location( 7, 8 ), alice );
        world.add( new Location( 5, 5 ), bob );
        world.show();
    }
}