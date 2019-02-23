import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author David Cheng
 * @version 10/2/18
 * 
 * @author Period - 4
 * @author Assignment - Java Methods Ch09 - SnackBar
 * 
 * @author Sources - N/A
 */
public class Vendor
{
    // Fields:
    private int availStock;

    private int price;

    private int deposit = 0;

    private int change = 0;

    private static double totalSales = 0;

    /**
     * Constructor
     * @param price of a single item in cents
     * @param initStock number of items to place in stock
     */
    public Vendor( int price, int initStock )
    {
        this.price = price;
        availStock = initStock;
    }

    /**
     * Sets the quantity of items in stock.
     * @param newStock int number of items to place in stock
     */
    public void setStock( int newStock )
    {
        availStock = newStock;
    }


    /**
     * returns total sales and resets total sales (to 0)
     * @return totalSales 
     */
    public static double getTotalSales()
    {
        double temp = totalSales;
        totalSales = 0;
        return temp;

    }

    /**
     * Returns the number of items currently in stock.
     * @return availStock int number of items currently in stock
     */
    public int getStock()
    {
        return availStock;
    }

    /**
     * Adds a specified amount (in cents) to the deposited amount.
     * @param numCents int number of cents to add to the deposit
     */
    public void addMoney( int numCents )
    {
        if ( availStock > 0 )
        {
            deposit += numCents;
        }
        else
        {
            deposit = 0;
        }
    }

    /**
     * Returns the currently deposited amount (in cents).
     * @return deposit int number of cents in the current deposit
     */
    public int getDeposit()
    {
        return deposit;
    }

    /**
     * Implements a sale. If there are items in stock and
     * the deposited amount is greater than or equal to
     * the single item price, then adjusts the stock
     * and calculates and sets change and returns true;
     * otherwise refunds the whole deposit (moves it into change)
     * and returns false.
     * @return boolean successful sale (true) or failure (false)
     */
    public boolean makeSale()
    {
        if ( availStock > 0 && deposit >= price )
        {
            availStock -= 1;
            change = deposit - price;
            totalSales += price / 100.0;
            deposit = 0;
            return true;
        }
        else
        {
            change = deposit;
            deposit = 0;
            return false;
        }
    }

    /**
     * Returns and zeroes out the amount of change (from the last
     * sale or refund).
     * @return temp int number of cents in the current change
     */
    public int getChange()
    {
        int temp = change;
        change = 0;
        return temp;
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Vendor.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
