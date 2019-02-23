import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;


/**
 * Creates a Jumper and puts it into GridWorld.
 *
 * @author David Cheng + Aman Choudhary
 * @version 10/26/18
 * @author Period: 4
 * @author Assignment: GridWorld_Part3_Jumper
 *
 * @author Sources: N/A
 */
public class JumperRunner
{
    /**
     * creates jumper and puts into gridworld
     * 
     * @param args
     *            no args
     */
    public static void main( String[] args )
    {
        ActorWorld world = new ActorWorld();
        Jumper jumper1 = new Jumper();

        Location loc1 = new Location( 3, 3 );
        Location loc2 = new Location( 1, 3 );

        Location loc3 = new Location( 3, 4 );
        Location loc4 = new Location( 1, 4 );

        Jumper jumper2 = new Jumper();
        Rock rock1 = new Rock();
        Flower flower1 = new Flower();

        world.add( loc1, jumper1 );
        world.add( loc2, rock1 );
        world.add( loc3, jumper2 );
        world.add( loc4, flower1 );
        world.show();
    }
}