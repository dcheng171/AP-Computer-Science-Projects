import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author David Cheng
 * @version 10/5/18
 * @author Period: 4
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: N/A
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        assertEquals( "1.0 + 0.0i", new Complex( 1.0 ).toString() );
    }


    @Test
    public void testConstructor2Param()
    {
        assertEquals( "1.0 + 2.0i", new Complex( 1.0, 2.0 ).toString() );
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        assertEquals( "2.0 + 2.0i", new Complex( 1.0, 2.0 ).add( 1.0 ).toString() );
    }


    @Test
    public void testAdd2ComplexNums()
    {
        assertEquals( "2.0 + 3.0i",
            new Complex( 1.0, 2.0 ).add( new Complex( 1.0, 1.0 ) ).toString() );
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        assertEquals( "-5.0 + 10.0i",
            new Complex( 1.0, 2.0 ).multiply( new Complex( 3.0, 4.0 ) ).toString() );
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        assertEquals( "2.0 + 4.0i", new Complex( 1.0, 2.0 ).multiply( 2.0 ).toString() );

    }


    @Test
    public void testAbsoluteValue()
    {
        assertEquals( "5.0", new Complex( 3.0, 4.0 ).abs() + "" );
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
