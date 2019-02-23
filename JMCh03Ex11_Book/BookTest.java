/**
 *  This is a class that tests the Book class.
 *
 *  @author  David Cheng 
 *  @version 8/31/18
 *  @author  Period: 4
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: None
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
       Book book1 = new Book(3);
       System.out.println( book1.getNumPages() );
       System.out.println( book1.getCurrentPage() );
       book1.nextPage();
       System.out.println( book1.getCurrentPage() );
       book1.nextPage();
       System.out.println( book1.getCurrentPage() );
       book1.nextPage();
       System.out.println( book1.getCurrentPage() );
       
    }
}
