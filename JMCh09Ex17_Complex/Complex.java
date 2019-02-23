/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author David Cheng
 * @version 10/5/18
 * @author Period: 4
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: N/A
 */
public class Complex
{
    // instance variables
    private double a;

    private double b;


    /**
     * constructor with one param
     * 
     * @param a real number 
     */
    public Complex( double a )
    {
        this.a = a;
        b = 0.0;
    }


    /**
     * constructor with two param
     * 
     * @param a real part
     * @param b imaginary part
     */
    public Complex( double a, double b )
    {
        this.a = a;
        this.b = b;
    }


    /**
     * calculates magnitude of complex number
     * 
     * @return magnitude
     */
    public double abs()
    {
        return Math.sqrt( a * a + b * b );
    }


    /**
     * adds two complex numbers
     * 
     * @param other
     *            Complex num
     * @return Complex num addition of the two complex numbers
     */
    public Complex add( Complex other )
    {
        return new Complex( a + other.a, b + other.b );
    }


    /**
     * Adds real num with complex num
     * 
     * @param num a real number
     * @return complex num
     */
    public Complex add( double num )
    {
        return new Complex( a + num, b );
    }


    // (a + bi)(c + di) = ac + adi + bci + bdi^2 = (ac - bd) + (ad + bc)i
    /**
     * multiplies two complex numbers
     * 
     * @param other the other complex number
     * @return product of two complex num
     */
    public Complex multiply( Complex other )
    {
        return new Complex( a * other.a - b * other.b
            , a * other.b + b * other.a );
    }


    /**
     * multiplies complex num with real num
     * 
     * @param num a real number
     * @return product of complex num and real num
     */
    public Complex multiply( double num )
    {
        return new Complex( num * a, num * b );
    }


    /**
     * converts to string
     * 
     * @return string
     */
    public String toString()
    {
        return a + " + " + b + "i";
    }
}
