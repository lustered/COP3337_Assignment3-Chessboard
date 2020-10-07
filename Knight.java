/*
Carlos Luis
U08
Knight.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Model a knight piece in the game of Chess.
 */
public class Knight
{
    private final Random rnd = new Random() ;
    // Position on the board (x,y)
    private Point position ;
    // Types of moves the Knight can make.
    private final int[][] moveTypes ;
    // Next Possible Moves
    ArrayList<Point> nextMovesAvailable ;

    /**
     * Initialize the knight at position (0,0) and legal moves.
     */
    public Knight()
    {
        // Initialize Position at row 0 column 0.
        position = new Point(0, 0) ;
        // Define the moves the knight can make.
        moveTypes = new int[][] { {-1,-2,-2,-1 ,1, 2,2,1} ,
                                  {2, 1, -1,-2,-2,-1,1,2} };

        nextMovesAvailable = new ArrayList<Point>() ;
    }

    /**
     * Initialize an instance of a Knight with a defined position. 
     *
     * @param position {@link Point} where the knight will start.
     */
    public Knight(Point position)
    {
        this();
        this.position = position ;
    }

    /**
     * Give current position of the knight.
     *
     * @return Point object with the knight's current position.
     */
    public Point getPosition()
    {
        return position;
    }

    /**
     * Checks if the move type is legal and adds the position to possible moves.
     *
     * @param board instance of {@link ChessBoard} to use within the method.
     * @return boolean true if the move is legal, else false.
     */
    public boolean canMove(ChessBoard board)
    {
        for(int i = 0 ; i < moveTypes[0].length ; i++)
        {
            // Check each move type 
            Point newPos = new Point( position.x + (moveTypes[0][i]) , 
                                      position.y + (moveTypes[1][i]) );

            // check if the position is even possible within the board
            if((newPos.x >= 0 && newPos.x < 8) && (newPos.y >= 0 && newPos.y < 8))
                // If one move type can be done on the board
                if(board.moveIsLegal(newPos))
                    // Add position to the available positions the Knight can move to.
                    nextMovesAvailable.add(newPos) ;
        }
        
        // Check if there were possible moves found
        if(nextMovesAvailable.size() > 0)
            return true;
        else
            // If the Knight has nowhere to move
            return false;
    }

    /**
     * Move the knight to the new position and set the tour number.
     *
     * @param board {@link ChessBoard} instance used to place the new position and 
     * tour number.
     * @param tourNumber int tour count of the knight.
     */
    public void move(ChessBoard board , int tourNumber)
    {
        // Get the size of the legal moves
        int size = nextMovesAvailable.size();
        
        // First check if there were recorded possible moves.
        // Eg. When placing the knight on the board no moves were 
        // checked yet, therefore nextMovesAvailable is empty
        // New legal position will be chosen at random  
        // else leave position the same.
        position.setLocation(nextMovesAvailable.size() > 0 
                ? nextMovesAvailable.get(rnd.nextInt(size))
                : getPosition());
        
        // Reset all the available moves for the next move.
        nextMovesAvailable.clear();
        
        // Set the tour counter on the board
        board.setTourNumber(position, tourNumber) ;
    }
}
