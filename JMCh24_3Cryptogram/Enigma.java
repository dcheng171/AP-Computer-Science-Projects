/**
 * A coder/decoder for the cipher
 * 
 * @author David Cheng
 * @version 2/11/19
 * 
 * @author Period - 4
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 * @author Sources - n/a
 */
public class Enigma
{
    private char[] lookupTable;

    /**
     * constructor
     * @param numLetters number of letters
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * substitutes ch in index of of lookupTable
     * @param index position
     * @param ch character
     */
    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }

    /**
     * decodes text
     * @param text text to be decoded
     * @return the decoded text
     */
    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );

        for ( int i = 0; i < text.length(); i++ )
        {
            char character = text.charAt( i );

            int index = 0;

            if ( Character.isLowerCase( character ) )
            {
                index = Character.getNumericValue( character ) - 
                                Character.getNumericValue( 'a' );
                buffer.append( ( "" + lookupTable[index] ).toLowerCase() );

            }
            else if ( Character.isUpperCase( character ) )
            {
                index = Character.getNumericValue( character ) - 
                                Character.getNumericValue( 'A' );
                buffer.append( ( "" + lookupTable[index] ).toUpperCase() );
            }
            else
            {
                buffer.append( character );
            }

        }

        return buffer.toString();
    }


    /**
     * produces hints for the possible reference of the encrypted letter
     * @param text text to be examined
     * @param lettersByFrequency standard frequency letters in english
     * @return new frequency of letters
     */
    public String getHints( String text, String lettersByFrequency )
    {
        int[] freqLetters = countLetters( text );

        int pos;

        String result = "";

        for ( int i = 0; i < freqLetters.length; i++ )
        {
            pos = 0;

            for ( int j = 0; j < freqLetters.length; j++ )
            {
                if ( freqLetters[j] < freqLetters[i] || 
                                freqLetters[j] == freqLetters[i] && j < i )
                {
                    pos++;
                }
            }

            result += lettersByFrequency.charAt( pos );

        }

        return result;
    }


    /**
     * counts number of occurrences of each letter in text
     * @param text text to be examined
     * @return array of number of occurrences of each letter in text
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        for ( int i = 0; i < text.length(); i++ )
        {
            String character = text.substring( i, i + 1 );

            char ch = character.charAt( 0 );

            if ( ch >= 'A' && ch <= 'Z' )
            {
                int index = Character.getNumericValue( ch ) - 
                                Character.getNumericValue( 'A' );

                counts[index]++;
            }
            else if ( ch >= 'a' && ch <= 'z' )
            {
                int index = Character.getNumericValue( ch ) - 
                                Character.getNumericValue( 'a' );

                counts[index]++;
            }
        }

        return counts;
    }
    
    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    /**
     * gets lookup table
     * @return the lookup table
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     * calls getCountLetters method
     * @param text text to be examined
     * @return result of countLetters
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }
}