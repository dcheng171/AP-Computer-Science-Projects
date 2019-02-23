import info.gridworld.actor.*;
import info.gridworld.grid.*;

import org.junit.*;
import static org.junit.Assert.*;


/**
 * Jumper tests:. test01 - jumper next to edge of grid - should turn test02 -
 * jumper 2 from edge of grid - should turn test03 - TODO Description test04 -
 * TODO Description test05 - TODO Description test06 - TODO Description test07 -
 * TODO Description
 *
 * @author David Cheng + Aman Choudhary
 * @version 10/26/18
 *
 * @author Period: 4
 * @author Assignment - GridWorld Part 3 Jumper
 *
 * @author Sources: N/A
 */
public class JUJumperTest
{
    /*
     * Variables used by the test methods.
     */
    private Grid<Actor> grid;

    private ActorWorld world;

    private Jumper jumper1;


    /**
     * Invoked before each test to instantiate the objects used for every test.
     */
    @Before
    public void initialize()
    {
        grid = new BoundedGrid<Actor>( 8, 8 );
        world = new ActorWorld( grid );
        jumper1 = new Jumper();
    }


    /**
     * test01 - jumper next to edge of grid - should turn
     */
    @Test
    public void jumperNextToEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 0, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test02 - jumper 2 from edge of grid - should turn.
     */
    @Test
    public void jumper2FromEdgeOfGridShouldTurn()
    {
        Location loc = new Location( 1, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( loc, jumper1, Location.NORTHEAST ) );
    }


    /**
     * test03 - Makes sure Jumper does not move one space
     */
    @Test
    public void jumperDoesNotMoveOneSpace()
    {
        Location loc = new Location( 3, 3 );
        Location wrongLoc = new Location( 2, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testEmpty( wrongLoc ) );
    }


    /**
     * test04 - jumper does not eat anything right in front of it
     */
    @Test
    public void jumperDoesNotEatAdjacentActors()
    {
        Location loc1 = new Location( 3, 0 );
        Location loc2 = new Location( 2, 0 );

        world.add( loc1, jumper1 );

        Jumper jumper2 = new Jumper();
        world.add( loc2, jumper2 );

        jumper1.act();
        assertTrue( testOccupied( loc2, jumper2, Location.NORTH ) );
    }


    /**
     * test05 - jumper eats actors 2 spaces in front of it
     */
    @Test
    public void jumperEatsActor2Spaces()
    {
        Location loc1 = new Location( 4, 0 );
        Location loc2 = new Location( 2, 0 );

        world.add( loc1, jumper1 );

        Jumper jumper2 = new Jumper();
        world.add( loc2, jumper2 );

        jumper1.act();

        assertTrue( testOccupied( loc2, jumper1, Location.NORTH ) );
    }


    /**
     * test06 - jumper turns if rock or flower 2 spaces in front
     */
    @Test
    public void jumperTurnsIfRockOrFlower2Spaces()
    {
        Location loc1 = new Location( 3, 3 );
        Location loc2 = new Location( 1, 3 );

        Location loc3 = new Location( 3, 4 );
        Location loc4 = new Location( 1, 4 );

        Jumper jumper2 = new Jumper();
        Rock rock1 = new Rock();
        Flower flower1 = new Flower();

        world.add( loc1, jumper1 );
        world.add( loc2, rock1 );
        world.add( loc3, jumper2 );
        world.add( loc4, flower1 );

        jumper1.act();
        jumper2.act();

        assertTrue( testOccupied( loc1, jumper1, Location.NORTHEAST ) );
        assertTrue( testOccupied( loc3, jumper2, Location.NORTHEAST ) );

    }


    /**
     * test07 - Jumper jumps 2 spaces
     */
    @Test
    public void Jumper2Spaces()
    {
        Location loc = new Location( 3, 3 );
        Location correctLoc = new Location( 1, 3 );
        world.add( loc, jumper1 );
        jumper1.act();

        assertTrue( testOccupied( correctLoc, jumper1, Location.NORTH ) );
    }


    /**
     * Test helper method to test for empty location.
     *
     * @param loc
     *            null location if empty
     * @return true if all assertions pass
     */
    private boolean testEmpty( Location loc )
    {
        Actor empty = grid.get( loc );
        assertNull( "<<<<< " + loc + " should be empty. >>>>>", empty );

        return true;
    }


    /**
     * Test helper method to test that object is in a location, and has a
     * consistent loc, and direction dir.
     *
     * @param loc
     *            location that should be occupied
     * @param a
     *            actor that should be in location loc
     * @param dir
     *            direction this actor should be facing
     * @return true if all assertions pass
     */
    private boolean testOccupied( Location loc, Actor a, int dir )
    {
        Actor found = grid.get( loc );
        assertSame( "<<<<< " + loc + " should contain the actor. >>>>>", a, found );
        assertEquals( "<<<<< Loc should be " + loc + " >>>>>", loc, found.getLocation() );
        assertEquals( "<<<<< Dir should be " + dir + " >>>>>", dir, found.getDirection() );

        return true;
    }
}