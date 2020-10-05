import java.awt.Point ; 

/**
 * This class models a chess board for a knight piece and each position represents
 * the position in chronological order that the knight visited. 
 */
public class ChessBoard
{
    // board to store our tours
    private int[][] board; 

    /**
     * Creates an 8x8 board. 
     */
    public ChessBoard()
    {
        board = new int[8][8] ; 
    }

    /**
     * Check if the move is legal.
     *
     * @param position Point position object with x,y positions.  
     * @return boolean true if the move can be made, else false. 
     */
    public boolean moveIsLegal(Point position)
    {

        if(board[position.x][position.y] == 0)
            return true ; 
        else 
            return false ; 
    }

    /**
     * Set the move number at the specified index.
     */
    public void setTourNumber(Point pos, int moveNumber)
    {
        board[pos.x][pos.y] = moveNumber ; 
    }

    /**
     * Return a String displaying the state of the board.  
     *
     * @return a String displaying the state of the board.
     */
    public String toString()
    {
        // divider for each row
        String divider = new String(new char[40]).replace("\0", "-") ; 

        // String to concatenate board state
        String boardState = "\n\n" + divider + "\n" ; 

        // Iterate over rows and columns
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[i].length ; j++)
            {
                // Append each element
                
                // If the position was not reached during the tour.
                if(board[i][j] == 0)
                    // Replace 0 with *
                    boardState += String.format(" %2s |", "*"); 
                else
                    // Else just append the tour number
                    boardState += String.format(" %2s |", board[i][j]); 
            }
           
            // Start a new line every new row
            boardState += "\n" + divider + "\n" ; 
        }

        return boardState ; 
    }
}
