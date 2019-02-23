import info.gridworld.actor.Bug;
import java.awt.Color;


/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move
 * 
 * @author David Cheng
 * @version 9/1/18
 *
 * @author Period - 4
 * @author Assignment - Random Bugs - UTurnBug
 *
 * @author Sources - None
 */
public class UTurnBug extends Bug
{
    /**
     * Sets a bug with color yellow
     */
    public UTurnBug()
    {
        setColor( Color.YELLOW );
    }


    /**
     * Sets a bug with a given color
     * 
     * @param bugColor
     *            color of bug
     */
    public UTurnBug( Color bugColor )
    {
        setColor( bugColor );
    }


    /**
     * Turns 4 times (moving in a square)
     * 
     */
    public void turnAround()
    {
        turn();
        turn();
        turn();
        turn(); // Or: setDirection(getDirection() + 180);
    }


    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() )
            move();
        else
            turnAround();
    }
}
