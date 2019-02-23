//import java.awt.Color;
import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;


/**
 * Draws a polygon and calculates its perimeter and area
 *
 * @author David Cheng
 * @version 11/6/18
 *
 * @author Period - 4
 * @author Assignment - Irregular Polygon
 * 
 * @author Sources - N/A
 */
public class IrregularPolygon
{
    private DrawingTool pen; 
    //= new DrawingTool( new SketchPad( 300, 300, 0 ) );

    private ArrayList<Point2D.Double> myPolygon;


    /**
     * constructor, initializes arrayList
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    /**
     * adds point to arrayList
     * 
     * @param aPoint
     *            a given point
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }


    /**
     * calculates perimeter of polygon
     * 
     * @return perimeter of polygon
     */
    public double perimeter()
    {
        double perimeter = 0;
        int len = myPolygon.size();
        if ( len == 0 )
        {
            return 0.0;
        }
        for ( int i = 0; i < len - 1; i++ )
        {
            double point1X = myPolygon.get( i ).getX();
            double point1Y = myPolygon.get( i ).getY();
            double point2X = myPolygon.get( i + 1 ).getX();
            double point2Y = myPolygon.get( i + 1 ).getY();

            perimeter += Point2D.distance( point1X, point1Y, point2X, point2Y );
        }

        double lastPointX = myPolygon.get( len - 1 ).getX();
        double lastPointY = myPolygon.get( len - 1 ).getY();

        double firstPointX = myPolygon.get( 0 ).getX();
        double firstPointY = myPolygon.get( 0 ).getY();

        perimeter += Point2D.distance( lastPointX, lastPointY, 
            firstPointX, firstPointY );

        return perimeter;
    }


    /**
     * calculates area of polygon
     * 
     * @return area of polygon
     */
    public double area()
    {
        int len = myPolygon.size();
        if ( len == 0 )
        {
            return 0.0;
        }
        double area = 0;
        for ( int i = 0; i < len - 1; i++ )
        {
            area += myPolygon.get( i ).getX() * myPolygon.get( i + 1 ).getY();
        }

        area += myPolygon.get( len - 1 ).getX() * myPolygon.get( 0 ).getY();

        for ( int j = 0; j < len - 1; j++ )
        {
            area -= myPolygon.get( j ).getY() * myPolygon.get( j + 1 ).getX();
        }

        area -= myPolygon.get( len - 1 ).getY() * myPolygon.get( 0 ).getX();

        area /= 2;

        area = Math.abs( area );

        return area;
    }


    /**
     * draws polygon
     */
    public void draw()
    {
        pen.up();
        if ( myPolygon.size() == 0 )
        {
            return;
        }
        pen.move( myPolygon.get( 0 ).getX(), myPolygon.get( 0 ).getY() );
        pen.down();
        for ( int i = 0; i < myPolygon.size() - 1; i++ )
        {
            pen.move( myPolygon.get( i + 1 ).getX(), 
                myPolygon.get( i + 1 ).getY() );
        }

        pen.move( myPolygon.get( 0 ).getX(), myPolygon.get( 0 ).getY() );
    }
}
