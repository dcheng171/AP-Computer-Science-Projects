
public class Ch22Exercises
{
    private static int count = 0;
    
    public static void main( String[] args )
    {
        //printX(3);
        //enigma(3);
        //display(2009);
        //double[] v = {4, 1, 3, 1};
        //System.out.println( max(v, 4) );
        
        //pow(1.234, 9);
        //System.out.println( count );
        
        //System.out.println( countPaths(1, 2) );
        
        //StringBuffer word = new StringBuffer(3);
        //allWords(word, 3);
        
        /*ListNode<Integer> head = new ListNode<Integer>(10, null);
        head.setNext( new ListNode<Integer>(20, null) );
        head.getNext().setNext( new ListNode<Integer>(30, null) );
        head.getNext().getNext().setNext( new ListNode<Integer>(40, null) );
        head.getNext().getNext().getNext().setNext( new ListNode<Integer>(50, null) );
        
        ListNode<Integer> temp = head;
        while (temp != null)
        {
            System.out.println( temp.getValue() );
            temp = temp.getNext();
        }
        
        head = doTheTrick(head);
        temp = head;
        while (temp != null)
        {
            System.out.println( temp.getValue() );
            temp = temp.getNext();
        }*/
        
        System.out.println( isDivisibleBy9(8) );
    }
    
    public static void printX(int n)
    {
        if (n <= 0)
        {
            System.out.print( 0 );
        }
        else
        {
            printX(n - 1);
            System.out.print( n );
            printX(n - 2);
        }
    }
    
    public static void enigma(int n)
    {
        for (int i = 0; i < n; i++)
        {
            enigma(i);
        }
        System.out.print( n );
    }
    
    public static void display(int x)
    {
        if (x >= 10)
        {
            display(x/10);
            System.out.print( x % 10 );
        }
    }
    
    public static double max(double[] v, int n)
    {
        double m = v[n-1], m2;
        
        if (n > 1)
        {
            m2 = max(v, n - 1);
            if (m2 > m)
            {
                m = m2;
            }
        }
        return m;
    }
    
    public static int sumDigits(int n)
    {
        int d = 10;
        int sum = 0;
        int curNum = n;
        while (curNum>0)
        {
           int temp = curNum % d;
           sum += temp;
           curNum = curNum/d;
        }
        
        return sum;
    }
    
    public static boolean isDivisibleBy9(int n)
    {
        if (sumDigits(n) < 9)
        {
            return false;
        }
        else if (sumDigits(n) == 9)
        {
            return true;
        }
        else
        {
            return (isDivisibleBy9(sumDigits(n)));
        }
    }
    public static double pow(double x, int n)
    {
        double y;
        if (n == 1)
        {
            y = x;
        }
        else
        {
            count++;
            y = pow(x, n/2) * pow(x, n - n/2);
        }
        return y;
    }
    
    public static ListNode<Integer> doTheTrick(ListNode<Integer> head)
    {
        if (head == null || head.getNext() == null)
        {
            return head;
        }
        
        ListNode<Integer> newHead = head.getNext();
        newHead = doTheTrick(newHead);
        
        head.setNext( newHead.getNext() );
        newHead.setNext( head );
        return newHead;
    }
    public static int countPaths(int x, int y)
    {
        if (x == 0 || y == 0)
        {
            return 1;
        }
        else
        {
            return countPaths(x, y - 1) + countPaths(x - 1, y);
        }
    }
    
    public static void allWords(StringBuffer word, int length)
    {
        if (length == word.length())
        {
            System.out.println( word );
        }
        else
        {
            int k = word.length();
            word.append( '*' );
            if (k == 0 || word.charAt( k - 1 ) != 'A')
            {
                word.setCharAt(k, 'A');
                allWords(word, length);
            }
            word.setCharAt(k, 'B' );
            allWords(word, length);
            word.setCharAt(k, 'H' );
            allWords(word, length);  
            word.setLength( k );
        }
    }
}
