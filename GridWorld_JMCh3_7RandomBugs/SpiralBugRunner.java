import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.UnboundedGrid;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


/**
 * Creates a world with bugs that will move in a spiral
 * 
 * @author David Cheng
 * @version 9/1/18
 * 
 * @author Period - 4
 * @author Assignment - GridWorld Part 2, Exercise 2 - SpiralBugRunner
 * 
 * @author Sources - None
 */
public class SpiralBugRunner
{
    /**
     * Creates a world with bugs
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        UnboundedGrid grid = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld( grid );
        SpiralBug jerry = new SpiralBug( 6 );
        jerry.setColor( Color.ORANGE );
        world.add( new Location( 7, 8 ), jerry );
        world.show();
    }
}