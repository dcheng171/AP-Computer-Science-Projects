import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;

/**
 *  Creates a gridworld with black squares, and if you press a black square,
 *  it will "erase" (make it white) and also the squares that are connected to
 *  it. Then, it will erase those squares and erase the squares next to those
 *  squares until there are no more connected black squares. 
 *
 *  @author  David Cheng 
 *  @version 11/16/18
 *  @author Period: 4
 *  @author Assignment: AB24_1EraseObject_GridWorld
 *
 *  @author Sources: N/A
 */
public class EraseObject extends World<Tile>
{
    private static final Color IMGOBJ_COLOR = Color.BLACK;
    private static final Color ERASE_COLOR = Color.WHITE;
    
    /**
     * Constructs a default 20x20 grid containing black tiles
     * at the locations given in the file "digital.txt".
     */
    public EraseObject()
    {
        this( new BoundedGrid<Tile>( 20, 20 ), "digital.txt" );
    }

    /**
     * Constructs an EraseObject World with the provided grid. Populates
     * the world with black tile objects at the locations given in the 
     * specified file (fName).
     * 
     * @param bg    bounded grid used by this World
     * @param fName name of file containing location information for
     *               tile placement in this World
     */
    public EraseObject( BoundedGrid<Tile> bg, String fName )
    {
        setGrid( bg );
        getData( fName );

        setMessage( "Click on the object to be erased" );
    }

    /**
     * Overrides <code>info.gridworld.world.World&lt;Tile&lt;.locationClicked</code>
     * This method is called when the user clicks on a location in the WorldFrame.
     * Invokes the recursive erase procedure on the clicked location.
     * 
     * @param loc the grid location that the user selected
     * @return true - the world consumes the click
     */
    public boolean locationClicked( Location loc )
    {
        Grid<Tile> gr = getGrid();

        setMessage( "Tile clicked at " + loc );
        erase( gr, loc.getRow(), loc.getCol() );
        
        return true;
    }

    /**
     *  Loads the data from the specified file containing tile locations
     *  into the this grid.
     *  
     *  The first entry in the provided text file is the number of pairs
     *  that follow (i.e., 55). Each subsequent line contains a pair of
     *  integers, separated by a blank space. Each pair is a row and column
     *  coordinate that specifies the location of a black tile in the
     *  starting grid.
     *  
     *  @param fName name of file containing tile locations
     */
    private void getData( String fName )
    {
        File file = new File(fName);
        Scanner input = null;
        
        try
        {
            input = new Scanner(file);
        }
        catch ( FileNotFoundException e )
        {
            System.out.println( "*** Cannot open " + fName + " ***");
            
            System.exit(1); //quit the program 
        }
        
        
        int lineNum = 1;
        int numBlack = input.nextInt();
        int[][] data = new int[numBlack][2];
        
        int point = 0;
        
        while (lineNum < numBlack + 1 )
        {
            lineNum++;
            
            data[point][0] = input.nextInt();
            data[point][1] = input.nextInt();                
            point++;
        }
               
        Grid<Tile> gr = getGrid();
        
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                for (int k = 0; k < data.length; k++)
                {
                    if (data[k][0] == i && data[k][1] == j)
                    {
                        Location loc = new Location(i, j);
                        gr.put( loc, new Tile(IMGOBJ_COLOR) );
                    }
                }
            }
        }
        
                
    }

    /**
     * Recursively changes the color of a series of adjacent tiles (erases)
     * starting at the given coordinates if this coordinate is part of
     * the object. The method should erase the entire object (remove black).
     *
     * @param gr     grid containing sequences of adjacent tiles
     * @param row    row coordinate to begin erasure
     * @param col    column coordinate to begin erasure
     */
    private void erase( Grid<Tile> gr, int row, int col )
    {
        if (gr.get( new Location(row, col) ) == null
                        || gr.get( new Location(row, col) ).getColor() == 
                        Color.WHITE)
        {
            return;
        }
        else
        {
            gr.get( new Location(row, col) ).setColor( ERASE_COLOR );
            
            if (gr.isValid( new Location(row, col + 1 )))
            {
                erase( gr, row, col + 1);
            }
            
            if (gr.isValid( new Location (row + 1, col)))
            {
                erase(gr, row + 1, col);
            }
            
            if (gr.isValid( new Location (row, col - 1)))
            {
                erase (gr, row, col - 1);
            }
            
            if (gr.isValid( new Location (row - 1, col)))
            {
                erase (gr, row - 1, col);
            }            
        }
        
        return;
    }

    /**
     * creates EraseObject object
     * @param args no args
     */ 
    public static void main( String[] args )
    {
        new EraseObject().show();
    }
}
