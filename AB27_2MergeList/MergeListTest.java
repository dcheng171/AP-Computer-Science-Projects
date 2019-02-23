import java.util.*;


/**
 * Tests MergeSort class
 *
 * @author David
 * @version Dec 8, 2018
 * @author Period: 4
 * @author Assignment: AB27_2MergeList
 *
 * @author Sources: N/A
 */
public class MergeListTest
{
    /**
     * Test program for the MergeList class
     * 
     * @param args
     *            Command line arguments (not used)
     */
    public static void main( String[] args )
    {
        MergeList mList = new MergeList( "file20.txt" );
        LinkedList<Item> list = new LinkedList<Item>();

        System.out.println( "Original list\n" );
        mList.readData( list );
        mList.printList( list );

        System.out.println( "List after MergeSort\n" );
        list = mList.mergeSort( list );
        mList.printList( list );

        System.out.println( "Reversed list\n" );
        list = mList.reverseList( list );
        mList.printList( list );
    }
}
