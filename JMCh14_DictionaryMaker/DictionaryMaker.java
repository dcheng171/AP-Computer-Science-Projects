import java.util.Scanner;
import java.io.*;


/**
 * Goes through a dictionary input file and prints out words that are between 3
 * to 5 letters long
 * 
 * @author David Cheng
 * @version 11/19/18
 * 
 * @author Period - 4
 * @author Assignment - JM Ch14 - DictionaryMaker
 * 
 * @author Sources - N/A
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;

    public static Scanner fileIn; // public for test purposes

    public static PrintWriter fileOut; // public for test purposes


    /**
     * Creates input and output files
     * 
     * @param args
     *            no args
     * @throws IOException
     *             if input or output file cannot be found
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kboard = new Scanner( System.in );

        System.out.println();
        System.out.print( "Enter input file name: " );
        String fileName = kboard.next();

        openInputFile( fileName );
        if ( fileIn == null )
        {
            System.out.println( "*** Can't open " + fileName + " ***" );
            return;
        }

        createOutputFile( "RamblecsDictionary.java" );
        if ( fileOut == null )
        {
            fileIn.close();
            System.out.println( "*** Can't create RamblecsDictionary.java ***");
            return;
        }

        int count = copyWords();
        System.out.println( "Done: " + count + " words." );

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     * 
     * @param fileName
     *            name of input file
     */
    public static void openInputFile( String fileName )
    {
        File file = new File( fileName );

        try
        {
            fileIn = new Scanner( file );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "*** Cannot open " + fileName + " ***" );

            System.exit( 1 ); // quit the program
        }
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     * 
     * @param fileName
     *            name of output file
     */
    public static void createOutputFile( String fileName )
    {
        File file = new File( fileName );

        try
        {
            fileOut = new PrintWriter( file );
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "*** Cannot open " + fileName + " ***" );
            System.exit( 1 ); // quit the program
        }

    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {
        fileOut.print( "" + "public class RamblecsDictionary\r\n" + "{\r\n"
            + "  public String words[] =\r\n" + "  {\r\n" );
        int lineNum = 0;
        while ( fileIn.hasNextLine() == true )
        {
            lineNum++;
            String word = fileIn.nextLine().toUpperCase();
            if ( word.length() >= 3 && word.length() <= 5 )
            {
                fileOut.println( "\t\"" + word + "\"," );
            }
        }

        fileOut.print( "  };\r\n" + "}" );

        return lineNum;
    }
}
