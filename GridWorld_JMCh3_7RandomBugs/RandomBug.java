import info.gridworld.actor.Bug;
import java.awt.Color;

/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move

 * @author  David Cheng
 * @version 8/31/18
 *
 * @author  Period - 4
 * @author  Assignment - Random Bugs - UTurnBug
 *
 * @author  Sources - None
 */
public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }

    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }

    public void turn(int angle)
    {
        setDirection(getDirection() + angle);
    }

    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() )
            move();
        else
            turn();
    }
}
