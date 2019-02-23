/**
 *  Rolls dice 
 *
 *  @author  dcheng171
 *  @version Sep 18, 2018
 *  @author  Period: 4
 *  @author  Assignment: JMCh07_RollingDice
 *
 *  @author  Sources: N/A
 */
public class DieTest
{
    public static void main( String[] args )
    {
        Die die = new Die();
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
        die.roll();
        System.out.println( die.getNumDots() );
    }
}
