/**
 * Uses Insertion sort method to sort a list
 *
 * @author David
 * @version Nov 30, 2018
 * @author Period: 4
 * @author Assignment: JMCh13_9BenchmarksSC
 *
 * @author Sources: Gary, Maria Litvin
 */
public class InsertionSort extends StepCount
{
    /**
     * Sorts a[0], ..., a[size-1] in ascending order using Insertion Sort.
     * 
     * @param a
     *            list to be sorted
     */
    public void sort( double[] a )
    {
        addSteps( 1 );
        // n = 1
        for ( int n = 1; n < a.length; n++ )
        {
            addSteps( 3 );
            // 1 - checks n
            // 2 - increments n
            // 3 - sets aTemp
            // Save the next element to be inserted:
            double aTemp = a[n];

            // Going backward from a[n-1], shift elements to the
            // right until you find an element a[i] <= aTemp:
            int i = n;
            addSteps( 1 );
            // 1 - sets i
            while ( i > 0 && aTemp < a[i - 1] )
            {
                addSteps( 4 );
                // 1 - checks i
                // 2 - checks aTemp
                // 3 - sets a[i]
                // 4 - decrements i
                a[i] = a[i - 1];
                i--;
            }

            // Insert the saved element after a[i]:
            addSteps( 1 );
            // 1 - sets a[i]
            a[i] = aTemp;
        }
    }
}
