/**
 *  Creates a book where you can flip pages
 *
 *  @author  David Cheng 
 *  @version 8/31/18
 *  @author  Period: 4
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: None
 */
public class Book
{
    private int numPages;
    private int currentPage;
    
    /**
     * @param totalPages
     */
    public Book(int totalPages) {
        numPages = totalPages;
        currentPage = 1;
    }
    
    
    /**
     * get number of pages
     * @return numPages
     */
    public int getNumPages() {
        return numPages;
    }
    
    /**
     * gets current page
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }
    
    /**
     * flips the page
     * @return currentPage
     */
    public void nextPage() {
        if (currentPage < numPages) {
            currentPage++;
        }
    }
}
