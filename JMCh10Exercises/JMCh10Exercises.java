import java.util.*;


/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author David Cheng
 * @version 10/12/18
 * 
 * @author Period - 4
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - N/A
 */
public class JMCh10Exercises
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }


    
    //10-2(a)
    public boolean endsWithStar( String s )
    {
        return ( !s.equals( "" ) && s.charAt( s.length() - 1 ) == '*' );
    }


    // 10-2(b)
    public boolean endsWith2Stars( String s )
    {
        int length = s.length();
        return ( length >= 4 && s.substring( length - 2 ).equals( "**" ) );
    }


    // 10-6
    public String scroll( String s )
    {
        char firstChar = s.charAt( 0 );
        String newStr = s.substring( 1 ) + firstChar;

        return newStr;
    }


    // 10-7
    public String convertName( String name )
    {
        int commaIndex = 0;

        while ( name.charAt( commaIndex ) != ',' )
        {
            commaIndex++;
        }

        String firstName = name.substring( commaIndex + 2 );
        String lastName = name.substring( 0, commaIndex );

        String newName = firstName + " " + lastName;
        return newName; // FIX THIS!!!
    }


    // 10-8
    public String negate( String str ) // i.e. 1010 --> 0101
    {
        String newStr = str.replace( "0", "2" ); // 1212
        newStr = newStr.replace( "1", "0" ); // 0202
        newStr = newStr.replace( "2", "1" ); // 0101

        return newStr;
    }


    // 10-9
    public boolean isConstant( String s ) // i.e. "aaaa"
    {
        char firstChar = s.charAt( 0 );
        String newStr = s.substring( 1 ) + firstChar;

        return newStr.equals( s );
    }


    // 10-10
    public String removeComment( String str )
    {
        String result = str;
        int firstMark = str.indexOf( "/*" );
        int lastMark = str.indexOf( "*/" );

        if ( firstMark != -1 && lastMark != -1 )
        {
            result = str.substring( 0, firstMark ) + str.substring( lastMark + 2 );
        }

        return result;
    }


    // 10-11
    public String cutOut( String s, String s2 )
    {
        int lengthS2 = s2.length();
        int s2Occur = s.indexOf( s2 );
        String result = s;

        if ( s2Occur != -1 )
        {
            result = s.substring( 0, s2Occur ) + s.substring( s2Occur + lengthS2 );
        }

        return result;
    }


    // 10-14
    public String removeHtmlTags( String str )
    {
        String newStr = str;
        int firstHtmlTag1 = str.indexOf( "<" );
        int firstHtmlTag2 = str.indexOf( ">" );

        if ( firstHtmlTag1 == -1 || firstHtmlTag2 == -1 )
        {
            return newStr;
        }

        String word1 = str.substring( firstHtmlTag1 + 1, firstHtmlTag2 );
        System.out.println( word1 );
        if ( word1.indexOf( " " ) != -1 )
        {
            return newStr;
        }

        int secHtmlTag1 = str.indexOf( "<", firstHtmlTag2 );
        int secHtmlTag2 = str.indexOf( ">", firstHtmlTag2 + 1 );

        if ( secHtmlTag1 == -1 || secHtmlTag2 == -1 )
        {
            return newStr;
        }

        String word2 = str.substring( secHtmlTag1 + 1, secHtmlTag2 );
        System.out.println( word2 );

        if ( word2.equals( "/" + word1 ) )
        {
            newStr = str.substring( 0, firstHtmlTag1 )
                + str.substring( firstHtmlTag2 + 1, secHtmlTag1 )
                + str.substring( secHtmlTag2 + 1 );
        }

        return newStr;
    }


    // 10-15
    public boolean onlyDigits( String s )
    {
        int length = s.length();

        for ( int i = 0; i < length; i++ )
        {
            if ( !Character.isDigit( s.charAt( i ) ) )
            {
                return false;
            }
        }

        return true;
    }


    // 10-20
    public static boolean isValidISBN( String isbn ) //0965485340
    {
        int length = isbn.length();
        int sum = 0;

        if ( isbn.charAt( length - 1 ) == 'X' )
        {
            int multiply = 10;
            for ( int i = 0; i < isbn.length() - 1; i++ )
            {
                sum += multiply * Character.digit( isbn.charAt( i ), 10 );
                multiply--;
            }
            sum += 10;
        }
        else
        {
            int multiply = 10;
            for ( int i = 0; i < isbn.length(); i++ )
            {
                sum += multiply * Character.digit( isbn.charAt( i ), 10 );
                multiply--;
            }
        }

        return ( sum % 11 == 0 );
    }


    // 10-22
    public String shuffle( String s )
    {
        StringBuffer changedStr = new StringBuffer( s );

        int n = changedStr.length();

        while ( n > 1 )
        {
            int randNum = (int)( Math.random() * n );
            char randChar = changedStr.charAt( randNum );
            char char1 = changedStr.charAt( n - 1 );
            
            changedStr.setCharAt( n - 1, randChar );
            changedStr.setCharAt( randNum, char1 );
            n--;
        }

        String newStr = changedStr.toString();

        return newStr;
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println( "endsWithStar(" + end1Star + ") = "
                            + exercise.endsWithStar( end1Star ) );
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println( "endsWithStar(" + ends0Star + ") = "
                            + exercise.endsWithStar( ends0Star ) );
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println( "endsWith2Stars(" + end2Str + ") = "
                            + exercise.endsWith2Stars( end2Str ) );
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println( "endsWith2Stars(" + endsWith1Star + ") = "
                            + exercise.endsWith2Stars( endsWith1Star ) );
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println( "scroll(\"" + scrollStr + "\") --> " + "\""
                            + exercise.scroll( scrollStr ) + "\"" );
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println( "convertName(\"" + convStr + "\") --> " + "\""
                            + exercise.convertName( convStr ) + "\"" );
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println( "negate(\"" + negStr + "\") --> " + "\""
                            + exercise.negate( negStr ) + "\"" );
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println( "isConstant(\"" + constStr1 + "\") = "
                            + exercise.isConstant( constStr1 ) );
                        System.out.println( "isConstant(\"" + constStr2 + "\") = "
                            + exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println( "removeComment(\"" + comment + "\") --> " + "\""
                            + exercise.removeComment( comment ) + "\"" );
                        System.out.println( "removeComment(\"" + notComment + "\") --> " + "\""
                            + exercise.removeComment( notComment ) + "\"" );
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println( "cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> "
                            + "\"" + exercise.cutOut( cutstr, cutOutstr ) + "\"" );
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println( "removeHtmlTags(\"" + htmlStr + "\") --> " + "\""
                            + exercise.removeHtmlTags( htmlStr ) + "\"" );
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println( "onlyDigits(\"" + digitStr + "\") = "
                            + exercise.onlyDigits( digitStr ) );
                        System.out.println(
                            "onlyDigits(\"" + dStr + "\") = " + exercise.onlyDigits( dStr ) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println( "isValidISBN(\"" + validISBN + "\") = "
                            + exercise.isValidISBN( validISBN ) );
                        System.out.println( "isValidISBN(\"" + invalidISBN + "\") = "
                            + exercise.isValidISBN( invalidISBN ) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "abcd";
                        System.out.println( "shuffle(\"" + str + "\") --> " + "\""
                            + exercise.shuffle( str ) + "\"" );
                        System.out.println( "shuffle(\"" + str + "\") --> " + "\""
                            + exercise.shuffle( str ) + "\"" );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
