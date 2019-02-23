import java.util.ArrayList;


/**
 * Represents entire index for a document; list of all its index entries. Will
 * figure which words are present and what lines they occur at.
 *
 * @author David Cheng
 * @version Nov 9, 2018
 * @author Period: 4
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: N/A
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{
    /**
     * Creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
        super();
    }


    /**
     * Creates an empty DocumentIndex with a given initial capacity.
     * 
     * @param initialCapacity
     *            initial size of an arrayList
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    /**
     * If word is not yet in this DocumentIndex, creates a new IndexEntry for
     * word, and inserts it into this list in alphabetical order; adds num to
     * this word's IndexEntry by calling its add(num) method.
     * 
     * @param word
     *            the word found from the input file
     * @param num
     *            line number
     */
    public void addWord( String word, int num )
    {
        int index = foundOrInserted( word );

        super.get( index ).add( num );
    }


    /**
     * For each word in str, calls addWord(word, num).
     * 
     * @param str
     *            all words in a line
     * @param num
     *            line number
     */
    public void addAllWords( String str, int num )
    {
        String[] allWords = str.split( "\\W+" );

        for ( int i = 0; i < allWords.length; i++ )
        {
            if ( !allWords[i].equals( "" ) )
            {
                addWord( allWords[i].toUpperCase(), num );
            }
        }
    }


    /**
     * Tries to find an IndexEntry with a given word in this DocumentIndex.
     * If not found, inserts a new IndexEntry for word at the 
     * appropriate place (in lexicographical order). 
     * Returns the index of the found or inserted IndexEntry
     * 
     * @param word
     *            the word to be checked if already in DocumentIndex
     * @return index where word was found/inserted
     */
    private int foundOrInserted( String word )
    {
        for ( int i = 0; i < super.size(); i++ )
        {
            if ( super.get( i ).getWord().equals( word.toUpperCase() ) )
            {
                return i;
            }
        }

        int ret = 0;
        if ( super.size() == 0 )
        {
            super.add( new IndexEntry( word ) );
        }
        else
        {
            if ( word.compareTo( super.get( 0 ).getWord() ) < 0 )
            {
                super.add( 0, new IndexEntry( word ) );
            }
            else
            {
                for ( int j = 0; j < super.size(); j++ )
                {
                    if ( ( j == super.size() - 1 ) || 
                        word.compareTo( super.get( j ).getWord() ) > 0
                        && word.compareTo( super.get( j + 1 ).getWord() ) < 0 )
                    {
                        ret = j + 1;
                        super.add( j + 1, new IndexEntry( word ) );
                        break;
                    }
                }
            }
        }
        return ret;
    }
}
