/**
 * Uses merge sort algorithm to sort list
 *
 * @author David
 * @version Nov 30, 2018
 * @author Period: 4
 * @author Assignment: JMCh13_9BenchmarksSC
 *
 * @author Sources: Gary, Maria Litvin
 */
public class Mergesort extends StepCount
{
    private double[] temp;


    /**
     * Sorts a[0], ..., a[size-1] in ascending order using the Mergesort
     * algorithm.
     * 
     * @param a
     *            list to be sorted
     */
    public void sort( double[] a )
    {
        addSteps( 2 );
        // 1 - letting n = a.length
        // 2 - letting temp = new double[n]
        int n = a.length;
        temp = new double[n];
        recursiveSort( a, 0, n - 1 );
    }


    /**
     * Recursive helper method: sorts a[from], ..., a[to]
     * 
     * @param a
     *            list to be sorted
     * @param from
     *            start
     * @param to
     *            end
     */
    private void recursiveSort( double[] a, int from, int to )
    {

        if ( to - from < 2 ) // Base case: 1 or 2 elements
        {
            addSteps( 1 );
            // if comparison
            if ( to > from && a[to] < a[from] )
            {
                addSteps( 2 );
                // two comparisons in if statement
                addSteps( 3 );
                // swap takes three steps
                double aTemp = a[to]; // swap a[to] and a[from]
                a[to] = a[from];
                a[from] = aTemp;
            }
        }
        else // Recursive case
        {
            addSteps( 2 );
            // 1 - else statement
            // 2 - change middle
            int middle = ( from + to ) / 2;
            recursiveSort( a, from, middle );
            recursiveSort( a, middle + 1, to );
            merge( a, from, middle, to );
        }
    }


    /**
     * Merges a[from] ... a[middle] and a[middle+1] ... a[to] into one sorted
     * array a[from] ... a[to]
     * 
     * @param a
     *            list
     * @param from
     *            start
     * @param middle
     *            middle of list
     * @param to
     *            end
     */
    private void merge( double[] a, int from, int middle, int to )
    {
        addSteps( 3 );
        // 3 initializations
        int i = from;
        int j = middle + 1;
        int k = from;

        // While both arrays have elements left unprocessed:
        while ( i <= middle && j <= to )
        {
            addSteps( 2 );
            // 1 - checks i
            // 2 - checks j
            if ( a[i] < a[j] )
            {
                addSteps( 3 );
                // 1 - if comparison
                // 2 - setting temp[k]
                // 3 - incrementing i
                temp[k] = a[i]; // Or simply temp[k] = a[i++];
                i++;
            }
            else
            {
                addSteps( 3 );
                // 1 - else statement
                // 2 - setting temp[k]
                // 3 - incrementing j
                temp[k] = a[j];
                j++;
            }
            addSteps( 1 );
            // 1 - incrementing k
            k++;
        }

        // Copy the tail of the first half, if any, into temp:
        while ( i <= middle )
        {
            addSteps( 4 );
            // 1 - check i
            // 2 - setting temp[k]
            // 3 - incrementing i
            // 4 - incrementing k
            temp[k] = a[i]; // Or simply temp[k++] = a[i++]
            i++;
            k++;
        }

        // Copy the tail of the second half, if any, into temp:
        while ( j <= to )
        {
            addSteps( 4 );
            // 1 - checking j
            // 2 - setting temp
            // 3 - incrementing j
            // 4 - incrementing k
            temp[k] = a[j]; // Or simply temp[k++] = a[j++]
            j++;
            k++;
        }

        addSteps( 1 );
        // initializing k
        // Copy temp back into a
        for ( k = from; k <= to; k++ )
        {
            addSteps( 3 );
            // 1 - checking k <= to
            // 2 - incrementing k
            // 3 - setting a[k]
            a[k] = temp[k];
        }
    }
}
