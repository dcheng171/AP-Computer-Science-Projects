import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author David Cheng
 * @version 9/5/18-
 * @author Period: 4
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: N/A
 */
public class Coins
{
    private int myChange;

    /**
     * constructor for # of cents
     * 
     * @param change
     *            amount of change
     */
    public Coins( int change )
    {
        myChange = change;   
    }


    /**
     * Calculates coins necessary for change.
     */
    public void calculate()
    {
        int copyChange = myChange;
        System.out.println( copyChange + " cents =>" );
        int q = copyChange / 25;
        System.out.println( "Quarter(s) \t" + q );
        copyChange %= 25;
        int d = copyChange / 10;
        System.out.println( "Dime(s) \t" + d );
        copyChange %= 10;
        int n = copyChange / 5;
        System.out.println( "Nickel(s) \t" + n );
        copyChange %= 5;
        int p = copyChange;
        System.out.println( "Penny(s) \t" + p );
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getType().getName() 
                                + " " + field.getName() + ":"
                                + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}
