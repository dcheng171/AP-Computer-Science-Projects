import java.util.*;


/**
 * RPN Calculator
 *
 * @author David Cheng
 * @version 1/18/19
 * @author Period: 4
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: n/a
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * Calculates an expression written in reverse polish notation
     */
    public void calculate()
    {
        while ( scan.hasNext() )
        {
            String input = scan.next();

            for ( int i = 0; i < input.length(); i++ )
            {
                char letter = input.charAt( i );

                if ( !( letter == 'q' || letter == 'Q' ) )
                {
                    myQ.add( letter + "" );
                }

                if ( letter == 'q' || letter == 'Q' )
                {
                    System.out.println( toString() + "= " + myStack.pop() );
                }
                else if ( letter == '+' )
                {
                    add();
                }
                else if ( letter == '-' )
                {
                    subtract();
                }
                else if ( letter == '*' )
                {
                    multiply();
                }
                else if ( letter == '/' )
                {
                    divide();
                }
                else
                {
                    myStack.push( Character.getNumericValue( letter ) );
                }
            }
        }
    }


    /**
     * adds two previous num
     */
    public void add()
    {
        int num1 = myStack.pop();
        int num2 = myStack.pop();

        int sum = num1 + num2;

        myStack.push( sum );
    }


    /**
     * subtracts two previous num
     */
    public void subtract()
    {
        int num1 = myStack.pop();
        int num2 = myStack.pop();

        int sub = num2 - num1;

        myStack.push( sub );
    }


    /**
     * multiplies two previous num
     */
    public void multiply()
    {
        int num1 = myStack.pop();
        int num2 = myStack.pop();

        int prod = num1 * num2;

        myStack.push( prod );
    }


    /**
     * divides two previous num
     */
    public void divide()
    {
        int num1 = myStack.pop();
        int num2 = myStack.pop();

        int quot = num2 / num1;

        myStack.push( quot );
    }


    /**
     * converts the myQ to string
     * 
     * @returns myQ in string form
     */
    public String toString()
    {
        String res = "";
        while ( !myQ.isEmpty() )
        {
            res += myQ.remove() + " ";
        }
        return res;
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}