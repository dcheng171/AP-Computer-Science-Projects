import info.gridworld.actor.Bug;


/**
 * A bug that will run in a circle
 * 
 * @author David Cheng
 * @version 9/1/18
 * 
 * @author Period - 3
 * @author Assignment - GridWorld Part 2, Random bugs - CircleBug
 * 
 * @author Sources - None
 */
public class CircleBug extends Bug
{
    private int steps;

    private int sideLength;


    /**
     * Constructs a circle bug that traces a circle of a given side length
     * 
     * @param length
     *            the side length
     */
    public CircleBug( int length )
    {
        steps = 0;
        sideLength = length;
    }


    /**
     * Moves to the next location of the square.
     */
    public void act()
    {
        if ( steps < sideLength && canMove() )
        {
            move();
            steps++;
        }
        else
        {
            turn();
            // turn();
            steps = 0;
        }
    }
}
