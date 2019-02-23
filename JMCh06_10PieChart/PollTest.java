/**
 * Creates a new voting poll test
 *
 * @author David Cheng
 * @version 9/12/18
 * @author Period: 4
 * @author Assignment: JMCh06_10PieChart
 *
 * @author Sources: None
 */
public class PollTest
{
    /**
     * Creates three candidates, with voting
     * 
     * @param args is not used
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new PollDisplayPanel( "Tami",
            "Brian", "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
