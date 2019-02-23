/**
 * Creates a class same as Cow, except with a name as a parameter
 *
 * @author dcheng171
 * @version Oct 29, 2018
 * @author Period: 4
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: N/A
 */
class NamedCow extends Cow
{
    private String name;


    /**
     * Normal constructor from cow
     * 
     * @param type
     *            type of cow
     * @param sound
     *            sound cow makes
     */
    public NamedCow( String type, String sound )
    {
        super( type, sound );
    }


    /**
     * Same constructor as cow, but with name
     * 
     * @param type
     *            type of cow
     * @param name
     *            name of cow
     * @param sound
     *            sound cow makes
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        this.name = name;
    }


    /**
     * returns name of cow
     * 
     * @return name of cow
     */
    public String getName()
    {
        return name;
    }

}
