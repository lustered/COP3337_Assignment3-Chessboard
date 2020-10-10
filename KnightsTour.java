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
    // Number of moves of the longest tour.
    private int mostMoves ; 
    // To grab the best tour's board state.
    private ChessBoard bestBoard ;  
    // To check for a perfect tour.
    private Knight bestKnight ;
    // Keep records of tour <length, count> for all tours ran.
    private HashMap<Integer, Integer> tourRecords  ; 
    // Assign the best tour number
    private int tourNum  ; 
    // Keep a counter of how many tours are ran.
    private int totalTours ; 
    // Get the position of the last tour.
    private Point lastMovePosition ; 

    /**
     * Create a tour.
     */
    public KnightsTour()
    {
        tourRecords = new HashMap<Integer, Integer>() ; 
        bestBoard = new ChessBoard() ; 
        mostMoves = 0 ; 
        tourNum = 0 ; 
        totalTours = 0 ; 
    }
        
    /**
     * Can conduct a tour, I.e, create ChessBoard and Knight objects, place the Knight
     * on the board, and have the Knight move until there are no more legal moves.
     */
    public void conductTour()
    {
        // count variables
        int tourMoves = 1  ; 
        totalTours++ ; 

        // Create new board and knight, needed in case multiple tours are ran.
        ChessBoard board = new ChessBoard()  ; 
        
        // Initialize the knight
        // The knight has 2 constructors
        //
        // .noArg constructor will initialize the 
        // knight at (0,0) on the board
        //
        // . Otherwise, pass a Point object with the initial position. Eg.
        // Knight knight = new Knight(new Point(5,2))  ; 
        Knight knight = new Knight(new Point(0,0))  ; 

        // Move the knight and place the tour number on the board
        knight.move(board , 1) ; 


        // Move the knight until either moves are not legal
        while(knight.canMove(board))
            knight.move(board, ++tourMoves)  ; 
        
        // Initialize to 1 if key hasn't been initialized. else
        // increase the tour's length count by 1.
        tourRecords.merge(tourMoves, 1, Integer::sum)  ; 

        // Get the best tour's records
        if(tourMoves > mostMoves)
        {
            tourNum = totalTours ; 
            mostMoves =  tourMoves  ; 
            bestBoard = board ; 
            bestKnight = knight ; 
        }

    }


    /**
     * Get the results for the best tour, incluiding state of the board
     * best tour, tour length and a table showing the length of each tour 
     * and the count for each.
     */
    public String toString()
    {

        String divider = new String(new char[40]).replace("\0", "-") ; 
        // String to return the state of the best board and records
        String ret = "" ; 

        ret += String.format("\t::Best of %3s Tours::" , totalTours) ; 
        
        // If the tour had all the possible moves:
        // .check if it's a perfect tour
        // .else call it a complete tour
        if(mostMoves == 64)
            ret += bestKnight.isPerfectTour(bestBoard) ? 
                " A perfect tour!\n" :
                " A complete tour!\n" ;


        // Header for best board
        ret += String.format("\n%4sTour # %2s\t Tour Length: %2s\n"," ", tourNum, mostMoves) ; 

        // Append the best board's final state
        ret += bestBoard.toString()  ; 

        // Header for all the tour records
        ret += String.format("\n%15s\t%20s\n%42s" ,"Tour Length", "Num of Tours", divider)  ; 

        // Iterate over <Tour Length, Count> and append each result. 
        for(Map.Entry<Integer, Integer> tours : tourRecords.entrySet())
                ret += String.format("\n%10s%20s", tours.getKey(), tours.getValue())  ; 

        return ret ; 
    }
}
