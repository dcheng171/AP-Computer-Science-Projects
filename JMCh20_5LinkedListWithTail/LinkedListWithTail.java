import java.util.NoSuchElementException;

/**
 *  Implements a singly-linked list with a tail.
 *
 *  @author  David Cheng
 *  @version 12/14/18
 *  @author  Period: 4
 *  @author  Assignment: JMCh20_5LinkedListWithTail
 *
 *  @author  Sources: N/A
 */
public class LinkedListWithTail<E>
{
    private ListNode<E> head, tail;

    /**
     * Constructs an empty list.
     */
    public LinkedListWithTail()
    {
        head = null;
        tail = null;
    }

    /** 
     * Returns true if this list is empty; otherwise returns false.
     * 
     * @return true if this list contains no elements false otherwise
     */
    public boolean isEmpty()
    {
        return (head == null);
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * 
     * @return the head of this list, or null if this list is empty
     */
    public E peek()
    {
        if (head == null)
        {
            return null;
        }
        else
        {
            return head.getValue();
        }
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param obj - element to be appended to this list
     * @return true if this collection changed as a result of the call
     */
    public boolean add(E obj)
    {
        if (head == null)
        {
            head = new ListNode<E>(obj, null);
            tail = head;
            return true;
        }
        ListNode<E> newNode = new ListNode<E>(obj, null);
        
        tail.setNext( newNode );
        tail = newNode;
        
        return true;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     * 
     * @return the head of this list
     * @throws NoSuchElementException - if this list is empty
     */
    public E remove()
    {   
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        E temp = head.getValue();
        head = head.getNext();
        return temp;
    }
    
    /**
     * Exercise 20.12
     * 
     * Appends otherList at the end of this list.
     * Append should work in O(1) time, regardless of the list sizes, and
     * it should work properly when either list is empty or both list are empty
     * 
     * @param otherList list to be appended to the end of this list
     */
    public void append( LinkedListWithTail<E> otherList )
    {
        if (isEmpty() && otherList.isEmpty())
        {
            return;
        }
        else if (isEmpty())
        {
            head = otherList.head;
            tail = otherList.tail;
            return;
        }
        else if (otherList.isEmpty())
        {
            return;
        }
        
        tail.setNext( otherList.head );
    }
    
    /**   *** FOR TESTING PURPOSES ONLY ***
     *
     * Returns a string representation of this list.
     * 
     * @return a string representation of this list.
     */
    public String toString()
    {
        String str = "[", separator = "";

        for ( ListNode<E> node = head; node != null; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}

