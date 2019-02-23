/**
 * Creates a test for creating the animals
 *
 * @author dcheng171
 * @version Oct 29, 2018
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: N/A
 */
class OldMacDonald
{
    /**
     * Test for creating the animals
     * 
     * @param args
     *            no param
     */
    public static void main( String[] args )
    {
        Cow c = new Cow( "cow", "moo" );
        System.out.println( c.getType() + " goes " + c.getSound() );

        Farm test = new Farm();
        test.animalSounds();
    }
}
