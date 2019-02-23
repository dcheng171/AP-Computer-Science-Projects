/**
 * Switches every e in a phrase with #
 * 
 * @author David Cheng
 * @version 10/8/18
 * 
 * @author Period - 4
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - N/A
 */
public class LipogramAnalyzer
{
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        String newStr = "";
        for ( int i = 0; i < text.length(); i++ )
        {
            if ( text.charAt( i ) == letter )
            {
                newStr += "#";
            }
            else
            {
                newStr += text.charAt( i );
            }
        }

        return newStr;
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        String result = "";

        for ( int i = 0; i < text.length(); i++ )
        {
            if ( Character.isLetter( text.charAt( i ) ) )
            {

                if ( text.charAt( i ) == letter 
                                && ( i - 1 ) >= 0 && ( i + 1 ) < text.length()
                                && !Character.isLetter( text.charAt( i - 1 ) )
                                && !Character.isLetter( text.charAt( i + 1 ) )
                                && result.indexOf( "\n" + letter + "\n" ) == -1
                                && result.charAt( 0 ) != letter )
                {
                    result += ( text.charAt( i ) + "\n" );
                }

                else if ( i == text.length() - 1 
                                && text.charAt( text.length() - 1 ) == letter
                                && !Character.isLetter( text.charAt( i - 1 ) ) )
                {
                    result += ( letter + "\n" );
                }

                String word = extractWord( i );
                if ( word.indexOf( letter ) != -1 )
                {
                    if ( result.indexOf( word ) == -1 )
                    {
                        result += ( word + "\n" );
                    }
                }
            }
        }

        return result;
    }


    // made public for test purposes
    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        int i = pos;
        while ( i < text.length() && Character.isLetter( text.charAt( i ) ) )
        {
            i++;
        }

        int j = pos;
        while ( j >= 0 && Character.isLetter( text.charAt( j ) ) )
        {
            j--;
        }

        return text.substring( j + 1, i );
    }
}
