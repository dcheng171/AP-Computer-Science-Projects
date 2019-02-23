public class Pair
{
    private double first, second;
    
    public Pair(double a, double b)
    {
        first = a;
        second = b;
    }
    
    public Pair(Pair other)
    {
        first = other.first;
        second = other.second;
    }
    public void swap()
    {
        double temp = first; first = second; second = temp;
    }
    
    public Pair swap1()
    {
        return new Pair(second, first);
    }
}
