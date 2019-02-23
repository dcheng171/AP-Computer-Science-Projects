/**
 * Uses Quick sort method to sort list
 *
 * @author David
 * @version Nov 30, 2018
 * @author Period: 4
 * @author Assignment: JMCh13_9BenchmarksSC
 *
 * @author Sources: Gary, Maria Litvin
 */
public class Quicksort extends StepCount
{
    /**
     * Sorts a[0], ..., a[size-1] in ascending order using the Quicksort
     * algorithm.
     * 
     * @param a
     *            list to be sorted
     */
    public void sort( double[] a )
    {
        recursiveSort( a, 0, a.length - 1 );
    }


    /**
     * Recursive helper method: sorts a[from], ..., a[to]
     * 
     * @param a
     *            list
     * @param from
     *            start
     * @param to
     *            end
     */
    private void recursiveSort( double[] a, int from, int to )
    {

        if ( from >= to )
            return;
        addSteps( 1 );
        // checks from

        // Choose pivot a[p]:
        int p = ( from + to ) / 2;
        // The choice of the pivot location may vary:
        // you can also use p = from or p = to or use
        // a fancier method, say, the median of the above three.
        addSteps( 1 );
        // inits p

        // Partition:

        int i = from;
        int j = to;
        addSteps( 2 );
        // inits i and j
        while ( i <= j )
        {
            addSteps( 1 );
            // checks i
            if ( a[i] <= a[p] )
            {
                addSteps( 2 );
                // 1 - checks a[i]
                // increments i
                i++;
            }
            else if ( a[j] >= a[p] )
            {
                addSteps( 3 );
                // 1 - checks previous if statement
                // 2 - checks a[j]
                // 3 - decrements j
                j--;
            }
            else
            {
                addSteps( 7 );
                // 1 - checked previous if statement
                // 2 - checks else if statement
                // 3 to 5 - swap
                // 6 - increment i
                // 7 - decrement j
                swap( a, i, j );
                i++;
                j--;
            }
        }

        // Finish partitioning:

        if ( p < j ) // place the pivot in its correct position
        {
            addSteps( 5 );
            // 1 - checks p
            // 2 - 4 - swap
            // 5 - sets p
            swap( a, j, p );
            p = j;
        }
        else if ( p > i )
        {
            addSteps( 6 );
            // 1 - checks previous if
            // 2 - checks p
            // 3 - 5 - swap
            // 6 - sets p
            swap( a, i, p );
            p = i;
        }

        // Sort recursively:
        recursiveSort( a, from, p - 1 );
        recursiveSort( a, p + 1, to );
    }
}
