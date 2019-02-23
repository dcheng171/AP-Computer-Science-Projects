import java.util.Scanner;


/**
 * Translates an English phrase into piglatin.
 * 
 * @author David Cheng
 * @version 10/18/18
 * 
 * @author Period - 4
 * @author Assignment - PigLatinator
 * 
 * @author Sources - N/A
 */
public class PiglatinAnalyzer
{
    private String text;


    /**
     * Constructor: saves the text string
     * 
     * @param text
     */
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";

        for ( int i = 0; i < phraseToTranslate.length(); i++ )
        {
            char character = phraseToTranslate.charAt( i );

            if ( !Character.isLetter( character ) )
            {
                int j = i - 1;
                if ( j >= 0 && Character.isLetter( phraseToTranslate.charAt( j ) ) )
                {
                    String word = extractWord( j );
                    String pigLatinWord = wordToPigLatin( word );
                    translation += pigLatinWord + character;
                }
                else
                {
                    translation += character;
                }
            }

            else if ( i == phraseToTranslate.length() - 1 )
            {
                int j = i - 1;
                String word = extractWord( j );
                String pigLatinWord = wordToPigLatin( word );
                translation += pigLatinWord;
            }
        }

        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        boolean vowelPresent = false;
        int i;

        for ( i = 0; i < englishWord.length(); i++ )
        {
            char charOfWord = englishWord.charAt( i );
            if ( charOfWord == 'a' || charOfWord == 'e' || charOfWord == 'i' || charOfWord == 'o'
                || charOfWord == 'u' || charOfWord == 'A' || charOfWord == 'E' || charOfWord == 'I'
                || charOfWord == 'O' || charOfWord == 'U' )
            {
                vowelPresent = true;
                break;
            }
        }

        if ( !vowelPresent )
        {
            pigLatinWord = englishWord + "ay";
        }
        else
        {
            if ( i == 0 )
            {
                pigLatinWord = englishWord + "yay";
            }
            else
            {
                String start = englishWord.substring( 0, i );
                String end = englishWord.substring( i );
                if ( Character.isUpperCase( englishWord.charAt( 0 ) ) )
                {
                    end = Character.toUpperCase( end.charAt( 0 ) ) + end.substring( 1 );
                    start = Character.toLowerCase( start.charAt( 0 ) ) + start.substring( 1 );
                }
                pigLatinWord = end + start + "ay";
            }
        }

        return pigLatinWord;
    }


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
