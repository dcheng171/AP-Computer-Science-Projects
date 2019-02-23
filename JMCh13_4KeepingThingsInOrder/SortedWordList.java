/**
 * Implements a sorted list of words
 * 
 * @author David Cheng
 * @version 11/28/18
 * 
 * @author Period - 4
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - N/A
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    /**
     * Constructor
     */
    public SortedWordList()
    {
        super();
    }


    /**
     * Constructor with given size
     * 
     * @param init
     *            size of list
     */
    public SortedWordList( int init )
    {
        super( init );
    }


    /**
     * Check if a string is inside the list
     * 
     * @param str
     *            to be checked
     * @return whether string is in list (true/false)
     */
    public boolean contains( String str )
    {
        return ( indexOf( str ) != -1 );
    }


    /**
     * Finds index of a string, returns -1 if not found
     * 
     * @param str
     *            to be checked
     * @return index of string
     */
    public int indexOf( String str )
    {
        int left = 0; 
        int right = super.size() - 1;
        int middle;

        while ( left <= right )
        {
            middle = ( left + right ) / 2;

            int diff = str.compareTo( super.get( middle ) );
            if ( diff > 0 )
            {
                left = middle + 1;
            }
            else if ( diff < 0 )
            {
                right = middle - 1;
            }
            else
            {
                return middle;
            }
        }
        return -1;
    }


    /**
     * Puts word into index
     * 
     * @param i
     *            where to put word
     * @param word
     *            string to be added
     * 
     * @return previous string in index
     */
    public String set( int i, String word )
    {
        if ( i - 1 < 0 && super.get( i + 1 ).compareTo( word ) > 0 )
        {
            return super.set( 0, word );
        }
        else if ( i + 1 >= super.size() 
                        && super.get( i - 1 ).compareTo( word ) < 0 )
        {
            return super.set( super.size() - 1, word );
        }
        else if ( super.get( i - 1 ).compareTo( word ) >= 0
            || super.get( i + 1 ).compareTo( word ) <= 0 )
        {
            throw new IllegalArgumentException( "word =" + word + " i = " + i );
        }

        else
        {
            return super.set( i, word );
        }

    }


    /**
     * Adds a word into index i if it alphabetically fits
     * 
     * @param i
     *            index to add word
     * @param word
     *            string to be added
     */
    public void add( int i, String word )
    {
        if ( i <= 0 && word.compareTo( super.get( 0 ) ) < 0 )
        {
            super.add( 0, word );
        }
        else if ( i >= super.size() && 
                        word.compareTo( super.get( super.size() - 1 ) ) > 0 )
        {
            super.add( i, word );
        }
        else if ( word.compareTo( super.get( i - 1 ) ) <= 0
            || word.compareTo( super.get( i ) ) >= 0 )
        {
            throw new IllegalArgumentException( "word =" + word + " i =" + i );
        }

        else
        {
            super.add( i, word );
        }
    }


    /**
     * Adds word alphabetically into list
     * 
     * @param word word to be added
     * 
     * @return whether word was added
     */
    public boolean add( String word )
    {
        if ( contains( word ) )
        {
            return false;
        }
        else if ( super.size() == 0 )
        {
            super.add( word );
            return true;
        }
        else if ( super.size() == 1 )
        {
            if ( word.compareTo( super.get( 0 ) ) > 0 )
            {
                super.add( word );
            }
            else if ( word.compareTo( super.get( 0 ) ) < 0 )
            {
                super.add( 0, word );
            }
            return true;
        }
        else
        {
            int left = 0;
            int right = super.size() - 1;
            int middle;

            while ( left <= right )
            {
                middle = ( left + right ) / 2;

                // int test1 = "Dan".compareTo("Barb");
                // System.out.println( "test1: " + test1 );
                int diff = word.compareTo( super.get( middle ) );
                // System.out.println( word );
                // System.out.println( super.get( middle ) );
                // System.out.println( "diff: " + diff );
                if ( diff > 0 )
                {
                    if ( middle == super.size() - 1 )
                    {
                        super.add( middle + 1, word );
                        return true;
                    }

                    int diff2 = word.compareTo( super.get( middle + 1 ) );
                    if ( diff2 < 0 )
                    {
                        super.add( middle + 1, word );
                        return true;
                    }
                    else
                    {
                        left = middle + 1;
                    }
                }
                else if ( diff < 0 )
                {
                    if ( middle == 0 )
                    {
                        super.add( middle, word );
                        return true;
                    }
                    else
                    {
                        int diff2 = word.compareTo( super.get( middle - 1 ) );
                        if ( diff2 > 0 )
                        {
                            super.add( middle, word );
                            return true;
                        }
                        else
                        {
                            right = middle - 1;
                        }
                    }
                }
            }

            return true;
        }
    }


    /**
     * Combines two lists alphabetically
     * 
     * @param additionalWords
     *            other list to be merged
     */
    public void merge( SortedWordList additionalWords )
    {
        int n = additionalWords.size();

        /*
         * for (int i = 0; i < n; i++) { super.add( "" ); }
         */

        for ( int i = 0; i < n; i++ )
        {
            add( additionalWords.get( i ) );
        }
    }
}
