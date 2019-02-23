import java.util.*;


/**
 * Test for all the animals
 * 
 * @author David cheng
 * @version 10/29/18
 * 
 *          Period - 4 Assignment - A29.1 Old MacDonald
 * 
 *          Sources - Lesson 29
 */
public class Farm
{
    private Animal[] a = new Animal[3];


    /**
     * constructor for Farm, creates list of animals
     */
    public Farm()
    {
        // a[0] = new Cow("cow","moo moo");
        a[0] = new NamedCow( "cow", "Elsie", "moo" );
        // a[1] = new Chick("chick","cluck cluck");
        a[1] = new Chick( "chick", "cluckity cluck", "cheep" );
        a[2] = new Pig( "pig", "oink oink" );
    }


    /**
     * goes through the animals and their sounds
     */
    public void animalSounds()
    {
        for ( int i = 0; i < a.length; i++ )
        {
            System.out.println( a[i].getType() + " goes " + a[i].getSound() );
        }
        NamedCow named = (NamedCow)a[0];
        System.out.println( named.getType() + " is named " + named.getName() );
    }
}
