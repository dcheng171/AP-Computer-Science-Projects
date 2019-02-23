/**
 * Uses Selection sort method to sort list
 *
 * @author David
 * @version Nov 30, 2018
 * @author Period: 4
 * @author Assignment: JMCh13_9BenchmarksSC
 *
 * @author Sources: Gary, Maria Litvin
 */
public class SelectionSort extends StepCount
{
    /**
     * Sorts a[0], ..., a[size-1] in ascending order using Selection Sort.
     * 
     * @param a
     *            list to be sorted
     */
    public void sort( double[] a )
    {
        addSteps( 1 ); // initialize n
        for ( int n = a.length; n > 1; n-- )
        {
            addSteps( 3 );
            // 1 - check if n > 1
            // 2 - n--
            // 3 - initializes i to 1
            // Find the index iMax of the largest element
            // among a[0], ..., a[n-1]:

            int iMax = 0;
            for ( int i = 1; i < n; i++ )
            {
                addSteps( 3 );
                // 1 - checks if i < n
                // 2 - increments i
                // 3 - if statement
                if ( a[i] > a[iMax] )
                {
                    addSteps( 1 ); // let iMax = i
                    iMax = i;
                }
            }

            addSteps( 3 );
            // Swap takes three steps
            // Swap a[iMax] with a[n-1]:
            swap( a, iMax, n - 1 );

            // Decrement n (accomplished by n-- in the for loop).
        }
    }
}
