/**
 * Class for creating a chick
 *
 * @author dcheng171
 * @version Oct 29, 2018
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: N/A
 */
class Chick implements Animal
{
    private String myType;

    private String mySound;

    private String mySound2;


    /**
     * Initializes a newly created Chick object so that it represents an Animal
     * of the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of chick
     * @param sound
     *            the sound the chick makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Same as original constructor, except with two possible sounds
     * 
     * @param type
     *            type of chick
     * @param sound1
     *            a sound the chick makes
     * @param sound2
     *            another sound the chick makes
     */
    public Chick( String type, String sound1, String sound2 )
    {
        myType = type;

        mySound = sound1;
        mySound2 = sound2;

    }


    /**
     * returns sound1 if random number if less than 0.5, sound2 otherwise
     * 
     * @return sound of chick
     */
    public String getSound()
    {
        double rand = Math.random();

        if ( rand < 0.5 )
        {
            return mySound;
        }
        else
        {
            return mySound2;
        }
    }


    /**
     * returns type of chick
     * 
     * @return type of chick
     */
    public String getType()
    {
        return myType;
    }
}