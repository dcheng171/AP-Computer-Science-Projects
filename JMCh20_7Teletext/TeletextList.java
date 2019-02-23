import java.awt.Graphics;


/**
 * Implements the list of messages for teletext
 *
 * @author David Cheng
 * @version Jan 8, 2019
 * @author Period: 4
 * @author Assignment: JMCh20_7Teletext
 *
 * @author Sources: N/A
 */
public class TeletextList
{
    private ListNode2<String> heading;

    private ListNode2<String> topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        heading = new ListNode2<String>( "Today's headlines:", null, null );
        ListNode2<String> prevN = new ListNode2<String>( "", null, heading );
        ListNode2<String> nextN = new ListNode2<String>( "", heading, null );
        heading.setPrevious( prevN );
        heading.setNext( nextN );

        for ( int i = 0; i < headlines.length; i++ )
        {
            nextN = new ListNode2<String>(headlines[i], nextN, null);
            nextN.getPrevious().setNext(nextN);
        }

        nextN.setNext( prevN );
        prevN.setPrevious( nextN );

        topNode = heading;
    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        addAfter( heading.getNext(), msg );
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        ListNode2<String> nextN = topNode.getNext();
        ListNode2<String> prevN = topNode.getPrevious();
        
        if (nextN.equals( heading ) || topNode.equals( heading )
                        || prevN.equals( heading ))
        {
            remove(nextN);
        }
    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        topNode = topNode.getNext();
    }


    /**
     * Adds a new node with msg to the headlines list before a given node.
     * Returns a referenece to the added node.
     * 
     * @param node
     *            reference to node
     * @param msg
     *            message to be added
     * @return the new node
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new 
                        ListNode2<String>( msg, node.getPrevious(), node );
        node.getPrevious().setNext( newNode );
        node.setPrevious( newNode );
        return newNode;
    }


    /**
     * Adds a new node with msg to the headlines list after a given node.
     * Returns a reference to the added node.
     * 
     * @param node
     *            ref. to node
     * @param msg
     *            message to be added
     * @return the new node
     */
    private ListNode2<String> addAfter( ListNode2<String> node, String msg )
    {
        return addBefore(node.getNext(), msg);
    }


    /**
     * Removes a given node from the list.
     * 
     * @param node
     *            node to be removed
     */
    private void remove( ListNode2<String> node )
    {
        ListNode2<String> prevN = node.getPrevious();
        ListNode2<String> nextN = node.getNext();

        prevN.setNext( nextN );
        nextN.setPrevious( prevN );
    }


    /**
     * Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * 
     * @param g
     *            graphics
     * @param x
     *            x-coord. of topNode
     * @param y
     *            y-coord. of topNode.
     * @param lineHeight
     *            height of line
     * @param nLines
     *            number of lines
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; 
                        node.getNext() != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
