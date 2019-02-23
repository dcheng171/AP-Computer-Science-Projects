import java.util.ArrayList;


/**
 * Defines an object that has a word, and a list numbers, which store the line
 * numbers where the word occurs
 *
 * @author David
 * @version Nov 9, 2018
 * @author Period: 4
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: N/A
 */
public class IndexEntry
{
    private String word;

    private ArrayList<Integer> numsList;


    /**
     * Constructs an IndexEntry for a given word (converted to upper case);
     * sets numsList to an empty ArrayList.
     * 
     * @param word
     *            a word
     */
    public IndexEntry( String word )
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    /**
     * Returns the word of this IndexEntry object.
     * 
     * @return the word
     */
    public String getWord()
    {
        return word;
    }


    /**
     * If num is not already in the list, adds num at the end of this
     * IndexEntry's list of numbers.
     * 
     * @param num
     *            line number
     */
    public void add( int num )
    {
        if ( !numsList.contains( num ) )
        {
            numsList.add( num );
        }
    }


    /**
     * Converts this IndexEntry into a string in the following format: the word
     * followed by a space, followed by numbers separated by a comma and a
     * space.
     * 
     * @return word with list of numbers separated by spaces and commas
     */
    public String toString()
    {
        String nums = numsList.get( 0 ).toString();

        for ( int i = 1; i < numsList.size(); i++ )
        {
            nums += ", " + numsList.get( i );
        }

        return ( word + " " + nums );
    }
}
