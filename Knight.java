import java.awt.Point;

/**
 * Model a knight piece in the game of Chess.
 */
public class Knight
{
    // Position on the board (x,y)
    private Point position ;
    
    // Types of moves the Knight can make.
    private int[][] moveTypes ;

    /**
     * Initialize the knight's position and legal moves.
     */
    public Knight()
    {
        // Initialize Position at row 0 column 0
        position = new Point(0, 0) ;
        // Define Possible moves
        moveTypes = new int[][] { {-1,-2,-2,-1 ,1, 2,2,1} ,
                                  {2, 1, -1,-2,-2,-1,1,2} };
    }

    // Notes: this is to get the last tour ID.
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
     * Helper Checks if the move type is legal.
     *
     * @param board instance of {@link ChessBoard} to use within the method.
     * @return True if the move is legal, else False.
     */
    public boolean canMove(ChessBoard board)
    {
        // for(int i = 0 ; i < moveTypes[0].length ; i++)
        for(int i = 0 ; i < 8 ; i++)
        {
            // Check each move type 
            Point newPos = new Point( position.x + (moveTypes[0][i]) , 
                                      position.y + (moveTypes[1][i]) );

            // check if the position is even possible within the board
            if((newPos.x >= 0 && newPos.x < 8) && (newPos.y >= 0 && newPos.y < 8))
            {
                //
                // If one move type can be done on the board
                if(board.moveIsLegal(newPos))
                {
                    // Set the knight's next position at that found position
                    position.setLocation(newPos);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Move the knight to the new position and set the tour number.
     *
     * @param board {@link ChessBoard} instance used to place the new position and 
     * tour number.
     * @param tourNumber int tour count of the knight.
     */
    public void move(ChessBoard board , Point position, int tourNumber)
    {
        board.setTourNumber(position, tourNumber) ;
    }
}

