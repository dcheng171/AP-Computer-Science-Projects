import java.util.Stack;
// import java.util.List;


/**
 * BrowserModel class
 *
 * @author David
 * @version Jan 22, 2019
 * @author Period: 4
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: n/a
 */

public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStk;

    private Stack<Integer> forwardStk;

    private int topLine;


    /**
     * BrowswerModel constructor
     * 
     * @param view
     *            browser view
     */

    public BrowserModel( BrowserView view )
    {
        this.view = view;

        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        view.update( 0 );
    }


    /**
     * goes back a line
     */

    public void back()
    {
        forwardStk.push( topLine );

        if ( hasBack() )
        {
            int n = backStk.pop();
            topLine = n;
        }

        view.update( topLine );
    }


    /**
     * goes forward a line
     */

    public void forward()
    {
        backStk.push( topLine );

        if ( hasForward() )
        {
            int n = forwardStk.pop();
            topLine = n;
            view.update( topLine );
        }

    }


    /**
     * goes back to the top line
     */

    public void home()
    {
        backStk.push( topLine );

        topLine = 0;
        view.update( topLine );
        forwardStk.removeAllElements();
    }


    /**
     * follows the hyperlink on a line
     * 
     * @param n
     *            line to go to
     */

    public void followLink( int n )
    {
        backStk.push( topLine );

        topLine = n;
        view.update( n );
        forwardStk.removeAllElements();
    }


    /**
     * checks whether backStk is empty
     * 
     * @return whether backStk is empty
     */

    public boolean hasBack()
    {
        return !backStk.isEmpty();
    }


    /**
     * checks whether forwardStk is empty
     * 
     * @return whether forwardStk is empty
     */

    public boolean hasForward()
    {
        return !forwardStk.isEmpty();
    }


    // The following are for test purposes only
    /**
     * gets backstk
     * 
     * @return back stack
     */

    public Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * gets forwardStk
     * 
     * @return forward stack
     */

    public Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * gets the top line
     * 
     * @return top line
     */
    public int getTopLine()
    {
        return topLine;
    }
}
