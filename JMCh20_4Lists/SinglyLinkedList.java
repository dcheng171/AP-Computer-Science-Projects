import java.util.Iterator;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
    Implements a singly-linked list.
    
    @author  David Cheng 
    @version 12/10/18
    
    @author  Period - 4
    @author  Assignment - N/A
    
    @author  Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }
        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (nodeCount == 0);  
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;  
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        ListNode<E> temp = head;
        while (temp != null)
        {
            if (temp.getValue().equals( obj ))
            {
                return true;
            }
            temp = temp.getNext();
        }
        return false;  
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {        
        int count = 0;
        for (ListNode<E> node = head; node != null; node = node.getNext())
        {
            if (node.getValue().equals(obj))
            {
                return count;
            }
            count++;
        }
        return -1; 
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        if (nodeCount == 0)
        {
            head = new ListNode<E>(obj, null);
            nodeCount++;
            return true;
        }
        
        ListNode<E> node = head;
        while (node != null)
        {
            if (node.getNext() == null)
            {
                node.setNext( new ListNode<E>(obj, null) );
                nodeCount++;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        if (nodeCount == 0)
        {
            return false;
        }
        
        ListNode<E> node = head;
        
        while (node != null)
        {
            if (node.getNext().getValue().equals( obj ))
            {
                if (node.getNext().getNext() == null)
                {
                    node.getNext().setValue( null );
                    return true;
                }
                ListNode<E> nextNext = node.getNext().getNext();
                
                node.setNext( nextNext );
                
                nodeCount--;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        int y = 0;
        
        for (E x : this)
        {
            if (y == i)
            {
                return x;
            }
            else
            {
                y++;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {                                
        if (nodeCount == 0 || i < 0 || i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        
        ListNode<E> node = head;
        int count = 0;
        
        while (node != null)
        {
            if (count + 1 == i)
            {     
                E x = node.getNext().getValue();
                node.setNext(new ListNode<E>(obj, node.getNext().getNext()));
                return x;
            }
            count++;
            node = node.getNext();
        }
        
        throw new IndexOutOfBoundsException();
        
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        if (i == 0)
        {
            head = new ListNode<E>(obj, head);
            nodeCount++;
            return;
        }
        
        ListNode<E> node = head;
        int count = 0;
        
        while (node != null)
        {
            if (count + 1 == i)
            {     
                node.setNext(new ListNode<E>(obj, node.getNext()));
                nodeCount++;
                return;
            }
            count++;
            node = node.getNext();
        }
        
        throw new IndexOutOfBoundsException();
    }

    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {
        if (i == 0)
        {
            E temp = head.getValue();
            head = head.getNext();
            nodeCount--;
            return temp;
        }
        
        if (i >= nodeCount)
        {
            throw new IndexOutOfBoundsException();
        }
        
        ListNode<E> node = head;
        int count = 0;
        
        while (node != null)
        {
            if (count + 1 == i)
            {
                E temp = node.getNext().getValue();
                
                if (i == nodeCount - 1)
                {
                    node.setNext(null);
                    nodeCount--;
                    return temp;
                }
                ListNode<E> nextNext = node.getNext().getNext();
                
                node.setNext( nextNext );
                
                nodeCount--;
                return temp;
            }
            count++;
            node = node.getNext();
        }
        
        throw new IndexOutOfBoundsException();
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
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

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}

