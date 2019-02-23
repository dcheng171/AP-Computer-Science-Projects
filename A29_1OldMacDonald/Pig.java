/**
 * A pig class that extends animal, creates a pig with a type and sound
 *
 * @author dcheng171
 * @version Oct 29, 2018
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: N/A
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Initializes a newly created pig object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of pig
     * @param sound
     *            the sound the pig makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * gets sound of pig
     * 
     * @return sound of pig
     */
    public String getSound()
    {
        return mySound;
    }


    /**
     * returns type of pig
     * 
     * @return type of pig
     */
    public String getType()
    {
        return myType;
    }
}