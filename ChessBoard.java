/*
Carlos Luis
U08
ChessBoard.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

import java.awt.Point ; 

/**
 * This class models a chess board for a knight piece and each position represents
 * the position in chronological order that the knight visited. 
 */
public class ChessBoard
{
    // Board to store our tours as the knight moves.
    private int[][] board ; 

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
     * @param position {@link Point} position object with x,y positions.  
     * @return boolean true if the move can be made, else false. 
     */
    public boolean moveIsLegal(Point position)
    {
        // All the elements of an int array are initialized to 0
        // If the index is a default one, return true, else false.
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
     * Check if the position is one move away from the first tour.
     * 
     *
     * @param pos {@link Point} position to check.
     * @return {@link Boolean} true if position is one move away else false. 
     */
    public boolean oneMoveAway(Point pos)
    {
        try
        {
           if(board[pos.x][pos.y] == 1)
               return true;
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            return false;
        }

        return false;
    }

    /**
     * Return a String displaying the state of the board.  
     *
     * @return a String displaying the state of the board.
     */
    public String toString()
    {
        // dividers for each row
        String divider = new String(new char[41]).replace("\0", "-") ; 
        String gridDivider = "\n\t" + divider + "\n\t"; 

        // String to concatenate board state
        String boardState = gridDivider + "|" ; 

        // Iterate over rows and columns
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[i].length ; j++)
            {
                // Append each element.
                // If the position was not reached during the tour.
                if(board[i][j] == 0)
                    // Replace 0 with *
                    boardState += String.format(" %2s |", "*") ; 
                else
                    // Else just append the tour number
                    boardState += String.format(" %2s |", board[i][j]) ; 
            }
           
            // Start a new line every new row. Append a closing pipe unless
            // it's the last line. Just 
            boardState += (i < board.length - 1) ? gridDivider + "|" : gridDivider ; 
        }

        return boardState ; 
    }
}
