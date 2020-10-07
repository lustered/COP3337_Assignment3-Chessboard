/*
Carlos Luis
U08
KnightsTour.java
I affirm that this program is entirely my own work and none of it
is the work of any other person.
*/

import java.util.HashMap ; 
import java.util.Map ; 
// Needed in case we want to initialize the knight at a non-default position
import java.awt.Point ; 

/**
 * Conducts the Knight's Tour.  
 */
public class KnightsTour
{
    // Number of moves of the longest tour
    private int mostMoves ; 
    // To grab the best tour's board state
    private ChessBoard bestBoard ;  
    // Keep records of tour <length, count> for all tours ran
    private HashMap<Integer, Integer> tourRecords  ; 
    // Assign the best tour number
    private int tourNum  ; 
    // Keep a counter of how many tours are ran
    private int tourIter ; 

    /**
     * Create a tour, initialize records table and best tour. 
     */
    // public KnightsTour(int tours)
    public KnightsTour()
    {
        // tourRecords = new int[tours][64]  ; 
        // tourRecords = new int[64]  ; 
        tourRecords = new HashMap<Integer, Integer>() ; 
        bestBoard = new ChessBoard() ; 
        mostMoves = 0  ; 
        tourNum = 0  ; 
        tourIter = 0 ; 
    }
        
    /**
     * Can conduct a tour, I.e, create ChessBoard and Knight objects, place the Knight
     * on the board, and have the Knight move until there are no more legal moves.
     *
     */
    public void conductTour()
    {
        // count variables
        int tourMoves = 1  ; 
        tourIter++ ; 

        // Create new board and knight, needed in case multiple tours are ran.
        ChessBoard board = new ChessBoard()  ; 
        // Initialize the knight
        // The knight has 2 constructors
        //
        // .noArg constructor will initialize the 
        // knight at 0,0 on the board
        //
        // . Otherwise, pass a Point object with the initial position.
        // Knight knight = new Knight(new Point(5,2))  ; 
        Knight knight = new Knight()  ; 

        knight.move(board , 1) ; 


        while(knight.canMove(board) && tourMoves < 65)
            knight.move(board, ++tourMoves)  ; 
        
        // Increase the tour's length count by 1 
        tourRecords.merge(tourMoves, 1, Integer::sum)  ; 

        if(tourMoves > mostMoves)
        {
            tourNum = tourIter ; 
            mostMoves =  tourMoves  ; 
            bestBoard = board ; 
        } 
    }


    /**
     * 
     * 
     */
    public String bestTourResult()
    {
        int totalTours = 0 ; 
        for(int vals : tourRecords.values())
            totalTours += vals ; 

        String divider = new String(new char[40]).replace("\0", "-") ; 
        String ret = "" ; 

        ret += String.format("\n\t::Best of %3s Tours::" , totalTours) ; 
        ret += (mostMoves == 64) ? " (a complete tour)\n" : "\n"  ; 
        ret += String.format("\n%4sTour # %2s\t Tour Length: %2s\n"," ", tourNum, mostMoves)  ; 
        ret += bestBoard.toString()  ; 

        // All the tour records
        ret += String.format("\n%15s\t%20s\n%42s" ,"Tour Length", "Num of Tours", divider)  ; 

        // Iterate over <Tour Length, Count>
        for(Map.Entry<Integer, Integer> tours : tourRecords.entrySet())
            // if(tours.getValue() != 0)
                ret += String.format("\n%10s%20s", tours.getKey(), tours.getValue())  ; 

        ret = String.format("%-100s" , ret) ; 
        return ret ; 
    }
}
