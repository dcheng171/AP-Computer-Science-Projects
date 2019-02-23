import java.math.*;

public class EulerMethod
{
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public static void main( String[] args )
    {
        double deltaX = 0.01;
        double initY = 1;
        double xn = 0;
        double yn = initY;
        
        System.out.print( "n\t" );
        System.out.print( "xn\t" );
        System.out.print( "yn\t" );
        System.out.print( "deltay\t" );
        System.out.print( "yn+1" );
        System.out.println(  );
        
        for (int n = 0; n <= 100; n++)
        {
            System.out.print( n + "\t" );
            System.out.print( round(xn, 3) + "\t" );           
            System.out.print( round(yn, 3) + "\t" );
            double oldYn = yn;
            yn = (Math.sqrt(yn)/2)*deltaX;           
            System.out.print(round(yn, 3) + "\t" );
            yn += oldYn;
            System.out.print( round(yn, 3) );
            xn += deltaX;
            System.out.println(  );
        }
    }

    
}
