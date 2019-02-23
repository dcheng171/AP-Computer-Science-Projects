import java.util.*;

/**
 * MailServer class, creates a server where actors can send mails to each other
 * 
 * @author David Cheng 
 * @version 1/23/19
 * 
 * @author Period - 4
 * @author Assignment - MailServer
 * 
 * @author Sources - textbook
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors;
    
    /**
     * MailServer constuctor
     */
    public MailServer() 
    {
        actors = new TreeSet<Actor>();
    }
    
    /**
     * adds actor to the list of emailers
     * @param actor an actor
     */
    public void signUp(Actor actor)
    {
        actors.add( actor );
    }
    
    /**
     * sends a mail to the recipient, or if null, sends to everyone
     * @param msg message to be sent
     */
    public void dispatch(Message msg)
    {
        if (msg.getRecipient() == null)
        {
            for (Actor x : actors)
            {
                if (!x.equals( msg.getSender() ))
                {
                    x.receive( msg );
                }
            }
        }
        else
        {
            msg.getRecipient().receive( msg );
        }
    }
    
    
    
    // for testing purposes only
    /**
     * gets all actors
     * @return actors in the set
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
